package com.speedtago.action.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedtago.action.Action;
import com.speedtago.menu.model.MenuListDto;
import com.speedtago.menu.service.MenuServiceImpl;

public class MoveGuideBoardAction implements Action  {

	private static MoveGuideBoardAction moveGuideBoardAction;
	
	static {
		moveGuideBoardAction = new MoveGuideBoardAction();
	}
	
	private MoveGuideBoardAction() {}
	
	
	public static MoveGuideBoardAction getMoveGuideBoardAction() {
		return moveGuideBoardAction;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MenuListDto> menulist = MenuServiceImpl.getMenuService().getBoardMenu();
		request.setAttribute("menulist", menulist);
		return "/reservation/reservation_guide.jsp";
	}

}
