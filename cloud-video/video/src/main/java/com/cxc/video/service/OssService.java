/**
 * 
 */
package com.cxc.video.service;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.common.utils.DateUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.cxc.video.ret.OssSign;
import com.cxc.video.ret.OssSignApp;

/**
 * <pre>
 * 阿里云对象存储服务
 * @author wanglei
 * </pre>
 */
@Service
public class OssService {
	private static final Logger log = LoggerFactory.getLogger(OssService.class);
	/**
	 * sts相关参数
	 */
	@Value("${aliyun.oss.sts.durationSeconds}")
	private Long durationSeconds;
	@Value("${aliyun.oss.sts.policy}")
	private String policy;
	@Value("${aliyun.oss.sts.roleArn}")
	private String roleArn;
	@Value("${aliyun.oss.sts.roleSessionName}")
	private String roleSessionName;

	/**
	 * oss相关参数
	 */
	@Value("${aliyun.oss.region}")
	private String region;
	@Value("${aliyun.oss.version}")
	private String version;
	@Value("${aliyun.oss.accessKeyId}")
	private String accessKeyId;
	@Value("${aliyun.oss.accessKeySecret}")
	private String accessKeySecret;
	@Value("${aliyun.oss.endpoint}")
	private String endpoint;
	@Value("${aliyun.oss.bucket}")
	private String bucket;
	@Value("${aliyun.oss.dir}")
	private String dir;
	private String host;
	private DefaultAcsClient ossClient;
	
	@PostConstruct
	public void init() {
		host = String.format("http://%s.%s", bucket, endpoint) ;
		ossClient = new DefaultAcsClient(DefaultProfile.getProfile(region, accessKeyId, accessKeySecret));
	}
	/**
	 * 获取对象存储上传文件凭证,web端js用
	 * @return
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public Object policy(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, IOException {
		/**
		 * 1.发送请求给阿里云oss服务，获取凭证
		 * 2.返回给客户端
		 */		
		OSSClient client = new OSSClient(bucket, accessKeyId, accessKeySecret);
		long expireTime = durationSeconds;
    	long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
        Date expiration = new Date(expireEndTime);
        PolicyConditions policyConds = new PolicyConditions();
        policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
        policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

        String postPolicy = client.generatePostPolicy(expiration, policyConds);
        byte[] binaryData = postPolicy.getBytes("utf-8");
        String encodedPolicy = BinaryUtil.toBase64String(binaryData);
        String postSignature = client.calculatePostSignature(postPolicy);

        OssSign os = new OssSign();
        os.setAccessid(accessKeyId);
        os.setPolicy(encodedPolicy);
        os.setSignature(postSignature);
        os.setHost(host);
        os.setDir(dir);
        os.setExpire(expireEndTime);
        log.info("oss sign expire:{}", os.getExpire());
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST");
        return os;
	}
	/**
	 * 获取oss上传文件凭证
	 * @return
	 * @throws Exception
	 */
	public OssSignApp policyApp(Long userId) throws Exception {
		AssumeRoleRequest arrequest = new AssumeRoleRequest();
		arrequest.setVersion(version);
		arrequest.setMethod(MethodType.POST);
		arrequest.setProtocol(ProtocolType.HTTPS);
		arrequest.setDurationSeconds(durationSeconds);
		arrequest.setPolicy(policy);
		arrequest.setRoleArn(roleArn);
		arrequest.setRoleSessionName(roleSessionName);
		AssumeRoleResponse arresponse = ossClient.getAcsResponse(arrequest);
		OssSignApp osa = new OssSignApp();
		osa.setAccessKeyId(arresponse.getCredentials().getAccessKeyId());
		osa.setAccessKeySecret(arresponse.getCredentials().getAccessKeySecret());
		osa.setBucketName(bucket);
		osa.setObjectKey(dir + userId + "/" +  UUID.randomUUID().toString().replaceAll("-", ""));
		osa.setExpire(DateUtil.parseIso8601Date(arresponse.getCredentials().getExpiration()));
		osa.setEndpoint(endpoint);
		osa.setSecurityToken(arresponse.getCredentials().getSecurityToken());
		
		return osa;
	}
	
/*	private void response(HttpServletRequest request, HttpServletResponse response, String results) throws IOException {
		String callbackFunName = request.getParameter("callback");
		if (callbackFunName==null || callbackFunName.equalsIgnoreCase(""))
			response.getWriter().println(results);
		else
			response.getWriter().println(callbackFunName + "( "+results+" )");
		response.setStatus(HttpServletResponse.SC_OK);
        response.flushBuffer();
	}*/
}
