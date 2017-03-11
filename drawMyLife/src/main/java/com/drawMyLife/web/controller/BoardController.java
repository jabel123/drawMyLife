package com.drawMyLife.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.drawMyLife.common.dao.MemberAccess;
import com.drawMyLife.common.util.PageUtil;
import com.drawMyLife.web.service.board.BoardService;
import com.drawMyLife.web.service.member.MemberService;
import com.drawMyLife.web.vo.BoardVO;
import com.drawMyLife.web.vo.CategoryVO;
import com.drawMyLife.web.vo.CommentVO;
import com.drawMyLife.web.vo.MemberVO;
import com.google.gson.JsonObject;

/**
 * 
 * @author jabel
 * 작성하다 보니 마이페이지를 관리하는 Controller가 되었다.
 * 1. 하루평가 2. 낙서장 3. TodoList
 */
@Controller
public class BoardController {
	
	@Resource
	private MemberService memberService;
	
	@Resource(name = "boardService")
	BoardService boardService;

	// 게시판 작성
	@RequestMapping(value = "{muid}/board/insert", method = RequestMethod.GET)
	public ModelAndView insertBoardGet(@PathVariable String muid,HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView("board/insert");
		HashMap<String, Object> map = new HashMap<String, Object>();
		MemberVO member=MemberAccess.getMemberInfoUsingMUID(memberService, muid);
	
		map.put("category_id", Integer.parseInt(req.getParameter("category_id")));
		mav.addObject("category", boardService.selectCategoryList(map).get(0));
		mav.addObject("member",member);

		return mav;
	}

	@RequestMapping(value = "{muid}/board/insert", method = RequestMethod.POST)
	public String insertBoardPost(@PathVariable String muid, @ModelAttribute BoardVO vo, HttpServletRequest req, HttpServletResponse resp) {
		boardService.insertBoard(vo);
		MemberVO member=MemberAccess.getMemberInfoUsingMUID(memberService, muid);
		System.out.println(muid);
		return "redirect:/"+muid+"/board/list?categoryId=" + vo.getCategoryId();
	}

	// 게시판 리스트
	@RequestMapping(value = "{muid}/board/list", method = RequestMethod.GET)
	public ModelAndView listBoardGet(@PathVariable String muid, HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		ModelAndView mav = new ModelAndView("board/list");
		int page_term = 10; // 하나의 페이지에 몇개의 게시판을 표시할 것인가

		HashMap<String, Object> map = new HashMap<String, Object>();

		String page = req.getParameter("page");

		if (page == null || page.equals("")) {
			page = "1";
		}
		MemberVO member=MemberAccess.getMemberInfoUsingMUID(memberService, muid);
		map.put("memberId", member.getMno());
		map.put("start", (Integer.parseInt(page) - 1) * page_term);
		map.put("page", page_term);

		int category_id = Integer.parseInt(req.getParameter("categoryId"));
		map.put("category_id", category_id);

		List<BoardVO> list = boardService.selectList(map);

		int totalCount = boardService.selectBoardListCount(map);

		mav.addObject("member",member);
		mav.addObject("boardList", list);
		mav.addObject("category", boardService.selectCategoryList(map).get(0));
		PageUtil.setPaging(mav, totalCount, page_term, Integer.parseInt(page));

		return mav;
	}

	// 게시판 상세
	@RequestMapping(value = "{muid}/board/detail", method = RequestMethod.GET)
	public ModelAndView detailBoardGet(@PathVariable String muid,HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView("board/detail");
		MemberVO member=MemberAccess.getMemberInfoUsingMUID(memberService, muid);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("dno", Integer.parseInt(req.getParameter("dno")));
		BoardVO vo = boardService.selectBoard(map);
		boardService.updateHit(map);
		List<CommentVO> commentList = boardService.selectCommentList(map);

		map.put("category_id", vo.getCategoryId());

		mav.addObject("member",member);
		mav.addObject("board", vo);
		mav.addObject("category", boardService.selectCategoryList(map).get(0));
		mav.addObject("commentList", commentList);
		return mav;
	}

	// 게시판 삭제
	@RequestMapping(value = "{muid}/board/delete", method = RequestMethod.GET)
	public String deleteBoardGet(@PathVariable String muid, HttpServletRequest req, HttpServletResponse resp) {
		String boardId = req.getParameter("boardId");
		String categoryId = req.getParameter("categoryId");

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("boardId", Integer.parseInt(boardId));
		boardService.deleteBoard(map);
		return "redirect:/"+muid+"/board/list?categoryId=" + categoryId;
	}

	// 게시판 수정
	@RequestMapping(value = "{muid}/board/update", method = RequestMethod.GET)
	public ModelAndView updateBoardGet(@PathVariable String muid,HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView("board/update");

		MemberVO member=MemberAccess.getMemberInfoUsingMUID(memberService, muid);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("dno", Integer.parseInt(req.getParameter("boardId")));
		BoardVO vo = boardService.selectBoard(map);

		map.put("category_id", vo.getCategoryId());
		
		mav.addObject("member",member);
		mav.addObject("category", boardService.selectCategoryList(map).get(0));
		mav.addObject("board", vo);

		return mav;
	}

	@RequestMapping(value = "{muid}/board/update", method = RequestMethod.POST)
	public String updateBoardPost(@PathVariable String muid,@ModelAttribute BoardVO vo, HttpServletRequest req, HttpServletResponse resp) {
		boardService.updateBoard(vo);
		return "redirect:/"+muid+"/board/list?categoryId=" + vo.getCategoryId();
	}

	// 댓글 추가
	@RequestMapping(value = "{muid}/board/comment", method = RequestMethod.POST)
	public String insertComment(@PathVariable String muid,@ModelAttribute CommentVO vo, HttpServletRequest req, HttpServletResponse resp) {
		boardService.insertComment(vo);

		System.out.println(vo);
		return "redirect:/"+muid+"/board/detail?dno=" + vo.getBoardId();
	}

	// 오늘 일기를 작성하였나 체크
	@RequestMapping(value = "/board/diaryCheck", method = RequestMethod.POST)
	public ResponseEntity<String> diaryCheck(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json;charset=UTF-8");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		MemberVO member = (MemberVO) session.getAttribute("smember");
		
		map.put("todayCheck", 1);	// todayCheck가 널값만 아니면 오늘날짜로 WHERE문을 걸도록 한다.
		map.put("category_id", 1);
		map.put("mno", member.getMno());
		int boardCount=boardService.selectBoardListCount(map);
		
		JsonObject jObj=new JsonObject();
		if(boardCount>0){			
			jObj.addProperty("writtenDiary", "yes");
		}else{
			jObj.addProperty("writtenDiary", "no");
		}
		
		
		return new ResponseEntity<String>(jObj.toString(), responseHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "{muid}/board/todoList", method = RequestMethod.GET)
	public ModelAndView todoListGet(@PathVariable String muid, HttpServletRequest req, HttpServletResponse resp)
	{
		ModelAndView mav=new ModelAndView("board/todoList");
		
		MemberVO member=MemberAccess.getMemberInfoUsingMUID(memberService, muid);
		mav.addObject("member",member);
		mav.addObject("category",new CategoryVO().setCategoryId(3));
		
		return mav;
		
	}
}
