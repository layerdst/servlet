<%@ page import="hello.servlet.domain.member.MemberRespository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRespository rep = MemberRespository.getInstance();
    List<Member> members = rep.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% for(Member m : members){ %>
    <tr>
        <td><%= m.getId()%> </td>
        <td><%= m.getUsername()%></td>
    </tr>
    <%}%>
</body>
</html>
