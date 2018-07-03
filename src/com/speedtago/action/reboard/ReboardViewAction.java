package com.speedtago.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.speedtago.action.Action;
import com.speedtago.board.model.ReboardDto;
import com.speedtago.board.service.ReboardServiceImpl;
import com.speedtago.member.model.MemberDto;
import com.speedtago.util.ParameterCheck;

public class ReboardViewAction implements Action {

	private static ReboardViewAction reboardViewAction;
	
	static {
		reboardViewAction = new ReboardViewAction();
	}
	
	private ReboardViewAction() {}

	public static ReboardViewAction getReboardViewAction() {
		return reboardViewAction;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp?";
		HttpSession session = request.getSession(); 
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) { 
			int seq = ParameterCheck.naNToZero(request.getParameter("seq"));
			if(seq != 0) {
				ReboardDto reboardDto = ReboardServiceImpl.getReboardService().viewArticle(seq);
				request.setAttribute("article", reboardDto);
				path = "/reboard/view.jsp?";
			}
		} else {
			path = "/index.jsp?";//TODO ���߿� �α��� �������� �̵����Ѷ�.
		}
		return path;
	}

}
