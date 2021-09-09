package com.id3.crudapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_detail")
public class UserDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="linkedin_link")
	private String linkedinLink;
	
	@Column(name="education")
	private String education;

	public UserDetail(String linkedinLink, String education) {
		this.linkedinLink = linkedinLink;
		this.education = education;
	} 
	
	public UserDetail() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLinkedinLink() {
		return linkedinLink;
	}

	public void setLinkedinLink(String linkedinLink) {
		this.linkedinLink = linkedinLink;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", linkedinLink=" + linkedinLink + ", education=" + education + "]";
	}
	
	
	
}
