package com.kh.dodamPj.vo;

import java.sql.Timestamp;

public class CommentVo {
	private int c_no;
	private int n_no;
	private String user_id;
	private String c_content;
	private Timestamp c_regdate;
	public CommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentVo(int c_no, int n_no, String user_id, String c_content, Timestamp c_regdate) {
		super();
		this.c_no = c_no;
		this.n_no = n_no;
		this.user_id = user_id;
		this.c_content = c_content;
		this.c_regdate = c_regdate;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getN_no() {
		return n_no;
	}
	public void setN_no(int n_no) {
		this.n_no = n_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public Timestamp getC_regdate() {
		return c_regdate;
	}
	public void setC_regdate(Timestamp c_regdate) {
		this.c_regdate = c_regdate;
	}
	@Override
	public String toString() {
		return "CommentVo [c_no=" + c_no + ", n_no=" + n_no + ", user_id=" + user_id + ", c_content=" + c_content
				+ ", c_regdate=" + c_regdate + "]";
	}
	
	
}
