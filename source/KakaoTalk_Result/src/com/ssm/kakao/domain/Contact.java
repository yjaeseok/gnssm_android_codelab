package com.ssm.kakao.domain;

public class Contact {
	public long Id;
	public String DisplayName;
	public String PhotoId;
	
	public Contact(long Id, String DisplayName, String PhotoId) {
		this.Id = Id;
		this.DisplayName = DisplayName;
		this.PhotoId = PhotoId;
	}
}
