package com.speedtago.factory;

import com.speedtago.action.Action;
import com.speedtago.action.admin.board.*;

public class BoardAdminActionFactory {

	private static Action moveIndexBoardAction;
	private static Action moveReservationBoardAction;
	private static Action moveCarInfoBoardAction;
	private static Action moveGuideBoardAction;
	
	private static Action moveRfcourseBoardAction;
	private static Action moveBfcourseBoardAction;
	private static Action moveTreviewBoardAction;
	private static Action moveVideoBoardAction;
	private static Action movePhotoBoardAction;
	
	private static Action moveNoticeBoardAction;
	private static Action moveNewsBoardAction;
	private static Action moveTravelBoardAction;
	private static Action moveQaBoardAction;
	private static Action moveConsultBoardAction;
	
	private static Action makeCategoryAction;
	private static Action makeBoardAction;
	
	private static Action moveMyPagePointBoardAction;
	private static Action moveReserCheckBoardAction;
	
	
	static {
		moveIndexBoardAction = MoveIndexBoardAction.getMoveIndexBoardAction();
		moveReservationBoardAction = MoveReservationBoardAction.getMoveReservationBoardAction();
		moveCarInfoBoardAction = MoveCarInfoBoardAction.getMoveCarInfoBoardAction();
		moveGuideBoardAction = MoveGuideBoardAction.getMoveGuideBoardAction();
		
		moveRfcourseBoardAction = MoveRfcourseBoardAction.getMoveRfcourseBoardAction();
		moveBfcourseBoardAction = MoveBfcourseBoardAction.getMoveBfcourseBoardAction();
		moveTreviewBoardAction = MoveTreviewBoardAction.getMoveTreviewBoardAction();
		moveVideoBoardAction = MoveVideoBoardAction.getMoveVideoBoardAction();
		movePhotoBoardAction = MovePhotoBoardAction.getMovePhotoBoardAction();
		
		moveNoticeBoardAction = MoveNoticeBoardAction.getMoveNoticeBoardAction();
		moveNewsBoardAction = MoveNewsBoardAction.getMoveNewsBoardAction();
		
		moveTravelBoardAction = MoveTravelBoardAction.getMoveTravelBoardAction();
		
		moveQaBoardAction = MoveQaBoardAction.getMoveQaBoardAction();
		moveConsultBoardAction = MoveConsultBoardAction.getMoveConsultBoardAction();
		
		makeCategoryAction = MakeCategoryAction.getMakeCategoryAction();
		makeBoardAction = MakeBoardAction.getMakeBoardAction();
	
		moveMyPagePointBoardAction = MoveMyPagePointBoardAction.getMoveMyPagePointBoardAction();
		moveReserCheckBoardAction = MoveReserCheckBoardAction.getMoveReserCheckBoardAction();

	}

	
	public static Action getMoveMyPagePointBoardAction() {
		return moveMyPagePointBoardAction;
	}

	public static Action getMoveReserCheckBoardAction() {
		return moveReserCheckBoardAction;
	}

	public static Action getMoveConsultBoardAction() {
		return moveConsultBoardAction;
	}

	public static Action getMoveNoticeBoardAction() {
		return moveNoticeBoardAction;
	}

	public static Action getMoveNewsBoardAction() {
		return moveNewsBoardAction;
	}

	public static Action getMoveTravelBoardAction() {
		return moveTravelBoardAction;
	}

	public static Action getMoveQaBoardAction() {
		return moveQaBoardAction;
	}

	public static Action getMoveRfcourseBoardAction() {
		return moveRfcourseBoardAction;
	}

	public static Action getMoveBfcourseBoardAction() {
		return moveBfcourseBoardAction;
	}

	public static Action getMoveTreviewBoardAction() {
		return moveTreviewBoardAction;
	}

	public static Action getMoveVideoBoardAction() {
		return moveVideoBoardAction;
	}

	public static Action getMovePhotoBoardAction() {
		return movePhotoBoardAction;
	}
	
	public static Action getMoveGuideBoardAction() {
		return moveGuideBoardAction;
	}

	public static Action getMoveCarInfoBoardAction() {
		return moveCarInfoBoardAction;
	}

	public static Action getMoveReservationBoardAction() {
		return moveReservationBoardAction;
	}

	public static Action getMoveIndexBoardAction() {
		return moveIndexBoardAction;
	}

	public static Action getMakeCategoryAction() {
		return makeCategoryAction;
	}

	public static Action getMakeBoardAction() {
		return makeBoardAction;
	}
	
}













