package com.drawMyLife.web.service.board;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.drawMyLife.web.dao.BoardDao;
import com.drawMyLife.web.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Resource(name="boardDao")
	BoardDao boardDao;
	
	@Override
	public void insertBoard(BoardVO vo) {
		boardDao.insert(vo);
	}

	@Override
	public List<BoardVO> selectList(HashMap<String, Object> param) {
		
		return boardDao.selectList(param);
	}

	@Override
	public BoardVO selectBoard(HashMap<String, Object> map) {
		return boardDao.selectBoard(map);
	}

	@Override
	public List<BoardVO> selectCategoryList(HashMap<String, Object> map) {
		// 
		return boardDao.selectCategoryList(map);
	}

}
