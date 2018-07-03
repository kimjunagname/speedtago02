package com.speedtago.action.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedtago.action.Action;
import com.speedtago.menu.model.MenuListDto;
import com.speedtago.menu.service.MenuServiceImpl;

public class MoveTravelBoardAction implements Action {

	private static MoveTravelBoardAction moveTravelBoardAction;
	
	static {
		moveTravelBoardAction = new MoveTravelBoardAction();
	}
	
	private MoveTravelBoardAction() {}
	
	public static MoveTravelBoardAction getMoveTravelBoardAction() {
		return moveTravelBoardAction;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MenuListDto> menulist = MenuServiceImpl.getMenuService().getBoardMenu();
		request.setAttribute("menulist", menulist);
		return "/travel/travel_list.jsp";
	}

}
