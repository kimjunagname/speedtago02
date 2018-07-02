package com.speedtago.member.service;

import java.util.*;

import com.speedtago.member.dao.MemberDao;
import com.speedtago.member.dao.MemberDaoImpl;
import com.speedtago.member.model.*;

public class MemberServiceImpl implements MemberService {

private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}
	
	@Override
	public int idCheck(String id) {
		return memberDao.idCheck(id);
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {	
		return memberDao.zipSearch(dong);
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		return memberDao.registerMember(memberDetailDto);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		System.out.println("services>>>>" + id);
		System.out.println("services>>>>" + memberDao);
		
		return memberDao.getMember(id);
	}
	

	@Override
	public int modifyMember(MemberDetailDto memberDetailDto) {
		System.out.println("services_modifyMember id >>>>" + memberDetailDto.getId());
		System.out.println("services_modifyMember memberDetailDto>>>>" + memberDetailDto);
		
		return memberDao.modifyMember(memberDetailDto);
	}

	@Override
	public int deleteMember(String id) {
		System.out.println("services_deleteMember id >>>>" + id);
		return  memberDao.deleteMember(id);
	}

	@Override
	public MemberDto login(String id, String pass) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("userid",id);
		map.put("userpass",pass);
		return memberDao.login(map);
	}

	@Override
	public MemberDetailDto getIdSearch(MemberDetailDto memberDetailDto) {
		System.out.println("services_getIdSearch name >>>>" + memberDetailDto.getName());
		System.out.println("services_getIdSearch email1 >>>>" + memberDetailDto.getEmail1());
		System.out.println("services_getIdSearch email2 >>>>" + memberDetailDto.getEmail2());
		
		System.out.println("services_getIdSearch memberDetailDto>>>>" + memberDetailDto.getId());
		return memberDao.getIdSearch(memberDetailDto);
	}

	@Override
	public MemberDetailDto getPassSearch(MemberDetailDto memberDetailDto) {
		System.out.println("services_getPassSearch name >>>>" + memberDetailDto.getName());
		System.out.println("services_getPassSearch email1 >>>>" + memberDetailDto.getEmail1());
		System.out.println("services_getPassSearch email2 >>>>" + memberDetailDto.getEmail2());
		System.out.println("services_getPassSearch id >>>>" + memberDetailDto.getId());
		
		System.out.println("services_getIdSearch memberDetailDto>>>>" + memberDetailDto.getPass());
		return memberDao.getPassSearch(memberDetailDto);
	}

	@Override
	public int getPassChange(MemberDetailDto memberDetailDto) {
		
		
		return memberDao.getPassChange(memberDetailDto);
	}
	
}
