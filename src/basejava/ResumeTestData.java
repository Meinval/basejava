package basejava;

import basejava.model.*;

import java.time.Month;
import java.util.ArrayList;

public class ResumeTestData {
    public static Resume getTestData(String uuid, String fio) {
        Resume resumeTestData = new Resume(fio);
        resumeTestData.setUuid(uuid);
        resumeTestData.getContactsMap().put(ContactType.PHONE, "+7(921) 855-0482");
        resumeTestData.getContactsMap().put(ContactType.SKYPE, "grigory.kislin");
        resumeTestData.getContactsMap().put(ContactType.EMAIL, "gkislin@yandex.ru");
        resumeTestData.getContactsMap().put(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resumeTestData.getContactsMap().put(ContactType.GITHUB, "https://github.com/gkislin");
        resumeTestData.getContactsMap().put(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        resumeTestData.getContactsMap().put(ContactType.HOMEPAGE, "http://gkislin.ru/");
        resumeTestData.getSectionsMap().put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resumeTestData.getSectionsMap().put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        ArrayList<String> achievements = new ArrayList<>();
        achievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"" +
                "Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievements.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
                "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
                "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievements.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, " +
                "GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievements.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). " +
                "Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. " +
                "Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievements.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), " +
                "Белоруcсии(Erip, Osmp) и Никарагуа.");
        resumeTestData.getSectionsMap().put(SectionType.ACHIEVEMENT, new TextListSection(achievements));
        ArrayList<String> qualifications = new ArrayList<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        qualifications.add("MySQL, SQLite, MS SQL, HSQLDB");
        qualifications.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        qualifications.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        qualifications.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), " +
                "JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualifications.add("Python: Django.");
        qualifications.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, " +
                "MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualifications.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        qualifications.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualifications.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов");
        qualifications.add("проектрирования, архитектурных шаблонов, UML, функционального");
        qualifications.add("программирования");
        qualifications.add("Родной русский, английский \"upper intermediate\"");
        resumeTestData.getSectionsMap().put(SectionType.QUALIFICATIONS, new TextListSection(qualifications));
        ArrayList<Organization> experiences = new ArrayList<>();
        experiences.add(new Organization("Java Online Projects",
                "http://javaops.ru/",
                new Position(2013,
                        Month.OCTOBER,
                        2019,
                        Month.DECEMBER,
                        "Автор проекта.",
                        "Создание, организация и проведение Java онлайн проектов и стажировок.")));
        experiences.add(new Organization("Wrike",
                "https://www.wrike.com/",
                new Position(2014,
                        Month.OCTOBER,
                        2015,
                        Month.JANUARY,
                        "Старший разработчик (backend)",
                        "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, " +
                                "PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")));
        experiences.add(new Organization("RIT Center",
                "",
                new Position(2012,
                        Month.APRIL,
                        2014,
                        Month.OCTOBER,
                        "Java архитектор",
                        "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, " +
                                "ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), " +
                                "AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, " +
                                "1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. " +
                                "Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, " +
                                "Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python")));
        experiences.add(new Organization("Luxoft (Deutsche Bank)",
                "https://www.luxoft.com/",
                new Position(2020,
                        Month.DECEMBER,
                        2012,
                        Month.APRIL,
                        "Ведущий программист",
                        "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). " +
                                "Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. " +
                                "JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.")));
        experiences.add(new Organization("Yota",
                "https://www.yota.ru/",
                new Position(2008,
                        Month.JUNE,
                        2010,
                        Month.DECEMBER,
                        "Ведущий специалист",
                        "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                                "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)")));
        experiences.add(new Organization("Enkata",
                "https://www1.pega.com/products/pega-platform/robotic-automation",
                new Position(2007,
                        Month.MARCH,
                        2008,
                        Month.JUNE,
                        "Разработчик ПО",
                        "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).")));
        experiences.add(new Organization("Siemens AG",
                "https://www.siemens.com/ru/ru/home.html",
                new Position(2005,
                        Month.JANUARY,
                        2007,
                        Month.FEBRUARY,
                        "Разработчик ПО",
                        "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).")));
        experiences.add(new Organization("Alcatel",
                "http://www.alcatel.ru/",
                new Position(1997,
                        Month.SEPTEMBER,
                        2005,
                        Month.JANUARY,
                        "Инженер по аппаратному и программному тестированию",
                        "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).")));
        resumeTestData.getSectionsMap().put(SectionType.EXPERIENCE, new OrganizationSection(experiences));
        ArrayList<Organization> educations = new ArrayList<>();
        educations.add(new Organization("Coursera",
                "https://www.coursera.org/learn/progfun1",
                new Position(2013,
                        Month.MARCH,
                        2013,
                        Month.MAY,
                        "\"Functional Programming Principles in Scala\" by Martin Odersky",
                        "")));
        educations.add(new Organization("Luxoft",
                "https://www.luxoft-training.ru/kurs/obektno-orientirovannyy__analiz_is_kontseptualnoe_modelirovanie_na_uml_dlya_sistemnyh_analitikov_.html",
                new Position(2011,
                        Month.MARCH,
                        2011,
                        Month.APRIL,
                        "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                        "")));
        educations.add(new Organization("Siemens AG",
                "https://www.siemens.com/ru/ru/home.html",
                new Position(2005,
                        Month.JANUARY,
                        2005,
                        Month.APRIL,
                        "3 месяца обучения мобильным IN сетям (Берлин)",
                        "")));
        educations.add(new Organization("Alcatel",
                "http://www.alcatel.ru/",
                new Position(1997,
                        Month.SEPTEMBER,
                        1998,
                        Month.MARCH,
                        "6 месяцев обучения цифровым телефонным сетям (Москва)",
                        "")));
        educations.add(new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "http://www.ifmo.ru/ru/",
                new Position(1993,
                        Month.SEPTEMBER,
                        1996,
                        Month.JULY,
                        "Аспирантура (программист С, С++)",
                        ""), new Position(1987,
                Month.SEPTEMBER,
                1993,
                Month.JULY,
                "Инженер (программист Fortran, C)",
                "")));
        educations.add(new Organization("Заочная физико-техническая школа при МФТИ",
                "http://www.school.mipt.ru/",
                new Position(1984,
                        Month.APRIL,
                        1987,
                        Month.JUNE,
                        "Закончил с отличием",
                        "")));
        resumeTestData.getSectionsMap().put(SectionType.EDUCATION, new OrganizationSection(educations));
        return resumeTestData;
    }
}