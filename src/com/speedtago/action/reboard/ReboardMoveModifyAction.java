package com.speedtago.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.speedtago.action.Action;
import com.speedtago.board.model.ReboardDto;
import com.speedtago.board.service.ReboardServiceImpl;
import com.speedtago.member.model.MemberDto;
import com.speedtago.util.ParameterCheck;

public class ReboardMoveModifyAction implements Action {

	private static ReboardMoveModifyAction reboardMoveModifyAction;
	
	static {
		reboardMoveModifyAction = new ReboardMoveModifyAction();
	}
	
	private ReboardMoveModifyAction() {}

	public static ReboardMoveModifyAction getReboardMoveModifyAction() {
		return reboardMoveModifyAction;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path ="/index.jsp?";
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = ParameterCheck.naNToZero(request.getParameter("seq"));
			System.out.println("ReboardMoveModifyAction seq >>>>>" + seq);
			
			ReboardDto reboardDto = ReboardServiceImpl.getReboardService().getArticle(seq);
			request.setAttribute("article", reboardDto);
			
			//�ۼ��� > ��Ʈ�ѷ� > �׼�(���� - mvmodify) > ���� > DAO > modify.jsp > �̵�
			
			
			path = "/reboard/modify.jsp?seq=" + seq + "&";
			
		}else {
			path = "/index.jsp";
		}
		return path;
	}
}
