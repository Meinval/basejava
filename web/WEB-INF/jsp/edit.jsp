<%@ page import="basejava.model.ContactType" %>
<%@ page import="basejava.model.OrganizationSection" %>
<%@ page import="basejava.model.SectionType" %>
<%@ page import="basejava.model.TextListSection" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>
        <hr>
        <input type="hidden" name="uuid" value="${resume.uuid}">
        <dl>
            <dt>Имя:</dt>
            <dd><label>
                <input type="text" name="fullName" size=50 value="${resume.fullName}">
            </label></dd>
        </dl>
        <h3>Контакты:</h3>
        <c:forEach var="type" items="<%=ContactType.values()%>">
            <dl>
                <dt>${type.title}</dt>
                <dd><label>
                    <input type="text" name="${type.name()}" size=30 value="${resume.getContact(type)}">
                </label></dd>
            </dl>
        </c:forEach>
        <h3>Секции:</h3>
        <c:forEach var="sectionType" items="<%=SectionType.values()%>">
            <hr>
            <dl>
                <dt>${sectionType.title}</dt>
                <br>
                <c:choose>
                    <c:when test="${sectionType.equals(SectionType.PERSONAL)}">
                        <dd><label>
<textarea rows="2" cols="220"
          name="${sectionType.name()}">${resume.getSection(sectionType)}</textarea>
                        </label></dd>
                        <br>
                    </c:when>
                    <c:when test="${sectionType.equals(SectionType.OBJECTIVE)}">
                        <dd><label>
<textarea rows="2" cols="220"
          name="${sectionType.name()}">${resume.getSection(sectionType)}</textarea>
                        </label></dd>
                        <br>
                    </c:when>
                    <c:when test="${sectionType.equals(SectionType.ACHIEVEMENT)}">
                        <c:forEach var="line"
                                   items="<%=((TextListSection) resume.getSection(SectionType.ACHIEVEMENT)).getLines()%>">
                            <dd><label>
                                <textarea rows="2" cols="220" name="${sectionType.name()}">${line}</textarea>
                            </label></dd>
                            <br>
                        </c:forEach>
                    </c:when>
                    <c:when test="${sectionType.equals(SectionType.QUALIFICATIONS)}">
                        <c:forEach var="line"
                                   items="<%=((TextListSection) resume.getSection(SectionType.QUALIFICATIONS)).getLines()%>">
                            <dd><label>
                                <textarea rows="2" cols="220" name="${sectionType.name()}">${line}</textarea>
                            </label></dd>
                            <br>
                        </c:forEach>
                    </c:when>
                    <c:when test="${sectionType.equals(SectionType.EXPERIENCE)}">
                        <label>
                            <input type="text" size=50 name="${sectionType.name()}" value="${sectionType.name()}"
                                   hidden>
                        </label>
                        <c:forEach var="organisation"
                                   items="<%=((OrganizationSection) resume.getSection(SectionType.EXPERIENCE)).getOrganizations()%>">
                            <label>Наименование организации
                                <input type="text" size=50 name="${sectionType.name()}name"
                                       value="${organisation.name}">
                            </label>
                            <br>
                            <label>Ссылка на организацию
                                <input type="text" size=50 name="${sectionType.name()}url" value="${organisation.url}">
                            </label>
                            <br>
                            <c:forEach var="position"
                                       items="${organisation.positions}">
                                <table>
                                    <tr>
                                        <td>
                                            <label>Дата начала
                                                <input type="date" size=30
                                                       name="${sectionType.name()}${organisation.name}datestart"
                                                       value="${position.dateStart}">
                                            </label>
                                            <br>
                                            <label>Дата окончания
                                                <input type="date" size=30
                                                       name="${sectionType.name()}${organisation.name}dateend"
                                                       value="${position.dateEnd}">
                                            </label>
                                        </td>
                                        <td>
                                            <label>Наименование
                                                <input type="text" size=198
                                                       name="${sectionType.name()}${organisation.name}title"
                                                       value="${position.title}">
                                            </label>
                                            <br>
                                            <label>Описание
                                                <textarea rows="2" cols="200"
                                                          name="${sectionType.name()}${organisation.name}text">${position.text}</textarea>
                                            </label>
                                        </td>
                                    </tr>
                                </table>
                            </c:forEach>
                        </c:forEach>
                    </c:when>
                    <c:when test="${sectionType.equals(SectionType.EDUCATION)}">
                        <c:forEach var="organisation"
                                   items="<%=((OrganizationSection) resume.getSection(SectionType.EDUCATION)).getOrganizations()%>">
                            <label>
                                <input type="text" size=50 name="${sectionType.name()}" value="${sectionType.name()}"
                                       hidden>
                            </label>
                            <label>Наименование организации
                                <input type="text" size=50 name="${sectionType.name()}name"
                                       value="${fn:escapeXml(organisation.name)}">
                            </label>
                            <br>
                            <label>Ссылка на организацию
                                <input type="text" size=50 name="${sectionType.name()}url" value="${organisation.url}">
                            </label>
                            <br>
                            <c:forEach var="position"
                                       items="${organisation.positions}">
                                <table>
                                    <tr>
                                        <td>
                                            <label>Дата начала
                                                <input type="date" size=30
                                                       name="${sectionType.name()}${organisation.name}datestart"
                                                       value="${position.dateStart}">
                                            </label>
                                            <br>
                                            <label>Дата окончания
                                                <input type="date" size=30
                                                       name="${sectionType.name()}${organisation.name}dateend"
                                                       value="${position.dateEnd}">
                                            </label>
                                        </td>
                                        <td>
                                            <label>Наименование
                                                <input type="text" size=198
                                                       name="${sectionType.name()}${organisation.name}title"
                                                       value="${fn:escapeXml(position.title)}">
                                            </label>
                                            <br>
                                            <label>Описание
                                                <textarea rows="2" cols="200"
                                                          name="${sectionType.name()}${organisation.name}text">${fn:escapeXml(position.text)}</textarea>
                                            </label>
                                        </td>
                                    </tr>
                                </table>
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

