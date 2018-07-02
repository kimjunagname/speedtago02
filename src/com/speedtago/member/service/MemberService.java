package com.speedtago.member.service;

import java.util.List;

import com.speedtago.member.model.*;

public interface MemberService {

	
	//���̵� �ߺ� �˻� > int cnt
	//id�������� DB ��ȸ�� counter�� �����´�.
	//1 > �ߺ� / 0 > ��밡��
	int idCheck(String id);
	
	//�����ȣ �˻� > String
	//�����ȣ dong�� �������� db ��ȸ�� ���� List�� �����´�
	List<ZipDto> zipSearch(String dong);
	
	//ȸ������ > Dto or Array list
	//ȸ�� ���� ������ �����ͼ�, dto�� int �� �μ�Ʈ �Ѵ�.
	int registerMember(MemberDetailDto memberDetailDto);
	
	//��� �������� > Dto  or Array list
	//��� ������ dto�� ���� 
	MemberDetailDto getMember(String id);
	
	//ȸ������ ���� > Dto  or Array list
	int modifyMember(MemberDetailDto memberDetailDto);
	
	//ȸ������ ���� > int cnt
	int deleteMember(String id);
	
	//�α��ν� > name, id, �̸���(dto)
	//�α��ν� �̸�, id, �̸��� ������	
	MemberDto login(String id, String pass);
	
	//id ã��
	MemberDetailDto getIdSearch(MemberDetailDto memberDetailDto);
	//pass ã��
	MemberDetailDto getPassSearch(MemberDetailDto memberDetailDto);
	//pass ����
	int getPassChange(MemberDetailDto memberDetailDto);
	
}
