package com.drawMyLife.web.service.board;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.drawMyLife.web.dao.BoardDao;
import com.drawMyLife.web.vo.BoardVO;
import com.drawMyLife.web.vo.CommentVO;

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

	@Override
	public int selectBoardListCount(HashMap<String, Object> map) {
		
		return boardDao.selectBoardListCount(map);
	}

	@Override
	public void deleteBoard(HashMap<String, Object> map) {
		boardDao.deleteBoard(map);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDao.updateBoard(vo);
	}

	@Override
	public void insertComment(CommentVO vo) {
		boardDao.insertComment(vo);
		
	}

	@Override
	public List<CommentVO> selectCommentList(HashMap<String, Object> map) {
		return boardDao.selectCommentList(map);
	}

}
