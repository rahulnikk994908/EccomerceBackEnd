package com.backend.Response;

public class AuthResponse {
	
	private String jwt;
	private String msg;
	private boolean status;

	public AuthResponse(String jwt, String msg) {
		super();
		this.jwt = jwt;
		this.msg = msg;
	}
	public AuthResponse(String jwt, boolean status) {
		super();
		this.jwt = jwt;
		this.status = status;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
   public AuthResponse() {
	   
   }
}
