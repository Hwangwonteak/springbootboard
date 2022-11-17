package com.sycompany.boardtest01;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sycompany.boardtest01.dao.IDao;
import com.sycompany.boardtest01.dto.MemberDto;

@Controller
public class TestController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/join")
	public String join() {
	
		
		return "join";
	}
	
	@RequestMapping("/joinMember")
	public String joinMember(HttpServletRequest request, Model model) {
	
		//IDao는 인터페이스라서 생성자 사용불가
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		dao.memberJoin(mid, mpw, mname, memail);
		
		model.addAttribute("memberID",mid);
		
		return "joinOk";
	}
	
	@RequestMapping("/joinOk")
	public String joinOk() {

		return "joinOk";
	}
	
	@RequestMapping("/memberList")
	public String memberList(Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		
		dtos = dao.memberList();
		
		model.addAttribute("dtos",dtos);

		return "memberList";
	}
	
	@RequestMapping("/idSearch")
	public String idSearch(Model model) {
		

		return "idSearch";
	}
	
	@RequestMapping("/idok")
	public String idok(HttpServletRequest request ,Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("searchId");
		
		MemberDto dto = dao.searchIdOk(mid);
		
		model.addAttribute("dto", dto);

		return "idok";
	}
}
