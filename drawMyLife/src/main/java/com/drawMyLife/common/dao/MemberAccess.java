package com.drawMyLife.common.dao;

import com.drawMyLife.web.service.member.MemberService;
import com.drawMyLife.web.vo.MemberVO;

// Rest 방식으로 접근하게되면
// 회원정보를 갖고오는 방식이 잦아지는데 공통코드 관리를 위한 클래스
public class MemberAccess {
	public static MemberVO getMemberInfoUsingMUID(MemberService memberService, String muid) {
		MemberVO vo = new MemberVO();
		vo.setLogin(false);
		vo.setMuid(muid);
		return memberService.selectOneInfo(vo);
	}
}
