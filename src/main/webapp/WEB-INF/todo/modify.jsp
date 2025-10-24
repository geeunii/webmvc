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
    <title>Todo Modify/Remove</title>
</head>
<body>

<%--
  수정/삭제 작업은 중요 데이터 변경이므로 반드시 "post" 방식으로 보냅니다.
  action 속성은 버튼에서 개별로 지정할 것이므로 여기서는 생략해도 됩니다.
--%>
<form method="post">
    <div>
        <label for="tno"></label>
        <%--
          tno(PK)는 절대 수정하면 안 되므로 'readonly' (읽기 전용) 속성을 추가합니다.
        --%>
        <input type="text" name="tno" id="tno" value="${dto.tno}" readonly/>
    </div>
    <div>
        <label for="title"></label>
        <input type="text" name="title" id="title" value="${dto.title}"/>
    </div>
    <div>
        <label for="dueDate"></label>
        <input type="date" name="dueDate" id="dueDate" value="${dto.dueDate}"/>
    </div>
    <div>
        <label for="finished"></label>
        <%--
          체크박스가 선택된 채로 전송되면 'on' (혹은 value값)이,
          체크가 해제된 채로 전송되면 'null' (값이 없음)이 컨트롤러로 넘어갑니다.
          value="true"를 명시해주는 것이 좋습니다.
        --%>
        <input type="checkbox" name="finished" id="finished" value="true" ${dto.finished ? 'checked' : ''} />
    </div>

    <hr>

    <div>
        <%--
          [핵심] type="submit"으로 바꾸고,
          formaction 속성으로 이 버튼을 눌렀을 때 폼 데이터가 전송될 URL을 지정합니다.
        --%>
        <button type="submit" formaction="/todo/modify">Modify</button>
    </div>
    <div>
        <%--
          [핵심] 이 버튼도 type="submit"으로 바꾸고,
          formaction으로 삭제를 처리할 URL을 지정합니다.
          삭제 시에도 tno 값이 필요하므로 폼 전송(submit)이 맞습니다.
        --%>
        <button type="submit" formaction="/todo/remove">Remove</button>
    </div>
</form>
</body>
</html>
