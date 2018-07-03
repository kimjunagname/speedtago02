<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.speedtago.member.model.MemberDto"%>
<%
String root = request.getContextPath();

MemberDto memberDto = new MemberDto();
memberDto.setId("many435");
memberDto.setName("김정남");
memberDto.setEmail1("many");
memberDto.setEmail2("naver.com");

session.setAttribute("userInfo", memberDto);


response.sendRedirect(root + "/index.jsp");
%>    


<!-- 
1번
DB >> 레벨 / 스텝 보고
대부분 문제는 DB에 넣을떄 문제 -->