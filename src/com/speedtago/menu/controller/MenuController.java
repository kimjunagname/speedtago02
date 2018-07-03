package com.speedtago.menu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedtago.factory.BoardAdminActionFactory;
import com.speedtago.util.KitriConstance;
import com.speedtago.util.PageMove;

@WebServlet("/menu")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String act = request.getParameter("act");
		System.out.println("act >>>>>>>>>> " + act);
		
		String path = "/index.jsp";
		if("mvindex".equals(act)) {
			path = BoardAdminActionFactory.getMoveIndexBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvreservation".equals(act)) {
			//차량예약 >> 차량예약, 예약하기
			path = BoardAdminActionFactory.getMoveReservationBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvguide".equals(act)) {
			//차량예약 >> 이용가이드
			path = BoardAdminActionFactory.getMoveGuideBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvcarinfo".equals(act)) {
			//차량예약 >> 차량 정보
			path = BoardAdminActionFactory.getMoveCarInfoBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		///////////////////////////////////////////////////////////////////////////////////////////	
		} else if("mvbflist".equals(act)) {
			//여행정보 >> BF추천코스
			path = BoardAdminActionFactory.getMoveBfcourseBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvrfcourse".equals(act)) {
			//여행정보 >> 추천여행코스
			path = BoardAdminActionFactory.getMoveRfcourseBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvtreview".equals(act)) {
			//여행정보 >> 여행후기
			path = BoardAdminActionFactory.getMoveTreviewBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvvideo".equals(act)) {
			//여행정보 >> 영상
			path = BoardAdminActionFactory.getMoveVideoBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvphoto".equals(act)) {
			//여행정보 >> 포토
			path = BoardAdminActionFactory.getMovePhotoBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
			///////////////////////////////////////////////////////////////////////////////////////////
		} else if("mvnotice".equals(act)) {
			//소식 >> 소식, 공지사항
			path = BoardAdminActionFactory.getMoveNoticeBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvnews".equals(act)) {
			//소식 >> 계간초록여행	
			path = BoardAdminActionFactory.getMoveNewsBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
			///////////////////////////////////////////////////////////////////////////////////////////
		} else if("mvtravel".equals(act)) {
			// 홍보영상 >> 홍보영상
			path = BoardAdminActionFactory.getMoveTravelBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
			///////////////////////////////////////////////////////////////////////////////////////////
		} else if("mvqa".equals(act)) {
			// Q&A >> Q&A, 자주 묻는 질문
			path = BoardAdminActionFactory.getMoveQaBoardAction().execute(request, response);
	        PageMove.forward(request, response, path);
		} else if("mvconsult".equals(act)) {
			// Q&A >> 1:1상담
			path = BoardAdminActionFactory.getMoveConsultBoardAction().execute(request, response);
	        PageMove.forward(request, response, path);
	        ///////////////////////////////////////////////////////////////////////////////////////////
		} else if("mvresercheck".equals(act)) {
			//MyPage >> MyPage, 예약 확인 
			path = BoardAdminActionFactory.getMoveReserCheckBoardAction().execute(request, response);
	        PageMove.forward(request, response, path);
		} else if("mvpoint".equals(act)) {
			//MyPage >> 포인트
			path = BoardAdminActionFactory.getMoveMyPagePointBoardAction().execute(request, response);
	        PageMove.forward(request, response, path);
	        ///////////////////////////////////////////////////////////////////////////////////////////
		} else if("".equals(act)) {

			
		} else if("".equals(act)) {
			
		} 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(KitriConstance.ENCODE);
		doGet(request, response);
	}

}



