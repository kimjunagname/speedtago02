package com.speedtago.action.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedtago.action.Action;
import com.speedtago.menu.model.MenuListDto;
import com.speedtago.menu.service.MenuServiceImpl;

public class MoveBfcourseBoardAction implements Action{

	private static MoveBfcourseBoardAction moveBfcourseBoardAction;
	
	static {
		moveBfcourseBoardAction = new MoveBfcourseBoardAction();
	}
	
	private MoveBfcourseBoardAction () {}
		
	public static MoveBfcourseBoardAction getMoveBfcourseBoardAction() {
		return moveBfcourseBoardAction;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MenuListDto> menulist = MenuServiceImpl.getMenuService().getBoardMenu();
		request.setAttribute("menulist", menulist);
		return "/bfcourse/bfcourse_list.jsp";
	}

}
