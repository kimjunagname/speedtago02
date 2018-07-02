package com.speedtago.member.dao;

import java.util.List;
import java.util.Map;

import com.speedtago.member.model.*;

public interface MemberDao {

	int idCheck(String id);
	List<ZipDto> zipSearch(String dong);
	int registerMember(MemberDetailDto memberDetailDto);
	MemberDetailDto getMember(String id);
	int modifyMember(MemberDetailDto memberDetailDto);
	int deleteMember(String id);
	MemberDto login(Map<String, String> map);
	
	MemberDetailDto getIdSearch(MemberDetailDto memberDetailDto);
	MemberDetailDto getPassSearch(MemberDetailDto memberDetailDto);
	
	int getPassChange(MemberDetailDto memberDetailDto);
}
