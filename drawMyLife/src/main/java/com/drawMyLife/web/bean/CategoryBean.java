package com.drawMyLife.web.bean;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.drawMyLife.web.vo.BoardVO;

public class CategoryBean {
	private SqlSessionTemplate template;
	private List<BoardVO> categoryList;
	
	public CategoryBean(SqlSessionTemplate template) {
		this.template=template;
	}

	public List<BoardVO> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<BoardVO> categoryList) {
		this.categoryList = categoryList;
	}


	
}
