package basejava.web;

import basejava.ResumeTestData;
import basejava.model.*;
import basejava.util.DateUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().write("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + request.getContextPath() + "/css/style.css\"/>");
        Resume resume = ResumeTestData.getTestData("uuid1", "Иванов Иван Иванович");
        response.getWriter().write("<table id=\"resumeTable\"");
        response.getWriter().write("<tr><td><br><h2>"
                + resume.getUuid()
                + "</h2></td></tr>");
        response.getWriter().write("<tr><td><br><h2>"
                + resume.getFullName()
                + "</h2></td></tr>");
        for (Map.Entry<ContactType, String> e : resume.getContactsMap().entrySet()) {
            response.getWriter().write("<tr><td>"
                    + e.getKey().getTitle()
                    + ": <a href=\""
                    + e.getValue()
                    + "\">"
                    + e.getValue()
                    + "<a></td></tr>");
        }
        for (Map.Entry<SectionType, AbstractSection> e : resume.getSectionsMap().entrySet()) {
            SectionType sectionType = e.getKey();
            AbstractSection abstractSection = e.getValue();
            response.getWriter().write("<tr><td><br><h2>"
                    + sectionType.getTitle()
                    + "</h2></td></tr>");
            switch (sectionType) {
                case OBJECTIVE:
                case PERSONAL:
                    response.getWriter().write("<tr><td>" + abstractSection + "</td></tr>");
                    break;
                case ACHIEVEMENT:
                case QUALIFICATIONS:
                    for (String line : ((TextListSection) abstractSection).getLines()) {
                        response.getWriter().write("<tr><td>"
                                + line
                                + "</td></tr>");
                    }
                    break;
                case EXPERIENCE:
                case EDUCATION:
                    for (Organization organization : ((OrganizationSection) abstractSection).getOrganizations()) {
                        response.getWriter().write("<tr><td><a href=\""
                                + organization.getUrl()
                                + "\">"
                                + organization.getName()
                                + "<a></td><tr>");
                        response.getWriter().write("<tr><td><table>");
                        for (Position position : organization.getPositions()) {
                            response.getWriter().write("<tr><td>"
                                    + DateUtil.formatDate(position.getDateStart())
                                    + "-"
                                    + DateUtil.formatDate(position.getDateEnd())
                                    + "</td><td><table><tr><td><b>"
                                    + position.getTitle()
                                    + "</b></td></tr><tr><td"
                                    + position.getText()
                                    + "</td></tr></table></td></tr>");
                        }
                        response.getWriter().write("</td></tr></table>");
                    }
            }
        }
    }
}
