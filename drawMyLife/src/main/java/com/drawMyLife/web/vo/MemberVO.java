package com.drawMyLife.web.vo;

import java.sql.Date;
/*
 * 테이블 컬럼
 * 
MNO	int(11)					//회원 NO (PK)
EMAIL	varchar(45)			//EMAIL
PWD	varchar(100)			//비밀번호
MNAME	varchar(50)			//닉네임
CRE_DATE	datetime		//가입날짜
MOD_DATE	datetime		//수정날짜
 */
public class MemberVO {
	private int mno;
	private String muid;
	private String email;
	private String pwd;
	private String mname;
	private Date creDate;
	private Date modDate;
	private boolean isLogin;

	public boolean isLogin() {
		return isLogin;
	}

	public MemberVO setLogin(boolean isLogin) {
		this.isLogin = isLogin;
		return this;
	}

	public int getMno() {
		return mno;
	}

	public MemberVO setMno(int mno) {
		this.mno = mno;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public MemberVO setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPwd() {
		return pwd;
	}

	public MemberVO setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}

	public String getMname() {
		return mname;
	}

	public MemberVO setMname(String mname) {
		this.mname = mname;
		return this;
	}

	public Date getCreDate() {
		return creDate;
	}

	public MemberVO setCreDate(Date creDate) {
		this.creDate = creDate;
		return this;
	}

	public Date getModDate() {
		return modDate;
	}

	public MemberVO setModDate(Date modDate) {
		this.modDate = modDate;
		return this;
	}

	public String getMuid() {
		return muid;
	}

	public void setMuid(String muid) {
		this.muid = muid;
	}

	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", muid=" + muid + ", email=" + email + ", pwd=" + pwd + ", mname=" + mname
				+ ", creDate=" + creDate + ", modDate=" + modDate + ", isLogin=" + isLogin + "]";
	}


}
