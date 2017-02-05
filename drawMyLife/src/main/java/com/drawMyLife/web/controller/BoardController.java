package com.drawMyLife.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.drawMyLife.common.util.PageUtil;
import com.drawMyLife.web.service.board.BoardService;
import com.drawMyLife.web.vo.BoardVO;

@Controller
public class BoardController {

	@Resource(name = "boardService")
	BoardService boardService;

	// 게시판 작성
	@RequestMapping(value = "/board/insert", method = RequestMethod.GET)
	public ModelAndView insertBoardGet(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav=new ModelAndView("board/insert");
		HashMap<String, Object> map=new HashMap<String, Object>();		
		
		map.put("category_id", Integer.parseInt(req.getParameter("category_id")));
		mav.addObject("category", boardService.selectCategoryList(map).get(0));		
		
		return mav;
	}

	@RequestMapping(value = "/board/insert", method = RequestMethod.POST)
	public String insertBoardPost(@ModelAttribute BoardVO vo, HttpServletRequest req, HttpServletResponse resp) {
		boardService.insertBoard(vo);
		return "redirect:/board/list?categoryId="+vo.getCategoryId();
	}

	// 게시판 리스트
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public ModelAndView listBoardGet(HttpServletRequest req, HttpServletResponse resp,HttpSession session) {
		ModelAndView mav = new ModelAndView("board/list");	
		int page_term=10; // 하나의 페이지에 몇개의 게시판을 표시할 것인가

		HashMap<String, Object> map = new HashMap<String, Object>();

		String page = req.getParameter("page");

		if (page == null || page.equals("")) {
			page = "1";
		}
		map.put("start", (Integer.parseInt(page) - 1)*page_term);
		map.put("page", page_term);
		
		int category_id=Integer.parseInt(req.getParameter("categoryId"));
		map.put("category_id", category_id);

		List<BoardVO> list = boardService.selectList(map);
		
		int totalCount=boardService.selectBoardListCount(map);
		
		mav.addObject("boardList", list);			
		mav.addObject("category",boardService.selectCategoryList(map).get(0));
		PageUtil.setPaging(mav, totalCount, page_term, Integer.parseInt(page));
		
		return mav;
	}

	// 게시판 상세
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView detailBoardGet(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav=new ModelAndView("board/detail");

		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("dno", Integer.parseInt(req.getParameter("dno")));
		BoardVO vo=boardService.selectBoard(map);
		
		map.put("category_id", vo.getCategoryId());
		
		mav.addObject("board", vo);		
		mav.addObject("category",boardService.selectCategoryList(map).get(0));
		return mav;
	}
	
	//게시판 삭제
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String deleteBoardGet(HttpServletRequest req, HttpServletResponse resp) {		
		String boardId=req.getParameter("boardId");
		String categoryId=req.getParameter("categoryId");
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("boardId",Integer.parseInt(boardId));
		boardService.deleteBoard(map);
		return "redirect:/board/list?categoryId="+categoryId;
	}
	
	//게시판 수정
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public ModelAndView updateBoardGet(HttpServletRequest req, HttpServletResponse resp) {	
		ModelAndView mav=new ModelAndView("board/update");
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("dno", Integer.parseInt(req.getParameter("boardId")));
		BoardVO vo=boardService.selectBoard(map);
		
		map.put("categoryId", vo.getCategoryId());
		mav.addObject("category", boardService.selectCategoryList(map).get(0));		
		mav.addObject("board",vo);
		
		return mav;
	}
	
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String updateBoardPost(@ModelAttribute BoardVO vo, HttpServletRequest req, HttpServletResponse resp) {
		boardService.updateBoard(vo);
		return "redirect:/board/list?categoryId="+vo.getCategoryId();
	}
}
