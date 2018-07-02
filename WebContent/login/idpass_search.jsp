<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
            <table class="table table-striped" style="table-layout: fixed; width:500px; height: 15px;">
			<form name ="idsearchform" method="post" action="">
			<input type="hidden" name="act" value="mvid_search">
	 
			<!-- 컬럼 크기 조절 -->
			<colgroup>
    			<col style="width: 25%; "/>
   				<col style="width: 25%; "/>
    			<col style="width: 25%; "/>
    			<col style="width: 25%; "/>
  			</colgroup>
            
              <tr>
                <td>이름</td>
                <td colspan="3">
                  <input type="text" id="name1" name="name1" style="text-align:left; width:400px;  height:30px;">
                </td>
              </tr>
              <tr>
                <td>이메일</td>
                <td>
                  <input type="text" id="email1" name="email1" style="text-align:left; width:150px; height:30px;" >
                </td>
                
                <td style="text-align:left; height:30px;">
				<font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@</font>
				</td>
                
                <td>
                 <select name="email2" id ="email2" size="1" style="width:180px; height:30px;">
					<option value="naver.com">naver.com</option>
					<option value="hanmail.net">hanmail.net</option>
				</select>
				</td>
				
              </tr>
              <tr>       
                <td align="right" colspan="4">
                   <button type="button" class="btn btn-primary btn-sm"  onclick="javascript:idsearch();"  id="idsearchbtn" name="idsearchbtn">아이디 찾기</button>
                </td>
              </tr>
            </table>
            </form>
            
            <div class="text-primary" align="left">
              <font size="5"><strong>비밀번호 찾기</strong></font><br>
              &nbsp;
            </div> 
            
            
            <table class="table table-striped" style="table-layout: fixed; width:500px; height: 15px;">
			<form name ="passsearchform" method="post" action="">
			<input type="hidden" name="act" value="mvpass_search">
			<!-- 컬럼 크기 조절 -->
			<colgroup>
    			<col style="width: 25%; "/>
   				<col style="width: 25%; "/>
    			<col style="width: 25%; "/>
    			<col style="width: 25%; "/>
  			</colgroup>

              <tr>
                <td>아이디</td>
                <td colspan="2">
                  <input type="text" id="id" name="id" style="text-align:left; width:300px; height:30px;" placeholder="아이디 입력">
                </td>
              </tr>
              
              <tr>
                <td>이름</td>
                <td colspan="3">
                  <input type="text" id="name" name="name" style="text-align:left; width:400px;  height:30px;">
                </td>
              </tr>
              
              <tr>
                <td>이메일</td>
                <td>
                  <input type="text" id="email1" name="email1" style="text-align:left; width:150px; height:30px;" >
                </td>
                
                <td style="text-align:left; height:30px;">
				<font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;@</font>
				</td>
                
                <td>
                 <select name="email2" id ="email2" size="1" style="width:180px; height:30px;">
					<option value="naver.com">naver.com</option>
					<option value="hanmail.net">hanmail.net</option>
				</select>
				</td>
				
              </tr>
              <tr>       
                <td align="right" colspan="4">
                   <button type="button" class="btn btn-primary btn-sm" onclick="javascript:passsearch();" id="idsearchbtn" name="idsearchbtn">비밀번호 찾기</button>
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
function idsearch() {
	if(document.getElementById("name1").value  == "") {
   		alert("이름 입력!");
   		return;
   	} else if(document.getElementById("email1").value == "" && document.getElementById("email2").value == "") {
   		alert("eamil 입력!");
   		return;
   	} else {
   		document.idsearchform.action = "<%=root%>/user";
   		document.idsearchform.submit();
   	}	
}

function passsearch() {
	if(document.getElementById("name").value  == "") {
   		alert("이름 입력!");
   		return;
   	} else if(document.getElementById("id").value == "") {
   		alert("id 입력!");
   		return;
   	} else if(document.getElementById("email1").value == "" && document.getElementById("email2").value == "") {
   		alert("eamil 입력!");
   		return;
   	} else {
   		document.passsearchform.action = "<%=root%>/user";
   		document.passsearchform.submit();
   	}	
}
</script>
	<!-- Footer -->
	<!-- -------------하단분리------------------------- -->
	<%@ include file="/menu/bottom.jsp" %>
	<!-- -------------------------------------------- -->