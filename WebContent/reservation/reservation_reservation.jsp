<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<!-- Header -->
<!-- ---------------상단 고정-------------------- -->
<%@ include file="/menu/top.jsp"%>
<!-- ----------------------------------------- -->
<script type="text/javascript">
function categoryChange(e){
 var car_small = ["스파크", "엑센트", "마티즈", "티볼리"];
 var car_middle = ["그랜저", "소나타", "SM6", "SM5"];
 var car_big = ["카니발","스타렉스","코란도","장애인용 승합"];
 var target = document.getElementById("car");
 if(e.value == "small"){
   var d = car_small;
 } else if(e.value == "middle"){
   var d = car_middle;
 } else if(e.value == "big"){
   var d = car_big;
 }
 target.options.length = 0;
 for(x in d){
   var opt = document.createElement("option");
   opt.value = d[x];
   opt.innerHTML = d[x];
   target.appendChild(opt);
 }
}
function openMap() {
  window.open("<%=root%>/car?act=mvopenMap","map","top=200, left=300, width=4000, height=5000, menubar=no, status=no, toolbar=no, location=no, scrollbars=yes");
}
</script>
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
        <h2>차량 예약</h2>
        <hr style="border: solid 1px black;">
      </header>
      <table class="table table-striped">
        <tr>
          <th>성명</th>
          <td colspan="2"><input type="text" id="name" name="name"
            style="text-align: left; width: 300px; height: 30px;">
          </td>
        </tr>
        <tr>
          <th>전화번호</th>
          <td><input type="text" id="tel" name="tel"
            style="text-align: left; width: 300px; height: 30px;">
          </td>
        </tr>

        <tr>
          <th>예약일</th>
          <td colspan="2"><input type="date" id="startdate"
            name="startdate"
            style="text-align: left; width: 300px; height: 30px;">
            <input type="time" id="starttime" name="starttime"
            style="text-align: left; width: 300px; height: 30px;">
          </td>
        </tr>
        <tr>
          <th>반납일</th>
          <td colspan="2"><input type="date" id="enddate"
            name="enddate"
            style="text-align: left; width: 300px; height: 30px;">
            <input type="time" id="enddate" name="enddate"
            style="text-align: left; width: 300px; height: 30px;">
          </td>
        </tr>
        <tr>
          <th>차종</th>
          <td colspan="2"><select
            onchange="javascript:categoryChange(this);">
              <option value="small" selected="selected">소형</option>
              <option value="middle">중형</option>
              <option value="big">승합</option>
          </select></td>
        </tr>
        <tr>
          <th>차량명</th>
          <td colspan="2"><select id="car">
              <option selected="selected"></option>
          </select></td>
        </tr>
        <tr>
          <th>대여지 선택</th>
          <td colspan="2"><input type="text" id="rentalpost"
            readonly="readonly" name="rentalpost"
            style="text-align: left; width: 400px; height: 30px;">
          </td>

        </tr>
        <tr>
          <th>반납지 선택</th>
          <td><input type="text" id="returnpost"
            readonly="readonly" name="returnpost"
            style="text-align: left; width: 400px; height: 30px;">
          </td>
          <td>
            <button type="button" class="btn btn-primary btn-sm"
              onclick="javascript:openMap();">대여 반납지 지도로 선택</button>
          </td>
        </tr>
        <tr>
          <th>총 결제금액</th>
          <td><input type="text" id="paycalview"
            readonly="readonly" name="paycalview"
            style="text-align: left; width: 150px; height: 30px;">
          </td>
          <td>
            <button type="button" class="btn btn-primary btn-sm" onclick="">요금계산하기</button>
            <button type="button" class="btn btn-primary btn-sm"  data-toggle="modal" data-target="#inform">요금안내</button>
          </td>
        </tr>
        <tr>
          <td align="left"><input type="button" value="취소"
            onclick=""></td>
          <td align="right" colspan="2">
          <input type="button" value="다음단계" onclick=""><a href="<%=root %>/reservation/reservation_payment.jsp"></a>
          </td>
          
        </tr>
      </table>
    </article>
  </div>
</div>
<!-- 내용 종료 [범위: 10]----------------------------------------------------- -->
</div>
</div>
</section>

<!-- 가격 안내 모달창 -->
    <div class="modal fade" id="inform" tabindex="-1" role="dialog"
      aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title" id="myModalLabel">요금안내</h4>
          </div>
          <div class="modal-body">
            <p><b>☞ 소형차</b><br> 1일 사용시 10,000원</p>
            <p><b>☞ 중형차</b><br> 1일 사용시 15,000원</p>
            <p><b>☞ 승합차</b><br> 1일 사용시 20,000원</p>
            <p>☞ 안내사항 :<br> 반납 연기시 <b>30분</b> 단위로 <b>2,000원</b>의 추가요금이 발생합니다.</p>
            <p>(추가요금은 반납지에서 지불하는 것으로 원칙으로 합니다.)<br></p>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
          </div>
        </div>
        <!-- 모달 콘텐츠 -->
      </div>
      <!-- 모달 다이얼로그 -->
    </div>
<!-- Footer -->
<!-- -------------하단분리------------------------- -->
<%@ include file="/menu/bottom.jsp"%>
<!-- -------------------------------------------- -->