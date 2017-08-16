package com.cxc.video.ali;

import java.util.Map;
import java.util.TreeMap;

/**
 * 阿里云视频服务公共参数
 * @author wanglei
 * 2017-4-27
 */
public class AliVideoCommonParams {
	/**
	 * Format 	String 	否 	返回值的类型，支持JSON与XML，默认为XML。
Version 	String 	是 	API版本号，为日期形式：YYYY-MM-DD，本版本对应为2017-03-21。
AccessKeyId 	String 	是 	阿里云颁发给用户的访问服务所用的密钥ID。
Signature 	String 	是 	签名结果串，关于签名的计算方法，请参见签名机制。
SignatureMethod 	String 	是 	签名方式，目前支持HMAC-SHA1。
Timestamp 	String 	是 	请求的时间戳。日期格式按照ISO8601标准表示，并需要使用UTC时间。格式为：YYYY-MM-DDThh:mm:ssZ
例如，2017-3-29T12:00:00Z(为北京时间2017年3月29日的20点0分0秒。
SignatureVersion 	String 	是 	签名算法版本，目前版本是1.0。
SignatureNonce 	String 	是 	唯一随机数，用于防止网络重放攻击。用户在不同请求间要使用不同的随机数值。
	 */
	
	private String Format;
	private String Version;
	private String AccessKeyId;
	private String Signature;
	private String SignatureMethod;
	private String Timestamp;
	private String SignatureVersion;
	private String SignatureNonce;
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getAccessKeyId() {
		return AccessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		AccessKeyId = accessKeyId;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature(String signature) {
		Signature = signature;
	}
	public String getSignatureMethod() {
		return SignatureMethod;
	}
	public void setSignatureMethod(String signatureMethod) {
		SignatureMethod = signatureMethod;
	}
	public String getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}
	public String getSignatureVersion() {
		return SignatureVersion;
	}
	public void setSignatureVersion(String signatureVersion) {
		SignatureVersion = signatureVersion;
	}
	public String getSignatureNonce() {
		return SignatureNonce;
	}
	public void setSignatureNonce(String signatureNonce) {
		SignatureNonce = signatureNonce;
	}
	public static void main11(String[] args) {
		//Timestamp=2015-05-14T09%3A03%3A45Z&Format=XML&AccessKeyId=testId&Action=GetVideoPlayAuth&PageSize=2&SignatureMethod=HMAC-SHA1&SignatureNonce=4902260a-516a-4b6a-a455-45b653cf6150&SignatureVersion=1.0&Version=2017-03-21
		Map<String, String> map = new TreeMap<>();
		map.put("Timestamp", "2015-05-14T09%3A03%3A45Z");
		map.put("Format", "XML");
		map.put("AccessKeyId", "testId");
		map.put("Action", "GetVideoPlayAuth");
		map.put("PageSize", "2");
		map.put("SignatureMethod", "HMAC-SHA1");
		map.put("SignatureNonce", "4902260a-516a-4b6a-a455-45b653cf6150");
		map.put("SignatureVersion", "1.0");
		map.put("Version", "2017-03-21");
		for (String key : map.keySet()) {
			System.out.println(key);
		}
	}
}
