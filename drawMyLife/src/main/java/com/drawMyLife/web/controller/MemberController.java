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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.drawMyLife.web.service.board.BoardService;
import com.drawMyLife.web.service.member.MemberService;
import com.drawMyLife.web.vo.BoardVO;
import com.drawMyLife.web.vo.LoginVO;
import com.drawMyLife.web.vo.MemberVO;
import com.google.gson.Gson;

/**
 * 
 * @author jabel 회원관리 관련 클래스
 *
 */
@Controller
public class MemberController {
	@Resource
	private MemberService memberService;
	
	@Resource(name = "boardService")
	BoardService boardService;
	
	/**
	 * 회원가입
	 * ------------------------------------------------------------------------------
	 */
	@RequestMapping(value = "/member/join", method = RequestMethod.GET)
	public ModelAndView memberJoinGet(HttpServletRequest req, HttpServletResponse resp) {

		ModelAndView mav=new ModelAndView("member/join");
		return mav;
	}

	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public String memberJoinPost(@ModelAttribute MemberVO vo, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {
		memberService.insertMember(vo);

		return "redirect:/";
	}

	/**
	 * 로그인
	 * ------------------------------------------------------------------------------
	 */

	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public ResponseEntity<String> memberLoginPost(@ModelAttribute MemberVO vo, HttpServletRequest req,
			HttpServletResponse resp, HttpSession session) {
		
		LoginVO loginVO = new LoginVO();

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json;charset=UTF-8");

		if (memberService.selectId(vo) == 0) {
			loginVO.setIsSucceed(LoginVO.Succeed.IDERR.toString());
		} 
		else if (memberService.selectIdAndPw(vo) == 0) {
			loginVO.setIsSucceed(LoginVO.Succeed.PWERR.toString());
		} 
		else {
			loginVO.setIsSucceed(LoginVO.Succeed.OK.toString());			
			vo=memberService.selectOneInfo(vo);			
			session.setAttribute("smember", vo);
			
		}
		Gson gson = new Gson();

		
		return new ResponseEntity<String>(gson.toJson(loginVO), responseHeaders, HttpStatus.OK);
	}
	
	/**
	 * 로그아웃 session.invalidate(); 
	 */
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String memberLogoutGet(HttpServletRequest req, HttpServletResponse resp,HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
}
