package com.gowoo.chatApp.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "member")
public class MemberDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long seq;
	
	@Column(name = "id")
	private String id;
	
	@Column(name="pw")
	private String pw;
	
	
	
	public MemberDTO() {
		
	}
	
	public MemberDTO(String id,String pw) {
		this.id=id;
		this.pw=pw;
	}
	
	

	@Override
	public String toString() {
		return "MemberDTO [seq=" + seq + ", id=" + id + ", pw=" + pw + "]";
	}



	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
}
