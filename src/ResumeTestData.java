

import model.*;

import java.util.ArrayList;
import java.util.Objects;

public class ResumeTestData {
    private static final String MARK = "● ";

    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        ContractInfo contractInfo = new ContractInfo("+7(921) 855-0482",
                "grigory.kislin",
                "gkislin@yandex.ru",
                "https://www.linkedin.com/in/gkislin",
                "https://github.com/gkislin",
                "https://stackoverflow.com/users/548473",
                "http://gkislin.ru/");
        resume.setContactInfoSection(contractInfo);
        resume.setObjectiveSection(new TextSection(SectionType.OBJECTIVE, "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.setPersonalSection(new TextSection(SectionType.PERSONAL, "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        ArrayList<ResumeRow> achievements = new ArrayList<>();
        achievements.add(new ResumeRow("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"" +
                "Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.", true));
        achievements.add(new ResumeRow("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.", true));
        achievements.add(new ResumeRow("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
                "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
                "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.", true));
        achievements.add(new ResumeRow("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, " +
                "GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.", true));
        achievements.add(new ResumeRow("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). " +
                "Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. " +
                "Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).", true));
        achievements.add(new ResumeRow("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), " +
                "Белоруcсии(Erip, Osmp) и Никарагуа.", true));
        resume.setAchievementSection(new TextListSection(SectionType.ACHIEVEMENT, achievements));
        ArrayList<ResumeRow> qualifications = new ArrayList<>();
        qualifications.add(new ResumeRow("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2", true));
        qualifications.add(new ResumeRow("Version control: Subversion, Git, Mercury, ClearCase, Perforce", true));
        qualifications.add(new ResumeRow("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,", true));
        qualifications.add(new ResumeRow("MySQL, SQLite, MS SQL, HSQLDB", true));
        qualifications.add(new ResumeRow("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,", true));
        qualifications.add(new ResumeRow("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,", true));
        qualifications.add(new ResumeRow("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), " +
                "JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).", true));
        qualifications.add(new ResumeRow("Python: Django.", true));
        qualifications.add(new ResumeRow("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js", true));
        qualifications.add(new ResumeRow("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka", true));
        qualifications.add(new ResumeRow("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, " +
                "MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.", true));
        qualifications.add(new ResumeRow("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,", true));
        qualifications.add(new ResumeRow("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.", true));
        qualifications.add(new ResumeRow("Отличное знание и опыт применения концепций ООП, SOA, шаблонов", true));
        qualifications.add(new ResumeRow("проектрирования, архитектурных шаблонов, UML, функционального", true));
        qualifications.add(new ResumeRow("программирования", true));
        qualifications.add(new ResumeRow("Родной русский, английский \"upper intermediate\"", true));
        resume.setQualificationsSection(new TextListSection(SectionType.QUALIFICATIONS, qualifications));
        ArrayList<ResumeRow> experiences = new ArrayList<>();
        experiences.add(new ResumeRow("Java Online Projects", "10/2013", "Сейчас", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.", false));
        experiences.add(new ResumeRow("Wrike",
                "10/2014",
                "01/2016",
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                false));
        experiences.add(new ResumeRow("RIT Center",
                "04/2012",
                "10/2014",
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python",
                false));
        experiences.add(new ResumeRow("Luxoft (Deutsche Bank)",
                "12/2010",
                "04/2012",
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.",
                false));
        experiences.add(new ResumeRow("Yota",
                "06/2008",
                "12/2010",
                "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)",
                false));
        experiences.add(new ResumeRow("Enkata",
                "03/2007",
                "06/2008",
                "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).",
                false));
        experiences.add(new ResumeRow("Siemens AG",
                "01/2005",
                "02/2007",
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).",
                false));
        experiences.add(new ResumeRow("Alcatel",
                "09/1997",
                "01/2005",
                "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).",
                false));
        resume.setExperienceSection(new TextListSection(SectionType.EXPERIENCE, experiences));
        ArrayList<ResumeRow> educations = new ArrayList<>();
        educations.add(new ResumeRow("Coursera",
                "03/2013",
                "05/2013",
                "\"Functional Programming Principles in Scala\" by Martin Odersky",
                false));
        educations.add(new ResumeRow("Luxoft",
                "03/2011",
                "04/2011",
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                false));
        educations.add(new ResumeRow("Siemens AG",
                "01/2005",
                "04/2005",
                "3 месяца обучения мобильным IN сетям (Берлин)",
                false));
        educations.add(new ResumeRow("Alcatel",
                "09/1997",
                "03/1998",
                "6 месяцев обучения цифровым телефонным сетям (Москва)",
                false));
        educations.add(new ResumeRow("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "09/1993",
                "07/1996",
                "Аспирантура (программист С, С++)",
                false));
        educations.add(new ResumeRow(null,
                "09/1987",
                "07/1993",
                "Инженер (программист Fortran, C)",
                false));
        educations.add(new ResumeRow("Заочная физико-техническая школа при МФТИ",
                "09/1984",
                "06/1987",
                "Закончил с отличием",
                false));
        resume.setEducationSection(new TextListSection(SectionType.EDUCATION, educations));

        printResume(resume);
    }

    private static void printResume(Resume resume) {
        System.out.println(resume.getFullName());
        System.out.println("Тел.:" + resume.getContactInfoSection().getPhoneNumber());
        System.out.println("Skype.:" + resume.getContactInfoSection().getSkypeNumber());
        System.out.println("Почта.:" + resume.getContactInfoSection().getEmail());
        System.out.println(resume.getContactInfoSection().getLinkedinUrl());
        System.out.println(resume.getContactInfoSection().getGithubUrl());
        System.out.println(resume.getContactInfoSection().getStackoverflowUrl());
        System.out.println(resume.getContactInfoSection().getHomePageUrl());
        printTextSection(resume.getObjectiveSection());
        printTextSection(resume.getPersonalSection());
        printTextListSection(resume.getAchievementSection());
        printTextListSection(resume.getQualificationsSection());
        printTextListSection(resume.getExperienceSection());
        printTextListSection(resume.getEducationSection());
    }

    private static void printTextSection(TextSection textSection) {
        System.out.println(textSection.getSectionType().getTitle());
        System.out.println(textSection.getText());
    }

    private static void printTextListSection(TextListSection textListSection) {
        System.out.println(textListSection.getSectionType().getTitle());
        for (ResumeRow resumeRow : textListSection.getTextArray()) {
            if (resumeRow.isNeedMark()) {
                System.out.print(MARK);
            }
            if (Objects.nonNull(resumeRow.getRowHeader())) {
                System.out.println(resumeRow.getRowHeader());
            }
            if (Objects.nonNull(resumeRow.getDateStart())) {
                System.out.println(resumeRow.getDateStart() + " - " + resumeRow.getDateEnd());
            }
            if (Objects.nonNull(resumeRow.getBoldText())) {
                System.out.println(resumeRow.getBoldText());
            }
            if (Objects.nonNull(resumeRow.getText())) {
                System.out.println(resumeRow.getText());
            }
        }
    }
}