package com.drawMyLife.web;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.drawMyLife.web.service.board.BoardService;
import com.drawMyLife.web.service.member.MemberServiceImpl;
import com.drawMyLife.web.vo.BoardVO;

@Controller
public class HomeController {
	
	@Resource(name="memberService")
	private MemberServiceImpl memberService;
	@Resource(name="boardService")
	BoardService boardService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model,HttpSession session) throws Exception {
		ModelAndView mav=new ModelAndView("home");
		
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("page", 5);
		map.put("start", 0);
		
		map.put("category_id", 1);
		List<BoardVO> list=boardService.selectList(map);
		
		mav.addObject("boardList", list);
		
		return mav;
	}	
}
