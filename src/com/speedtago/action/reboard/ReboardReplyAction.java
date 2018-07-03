package com.speedtago.action.reboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.speedtago.action.Action;
import com.speedtago.board.model.ReboardDto;
import com.speedtago.board.service.ReboardServiceImpl;
import com.speedtago.member.model.MemberDto;
import com.speedtago.util.ParameterCheck;

public class ReboardReplyAction implements Action {

	private static ReboardReplyAction reboardReplyAction;
	
	static {
		reboardReplyAction = new ReboardReplyAction();
	}
	
	private ReboardReplyAction() {}

	public static ReboardReplyAction getReboardReplyAction() {
		return reboardReplyAction;
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
			//�Ѿ���°��� �翬�� �־�� �ϱ⶧���� ������ �߻����Ѿ� �Ѵ�.
			//0�� üũ�� �ϸ� �ȵȴ�.
			//������ ref, lev, step, pseq
			reboardDto.setRef(Integer.parseInt(request.getParameter("ref")));
			reboardDto.setLev(Integer.parseInt(request.getParameter("lev")));
			reboardDto.setStep(Integer.parseInt(request.getParameter("step")));
			reboardDto.setPseq(Integer.parseInt(request.getParameter("pseq")));
			
			//�����̾ƴϰ�, ���ö����̴�.
			int seq = ReboardServiceImpl.getReboardService().replyArticle(reboardDto);
			if(seq != 0) {
				path = "/reboard/writeok.jsp?seq=" + seq + "&";
			}
		} else {
			path = "/index.jsp?";//TODO ���߿� �α��� �������� �̵����Ѷ�.
		}
		return path;
	}
		
}
