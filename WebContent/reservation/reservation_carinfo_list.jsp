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
			<!-- ---------------left 고정-------------------- -->
			<jsp:include page="/menu/left_car.jsp" flush='false' />
			<!-- ----------------------------------------- -->
			<!-- 왼쪽 사이트 바 종료----------------------------------------------------- -->
			<!-- 내용 시작 [범위: 10]----------------------------------------------------- -->
			<div class="col-10  col-12-narrower imp-narrower">
					<div id="content">

							<!-- Content -->

							<article>
								<header>
									<h2>차량정보</h2>
									<hr style="border: solid 1px black;">
								</header>

								<!--  게시판 작성 -->

								<br>
								<table class="type06">
									<tr>
										<td><a href="<%=root%>/photo_read.jsp"><img src="<%=root%>/images/car1.jpg" width="150" height="100" /></a></td>
										<td><a href="<%=root%>/photo_read.jsp"><img src="<%=root%>/images/car2.jpg" width="150" height="100" /></a></td>
										<td><a href="<%=root%>/photo_read.jsp"><img src="<%=root%>/images/car3.jpg" width="150" height="100" /></a></td>
										<td><a href="<%=root%>/photo_read.jsp"><img src="<%=root%>/images/car4.jpg" width="150" height="100" /></a></td>
										<td><a href="<%=root%>/photo_read.jsp"><img src="<%=root%>/images/car1.jpg" width="150" height="100" /></a></td>
									</tr>
									<tr style="font-size: small;">
										<td>소형차</td>
										<td>중형차</td>
										<td>대형차</td>
										<td>벤</td>
										<td>벤츠</td>

									</tr>
									<tr style="font-size: small;">
										<td>조회수1</td>
										<td>조회수2</td>
										<td>조회수3</td>
										<td>조회수4</td>
										<td>조회수5</td>
									</tr>
									<tr style="font-size: small;">
										<td>날짜1</td>
										<td>날짜2</td>
										<td>날짜3</td>
										<td>날짜4</td>
										<td>날짜5</td>
									</tr>

								</table>
								
								<table class="type06">
									<tr>
										<td><a href="<%=root%>/photo_read.jsp"><img src="<%=root%>/images/car1.jpg" width="150" height="100" /></a></td>
										<td><a href="<%=root%>/photo_read.jsp"><img src="<%=root%>/images/car2.jpg" width="150" height="100" /></a></td>
										<td><a href="<%=root%>/photo_read.jsp"><img src="<%=root%>/images/car2.jpg" width="150" height="100" /></a></td>
										<td><a href="<%=root%>/photo_read.jsp"><img src="<%=root%>/images/car3.jpg" width="150" height="100" /></a></td>
										<td><a href="<%=root%>/photo_read.jsp"><img src="<%=root%>/images/car4.jpg" width="150" height="100" /></a></td>
									</tr>
									<tr style="font-size: small;">
										<td>글1</td>
										<td>글2</td>
										<td>글3</td>
										<td>글4</td>
										<td>글5</td>

									</tr>
									<tr style="font-size: small;">
										<td>조회수1</td>
										<td>조회수2</td>
										<td>조회수3</td>
										<td>조회수4</td>
										<td>조회수5</td>
									</tr>
									<tr style="font-size: small;">
										<td>날짜1</td>
										<td>날짜2</td>
										<td>날짜3</td>
										<td>날짜4</td>
										<td>날짜5</td>
									</tr>

								</table>
								<div align="right"><a href="#"><input type="button" value="글작성"></a></div>


							</article>

						</div>
					</div>
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
