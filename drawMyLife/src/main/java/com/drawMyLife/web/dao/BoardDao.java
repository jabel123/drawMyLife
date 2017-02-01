package com.drawMyLife.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drawMyLife.common.dao.AbstractDao;
import com.drawMyLife.web.vo.BoardVO;

@Repository("boardDao")
public class BoardDao extends AbstractDao{
	
	public void insert(BoardVO vo){
		insert("board.insertBoard", vo);		
	}
	public List<BoardVO> selectList(Map<String, Object> param){ 
		List<BoardVO> list=selectList("board.selectList",param);
		return list;
	}
	public BoardVO selectBoard(HashMap<String, Object> map) {
		
		return (BoardVO) selectOne("board.selectDetail", map);
	}
	public List<BoardVO> selectCategoryList(HashMap<String, Object> map) {
		List<BoardVO> list=selectList("board.selectCategory",map);
		return list;
	}
}
