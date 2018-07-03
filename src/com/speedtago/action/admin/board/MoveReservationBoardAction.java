package com.speedtago.action.admin.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedtago.action.Action;
import com.speedtago.menu.model.MenuListDto;
import com.speedtago.menu.service.MenuServiceImpl;

public class MoveReservationBoardAction implements Action {

	
	private static MoveReservationBoardAction moveReservationBoardAction;
	
	static {
		moveReservationBoardAction = new MoveReservationBoardAction();
	}
	
	private MoveReservationBoardAction() {}
	
	
	public static MoveReservationBoardAction getMoveReservationBoardAction() {
		return moveReservationBoardAction;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<MenuListDto> menulist = MenuServiceImpl.getMenuService().getBoardMenu();
		request.setAttribute("menulist", menulist);
		return "/reservation/reservation_guide.jsp";
		//이용가이드 > 차량정보 확인 > 예약 > 결재 > 확인
	}

}
