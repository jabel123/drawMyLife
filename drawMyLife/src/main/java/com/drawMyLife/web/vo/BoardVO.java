package com.drawMyLife.web.vo;

import java.sql.Date;

/*
 * 테이블 컬럼
BOARD_ID	int(11)		게시판 PK
MEMBER_ID	int(11)		작성자 ID(FK)
WRITE_DATE	date		작성날짜
MODIFY_DATE	date		수정날짜
TITLE	varchar(45)		제목
CONTENT	mediumtext		내용
EVALUATION	int(11)		게시글 평가점수(일기에 활용)
CATEGORY_ID	int(11)		게시글 카테고리 ID(FK)
HIT	int(11)				조회수

*/

public class BoardVO {
	private int boardId;			// 게시판 고유번호
	private int memberId;			// 사용자 번호
	private String mname;			// 사용자 이름
	private Date writeDate;			// 작성날짜
	private Date modifyDate;		// 수정날짜
	private String title;			// 제목
	private String content;			// 내용
	private int evaluation;			// 평가점수
	private int hit;				// 조회수
	
	private int categoryId;			// 카테고리 아이디
	private String categoryName;	// 카테고리 명
	

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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", memberId=" + memberId + ", mname=" + mname + ", writeDate="
				+ writeDate + ", modifyDate=" + modifyDate + ", title=" + title + ", content=" + content
				+ ", evaluation=" + evaluation + ", categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

	

}
