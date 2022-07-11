<%@ page import="hello.servlet.domain.member.MemberRespository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //request, response 사용 가능
    MemberRespository respository = MemberRespository.getInstance();
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    respository.save(member);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    성공
    <ul>
        <li>id = <%=member.getId()%> </li>
        <li>id = <%=member.getUsername()%> </li>
        <li>id = <%=member.getAge()%> </li>
    </ul>
<a href="/index.html">
    인덱스
</a>
</body>
</html>
