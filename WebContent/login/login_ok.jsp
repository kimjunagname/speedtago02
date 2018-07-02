<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.speedtago.member.model.*"%>
<%
if(memberDto != null){ 
%>
		<!-- Header -->
		<!-- ---------------상단 고정-------------------- -->
		<%@ include file="/menu/top.jsp" %>
		<!-- ----------------------------------------- -->
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br>
		<!-- 왼쪽 사이트 바 시작 [범위: 2]----------------------------------------------------- -->
		<!-- Main -->
		<section class="wrapper style1">
		<div class="container">
			<div class="row gtr-200">
				<!-- 왼쪽 사이트 바 범위 조절[범위: 2]  <div class="col-2 col-12-narrower"> ----------------------------------------------------- -->
				<!-- ---------------left 고정-------------------- -->
				<!-- ----------------------------------------- -->
				<!-- 왼쪽 사이트 바 종료----------------------------------------------------- -->

				<!-- 내용 시작 [범위: 10]----------------------------------------------------- -->
				    <!-- Main -->
    
        <div class="col-3 col-12-narrower">
          <div id="sidebar1">
            <!-- Sidebar 1 -->
          </div>
        </div>
        <div class="col-6 col-12-narrower imp-narrower">
          <div id="content">
            <!-- Content -->
            <div class="text-primary" align="left">
              <font size="5"><strong>아이디 찾기</strong></font><br>
              &nbsp;
            </div>   
          </div>
          <div class="col-3 col-12-narrower">
            <table class="table table-striped">
           <form name="loginform" method="get" action="">
		   <input type="hidden" name="act" value="mvlogin">
			   <tr>
                <td>아이디</td>
                <td colspan="2">
                  <input type="text" id="id" name="id" value="<%=memberDetailDto.getId()%>" readonly="readonly" style="text-align:left; width:300px; height:30px;">
                </td>
              </tr>
              
              <font color ="blue">  
	<b><%=memberDto.getName()%>(<%=memberDto.getId()%>)</b>님 안녕하세요.<br>
    <a href="mailto:"<%=memberDto.getEmail1()%>@<%=memberDto.getEmail2()%>">메일 보내기</a><br>
    <a href="<%=root%>/user?act=mvmaillist">내 메일함</a>
    
	</font>
              
              
              
              
              
              <tr>       
                <td align="right" colspan="2">
                   <button type="button" class="btn btn-primary btn-sm" onclick="javascript:movelogin();">로그인</button>
                </td>
              </tr>
              </form>
            </table>
          </div>
        </div>
      </div>
    </section>
				<!-- 내용 종료 [범위: 10]----------------------------------------------------- -->

			</div>
		</div>
		</section>

		<div class="col-3 col-12-narrower">
			<div id="sidebar2">

				<!-- Sidebar 2 -->

			</div>
		</div>
	</div>
	</div>
	</section>
	
<script type="text/javascript">
function movelogin(){
	document.loginform.action = "<%=root%>/user";
	document.loginform.submit();
 }
</script>
	<!-- Footer -->
	<!-- -------------하단분리------------------------- -->
	<%@ include file="/menu/bottom.jsp" %>
	<!-- -------------------------------------------- -->
<%
  } else {
%>
    <script>
		alert("로그인 후에 서비스를 이용 가능합니다.");
		document.location.href = "<%=root%>/user?act=mvlogin";
	</script>
<%
  }
%>
	
	
	