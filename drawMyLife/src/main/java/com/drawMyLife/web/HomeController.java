package com.drawMyLife.web;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.drawMyLife.common.dao.MemberAccess;
import com.drawMyLife.web.service.board.BoardService;
import com.drawMyLife.web.service.member.MemberServiceImpl;
import com.drawMyLife.web.vo.BoardVO;
import com.drawMyLife.web.vo.MemberVO;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class HomeController {

	@Resource(name = "memberService")
	private MemberServiceImpl memberService;
	@Resource(name = "boardService")
	BoardService boardService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/{muid}", method = RequestMethod.GET)
	public ModelAndView home(@PathVariable("muid") String muid) throws Exception {
		ModelAndView mav = new ModelAndView("home");

		MemberVO vo = MemberAccess.getMemberInfoUsingMUID(memberService, muid);

		mav.addObject("member", vo);
		return mav;
	}

	// 일기의 평가점수들을 그래프로 나타내기위해 json 형식으로 전달하는 함수
	@RequestMapping(value = "/member/graph", method = RequestMethod.POST)
	public ResponseEntity<String> homeGraphGet(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json;charset=UTF-8");

		HashMap<String, Object> map = new HashMap<String, Object>();

		MemberVO member = MemberAccess.getMemberInfoUsingMUID(memberService, req.getParameter("muid"));
		/* MemberVO member=(MemberVO) session.getAttribute("smember"); */
		map.put("memberId", member.getMno());
		map.put("category_id", 1);
		map.put("start", 0);
		map.put("page", 13);
		// start,page
		List<BoardVO> boardList = boardService.selectList(map);
		JsonObject jObj = new JsonObject();
		JsonArray lineArray = new JsonArray();
		JsonArray diaryArr = new JsonArray();

		for (BoardVO vo : boardList) {
			// 그래프를 그려주기 위한 JsonArray
			JsonArray jArray = new JsonArray();
			jArray.add(vo.getWriteDate().toString());
			jArray.add(vo.getEvaluation());
			lineArray.add(jArray);

			// 나의 다이어리 리스트에 추가할 vo
			JsonObject obj = new JsonObject();
			obj.addProperty("dno", vo.getBoardId());
			obj.addProperty("title", vo.getTitle());
			obj.addProperty("writeDate", vo.getWriteDate().toString());
			diaryArr.add(obj);
		}
		jObj.add("line", lineArray);
		jObj.add("diaryArr", diaryArr);

		return new ResponseEntity<String>(jObj.toString(), responseHeaders, HttpStatus.OK);
	}

	// 첫 페이지인 index.jsp 이다. 친구목록만 뿌리는 상태이다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexGET() throws Exception {
		ModelAndView mav = new ModelAndView("index");
		
		
		mav.addObject("categoryId",1);
		

		return mav;
	}

	// 첫 페이지인 index.jsp 이다. 친구목록만 뿌리는 상태이다.
	@RequestMapping(value = "/friendSearch", method = RequestMethod.GET)
	public ModelAndView friendSearchGet() throws Exception {
		ModelAndView mav = new ModelAndView("home/friendSearch");
		HashMap<String, Object> map = new HashMap();
		List<MemberVO> memberList = memberService.selectMemberList(map);

		mav.addObject("categoryId",2);
		mav.addObject("memberList", memberList);

		return mav;
	}
}
