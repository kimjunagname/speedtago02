<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  import="java.util.List,com.speedtago.member.model.ZipDto"%>
<%
String root = request.getContextPath();
String zipcode = (String) request.getAttribute("zipNo");
String addr1 = (String) request.getAttribute("roadAddrPart1");
String addr2 = (String) request.getAttribute("roadAddrPart2");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">

  //주소 API 적용 시작.
  function getAddr() {
    // AJAX 주소 검색 요청
    $.ajax({
      url : "http://www.juso.go.kr/addrlink/addrLinkApiJsonp.do" // 주소검색 OPEN API URL
      ,
      type : "post"
      ,
      data : $("#form").serialize() // 요청 변수 설정
      ,
      dataType : "jsonp" // 크로스도메인으로 인한 jsonp 이용, 검색결과형식 JSON 
      ,
      crossDomain : true
      ,
      success : function(jsonStr) { // jsonStr : 주소 검색 결과 JSON 데이터      
        $("#list").html(""); // 결과 출력 영역 초기화
        var errCode = jsonStr.results.common.errorCode;
        var errDesc = jsonStr.results.common.errorMessage;
        if (errCode != "0") {
          $("#pageApi").html("");
          if (errCode == "E0001") {
            alert("승인되지 않은 KEY입니다.");
          }
          else if (errCode == "E0005") {
            alert("검색어를 입력해주세요.");
          }
          else if (errCode == "E0006") {
            alert("시도명으로는 검색이 불가합니다.");
          }
          else {
            alert("에러가 발생하였습니다. 잠시후 다시 시도해주세요.");
          }
        } else {
          if (jsonStr != null) {
            makeListJson(jsonStr); // 결과 JSON 데이터 파싱 및 출력
            pageMake(jsonStr);
          }
        }
      }
      ,
      error : function(xhr, status, error) {
        alert("에러발생"); // AJAX 호출 에러
      }
    });
  }
  
  //주소 검색후 데이터+건수 받아오기
  function makeListJson(jsonStr){
    var total = jsonStr.results.common.totalCount; // 총건수  
    var htmlStr = "";
    htmlStr += "<table>";
    htmlStr += "<tr align=\"left\">";
    htmlStr += "<td><b>"+total+"</b>건의 우편번호가 조회되었습니다.</td>";
    htmlStr += "</tr>";
    // jquery를 이용한 JSON 결과 데이터 파싱
      $(jsonStr.results.juso).each(function(){    
          htmlStr += "<tr>";
          htmlStr += "<td>"+this.zipNo+"</td>";
          htmlStr += "<td>"+this.roadAddrPart1+"</td>";
          htmlStr += "<td>"+this.roadAddrPart2+"</td>";
          htmlStr += "<td>"+"&nbsp;"+"</td>";
          htmlStr += "<td> <input type=\"button\" onclick=\"javascript:addressing(\'"+this.zipNo+"\',\'"+this.roadAddrPart1+"\',\'"+this.roadAddrPart2+"\')\" value=\"선택\"></td>";
          htmlStr += "</tr>";
      });
    htmlStr += "</table>";
  // 결과 HTML을 FORM의 결과 출력 DIV에 삽입
  $("#list").html(htmlStr);
  }
  
  // 주소값 넣어주기
  function addressing(zipNo,roadAddrPart1,roadAddrPart2){
	 document.form.action = "<%=root%>/user";
     document.form.submit();
	  
	  opener.document.form.zipNo.value = zipNo; // 우편번호
	  opener.document.form.roadAddrPart1.value = roadAddrPart1; // 도로명주소
	  opener.document.form.roadAddrPart2.value = roadAddrPart2; // 도로명주소
	  self.close();
  }
  
  // 페이지 이동
  function goPage(pageNum) {
    document.form.currentPage.value=pageNum;
    getAddr();
  }
  
  function pageMake(jsonStr){
    var total = jsonStr.results.common.totalCount; // 총건수
    var pageNum = document.form.currentPage.value;// 현재페이지
    var paggingStr = "";
    if(total < 1){
      var htmlStr = "";
      htmlStr += "<table>";
      htmlStr += "<tr>";
      htmlStr += "<td>검색결과가 없습니다.</td>";
      htmlStr += "</tr>";
      htmlStr += "</table>";
      $("#list").html(htmlStr);
      $("#pageApi").html("");
    }else{
      if(total > 1000){
          total=1000;
      }
    }
    var PAGEBLOCK=10; // 10
    var pageSize=10; // 10
    var totalPages = Math.floor((total-1)/pageSize) + 1; // 총페이지
    var firstPage = Math.floor((pageNum-1)/PAGEBLOCK) * PAGEBLOCK + 1; // 리스트의 처음 ( (2-1)/10 ) * 10 + 1 // 1 11 21 31
    if( firstPage <= 0 ) firstPage = 1; // 처음페이지가 1보다 작으면 무조건 1
    var lastPage = firstPage-1 + PAGEBLOCK; // 리스트의 마지막 10 20 30 40 50
    if( lastPage > totalPages ) lastPage = totalPages;  // 마지막페이지가 전체페이지보다 크면 전체페이지
    var nextPage = lastPage+1 ; // 11 21 
    var prePage = firstPage-PAGEBLOCK ; 
    if( firstPage > PAGEBLOCK ){
      paggingStr +=  "<a href='javascript:goPage("+prePage+");'>◁</a>  " ; // 처음 페이지가 아니면 ◁를 넣어줌
    }   
    for(var i=firstPage; i<=lastPage; i++ ){
      if(pageNum == i)
        paggingStr += "<a style='font-weight:bold;color:blue;font-size:15px;' href='javascript:goPage("+i+");'>" + i + "</a>  ";
      else
        paggingStr += "<a href='javascript:goPage("+i+");'>" + i + "</a>  ";
    }   
    if( lastPage < totalPages ){
      paggingStr +=  "<a href='javascript:goPage("+nextPage+");'>▷</a>"; // 마지막페이지가 아니면 >를 넣어줌
    }   
    $("#pageApi").html(paggingStr);
  }
// 주소 API 적용 끝

// 선택 버튼 클릭시
  function addressing(zipNo,roadAddrPart1,roadAddrPart2){
	    document.form.action = "<%=root%>/user";
    	document.form.submit();
    	
	// zipcode, address를 부모창 우편번호 주소칸에 얹고 닫기
	    opener.document.getElementById("zipcode").value =  zipNo; 
	    opener.document.getElementById("addr1").value =  roadAddrPart1;
	    opener.document.getElementById("addr2").value =  roadAddrPart2;
	    self.close();
  }
</script>
<title>우편번호 찾기</title>
</head>
<body>
  <center>
  <div><h3 class="text-primary">우편번호 검색</h3></div>
  <hr>
  <div>
  <font color="blue"><strong>찾고자 하는 주소의 검색어를 입력하여 주세요.</strong></font><br>
  <li>도로명 + 건물번호 (예)가산디지털1로 16</li>
  <li>건물명 (예)코오롱싸이언스밸리1차</li>
  <li>읍/면/동/리 + 지번 (예)가산동 673번지</li>
  </div>
  <hr>
<!-- post -->
  <form name="form" id="form" method="post">
    <input type="hidden" name="act" value="zipsearch">
    <!-- 요청 변수 설정 (현재 페이지. currentPage : n > 0) -->
    <input type="hidden" name="currentPage" value="1"/>       
    <!-- 요청 변수 설정 (페이지당 출력 개수. countPerPage 범위 : 0 < n <= 100) -->
    <input type="hidden" name="countPerPage" value="10"/>   
    <!-- 요청 변수 설정 (검색결과형식 설정, json) -->
    <input type="hidden" name="resultType" value="json"/>        
    <!-- 요청 변수 설정 (승인키) -->
    <input type="hidden" name="confmKey" value="U01TX0FVVEgyMDE4MDYyNzIyNDgwNDEwNzk2ODU="/>   
    <input type="text" name="keyword" size="35" placeholder="검색할 주소를 입력하세요."/>      
    <input type="button" onClick="getAddr();" class="btn btn-primary btn-sm" value="주소검색하기"/>
    <hr>  
    <div id="list"> 
      <!-- 검색 결과 리스트 출력 영역 --> 
    </div>
    <div class="paginate" id="pageApi" align="left"></div>
  </form>
  </center>
</body>
</html>