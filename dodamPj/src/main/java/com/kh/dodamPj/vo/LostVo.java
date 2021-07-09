package com.kh.dodamPj.vo;

import java.sql.Timestamp;

public class LostVo {
	private int b_no;
	private String b_title;
	private String b_content;
	private String user_name;
	private String user_email;
	private String user_tel;
	private Timestamp write_date;
	private int b_viewcnt;
	private String p_name;
	private String p_species;
	private String p_age;
	private String p_gender;
	private Timestamp p_lostdate;
	private String p_lostplace;
	private String p_character;
	
	public LostVo() {
		super();
	}

	public LostVo(int b_no, String b_title, String b_content, String user_name, int b_viewcnt) {
		super();
		this.b_no = b_no;
		this.b_title = b_title;
		this.b_content = b_content;
		this.user_name = user_name;
		this.b_viewcnt = b_viewcnt;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_tel() {
		return user_tel;
	}

	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	public Timestamp getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}

	public int getB_viewcnt() {
		return b_viewcnt;
	}

	public void setB_viewcnt(int b_viewcnt) {
		this.b_viewcnt = b_viewcnt;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_species() {
		return p_species;
	}

	public void setP_species(String p_species) {
		this.p_species = p_species;
	}

	public String getP_age() {
		return p_age;
	}

	public void setP_age(String p_age) {
		this.p_age = p_age;
	}

	public String getP_gender() {
		return p_gender;
	}

	public void setP_gender(String p_gender) {
		this.p_gender = p_gender;
	}

	public Timestamp getP_lostdate() {
		return p_lostdate;
	}

	public void setP_lostdate(Timestamp p_lostdate) {
		this.p_lostdate = p_lostdate;
	}

	public String getP_lostplace() {
		return p_lostplace;
	}

	public void setP_lostplace(String p_lostplace) {
		this.p_lostplace = p_lostplace;
	}

	public String getP_character() {
		return p_character;
	}

	public void setP_character(String p_character) {
		this.p_character = p_character;
	}

	@Override
	public String toString() {
		return "LostVo [b_no=" + b_no + ", b_title=" + b_title + ", b_content=" + b_content + ", user_name=" + user_name
				+ ", user_email=" + user_email + ", user_tel=" + user_tel + ", write_date=" + write_date
				+ ", b_viewcnt=" + b_viewcnt + ", p_name=" + p_name + ", p_species=" + p_species + ", p_age=" + p_age
				+ ", p_gender=" + p_gender + ", p_lostdate=" + p_lostdate + ", p_lostplace=" + p_lostplace
				+ ", p_character=" + p_character + "]";
	}
	
}