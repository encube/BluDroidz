package com.CSC193.bludroidz;

import java.io.Serializable;

public class Settings implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serverName;

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	
}
