package com.kh.dodamPj.vo;

import java.sql.Timestamp;

public class NewsBoardVo {
	private int ab_no;
	private String ab_title;
	private String ab_content;
	private String user_id;
	private Timestamp ab_regdate;
	private int ab_count;
	private int are_group;
	private int are_seq;
	private int are_level;
	private int comment_cnt;
	
	public NewsBoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsBoardVo(int ab_no, String ab_title, String ab_content, String user_id, Timestamp ab_regdate,
			int ab_count, int are_group, int are_seq, int are_level, int comment_cnt) {
		super();
		this.ab_no = ab_no;
		this.ab_title = ab_title;
		this.ab_content = ab_content;
		this.user_id = user_id;
		this.ab_regdate = ab_regdate;
		this.ab_count = ab_count;
		this.are_group = are_group;
		this.are_seq = are_seq;
		this.are_level = are_level;
		this.comment_cnt = comment_cnt;
	}

	public int getAb_no() {
		return ab_no;
	}

	public void setAb_no(int ab_no) {
		this.ab_no = ab_no;
	}

	public String getAb_title() {
		return ab_title;
	}

	public void setAb_title(String ab_title) {
		this.ab_title = ab_title;
	}

	public String getAb_content() {
		return ab_content;
	}

	public void setAb_content(String ab_content) {
		this.ab_content = ab_content;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Timestamp getAb_regdate() {
		return ab_regdate;
	}

	public void setAb_regdate(Timestamp ab_regdate) {
		this.ab_regdate = ab_regdate;
	}

	public int getAb_count() {
		return ab_count;
	}

	public void setAb_count(int ab_count) {
		this.ab_count = ab_count;
	}

	public int getAre_group() {
		return are_group;
	}

	public void setAre_group(int are_group) {
		this.are_group = are_group;
	}

	public int getAre_seq() {
		return are_seq;
	}

	public void setAre_seq(int are_seq) {
		this.are_seq = are_seq;
	}

	public int getAre_level() {
		return are_level;
	}

	public void setAre_level(int are_level) {
		this.are_level = are_level;
	}

	public int getComment_cnt() {
		return comment_cnt;
	}

	public void setComment_cnt(int comment_cnt) {
		this.comment_cnt = comment_cnt;
	}

	@Override
	public String toString() {
		return "newsBoardVo [ab_no=" + ab_no + ", ab_title=" + ab_title + ", ab_content=" + ab_content + ", user_id="
				+ user_id + ", ab_regdate=" + ab_regdate + ", ab_count=" + ab_count + ", are_group=" + are_group
				+ ", are_seq=" + are_seq + ", are_level=" + are_level + ", comment_cnt=" + comment_cnt + "]";
	}

	
}
