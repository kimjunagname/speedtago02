<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.speedtago.member.model.*"%>

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
              <font size="5"><strong>비밀번호 변경</strong></font><br>
              &nbsp;
            </div>   
          </div>
          <div class="col-3 col-12-narrower">
            <table class="table table-striped">
            <!-- 컬럼 크기 조절 -->
			<colgroup>
    			<col style="width: 40%; "/>
   				<col style="width: 60%; "/>
  			</colgroup>
            
           <form name="passchangeform" method="post" action="">
		   <input type="hidden" name="act" value="mvpasschange">
			   <tr>
                <td>비밀번호</td>
                <td>
                  <input type="password" id="pass" name="pass" value="<%=memberDetailDto.getPass() %>" style="text-align:left; width:300px; height:30px;">
                </td>
               </tr>
                
               <tr>
                <td>비밀번호 확인</td>
                  <td>
                  <input type="password" id="passcheck" name="passcheck" value="" style="text-align:left; width:300px; height:30px;">
                </td>
               </tr>
              
              <tr>       
                <td align="right" colspan="2">
                   <button type="button" class="btn btn-primary btn-sm" onclick="javascript:passchange();">비밀번호 변경</button>
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
function passchange(){
   	if(document.getElementById("pass").value  == "") {
   		alert("비밀번호 입력!");
   		return;
   	} else if(document.getElementById("pass").value != document.getElementById("passcheck").value) {
   		alert("비밀번호 확인!");
   		return;
   	} else {
   		document.passchangeform.action = "<%=root%>/user";
   		document.passchangeform.submit();
   	}
}
</script>
	<!-- Footer -->
	<!-- -------------하단분리------------------------- -->
	<%@ include file="/menu/bottom.jsp" %>
	<!-- -------------------------------------------- -->