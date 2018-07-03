package com.speedtago.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.speedtago.action.Action;
import com.speedtago.board.model.ReboardDto;
import com.speedtago.board.service.ReboardServiceImpl;
import com.speedtago.member.model.MemberDto;
import com.speedtago.util.ParameterCheck;

public class ReboardModifyAction implements Action {

	private static ReboardModifyAction reboardModifyAction;
	
	static {
		reboardModifyAction = new ReboardModifyAction();
	}
	
	private ReboardModifyAction() {}

	public static ReboardModifyAction getReboardModifyAction() {
		return reboardModifyAction;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = "/reboard/writefail.jsp";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		
		
		if(memberDto != null) {
			ReboardDto reboardDto = new ReboardDto();	
			reboardDto.setSubject(request.getParameter("subject"));
			reboardDto.setContent(request.getParameter("content"));
			reboardDto.setSeq(ParameterCheck.naNToZero(request.getParameter("seq")));
			
			int seq = ParameterCheck.naNToZero(request.getParameter("seq"));
			
			System.out.println("subject>>"+ reboardDto.getSubject());
			
			int cnt = ReboardServiceImpl.getReboardService().modifyArticle(reboardDto);
			request.setAttribute("article", reboardDto);
			//�ۼ��� > ��Ʈ�ѷ� > �׼�(���� - mvmodify) > ���� > DAO > modify.jsp > �̵�
			
			//path = "/reboard/view.jsp?seq=" + seq + "&";
			path = "/reboard/modifyok.jsp?";
			
			//Reboard reboardDto = ReboardServiceImple
			//request.setAttribut("article", reboardDto);
			//path = "/revoard/view.jsp"
			//
			//path = "/reboard?act=viewarticle"
			//service >> ���ٷ�Ʈ
			
			
			
		}else {
			path = "/reboard/modifyfail.jsp?";
		}
		return path;
	}
}

