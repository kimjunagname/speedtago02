<%@page import="com.speedtago.member.model.MemberDetailDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.speedtago.member.model.*" %>
<%
MemberDetailDto memberDetailDto = request.getAttribute("userInfo");
%>
		<!-- Header -->
		<!--  회원가입 작성 페이지 -->	
		<!-- ---------------상단 고정-------------------- -->
		<%@ include file="/menu/top.jsp" %>
		<!-- ----------------------------------------- -->
		<br> 
		<br> 
		<br> 
		<br> 
		<br> 
		<br> 
		<br>
		<br> 
		<br> 
		<br>
    		<!-- 왼쪽 사이트 바 시작 [범위: 2]----------------------------------------------------- -->
			<!-- ---------------left 고정-------------------- -->
			<jsp:include page="/menu/left_mypage.jsp" flush='false' />
			<!-- ----------------------------------------- -->
			<!-- 왼쪽 사이트 바 종료----------------------------------------------------- -->
			<!-- 내용 시작 [범위: 10]----------------------------------------------------- -->
			<div class="col-10 col-12-narrower imp-narrower">
          <div id="content">
            <!-- Content -->
            <div class="text-primary" align="left">
              <font size="5"><strong>회원정보 수정</strong></font><br>
              &nbsp;
            </div>   
          </div>
          <div class="col-3 col-12-narrower">
            <div id="sidebar2">
              <!-- Sidebar 2 -->
            </div>

           <!-- table 선언 -->
					<form name ="joinform" method="post" action="">
					<input type="hidden" name="act" value="register">
	 
					<table class="table table-striped" style="table-layout: fixed; width:800px; height: 15px;">
						<!-- 컬럼 크기 조절 -->
						<colgroup>
    						<col style="width: 25%; "/>
   							<col style="width: 25%; "/>
    					    <col style="width: 25%; "/>
    					    <col style="width: 25%; "/>
    					    <col /> 
  						</colgroup>
						
						<tr>
							<td>이름</td>
							<td colspan="3"><input type="text" id="name" name="name" value="<%=memberDetailDto.getName() %>" size="12" ></td>
						</tr>
						<tr>
							<td>아이디</td>
							<td colspan="2">
								<input type="text" id="id" name="id" value="<%=memberDetailDto.getId() %>" size="12" style="text-align: left;" readonly="readonly" >
							    
							</td>
							
							<td>
							   <span id="idresult"></span>
								<!-- <button type="button" class="btn btn-primary btn-sm" onkeyup="javascript:idcheck();">아이디 중복검사</button>  -->
							</td>
						</tr>

						<tr>
							<td>비밀번호</td>
							<td colspan="3">
								<input type="password" id="pass" name="pass" size="12" maxlength="12"style="text-align: left;">
							</td>
						</tr>
						
						<tr>
							<td>비밀번호 확인</td>
							<td colspan="3">
								<input type="password" id="passcheck" name="passcheck" id="passcheck" size="12" maxlength="12" style="text-align: left;">
							</td>
						</tr>

						<tr>
							<td class="td1">연락처</td>
							<td>
								<select class="td3" id="tel1" name="tel1" value="<%=memberDetailDto.getTel1() %>" size="1" maxlength="3" style="width:180px; height: 60px;">
									<option value="010" >010</option>
									<option value="011" >011</option>
									<option value="016" >016</option>
									<option value="017" >017</option>
									<option value="018" >018</option>
								</select> 
							</td>
							<td> 
							   <input class="td3" type="text" id="tel2" name="tel2" value="<%=memberDetailDto.getTel2() %>" size="4" maxlength="4" >  
							</td>
							<td>
							   <input class="td3" type="text" id="tel3" name="tel3" value="<%=memberDetailDto.getTel3() %>" size="4" maxlength="4" >
						 	</td>
						</tr>
						

						<tr>
							<td>우편번호</td>
							<td colspan="2">
								<input type="text" id="zipcode" name="zipcode" size="5"	maxlength="5" value="<%=memberDetailDto.getZipcode() %>" style="text-align: left;"	readonly="readonly" onclick="javascript:openzip();">
							</td>
							
							<td>
								<button type="button" class="btn btn-primary btn-sm" onclick="javascript:openzip();">우편번호 검색</button>
							</td>
						</tr>
						
						
						<tr>
							<td>주소</td>
							<td colspan="3">
								<input type="text" id="addr1" name="addr1" value="<%=memberDetailDto.getAddr1() %>" readonly="readonly" style="text-align: left; ">
							</td>
						</tr>
						
						<tr>
							<td>상세주소</td>
							<td colspan="3">
								<input type="text" id="addr2" name="addr2" value="<%=memberDetailDto.getAddr2() %>" style="text-align: left;">
							</td>
						</tr>
						
						<tr>
							<td>이메일</td>
							<td >
								<input type="text" name="email1" id="email1" value="<%=memberDetailDto.getEmail1() %>" style="width:300px;">
							</td>
							<td>
								<font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@</font>
							</td>
							<td colspan="2">
								<select name="email2" id ="email2" value="<%=memberDetailDto.getEmail2() %>"size="1" style="width:180px; height:60px;">
									<option value="naver.com">naver.com</option>
									<option value="hanmail.net">hanmail.net</option>
								</select>
							</td>
						</tr>
						<tr>
							<td align="left" colspan="2"><input type="button" value="수정" onclick="javascript:join();">
							</td>
							<td align="right" colspan="2"><input type="reset" value="취소" >
							</td>
						</tr>
					</table>
          </div>
        </div>
      </div>
    </section>

    
    <!-- Footer -->
	<!-- -------------하단분리------------------------- -->
	<%@ include file="/menu/bottom.jsp" %>
	<!-- -------------------------------------------- -->
