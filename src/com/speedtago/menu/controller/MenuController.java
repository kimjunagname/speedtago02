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
			//�������� >> ��������, �����ϱ�
			path = BoardAdminActionFactory.getMoveReservationBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvguide".equals(act)) {
			//�������� >> �̿밡�̵�
			path = BoardAdminActionFactory.getMoveGuideBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvcarinfo".equals(act)) {
			//�������� >> ���� ����
			path = BoardAdminActionFactory.getMoveCarInfoBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		///////////////////////////////////////////////////////////////////////////////////////////	
		} else if("mvbflist".equals(act)) {
			//�������� >> BF��õ�ڽ�
			path = BoardAdminActionFactory.getMoveBfcourseBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvrfcourse".equals(act)) {
			//�������� >> ��õ�����ڽ�
			path = BoardAdminActionFactory.getMoveRfcourseBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvtreview".equals(act)) {
			//�������� >> �����ı�
			path = BoardAdminActionFactory.getMoveTreviewBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvvideo".equals(act)) {
			//�������� >> ����
			path = BoardAdminActionFactory.getMoveVideoBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvphoto".equals(act)) {
			//�������� >> ����
			path = BoardAdminActionFactory.getMovePhotoBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
			///////////////////////////////////////////////////////////////////////////////////////////
		} else if("mvnotice".equals(act)) {
			//�ҽ� >> �ҽ�, ��������
			path = BoardAdminActionFactory.getMoveNoticeBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
		} else if("mvnews".equals(act)) {
			//�ҽ� >> �谣�ʷϿ���	
			path = BoardAdminActionFactory.getMoveNewsBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
			///////////////////////////////////////////////////////////////////////////////////////////
		} else if("mvtravel".equals(act)) {
			// ȫ������ >> ȫ������
			path = BoardAdminActionFactory.getMoveTravelBoardAction().execute(request, response);
			PageMove.forward(request, response, path);
			///////////////////////////////////////////////////////////////////////////////////////////
		} else if("mvqa".equals(act)) {
			// Q&A >> Q&A, ���� ���� ����
			path = BoardAdminActionFactory.getMoveQaBoardAction().execute(request, response);
	        PageMove.forward(request, response, path);
		} else if("mvconsult".equals(act)) {
			// Q&A >> 1:1���
			path = BoardAdminActionFactory.getMoveConsultBoardAction().execute(request, response);
	        PageMove.forward(request, response, path);
	        ///////////////////////////////////////////////////////////////////////////////////////////
		} else if("mvresercheck".equals(act)) {
			//MyPage >> MyPage, ���� Ȯ�� 
			path = BoardAdminActionFactory.getMoveReserCheckBoardAction().execute(request, response);
	        PageMove.forward(request, response, path);
		} else if("mvpoint".equals(act)) {
			//MyPage >> ����Ʈ
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



