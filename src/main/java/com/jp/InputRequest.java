package com.jp;

public class InputRequest<T> {
	
	private String userId;
	private T userDetails;
	
	public InputRequest() {
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public T getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(T userDetails) {
		this.userDetails = userDetails;
	}

}
