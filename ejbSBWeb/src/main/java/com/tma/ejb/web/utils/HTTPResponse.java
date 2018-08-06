package com.tma.ejb.web.utils;

public enum HTTPResponse {
	OK("ok", 200), ACCEPTED("accepted", 202), SERVER_ERROR("server error", 500);

	private String respMsg;
	private int statusCode;

	HTTPResponse(String msg, int status) {
		this.setRespMsg(msg);
		this.setStatusCode(status);
	}

	public String getRespMsg() {
		return respMsg;
	}

	void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public int getStatusCode() {
		return statusCode;
	}

	void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
