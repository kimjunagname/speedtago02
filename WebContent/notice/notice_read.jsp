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
				
			    <!-- ---------------left 고정-------------------- -->
				<jsp:include page="/menu/left_nn.jsp" flush='false' />
				<!-- ----------------------------------------- -->
				<!-- 왼쪽 사이트 바 종료----------------------------------------------------- -->

				<!-- 내용 시작 [범위: 10]----------------------------------------------------- -->
				<div class="col-10  col-12-narrower imp-narrower">
					<div id="content">
					
						<!-- Content -->
						<article> 
						<header>
						<h2>공지사항</h2>
						<hr style="border: solid 1px black;">
						</header> 


						<!-- ------------------------------계간 소식 테이블 리스트 추가 부분------------------------------ -->
						<!-- ------------------------------이미지 게시판 center 정렬 시작------------------------------ -->

						<!-- Highlights -->
						<section class="wrapper style1">
						<div class="container">
							<div class="row gtr-200">


								<!-- ------------------------------이미지 게시판 정렬시작 부분------------------------------ -->

								<!-- Posts -->
								<section class="wrapper style1">
								<div class="container">

									<!-- ------------------------------이미지 게시판 실제추가 부분------------------------------ -->

									<DIV align='left'>
										<h2>공지사항</h2>
									</DIV>
									<div class="row">
										<section class="col-12 col-12-narrower">
										<div class="box post">
											<div>
												<table class="table table-striped">
													<tr>
														<td align="left" width="70%">작성일:2018-06-01</td>
														<td align="left" width="30%">조회수: 71</td>
													</tr>
												</table>
											</div>
											<a href="<%=root %>/images/tu005.jpg" class="image left"><img
												src="<%=root %>/images/tu005.jpg" alt="" /></a>
											<div class="inner">
												<p>공지사항 1호 입니다.</p>
											</div>
										</div>

										<ul class='right' align="center">
											<button type="button"
												onclick="location.href='<%=root %>/speedtago_notice_list.jsp'">목록가기</button>
											<button type="button"
												onclick="location.href='<%=root %>/speedtago_notice_list_modfiy_write.jsp'">수정</button>
											<button type="button"
												onclick="location.href='<%=root %>/sspeedtago_notice_list.jsp'">삭제</button>
										</ul>

										</section>
									</div>


									<!-- ------------------------------이미지 게시판 끝 부분------------------------------ -->


								</div>
							</div>
						</section>
						<!-- ------------------------------이미지 게시판 center 정렬 종료------------------------------ -->






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
	<%@ include file="/menu/bottom.jsp" %>
	<!-- -------------------------------------------- -->
