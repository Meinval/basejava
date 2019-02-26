package basejava.web;

import basejava.Config;
import basejava.ResumeTestData;
import basejava.exception.NotExistStorageException;
import basejava.model.*;
import basejava.storage.Storage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResumeServlet extends HttpServlet {

    private Storage storage; // = Config.get().getStorage();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = Config.get().getStorage();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String uuid = request.getParameter("uuid");
        String fullName = request.getParameter("fullName");
        Resume r;
        boolean isNew = false;
        try {
            r = storage.get(uuid);
        } catch (NotExistStorageException e) {
            r = new Resume(uuid);
            isNew = true;
        }
        r.setFullName(fullName);
        for (ContactType type : ContactType.values()) {
            String value = request.getParameter(type.name());
            if (value != null && value.trim().length() != 0) {
                r.addContact(type, value);
            } else {
                r.getContactsMap().remove(type);
            }
        }
        for (SectionType sectionType : SectionType.values()) {
            String value = request.getParameter(sectionType.name());
            String[] values = request.getParameterValues(sectionType.name());
            if (value != null && value.trim().length() != 0) {
                switch (sectionType) {
                    case PERSONAL:
                    case OBJECTIVE:
                        r.addSection(sectionType, new TextSection(value));
                        break;
                    case QUALIFICATIONS:
                    case ACHIEVEMENT:
                        r.addSection(sectionType, new TextListSection(Arrays.asList(values)));
                        break;
                    case EDUCATION:
                    case EXPERIENCE:
                        List<Organization> organizations = new ArrayList<>();
                        String[] organisations = request.getParameterValues(sectionType.name() + "name");
                        String[] urls = request.getParameterValues(sectionType.name() + "url");
                        for (int i = 0; i < organisations.length; i++) {
                            Organization organization = new Organization(organisations[i], urls[i]);
                            String[] datesStart = request.getParameterValues(sectionType.name() + organisations[i] + "datestart");
                            String[] datesEnd = request.getParameterValues(sectionType.name() + organisations[i] + "dateend");
                            String[] titles = request.getParameterValues(sectionType.name() + organisations[i] + "title");
                            String[] texts = request.getParameterValues(sectionType.name() + organisations[i] + "text");
                            List<Position> positions = new ArrayList<>();
                            for (int x = 0; x < titles.length; x++) {
                                Position position = new Position(LocalDate.parse(datesStart[x]), LocalDate.parse(datesEnd[x]), titles[x], texts[x]);
                                positions.add(position);
                            }
                            organization.setPositions(positions);
                            organizations.add(organization);
                        }
                        r.addSection(sectionType, new OrganizationSection(organizations));
                        break;
                }
            } else {
                r.getSectionsMap().remove(sectionType);
            }
        }
        if (isNew) {
            storage.save(r);
        } else {
            storage.update(r);
        }
        response.sendRedirect("resume");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String uuid = request.getParameter("uuid");
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("resumes", storage.getAllSorted());
            request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
            return;
        }
        Resume r;
        switch (action) {
            case "delete":
                storage.delete(uuid);
                response.sendRedirect("resume");
                return;
            case "view":
            case "edit":
                if (uuid.equals("null")) {
                    r = ResumeTestData.getTestData(String.valueOf(Config.get().getStorage().size()), "Иванов Иван Иванович");
                } else {
                    r = storage.get(uuid);
                }
                break;
            default:
                throw new IllegalArgumentException("Action " + action + " is illegal");
        }
        request.setAttribute("resume", r);
        request.getRequestDispatcher(
                ("view".equals(action) ? "/WEB-INF/jsp/view.jsp" : "/WEB-INF/jsp/edit.jsp")
        ).forward(request, response);
    }
}
