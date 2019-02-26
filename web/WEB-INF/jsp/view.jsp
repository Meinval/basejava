<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="basejava.model.OrganizationSection" %>
<%@ page import="basejava.model.SectionType" %>
<%@ page import="basejava.model.TextListSection" %>
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
    <h2>${resume.fullName}&nbsp;<a href="resume?uuid=${resume.uuid}&action=edit"><img src="img/pencil.png" alt=""></a>
    </h2>
    <p>
        <c:forEach var="contactEntry" items="${resume.contactsMap}">
            <jsp:useBean id="contactEntry"
                         type="java.util.Map.Entry<basejava.model.ContactType, java.lang.String>"/>
                <%=contactEntry.getKey().toHtml(contactEntry.getValue())%><br/>
        </c:forEach>
    <p>
    <hr>
    <c:forEach var="sectionType" items="<%=SectionType.values()%>">
        <h2>${sectionType.title}</h2>
        <br>
        <c:choose>
            <c:when test="${sectionType.equals(SectionType.PERSONAL)}">
                <label>${resume.getSection(sectionType)}</label>
                <br>
            </c:when>
            <c:when test="${sectionType.equals(SectionType.OBJECTIVE)}">
                <label>${resume.getSection(sectionType)}</label>
                <br>
            </c:when>
            <c:when test="${sectionType.equals(SectionType.ACHIEVEMENT)}">
                <ul>
                    <c:forEach var="line"
                               items="<%=((TextListSection) resume.getSection(SectionType.ACHIEVEMENT)).getLines()%>">
                        <li>${line}</li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:when test="${sectionType.equals(SectionType.QUALIFICATIONS)}">
                <ul>
                    <c:forEach var="line"
                               items="<%=((TextListSection) resume.getSection(SectionType.QUALIFICATIONS)).getLines()%>">
                        <li>${line}</li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:when test="${sectionType.equals(SectionType.EXPERIENCE)}">
                <c:forEach var="organisation"
                           items="<%=((OrganizationSection) resume.getSection(SectionType.EXPERIENCE)).getOrganizations()%>">
                    <p><a href="${organisation.url}">${organisation.name}</a></p>
                    <c:forEach var="position"
                               items="${organisation.positions}">
                        <table>
                            <tr>
                                <td width="200" valign="top">
                                    <fmt:parseDate value="${position.dateStart}" pattern="yyyy-MM-dd"
                                                   var="parsedDateStart" type="date"/>
                                    <fmt:formatDate value="${parsedDateStart}" var="dateStart" type="date"
                                                    pattern="MM/yyyy"/>
                                        ${dateStart} -

                                    <fmt:parseDate value="${position.dateEnd}" pattern="yyyy-MM-dd" var="parsedDateEnd"
                                                   type="date"/>
                                    <fmt:formatDate value="${parsedDateEnd}" var="dateEnd" type="date"
                                                    pattern="MM/yyyy"/>

                                    <fmt:formatDate var="date_to_comare" value="${parsedDateEnd}"
                                                    pattern="yyyy-MM-dd HH:mm:ss"/>
                                    <c:set var="today_date" value="<%=new java.util.Date()%>"/>
                                    <fmt:formatDate var="today_formated_date" value="${today_date}"
                                                    pattern="yyyy-MM-dd HH:mm:ss"/>
                                    <c:if test="${date_to_comare gt today_formated_date}">
                                        Сейчас
                                    </c:if>
                                    <c:if test="${date_to_comare le today_formated_date}">
                                        ${dateEnd}
                                    </c:if>
                                </td>
                                <td>
                                    <b>${position.title}</b>
                                    <br>
                                        ${position.text}
                                </td>
                            </tr>
                        </table>
                    </c:forEach>
                </c:forEach>
            </c:when>
            <c:when test="${sectionType.equals(SectionType.EDUCATION)}">
                <c:forEach var="organisation"
                           items="<%=((OrganizationSection) resume.getSection(SectionType.EDUCATION)).getOrganizations()%>">
                    <p><a href="${organisation.url}">${organisation.name}</a></p>
                    <c:forEach var="position"
                               items="${organisation.positions}">
                        <table>
                            <tr>
                                <td width="200" valign="top">
                                    <fmt:parseDate value="${position.dateStart}" pattern="yyyy-MM-dd"
                                                   var="parsedDateStart" type="date"/>
                                    <fmt:formatDate value="${parsedDateStart}" var="dateStart" type="date"
                                                    pattern="MM/yyyy"/>
                                        ${dateStart} -

                                    <fmt:parseDate value="${position.dateEnd}" pattern="yyyy-MM-dd" var="parsedDateEnd"
                                                   type="date"/>
                                    <fmt:formatDate value="${parsedDateEnd}" var="dateEnd" type="date"
                                                    pattern="MM/yyyy"/>

                                    <fmt:formatDate var="date_to_comare" value="${parsedDateEnd}"
                                                    pattern="yyyy-MM-dd HH:mm:ss"/>
                                    <c:set var="today_date" value="<%=new java.util.Date()%>"/>
                                    <fmt:formatDate var="today_formated_date" value="${today_date}"
                                                    pattern="yyyy-MM-dd HH:mm:ss"/>
                                    <c:if test="${date_to_comare gt today_formated_date}">
                                        Сейчас
                                    </c:if>
                                    <c:if test="${date_to_comare le today_formated_date}">
                                        ${dateEnd}
                                    </c:if>
                                </td>
                                <td>
                                    <b>${position.title}</b>
                                    <br>
                                        ${position.text}
                                </td>
                            </tr>
                        </table>
                    </c:forEach>
                </c:forEach>
            </c:when>
        </c:choose>
    </c:forEach>

</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

