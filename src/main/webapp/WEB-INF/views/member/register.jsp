<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../resources/css/register.css"/>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src = "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>회원가입</title>
</head>
<script type="text/javascript">
    $(document).ready(function(){
        // 취소
        $(".cencle").on("click", function(){
            location.href = "";

        })
    })
</script>
<body>
<div class="container">
    <form action="/member/register" method="post">
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4 " src="../resources/image/signup.png" alt="" width="72" height="72">
            <h2>회원가입</h2>
            <p class="lead">카페 회원가입 페이지 입니다.</p>
        </div>

        <div class="col-md-12 order-md-1">
            <h4 class="mb-3">회원정보 입력</h4>
            <hr>
            <div class="mb-3">
                <label for="userName">이름</label>
                <input type="text" class="form-control"  id="name" name = "name" placeholder="이름을 입력하세요." required name="user-real-name">
            </div>

            <div class="mb-3">
                <label for="user_id">아이디</label>

                <input type="text" class="form-control" id="id" name = "id"  placeholder="아이디를 입력하세요.">
                <!--   <span id="result"></span> -->

            </div>
            <div class="mb-3">
                <label for="password">비밀번호</label>
                <input type="password" class="form-control" id="passwd" name = "passwd" placeholder="비밀번호를 입력하세요">
                <!--    <div class="invalid-feedback">유효한 비밀번호가 필요합니다.</div> -->
            </div>
            <div class="form-group has-feedback">
                <label class="control-label" for="residence">지역</label>
                <!-- <input class="form-control" type="text" id="residence" name="residence" /> -->
                <%--				<div class = "residence" >--%>
                <%--				<select name = "residence">--%>
                <%--					<option value='' selected>-- 선택 --</option>--%>
                <%--					<option value='Siheung'>시흥시</option>--%>
                <%--					<option value='Ansan'>안산시</option>--%>
                <%--					<option value='Suwon'>수원시</option>--%>
                <%--					<option value="gapyeong">가평군</option>--%>
                <%--					<option value="gapyeong">과천시</option>--%>
                <%--				</select>--%>
                <%--				</div>--%>
                <%--					<span id="si">--%>
                <%--     					<select name="residence" onchange="getText('residence')">--%>
                <%--	    		 		<option value="">시도를 선택하세요</option>--%>
                <%--     					</select>--%>
                <%--					</span>--%>
                <%--					<span id="gu">--%>
                <%--						<select name="residenceGu" onchange="getText('residenceGu')">--%>
                <%--						<option value="">구군을 선택하세요</option>--%>
                <%--						</select>--%>
                <%--    				</span>--%>

            </div>
            <div class="form-group has-feedback">
                <button class="btn btn-success" type="submit" id="submit">회원가입</button>
                <button class="cencle btn btn-danger" type="button">취소</button>
            </div>

            <br><br>

        </div>
    </form>
</div>

</body>

<script type="text/javascript">
    //$(function() : 문서 준비 완료.
    $(function(){

// 서버에서 문자열로 데이터 전달 받기
        $.ajax({   //jquery를 이용한 ajax 처리
            url : "/ajax/select2",
            success : function(data) {
                //data : utf-8로 인코딩된 순수 문자열 데이터.
                //배열로 변환
                let arr = data.substring(data.indexOf('[')+1,
                    data.indexOf(']')).split(",")
                $.each(arr,function(i,item) {
                    $("select[name=residence]").append(function(){
                        return "<option>"+item+"</option>"
                    })
                })
            }
        })

    })

/*     function getText(name) { //gu
        let city = $("select[name='residence']").val();
        let gu = $("select[name='residenceGu']").val();
        let disname;
        let toptext="구군을 선택하세요";
        let params = "";
        if (name == "si") {
            params = "si=" + city.trim();
            disname = "residenceGu";
        } else {
            return ;
        }
        $.ajax({
            url : "${path}/ajax/select",
            type : "POST",
            data : params,
            success : function(arr) {
                //데이터를 추가해야 하는 select 태그의 option 태그들을 전부 제거
                $("select[name="+disname+"] option").remove();
                //첫번째 option 객체 추가
                $("select[name="+disname+"]").append(function(){
                    return "<option value=''>"+toptext+"</option>"
                })
                //arr : 서버에서 전송한 배열 객체
                $.each(arr,function(i,item) {
                    $("select[name="+disname+"]").append(function(){
                        return "<option>"+item+"</option>"
                    })
                })
            }
        })
    } */
</script>
</html>