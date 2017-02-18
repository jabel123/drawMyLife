package com.drawMyLife.web.vo;

import java.sql.Date;

/*
 * 테이블 컬럼
COMMENT_ID	int(11)		//댓글 pk
BOARD_ID	int(11)		//게시글 ID(FK)
MEMBER_ID	int(11)		//작성자 ID(FK)
COMMENT	varchar(300)	//댓글내용
CRE_DATE	datetime	//작성일자
 */

public class CommentVO {
	private int categoryId;
	private String memberName;
	
	private int commentId;
	private int boardId;
	private int memberId;
	private String comment;
	private Date creDate;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreDate() {
		return creDate;
	}

	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "CommentVO [commentId=" + commentId + ", boardId=" + boardId + ", memberId=" + memberId + ", comment="
				+ comment + ", creDate=" + creDate + "]";
	}

}
