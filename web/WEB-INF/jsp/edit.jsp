<%@ page import="basejava.model.ContactType" %>
<%@ page import="basejava.model.OrganizationSection" %>
<%@ page import="basejava.model.SectionType" %>
<%@ page import="basejava.model.TextListSection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <jsp:useBean id="resume" type="basejava.model.Resume" scope="request"/>
    <title>Резюме ${resume.fullName}</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <form method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <dl>
            <dt>Имя:</dt>
            <dd><input type="text" name="fullName" size=50 value="${resume.fullName}"></dd>
        </dl>
        <h3>Контакты:</h3>
        <c:forEach var="type" items="<%=ContactType.values()%>">
            <dl>
                <dt>${type.title}</dt>
                <dd><input type="text" name="${type.name()}" size=30 value="${resume.getContact(type)}"></dd>
            </dl>
        </c:forEach>
        <h3>Секции:</h3>
        <c:forEach var="sectionType" items="<%=SectionType.values()%>">
            <dl>
                <dt>${sectionType.title}</dt>
                <c:choose>
                    <c:when test="${sectionType.equals(SectionType.PERSONAL)}">
                        <dd><input type="text" name="${sectionType.name()}" size=300
                                   value="${resume.getSection(sectionType)}"></dd>
                        <br>
                    </c:when>
                    <c:when test="${sectionType.equals(SectionType.OBJECTIVE)}">
                        <dd><input type="text" name="${sectionType.name()}" size=300
                                   value="${resume.getSection(sectionType)}"></dd>
                        <br>
                    </c:when>
                    <c:when test="${sectionType.equals(SectionType.ACHIEVEMENT)}">
                        <c:forEach var="line"
                                   items="<%=((TextListSection) resume.getSection(SectionType.ACHIEVEMENT)).getLines()%>">
                            <dd><input type="text" name="" size=350
                                       value="${line}"></dd>
                            <br>
                        </c:forEach>
                    </c:when>
                    <c:when test="${sectionType.equals(SectionType.QUALIFICATIONS)}">
                        <c:forEach var="line"
                                   items="<%=((TextListSection) resume.getSection(SectionType.QUALIFICATIONS)).getLines()%>">
                            <dd><input type="text" name="" size=350
                                       value="${line}"></dd>
                            <br>
                        </c:forEach>
                    </c:when>
                    <c:when test="${sectionType.equals(SectionType.EXPERIENCE)}">
                        <c:forEach var="organisation"
                                   items="<%=((OrganizationSection) resume.getSection(SectionType.EXPERIENCE)).getOrganizations()%>">
                            <dd><input type="text" name="" size=50
                                       value="${organisation.name}"></dd>
                            <br>
                            <dd><input type="text" name="" size=50
                                       value="${organisation.url}"></dd>
                            <br>
                            <c:forEach var="position"
                                       items="${organisation.positions}">
                                <dd><input type="text" name="" size=50
                                           value="${position.dateStart}"></dd>
                                <br>
                                <dd><input type="text" name="" size=50
                                           value="${position.dateEnd}"></dd>
                                <br>
                                <dd><input type="text" name="" size=50
                                           value="${position.title}"></dd>
                                <br>
                                <dd><input type="text" name="" size=50
                                           value="${position.text}"></dd>
                                <br>
                            </c:forEach>
                        </c:forEach>
                    </c:when>
                    <c:when test="${sectionType.equals(SectionType.EDUCATION)}">
                        <c:forEach var="organisation"
                                   items="<%=((OrganizationSection) resume.getSection(SectionType.EDUCATION)).getOrganizations()%>">
                            <dd><input type="text" name="" size=50
                                       value="${organisation.name}"></dd>
                            <br>
                            <dd><input type="text" name="" size=50
                                       value="${organisation.url}"></dd>
                            <br>
                            <c:forEach var="position"
                                       items="${organisation.positions}">
                                <dd><input type="text" name="" size=50
                                           value="${position.dateStart}"></dd>
                                <br>
                                <dd><input type="text" name="" size=50
                                           value="${position.dateEnd}"></dd>
                                <br>
                                <dd><input type="text" name="" size=50
                                           value="${position.title}"></dd>
                                <br>
                                <dd><input type="text" name="" size=50
                                           value="${position.text}"></dd>
                                <br>
                            </c:forEach>
                        </c:forEach>
                    </c:when>
                </c:choose>
            </dl>
        </c:forEach>

        <hr>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

