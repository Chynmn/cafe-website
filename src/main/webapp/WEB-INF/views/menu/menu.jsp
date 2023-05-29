<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Menu</title>
	<link rel="stylesheet" href="../resources/bootstrap.css" type="text/css"></link>
	<script type="text/javascript">
	function setBg(t) {
		//td = t.parentNode
		//td.style.backgroundColor = (t.checked) ? "darkgray" : "white";
		
		tr = t.parentNode.parentNode;
		tr.style.backgroundColor = (t.checked) ? "darkgray" : "white";
	}
	
	</script>	
	
</head>
<body class="text-center">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="/free/mission/list"><img src="../resources/dlogo.png" alt="" height="48"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
		<c:url value="/mission/register" var="url" /><a class="nav-link" href="${url}">미션 등록</a>
      </li>
      <li class="nav-item active">
		<c:url value="/member/modify" var="url" /><a class="nav-link" href="${url}">개인 정보 수정</a>
      </li>
      <li class="nav-item active">
		<c:url value="/login" var="url" /><a class="nav-link" href="${url}">로그아웃</a>
      </li>
    </ul>
  </div>
</nav>
<!-- 		<table class="table table-sm">
			<tr>
				<th scope="col"></th><th scope="col">미션명</th><th scope="col">목표</th><th scope="col">보상</th><th scope="col"></th>
			</tr>
			<c:forEach var="mission" items="${missions}">
				<tr>
					<td><input class="form-check-input" type="checkbox" onclick="setBg(this)" /></td>
					<td><c:out value="${mission.missionname}" /></td>
					<td><c:out value="${mission.goal}" /></td>
					<td><c:out value="${mission.reward}" /></td>
					<td><c:url value="/mission/read?missionname=${mission.missionname}" var="url"/><a href="${url}">미션 보기</a></td>
					<td><c:url value="/mission/modify?missionname=${mission.missionname}" var="url"/><a href="${url}">미션 수정</a></td>
					<td><c:url value="/mission/delete?missionname=${mission.missionname}" var="url"/><a href="${url}">미션 삭제</a></td>
				</tr>
			</c:forEach>
		</table> -->
		<c:forEach var="mission" items="${missions}">
		<div class="card row" style="width: 18rem;">
  			<img src="../resources/puyo.jpg" class="card-img-top" alt="...">
  			<div class="card-body">
    			<h5 class="card-title"><p style="font-weight:600; color:#692498;">Mission</p><c:out value="${mission.missionname}" /></h5>
    			<p class="card-text"><span style="font-weight:800;">ID </span><c:out value="${mission.id}" /><br><span style="font-weight:800;">Goal </span><c:out value="${mission.goal}" /><br><span style="font-weight:800;">Reward </span><c:out value="${mission.reward}" /></p>
				<%-- <c:url value="/mission/read?missionname=${mission.missionname}" var="url"/><a class="btn btn-success" href="${url}">show</a> --%>
    			<c:choose>
    				<c:when test="${mission.id eq member}">
    					<c:url value="/mission/modify?missionname=${mission.missionname}" var="url"/><a class="btn btn-primary" href="${url}">modify</a>
  						<c:url value="/mission/delete?mission_id=${mission.mission_id}" var="url"/><a class="btn btn-danger" href="${url}">delete</a>
  					</c:when>
  					<c:when test="${mission.id ne member }">
						<c:url value="/mission/addto" var="url">							
							<c:param name="id" value="${member}"></c:param>
  							<c:param name="missionname" value="${mission.missionname}"></c:param>
  							<c:param name="goal" value="${mission.goal}"></c:param>
  							<c:param name="reward" value="${mission.reward}"></c:param>
  						</c:url>
  						<a class="btn btn-primary" href="${url}">함께 하기</a>
					</c:when>
  				</c:choose>
  			</div>
		</div>
		</c:forEach>

</body>
</html>