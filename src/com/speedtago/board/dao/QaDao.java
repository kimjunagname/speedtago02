package com.speedtago.board.dao;

import java.util.List;

import com.speedtago.board.model.QaBoardDto;

public interface QaDao {
	public List<QaBoardDto> SelectQaBoardList(int category_id);
	public List<QaBoardDto> SelectQaBoard(int board_id);
	public int InsertQaBoard(String id);
	
}
