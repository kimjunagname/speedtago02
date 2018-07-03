package com.speedtago.action.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedtago.action.Action;
import com.speedtago.menu.model.MenuListDto;
import com.speedtago.menu.service.MenuServiceImpl;

public class MoveMyPagePointBoardAction implements Action {

	private static MoveMyPagePointBoardAction moveMyPagePointBoardAction;
	
	static {
		moveMyPagePointBoardAction = new MoveMyPagePointBoardAction();
	}
	
	private MoveMyPagePointBoardAction() {}
	
	
	public static MoveMyPagePointBoardAction getMoveMyPagePointBoardAction() {
		return moveMyPagePointBoardAction;
	}


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MenuListDto> menulist = MenuServiceImpl.getMenuService().getBoardMenu();
		request.setAttribute("menulist", menulist);
		return "/point/mypage_point.jsp";
	}

}
