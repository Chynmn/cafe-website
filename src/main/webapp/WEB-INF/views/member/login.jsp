<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<html>
<head>
    <title>Login</title>
    <!-- <link rel="stylesheet" href="./resources/css/sigup_Form.css"/>  -->
    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="../resources/css/login.css">
    <!-- 부가적인 테마 -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <script
            src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <% request.setCharacterEncoding("utf-8"); %>
</head>

<body>
<div class="container">
    <header>
        <h2>Login</h2>
    </header>

    <div class="content">
        <form action="/member/login" method="POST">
            <c:if test="${member == null}">
                <div class="mb-3">
                    <label for="id">아이디</label> <input id="id" class="form-control"
                                                       type="text" name="id" placeholder="아이디">

                </div>
                <div class="mb-3">
                    <label for="password">비밀번호</label> <input class="form-control"
                                                              id="passwd" type="password" name="passwd" placeholder="비밀번호">
                </div>
                <input type="submit" class="login_btn" value="로그인"/>
            </c:if>
        </form>
        <button class="login_btn"
                onclick="location.href='/member/register'">회원가입</button>

    </div>

    <c:if test="${msg == false}">
        <p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p>
    </c:if>
</div>

</body>
</html>