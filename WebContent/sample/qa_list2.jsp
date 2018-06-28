<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



		<!-- Header -->
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
		<!-- Main -->
		<section class="wrapper style1">
		<div class="container">
			<div class="row gtr-200">
			
			<!-- 왼쪽 사이트 바 범위 조절[범위: 2]  <div class="col-2 col-12-narrower"> ----------------------------------------------------- -->
			<!-- ---------------left 고정-------------------- -->
			<!-- <%@ include file="/menu/left_qa.jsp" %>  에러나서 지웠음--> 
			<jsp:include page="/menu/left_qa.jsp" flush='false' />
			<!-- ----------------------------------------- -->
			<!-- 왼쪽 사이트 바 종료----------------------------------------------------- -->
		
				<!-- 내용 시작 [범위: 10]----------------------------------------------------- -->
				<div class="col-10  col-12-narrower imp-narrower">
					<div id="content">

						<!-- Content -->
						<article> 
						<header>
						<h2>자주묻는 질문</h2>
						<hr style="border: solid 1px black;">
						</header> 
						<!--  게시판 작성 --> 
						<br>

						<div>

							<h4>자주묻는 질문 검색 ▶</h4>
							<select>
								<option value="보험사고">보험사고</option>
								<option value="분실신고">분실신고</option>
							</select> <select>
								<option value="제목">제목</option>
								<option value="내용">내용</option>
							</select> <input type="text" style="" value="내용을 입력해주세요"> <br>
						</div>
						<div>
							<p>전체 1개 (1/1) 페이지</p>
						</div>

						<table class="type06">
							<tr style="border-bottom: solid 1px black;">
								<td>글 번호</td>
								<td>구분</td>
								<td>제목</td>
								<td>등록날짜</td>
								<td>조회</td>
							</tr>
							
							

							<tr style="border-bottom: solid 1px black;">
								<td class="even">1</td>
								<td class="even">보험사고</td>
								<td class="even"><a href="<%=root %>/qa_read.jsp">고객님 사고접수는</a></td>
								<td class="even">2018.06.19</td>
								<td class="even">5554</td>
							</tr>
							<tr style="border-bottom: solid 1px black;">
								<td>1</td>
								<td>보험사고</td>
								<td><a href="<%=root %>/qa_read.jsp">고객님 사고접수는</a></td>
								<td>2018.06.19</td>
								<td>5554</td>
							</tr>

							<tr style="border-bottom: solid 1px black;">
								<td class="even">1</td>
								<td class="even">보험사고</td>
								<td class="even"><a href="<%=root %>/qa_read.jsp">고객님 사고접수는</a></td>
								<td class="even">2018.06.19</td>
								<td class="even">5554</td>
							</tr>

							<tr style="border-bottom: solid 1px black;">
								<td>1</td>
								<td>보험사고</td>
								<td><a href="<%=root %>/qa_read.jsp">고객님 사고접수는</a></td>
								<td>2018.06.19</td>
								<td>5554</td>
							</tr>

							<tr style="border-bottom: solid 1px black;">
								<td class="even">1</td>
								<td class="even">보험사고</td>
								<td class="even"><a href="<%=root %>/qa_read.jsp">고객님 사고접수는</a></td>
								<td class="even">2018.06.19</td>
								<td class="even">5554</td>
							</tr>

							<tr style="border-bottom: solid 1px black;">
								<td>1</td>
								<td>보험사고</td>
								<td><a href="<%=root %>/qa_read.jsp">고객님 사고접수는</a></td>
								<td>2018.06.19</td>
								<td>5554</td>
							</tr>

							<tr style="border-bottom: solid 1px black;">
								<td class="even">1</td>
								<td class="even">보험사고</td>
								<td class="even"><a href="<%=root %>/qa_read.jsp">고객님 사고접수는</a></td>
								<td class="even">2018.06.19</td>
								<td class="even">5554</td>
							</tr>

							<tr style="border-bottom: solid 1px black;">
								<td>1</td>
								<td>보험사고</td>
								<td><a href="<%=root %>/qa_read.jsp">고객님 사고접수는</a></td>
								<td>2018.06.19</td>
								<td>5554</td>
							</tr>
						</table>
						<div align="right"><a href="<%=root%>/qa_write.jsp"><input type="button" value="글작성"></a></div>
						</article>

					</div>
				</div>

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

	<!-- Footer -->
	<!-- -------------하단분리------------------------- -->
	<jsp:include page="/menu/bottom.jsp" flush='false' />
	<!-- -------------------------------------------- -->

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>