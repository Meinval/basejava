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

    <script language="javascript">
        function addOrganization(type) {
            var parentElementId = type.getAttribute("id");
            var organizationCounter = document.getElementById(parentElementId + "organizationCounter").value;
            var newId = parentElementId + organizationCounter;
            var tbl = document.createElement('table');
            tbl.setAttribute("id", newId + "table");
            tbl.setAttribute("class", "organization-table organization-table-new");
            var tr = document.createElement('tr');
            var th1 = document.createElement('th');
            var td1 = document.createElement('td');
            var tr2 = document.createElement('tr');
            var th2 = document.createElement('th');
            th2.setAttribute("rowspan", "2");
            var tr3 = document.createElement('tr');
            var td2 = document.createElement('td');
            td2.setAttribute("colspan", "2");

            var posCountInput = document.createElement("input");
            posCountInput.setAttribute("type", "text");
            posCountInput.setAttribute("id", newId + "posCounter");
            posCountInput.setAttribute("name", newId + "name");
            posCountInput.setAttribute("value", "0");
            posCountInput.hidden = true;

            var label1 = document.createElement('label');
            label1.innerHTML = "Наименование организации";
            var nameInput = document.createElement("input");
            nameInput.setAttribute("type", "text");
            nameInput.setAttribute("size", "110");
            nameInput.setAttribute("id", newId + "name");
            nameInput.setAttribute("name", parentElementId + "name");
            nameInput.required = true;

            var delOrganization = document.createElement("a");
            delOrganization.setAttribute("href", "javascript:deleteOrganization(" + newId + ")");
            delOrganization.setAttribute("id", newId + "delButton");

            var delImage = document.createElement("img");
            delImage.setAttribute("src", "img/delete.png");
            delImage.setAttribute("alt", "delOrganization");
            delImage.setAttribute("title", "Удалить организацию");

            var label2 = document.createElement('label');
            label2.innerHTML = "Страница сайта организации";
            var urlInput = document.createElement("input");
            urlInput.setAttribute("type", "text");
            urlInput.setAttribute("size", "110");
            urlInput.setAttribute("name", parentElementId + "url");
            urlInput.setAttribute("id", newId + "url");

            var addPosition = document.createElement("a");
            addPosition.setAttribute("href", "javascript:addPosition(" + newId + ")");
            addPosition.setAttribute("id", newId + "addButton");

            var addImage = document.createElement("img");
            addImage.setAttribute("src", "img/add.png");
            addImage.setAttribute("alt", "addPosition");
            addImage.setAttribute("title", "Добавить новую позицию");

            var span = document.createElement("span");
            span.setAttribute("id", newId);
            span.innerHTML = "&nbsp;";

            label1.appendChild(nameInput);
            th1.append(posCountInput, label1);
            delOrganization.appendChild(delImage);
            th2.appendChild(delOrganization);
            tr.append(th1, th2);
            label2.appendChild(urlInput);
            tr2.appendChild(label2);
            addPosition.appendChild(addImage);
            td1.appendChild(addPosition);
            tr3.appendChild(td1);

            tbl.append(tr, tr2, tr3, span);
            document.getElementById(parentElementId).appendChild(tbl);
            organizationCounter++;
            document.getElementById(parentElementId + "organizationCounter").setAttribute("value", organizationCounter);
        }

        function addPosition(type) {
            var parentElementId = type.getAttribute("id");
            var positionCounter = document.getElementById(parentElementId + "posCounter").value;
            var trMain = document.createElement('tr');
            var tdMain = document.createElement('td');
            tdMain.setAttribute("id", parentElementId + "pos" + positionCounter + "table");
            tdMain.setAttribute("colspan", "2");

            var tbl = document.createElement('table');
            tbl.setAttribute("class", "position-table position-table-new");
            var tr = document.createElement('tr');
            var td1 = document.createElement('td');

            var label1 = document.createElement('label');
            label1.innerHTML = "Дата начала";
            var dateStartInput = document.createElement("input");
            dateStartInput.setAttribute("type", "date");
            dateStartInput.setAttribute("size", "25");
            dateStartInput.setAttribute("name", parentElementId + "datestart");
            dateStartInput.setAttribute("min", "1900-01-01");
            dateStartInput.setAttribute("max", "2100-01-01");
            dateStartInput.required = true;

            var label2 = document.createElement('label');
            label2.innerHTML = "Дата окончания";
            var dateEndInput = document.createElement("input");
            dateEndInput.setAttribute("type", "date");
            dateEndInput.setAttribute("size", "25");
            dateEndInput.setAttribute("name", parentElementId + "dateend");
            dateEndInput.setAttribute("min", "1900-01-01");
            dateEndInput.setAttribute("max", "2100-01-01");
            dateEndInput.required = true;

            var label3 = document.createElement('label');
            label3.innerHTML = "Наименование";
            var titleInput = document.createElement("input");
            titleInput.setAttribute("type", "text");
            titleInput.setAttribute("size", "50");
            titleInput.setAttribute("name", parentElementId + "title");
            titleInput.required = true;

            label1.appendChild(dateStartInput);
            label2.appendChild(dateEndInput);
            label3.appendChild(titleInput);
            td1.appendChild(label1);
            td1.appendChild(label2);
            td1.appendChild(label3);

            var td2 = document.createElement('td');

            var delButton = document.createElement("a");
            delButton.setAttribute("href", "javascript:deleteAllSubElements(" + parentElementId + "pos" + positionCounter + ")");

            var delImage = document.createElement("img");
            delImage.setAttribute("src", "img/delete.png");
            delImage.setAttribute("alt", "delPosition");
            delImage.setAttribute("title", "Удалить позицию");

            delButton.appendChild(delImage);
            td2.appendChild(delButton);

            tr.appendChild(td1);
            tr.appendChild(td2);

            var tr2 = document.createElement('tr');
            var td3 = document.createElement('td');

            var label4 = document.createElement('label');
            label4.innerHTML = "Описание";
            var textArea = document.createElement("textarea");
            textArea.setAttribute("rows", "3");
            textArea.setAttribute("cols", "138");
            textArea.setAttribute("name", parentElementId + "text");

            label4.appendChild(textArea);
            td3.appendChild(label4);
            tr2.appendChild(td3);

            var span = document.createElement("span");
            span.setAttribute("id", parentElementId + "pos" + positionCounter);
            span.innerHTML = "&nbsp;";

            tbl.append(tr, tr2, span);
            tdMain.appendChild(tbl);
            trMain.appendChild(tdMain);
            document.getElementById(parentElementId).appendChild(trMain);
            positionCounter++;
            document.getElementById(parentElementId + "posCounter").setAttribute("value", positionCounter);
        }

        function deleteOrganization(type) {
            deleteAllSubElements(type);
            type.parentNode.removeChild(type);
        }

        function deleteAllSubElements(type) {
            var parentElementId = type.getAttribute("id");
            var parentElement = document.getElementById(parentElementId + "table");
            while (parentElement.firstChild) {
                parentElement.removeChild(parentElement.firstChild);
            }
            parentElement.parentNode.removeChild(parentElement)
        }
    </script>
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<section>
    <form method="post" action="resume" enctype="application/x-www-form-urlencoded">
        <table>
            <tr>
                <td class="menu">
                    <button type="submit">Сохранить</button>
                    <button onclick="window.history.back()">Отменить</button>
                </td>
                l
                <td class="main-td">
                    <div class="main-div">
                        <input type="hidden" name="uuid" value="${resume.uuid}">
                        <table class="section-table">
                            <tr>
                                <td class="td-ordered">Имя:</td>
                                <td><label>
                                    <input type="text" name="fullName" size=132 value="${resume.fullName}">
                                </label>
                                </td>
                            </tr>
                        </table>
                        <h2>Контакты:</h2>
                        <table class="section-table">
                            <c:forEach var="type" items="<%=ContactType.values()%>">
                                <tr>
                                    <td class="td-ordered"><label>${type.title}</label>
                                    </td>
                                    <td>
                                        <label><input type="text" name="${type.name()}" size=132
                                                      value="${resume.getContact(type)}">
                                        </label>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <h2>Секции:</h2>
                        <c:forEach var="sectionType" items="<%=SectionType.values()%>">
                            <%
                                SectionType section = (SectionType) pageContext.getAttribute("sectionType");
                            %>
                            <c:choose>
                                <c:when test="${(sectionType.equals(SectionType.PERSONAL)) or (sectionType.equals(SectionType.OBJECTIVE))}">
                                    <table class="section-table">
                                        <tr>
                                            <td>
                                                <h3>${sectionType.title}</h3>
                                                <label>
<textarea rows="3" cols="160"
          name="${sectionType.name()}">${resume.getSection(sectionType)}</textarea>
                                                </label>
                                            </td>
                                        </tr>
                                    </table>
                                </c:when>
                                <c:when test="${(sectionType.equals(SectionType.ACHIEVEMENT)) or (sectionType.equals(SectionType.QUALIFICATIONS))}">
                                    <table class="section-table">
                                        <tr>
                                            <td>
                                                <h4>${sectionType.title}</h4>
                                                <label>
<textarea rows="5" cols="160"
          name="${sectionType.name()}"><%=String.join("\n", (((TextListSection) resume.getSection(section)).getLines()))%></textarea>
                                                </label>
                                            </td>
                                        </tr>
                                    </table>
                                </c:when>
                                <c:when test="${(sectionType.equals(SectionType.EXPERIENCE)) or (sectionType.equals(SectionType.EDUCATION))}">
                                    <table class="section-table">
                                        <tr>
                                            <td>
                                                <label><input type="text" id="${sectionType.name()}organizationCounter"
                                                              value="<%=((OrganizationSection) resume.getSection(section)).getOrganizations().size()%>"
                                                              hidden><label>
                                                    <label>
                                                        <input type="text" size=50 name="${sectionType.name()}"
                                                               value="${sectionType.name()}"
                                                               hidden>
                                                    </label>
                                                    <h2>${sectionType.title}</h2>
                                                    <a
                                                            href="javascript:addOrganization(${sectionType.name()})"><img
                                                            src="img/add.png"
                                                            alt="addPosition"
                                                            title="Добавить новую организацию в ${sectionType.name()}"></a>
                                                    <c:forEach var="organisation"
                                                               items="<%=((OrganizationSection) resume.getSection(section)).getOrganizations()%>"
                                                               varStatus="orgCounter">
                                                    <table id="${sectionType.name()}${orgCounter.index}table"
                                                           class="organization-table">
                                                        <tr>
                                                            <th><label><input type="text"
                                                                              id="${sectionType.name()}${orgCounter.index}posCounter"
                                                                              value="${organisation.positions.size()}"
                                                                              hidden></label>
                                                                <label>Наименование организации
                                                                    <input type="text"
                                                                           id="${sectionType.name()}${orgCounter.index}name"
                                                                           required
                                                                           size=110
                                                                           name="${sectionType.name()}name"
                                                                           value="${organisation.name}">
                                                                </label></th>
                                                            <th rowspan="2"><a
                                                                    href="javascript:deleteOrganization(${sectionType.name()}${orgCounter.index})"
                                                                    id="${sectionType.name()}${orgCounter.index}delButton"><img
                                                                    src="img/delete.png"
                                                                    alt="delOrganization"
                                                                    title="Удалить организацию ${organisation.name}"></a>
                                                            </th>
                                                        </tr>
                                                        <tr>
                                                            <td><label>Страница сайта организации<input type="text"
                                                                                                        id="${sectionType.name()}${orgCounter.index}url"
                                                                                                        size=110
                                                                                                        name="${sectionType.name()}url"
                                                                                                        value="${organisation.url}">
                                                            </label></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="2"><a
                                                                    href="javascript:addPosition(${sectionType.name()}${orgCounter.index})"
                                                                    id="${sectionType.name()}${orgCounter.index}addButton"><img
                                                                    src="img/add.png"
                                                                    alt="addPosition"
                                                                    title="Добавить новую позицию в ${organisation.name}"></a>
                                                            </td>
                                                        </tr>
                                                        <c:forEach var="position"
                                                                   items="${organisation.positions}"
                                                                   varStatus="posCounter">
                                                            <tr id="${sectionType.name()}${orgCounter.index}pos${posCounter.index}table">
                                                                <td colspan="2">
                                                                    <table class="position-table">
                                                                        <tr>
                                                                            <td>
                                                                                <label>Дата начала
                                                                                    <input type="date"
                                                                                           size=25
                                                                                           min="1900-01-01"
                                                                                           max="2100-01-01"
                                                                                           required
                                                                                           name="${sectionType.name()}${orgCounter.index}datestart"
                                                                                           value="${position.dateStart}">
                                                                                </label>
                                                                                <label>Дата окончания
                                                                                    <input type="date"
                                                                                           size=25
                                                                                           min="1900-01-01"
                                                                                           max="2100-01-01"
                                                                                           required
                                                                                           name="${sectionType.name()}${orgCounter.index}dateend"
                                                                                           value="${position.dateEnd}">
                                                                                </label>
                                                                                <label>Наименование
                                                                                    <input type="text"
                                                                                           size=50
                                                                                           required
                                                                                           name="${sectionType.name()}${orgCounter.index}title"
                                                                                           value="${position.title}">
                                                                                </label>
                                                                            </td>
                                                                            <td>
                                                                                <a href="javascript:deleteAllSubElements(${sectionType.name()}${orgCounter.index}pos${posCounter.index})"><img
                                                                                        src="img/delete.png"
                                                                                        alt="delPosition"
                                                                                        title="Удалить позицию ${position.title}"></a>
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>
                                                                                <label>Описание
                                                                                    <textarea rows="3" cols="138"
                                                                                              name="${sectionType.name()}${orgCounter.index}text">${position.text}</textarea>
                                                                                </label>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <span id="${sectionType.name()}${orgCounter.index}pos${posCounter.index}">&nbsp;</span>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        <tr>
                                                            <td>
                                                                <span id="${sectionType.name()}${orgCounter.index}">&nbsp;</span>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                    </c:forEach>
                                                    <span id="${sectionType.name()}">&nbsp;</span>
                                            </td>
                                        </tr>
                                    </table>
                                </c:when>
                            </c:choose>
                        </c:forEach>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

