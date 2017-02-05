package com.drawMyLife.web.service.board;

import java.util.HashMap;
import java.util.List;

import com.drawMyLife.web.vo.BoardVO;

public interface BoardService {

	void insertBoard(BoardVO vo);
	List<BoardVO> selectList(HashMap<String, Object> param);
	BoardVO selectBoard(HashMap<String, Object> map);
	List<BoardVO> selectCategoryList(HashMap<String, Object> map);
	int selectBoardListCount(HashMap<String, Object> map);
	void deleteBoard(HashMap<String, Object> map);
	void updateBoard(BoardVO vo);
}
