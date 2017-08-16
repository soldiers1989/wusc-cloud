package com.cxc.chat.easemob.model;

/**
 *<pre>
 * {
  "access_token":"YWMtWY779DgJEeS2h9OR7fw4QgAAAUmO4Qukwd9cfJSpkWHiOa7MCSk0MrkVIco",
  "expires_in":5184000,
  "application":"c03b3e30-046a-11e4-8ed1-5701cdaaa0e4"
 * }</pre>
 * @author china
 *
 */
public class TokenResult {
	private String access_token;
	private Integer expires_in;//以秒为单位
	private String application;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
}
