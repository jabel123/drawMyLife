package com.drawMyLife.web.vo;

import java.sql.Date;

/*DIARY_ID	int(11)
MEMBER_ID	int(11)
WRITE_DATE	date
MODIFY_DATE	date
TITLE	varchar(45)
CONTENT	varchar(45)
EVALUATION	int(11)*/

public class BoardVO {
	private int boardId;
	private int memberId;
	private String mname;
	private Date writeDate;
	private Date modifyDate;
	private String title;
	private String content;
	private int evaluation;
	
	private int categoryId;
	private String categoryName;
	

	public int getBoardId() {
		return boardId;
	}

	public BoardVO setBoardId(int boardId) {
		this.boardId = boardId;
		return this;
	}

	public int getMemberId() {
		return memberId;
	}

	public BoardVO setMemberId(int memberId) {
		this.memberId = memberId;
		return this;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public BoardVO setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
		return this;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public BoardVO setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public BoardVO setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getContent() {
		return content;
	}

	public BoardVO setContent(String content) {
		this.content = content;
		return this;
	}

	public int getEvaluation() {
		return evaluation;
	}

	public BoardVO setEvaluation(int evaluation) {
		this.evaluation = evaluation;
		return this;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", memberId=" + memberId + ", mname=" + mname + ", writeDate="
				+ writeDate + ", modifyDate=" + modifyDate + ", title=" + title + ", content=" + content
				+ ", evaluation=" + evaluation + ", categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

	

}
