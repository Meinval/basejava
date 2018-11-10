import model.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");

        LinkedHashMap<ContactType, AbstractSection> contactsMap = new LinkedHashMap<>();
        contactsMap.put(ContactType.PHONE, new TextSection("+7(921) 855-0482"));
        contactsMap.put(ContactType.SKYPE, new TextSection("grigory.kislin"));
        contactsMap.put(ContactType.EMAIL, new TextSection("gkislin@yandex.ru"));
        contactsMap.put(ContactType.LINKEDIN, new TextSection("https://www.linkedin.com/in/gkislin"));
        contactsMap.put(ContactType.GITHUB, new TextSection("https://github.com/gkislin"));
        contactsMap.put(ContactType.STACKOVERFLOW, new TextSection("https://stackoverflow.com/users/548473"));
        contactsMap.put(ContactType.HOMEPAGE, new TextSection("http://gkislin.ru/"));
        resume.setContactsMap(contactsMap);

        LinkedHashMap<SectionType, AbstractSection> sectionsMap = new LinkedHashMap<>();
        sectionsMap.put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        sectionsMap.put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));

        ArrayList<RowText> achievements = new ArrayList<>();
        achievements.add(new RowText("● С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"" +
                "Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников."));
        achievements.add(new RowText("● Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk."));
        achievements.add(new RowText("● Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
                "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
                "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера."));
        achievements.add(new RowText("● Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, " +
                "GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга."));
        achievements.add(new RowText("● Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). " +
                "Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. " +
                "Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django)."));
        achievements.add(new RowText("● Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), " +
                "Белоруcсии(Erip, Osmp) и Никарагуа."));
        sectionsMap.put(SectionType.ACHIEVEMENT, new TableListSection(achievements));

        ArrayList<RowText> qualifications = new ArrayList<>();
        qualifications.add(new RowText("● JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2"));
        qualifications.add(new RowText("● Version control: Subversion, Git, Mercury, ClearCase, Perforce"));
        qualifications.add(new RowText("● DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,"));
        qualifications.add(new RowText("● MySQL, SQLite, MS SQL, HSQLDB"));
        qualifications.add(new RowText("● Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,"));
        qualifications.add(new RowText("● XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,"));
        qualifications.add(new RowText("● Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), " +
                "JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements)."));
        qualifications.add(new RowText("● Python: Django."));
        qualifications.add(new RowText("● JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js"));
        qualifications.add(new RowText("● Scala: SBT, Play2, Specs2, Anorm, Spray, Akka"));
        qualifications.add(new RowText("● Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, " +
                "MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT."));
        qualifications.add(new RowText("● Инструменты: Maven + plugin development, Gradle, настройка Ngnix,"));
        qualifications.add(new RowText("● администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer."));
        qualifications.add(new RowText("● Отличное знание и опыт применения концепций ООП, SOA, шаблонов"));
        qualifications.add(new RowText("● проектрирования, архитектурных шаблонов, UML, функционального"));
        qualifications.add(new RowText("● программирования"));
        qualifications.add(new RowText("● Родной русский, английский \"upper intermediate\""));
        sectionsMap.put(SectionType.QUALIFICATIONS, new TableListSection(qualifications));

        ArrayList<RowText> experiences = new ArrayList<>();
        experiences.add(new RowText("Java Online Projects", "10/2013", "Сейчас", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        experiences.add(new RowText("Wrike",
                "10/2014",
                "01/2016",
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, " +
                        "PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        experiences.add(new RowText("RIT Center",
                "04/2012",
                "10/2014",
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, " +
                        "ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), " +
                        "AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, " +
                        "1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. " +
                        "Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, " +
                        "Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
        experiences.add(new RowText("Luxoft (Deutsche Bank)",
                "12/2010",
                "04/2012",
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). " +
                        "Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. " +
                        "JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."));
        experiences.add(new RowText("Yota",
                "06/2008",
                "12/2010",
                "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                        "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));
        experiences.add(new RowText("Enkata",
                "03/2007",
                "06/2008",
                "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));
        experiences.add(new RowText("Siemens AG",
                "01/2005",
                "02/2007",
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));
        experiences.add(new RowText("Alcatel",
                "09/1997",
                "01/2005",
                "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));
        sectionsMap.put(SectionType.EXPERIENCE, new TableListSection(experiences));
        ArrayList<RowText> educations = new ArrayList<>();
        educations.add(new RowText("Coursera",
                "03/2013",
                "05/2013",
                "\"Functional Programming Principles in Scala\" by Martin Odersky"));
        educations.add(new RowText("Luxoft",
                "03/2011",
                "04/2011",
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\""));
        educations.add(new RowText("Siemens AG",
                "01/2005",
                "04/2005",
                "3 месяца обучения мобильным IN сетям (Берлин)"));
        educations.add(new RowText("Alcatel",
                "09/1997",
                "03/1998",
                "6 месяцев обучения цифровым телефонным сетям (Москва)"));
        educations.add(new RowText("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "09/1993",
                "07/1996",
                "Аспирантура (программист С, С++)"));
        educations.add(new RowText(null,
                "09/1987",
                "07/1993",
                "Инженер (программист Fortran, C)"));
        educations.add(new RowText("Заочная физико-техническая школа при МФТИ",
                "09/1984",
                "06/1987",
                "Закончил с отличием"));
        sectionsMap.put(SectionType.EDUCATION, new TableListSection(educations));
        resume.setSectionsMap(sectionsMap);
        printResume(resume);
    }

    private static void printResume(Resume resume) {
        System.out.println(resume.getFullName());
        for (Object o : resume.getContactsMap().entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            System.out.print(((ContactType) entry.getKey()).getTitle() + ": ");
            ((AbstractSection) entry.getValue()).print();
        }
        for (Object o : resume.getSectionsMap().entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(((SectionType) entry.getKey()).getTitle());
            ((AbstractSection) entry.getValue()).print();
        }
    }
}