<%@ page import="basejava.model.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Список всех резюме</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <table cellpadding="8" cellspacing="0" class="section-table">
        <tr>
            <th>Имя</th>
            <th>Email</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${resumes}" var="resume">
            <jsp:useBean id="resume" type="basejava.model.Resume"/>
            <tr>
                <td><a href="resume?uuid=${resume.uuid}&action=view">${resume.fullName}</a></td>
                <td><%=ContactType.EMAIL.toHtml(resume.getContact(ContactType.EMAIL))%>
                </td>
                <td><a href="resume?uuid=${resume.uuid}&action=delete"><img alt="deleteResume" src="img/delete.png"></a>
                </td>
                <td><a href="resume?uuid=${resume.uuid}&action=edit"><img alt="editResume" src="img/pencil.png"></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button onclick="location.href='resume?uuid=null&action=edit';">Заполнить новое резюме</button>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
