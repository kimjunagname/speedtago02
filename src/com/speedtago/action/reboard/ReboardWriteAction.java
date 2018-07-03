package com.speedtago.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.speedtago.action.Action;
import com.speedtago.board.model.ReboardDto;
import com.speedtago.board.service.ReboardServiceImpl;
import com.speedtago.member.model.MemberDto;
import com.speedtago.util.ParameterCheck;

public class ReboardWriteAction implements Action {
	
	private static ReboardWriteAction reboardWriteAction;
	
	static {
		reboardWriteAction = new ReboardWriteAction();
	}
	
	private ReboardWriteAction() {}

	public static ReboardWriteAction getReboardWriteAction() {
		return reboardWriteAction;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/reboard/writefail.jsp";
		HttpSession session = request.getSession(); 
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) { 
			ReboardDto reboardDto = new ReboardDto();	
			reboardDto.setId(memberDto.getId());
			reboardDto.setName(memberDto.getName());
			reboardDto.setEmail(memberDto.getEmail1() + "@" + memberDto.getEmail2());
			reboardDto.setSubject(request.getParameter("subject"));
			reboardDto.setContent(request.getParameter("content"));
			reboardDto.setBcode(ParameterCheck.naNToZero(request.getParameter("bcode")));
			
			int seq = ReboardServiceImpl.getReboardService().writeArticle(reboardDto);
			if(seq != 0) {
				path = "/reboard/writeok.jsp?seq=" + seq + "&";
			}
		} else {
			path = "/index.jsp?";//TODO 나중에 로그인 페이지로 이동시켜라.
		}
		return path;
	}

}
