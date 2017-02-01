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
		System.out.println( boardService.selectCategoryList(map).get(0));
		
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
		
	
		List<BoardVO> categoryList=boardService.selectCategoryList(new HashMap<String, Object>());
		mav.addObject("categoryList", categoryList);
	

		HashMap<String, Object> map = new HashMap<String, Object>();

		String page = req.getParameter("page");

		if (page == null || page.equals("")) {
			page = "1";
		}
		map.put("start", Integer.parseInt(page) - 1);
		map.put("page", 20);
		
		int category_id=Integer.parseInt(req.getParameter("categoryId"));
		map.put("category_id", category_id);

		List<BoardVO> list = boardService.selectList(map);
		
		mav.addObject("boardList", list);			
		mav.addObject("category",boardService.selectCategoryList(map).get(0));
		
		return mav;
	}

	// 게시판 상세
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public ModelAndView detailBoardGet(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav=new ModelAndView("board/detail");
		List<BoardVO> categoryList=boardService.selectCategoryList(new HashMap<String, Object>());
		mav.addObject("categoryList", categoryList);
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("dno", Integer.parseInt(req.getParameter("dno")));
		mav.addObject("board", boardService.selectBoard(map));
		return mav;
	}
}
