package com.speedtago.carreservation.dao;

import java.util.List;

import com.speedtago.carinfo.model.CarinforDto;
import com.speedtago.member.model.MemberDetailDto;

public interface CarReservationDao {

	public List<MemberDetailDto> SelectMember(String id);
	public List<CarinforDto> SelectInfo(String car_id);
	public int InserReservation();
	
	
}
