package com.cxc.video.ret;

public class OssSign {
	private String accessid;
	private String policy;
	private String signature;
	private String dir;
	private String host;
	private Long expire;
	public String getAccessid() {
		return accessid;
	}
	public void setAccessid(String accessid) {
		this.accessid = accessid;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Long getExpire() {
		return expire;
	}
	public void setExpire(Long expire) {
		this.expire = expire;
	}
}
