<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<!-- Header -->
<!-- ---------------상단 고정-------------------- -->
<%@ include file="/menu/top.jsp"%>
<!-- ----------------------------------------- -->
<style>
div.wrap > div{
  font-size: 12px;
  position: relative;
  float: left;
  margin-right: 5px;
  height: 30px;
  line-height: 30px;
  vertical-align: middle;
  input{
    line-height: 30px;
    margin: 0;
    padding: 0;
    padding-left: 5px;
    padding-right: 5px;
    width: 100px;
  }  
}
#ui-datepicker-div{
 top:-999px; 
 border: 0;
 font-size: 14px;
}
.ui-datepicker-header{
  font-size: 13px;
}
.ui-datepicker-calendar{
  background-color: #fff;
  border: 1px solid #ddd;
  
  tr{
    font-size: 11px;
  }
}
</style>

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
function calcPay(){
  // 대여일, 반납일이 null값이 아닐 경우에만 계산 처리한다.
  if(document.getElementById("startdate").value != "" && document.getElementById("enddate").value != ""){
        var startdate = document.getElementById("startdate").value;
        var enddate = document.getElementById("enddate").value;
         var target = document.getElementById("carinfo");
         // 대여일, 반납일 '-'기준으로 쪼개어 배열로 지정
        var arr1 = startdate.split('-');
        var arr2 = enddate.split('-');
        // std : 대여일, edd : 종료일 -> new Date 선언후 배열값을 인자값으로 담는다.
        var std = new Date(arr1[0], arr1[1], arr1[2]);
        var edd = new Date(arr2[0], arr2[1], arr2[2]);
        
        // 날짜 차이 알아내기
        var diff = edd-std; 
        var currDay = 24*60*60*1000; // 시*분*초*밀리세컨
        var currMonth = currDay * 30; // 월 만듬
        var currYear = currMonth*12; // 년 만듬
        var calc; // 요금 계산값
        // daylength : 차이값 (+1 한 이유 : 차량 빌린 해당 날부터 1일 추가 해야 하므로)  
        var daylength = parseInt(diff/currDay)+1;
        // 날짜 입력이 잘못되었을 경우
        if(daylength <= 0){
           alert("날짜 입력이 잘못되었습니다.");
           return;
        }
        // 값계산 - *소형 1일 기준 10,000 *중형 1일기준 15,000 *대형 1일기준 20,000, 값 선택 x alert & 계산값은 빈값처리 
        if(target.options[target.selectedIndex].value == 'small'){
          calc = daylength*10000;
        } else if(target.options[target.selectedIndex].value == 'middle'){
          calc = daylength*15000;
        } else if(target.options[target.selectedIndex].value == 'big'){
          calc = daylength*20000;
        } else{
          alert("차종을 선택해주세요.");
          calc = "";
        }
        document.getElementById("calview").value =  calc;
  } else {
    alert("예약일 반납일을 선택하세요.");
    return;
  }  
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
          <td colspan="2">
            <input type="date" id="startdate" name="startdate" style="text-align: left; width: 300px; height: 30px;">
            <input type="time" id="starttime" name="starttime" style="text-align: left; width: 300px; height: 30px;">
          </td>
        </tr>
        <tr>
          <th>반납일</th>
          <td colspan="2">
            <input type="date" id="enddate" name="enddate" style="text-align: left; width: 300px; height: 30px;">
            <input type="time" id="enddate" name="enddate" style="text-align: left; width: 300px; height: 30px;">
          </td>
        </tr>
        <tr>
          <th>차종</th>
          <td colspan="2">
          <select id="carinfo" onchange="javascript:categoryChange(this);">
              <option>---</option>
              <option id ="small" value="small">소형</option>
              <option id ="middle" value="middle">중형</option>
              <option id ="big" value="big">승합</option>
          </select></td>
        </tr>
        <tr>
          <th>차량명</th>
          <td colspan="2"><select id="car">
              <option id ="carname" selected="selected"></option>
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
          <td>
            <input type="text" id="calview" readonly="readonly" name="calview"  value="" style="text-align: left; width: 150px; height: 30px; ">
          </td>
          <td>
            <button type="button" class="btn btn-primary btn-sm" onclick="javascript:calcPay();">요금계산하기</button>
            <button type="button" class="btn btn-primary btn-sm"  data-toggle="modal" data-target="#inform">요금안내</button>
          </td>
        </tr>
        <tr>
          <td align="left"><input type="button" value="취소"
            onclick=""></td>
          <td align="right" colspan="2"><input type="button"
            value="다음단계" onclick=""></td>
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