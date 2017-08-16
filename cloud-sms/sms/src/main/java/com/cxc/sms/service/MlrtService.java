/**
 * 
 */
package com.cxc.sms.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cxc.sms.Sms;
import com.cxc.sms.util.Md5Util;
import com.cxc.sms.util.SmsUtil;

/**
 * <pre>
 * @author Leo
 * 美联软通发送服务
 * </pre>
 */
@Service
public class MlrtService implements SendService{

	private static final Logger log = LoggerFactory.getLogger(MlrtService.class);
	private String sendUrl = "http://m.5c.com.cn/api/send/index.php?username=%s&password_md5=%s&apikey=%s&mobile=%s&content=%s&encode=%s";
	@Value("${cxc.sms.mlrt.username}")
	private String username;
	@Value("${cxc.sms.mlrt.password}")
	private String password;
	@Value("${cxc.sms.mlrt.apikey}")
	private String apikey;
	@Value("${cxc.sms.mlrt.encode}")
	private String encode;
	@Value("${cxc.sms.mlrt.weight}")
	private Integer weight;
	
	private String password_md5;
	
	@PostConstruct
	public void init() {
		password_md5 = Md5Util.getMD5String(password).toLowerCase();
	}
	
	@Override
	public boolean sendOne(Sms sms) throws Exception{
		//新建一个StringBuffer链接
		//String encode = "GBK"; //页面编码和短信内容编码为GBK。重要说明：如提交短信后收到乱码，请将GBK改为UTF-8测试。如本程序页面为编码格式为：ASCII/GB2312/GBK则该处为GBK。如本页面编码为UTF-8或需要支持繁体，阿拉伯文等Unicode，请将此处写为：UTF-8

		if (StringUtils.isNotBlank(sms.getContent()) && SmsUtil.isValidMobile(sms.getMobile())) {
			if (StringUtils.isBlank(sms.getEncode())) {
				sms.setEncode(encode);
			}
			BufferedReader reader = null;
			try {
				String contentUrlEncode = URLEncoder.encode(sms.getContent(), sms.getEncode());  //对短信内容做Urlencode编码操作。注意：如
				//如连接超时，可能是您服务器不支持域名解析，请将下面连接中的：【m.5c.com.cn】修改为IP：【115.28.23.78】
				//把链接存入新建的URL中
				String link = String.format(sendUrl, username, password_md5, apikey, sms.getMobile(), contentUrlEncode, sms.getEncode());
				URL url = new URL(link);
				//打开URL链接
				HttpURLConnection connection = (HttpURLConnection)url.openConnection();
				//使用POST方式发送
				connection.setRequestMethod("POST");
				//使用长链接方式
				connection.setRequestProperty("Connection", "Keep-Alive");
				//发送短信内容
				reader = new BufferedReader(new InputStreamReader(url.openStream()));
				//获取返回值
				String result = reader.readLine();
				//输出result内容，查看返回值，成功为success，错误为error，详见该文档起始注释
				/**
				 success:msgid  提交成功
				 error:msgid  提交失败  
				 error:Missing username  用户名为空
				 error:Missing password  密码为空
				 error:Missing apikey  APIKEY为空
				 error:Missing recipient  手机号码为空
				 error:Missing message content  短信内容为空
				 error:Account is blocked  帐号被禁用
				 error:Unrecognized encoding  编码未能识别
				 error:APIKEY or password_md5 error  APIKEY或密码错误
				 error:Unauthorized IP address  未授权 IP 地址
				 error:Account balance is insufficient  余额不足
				 */
				log.warn("mobile:{},content:{},result:{}", sms.getMobile(), sms.getContent(), result);
				if (StringUtils.contains(result, "success")) {
					return true;
				}
			} catch (Exception e) {
				log.error("send mlrt sms error", e);
			} finally {
				if (reader != null) {
					reader.close();
				}
			}
		}
		
		return false;
	}

	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
}
