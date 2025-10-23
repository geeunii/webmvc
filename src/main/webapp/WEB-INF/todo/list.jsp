<%--
  Created by IntelliJ IDEA.
  User: geuni
  Date: 25. 10. 23.
  Time: 오후 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo List</title>
</head>
<body>
<h1>Todo List Page</h1>

<%--EL(Expression Language)
    간단한 표현식을 이용해서 데이터를 출력하는 용도로 사용하는 표현 언어
${list}
<h4>${list[0].tno}</h4>
<h4>${list[0].title}</h4>
<h4>${list[0].dueDate}</h4>--%>

<%--<ul>
    <c:forEach var="dto" items="${list}">
        <li>${dto}</li>
    </c:forEach>
</ul>
<c:forEach var="num" begin="1" end="10">
    <li>${num}</li>
</c:forEach>

<c:if test="${list.size() % 2 == 0}">
    짝수
</c:if>
<c:if test="${list.size() % 2 != 0}">
    홀수
</c:if>

<c:choose>
    <c:when test="${list.size() % 2 == 0}">
        짝수
    </c:when>
    <c:otherwise>
        홀수
    </c:otherwise>
</c:choose>

<c:set var="target" value="5">
    <ul>
        <c:forEach var="num" begin="1" end="10">
            <c:if test="${num == target}">
                num is target.
            </c:if>
        </c:forEach>
    </ul>
</c:set>--%>
</body>
</html>
