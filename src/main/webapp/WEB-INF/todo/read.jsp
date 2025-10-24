<%--
  Created by IntelliJ IDEA.
  User: geuni
  Date: 25. 10. 23.
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>
<form>
    <div>
        <label for="tno"></label>
        <input type="text" name="tno" id="tno" value="${dto.tno}" readonly>
    </div>
    <div>
        <label for="title"></label>
        <input type="text" name="title" id="title" value="${dto.title}" readonly>
    </div>
    <div>
        <label for="dueDate"></label>
        <input type="date" name="dueDate" id="dueDate" value="${dto.dueDate}" readonly>
    </div>
    <div>
        <label for="finished"></label>
        <%--
          체크박스는 '삼항 연산자'를 사용합니다.
          ${dto.finished ? 'checked' : ''}
          의미: "dto.finished가 true이면 'checked' 문자열을 출력하고, 아니면(false이면) 빈 문자열을 출력해라."

          disabled: 사용자가 클릭(체크/해제)할 수 없도록 비활성화
        --%>
        <input type="checkbox" name="finished" id="finished" ${dto.finished ? 'checked' : ''} disabled>
    </div>

    <div>
        <a href="/todo/modify?tno=${dto.tno}">
            Modify/Remove List
        </a>
    </div>
</form>

<%--${dto.tno} ${dto.title} ${dto.dueDate} ${dto.finished}--%>
</body>
</html>
