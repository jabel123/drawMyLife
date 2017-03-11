package com.drawMyLife.web.vo;

/**
 * categoryId
 * 1 : 하루평가
 * 2 : 낙서장
 * 3 : todoList
 * @author jabel
 *
 */
public class CategoryVO {
	public int categoryId;

	public int getCategoryId() {
		return categoryId;
	}

	public CategoryVO setCategoryId(int categoryId) {
		this.categoryId = categoryId;
		return this;
	}
}
