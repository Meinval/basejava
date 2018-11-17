import model.*;

import java.util.ArrayList;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        resume.getContactsMap().put(ContactType.PHONE, "+7(921) 855-0482");
        resume.getContactsMap().put(ContactType.SKYPE, "grigory.kislin");
        resume.getContactsMap().put(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.getContactsMap().put(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        resume.getContactsMap().put(ContactType.GITHUB, "https://github.com/gkislin");
        resume.getContactsMap().put(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        resume.getContactsMap().put(ContactType.HOMEPAGE, "http://gkislin.ru/");
        resume.getSectionsMap().put(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resume.getSectionsMap().put(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        ArrayList<String> achievements = new ArrayList<>();
        achievements.add("● С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"" +
                "Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        achievements.add("● Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievements.add("● Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. " +
                "Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. " +
                "Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        achievements.add("● Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, " +
                "GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievements.add("● Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). " +
                "Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. " +
                "Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        achievements.add("● Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), " +
                "Белоруcсии(Erip, Osmp) и Никарагуа.");
        resume.getSectionsMap().put(SectionType.ACHIEVEMENT, new TextListSection(achievements));
        ArrayList<String> qualifications = new ArrayList<>();
        qualifications.add("● JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("● Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("● DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        qualifications.add("● MySQL, SQLite, MS SQL, HSQLDB");
        qualifications.add("● Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        qualifications.add("● XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        qualifications.add("● Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), " +
                "JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        qualifications.add("● Python: Django.");
        qualifications.add("● JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications.add("● Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications.add("● Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, " +
                "MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualifications.add("● Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        qualifications.add("● администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualifications.add("● Отличное знание и опыт применения концепций ООП, SOA, шаблонов");
        qualifications.add("● проектрирования, архитектурных шаблонов, UML, функционального");
        qualifications.add("● программирования");
        qualifications.add("● Родной русский, английский \"upper intermediate\"");
        resume.getSectionsMap().put(SectionType.QUALIFICATIONS, new TextListSection(qualifications));
        ArrayList<Company> experiences = new ArrayList<>();
        experiences.add(new Company("Java Online Projects",
                "http://javaops.ru/",
                "10/2013",
                "Сейчас",
                "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок."));
        experiences.add(new Company("Wrike",
                "https://www.wrike.com/",
                "10/2014",
                "01/2016",
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, " +
                        "PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        experiences.add(new Company("RIT Center",
                "",
                "04/2012",
                "10/2014",
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, " +
                        "ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), " +
                        "AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, " +
                        "1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. " +
                        "Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, " +
                        "Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
        experiences.add(new Company("Luxoft (Deutsche Bank)",
                "https://www.luxoft.com/",
                "12/2010",
                "04/2012",
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). " +
                        "Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. " +
                        "JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."));
        experiences.add(new Company("Yota",
                "https://www.yota.ru/",
                "06/2008",
                "12/2010",
                "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                        "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));
        experiences.add(new Company("Enkata",
                "https://www1.pega.com/products/pega-platform/robotic-automation",
                "03/2007",
                "06/2008",
                "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));
        experiences.add(new Company("Siemens AG",
                "https://www.siemens.com/ru/ru/home.html",
                "01/2005",
                "02/2007",
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));
        experiences.add(new Company("Alcatel",
                "http://www.alcatel.ru/",
                "09/1997",
                "01/2005",
                "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));
        resume.getSectionsMap().put(SectionType.EXPERIENCE, new CompanySection(experiences));
        ArrayList<Company> educations = new ArrayList<>();
        educations.add(new Company("Coursera",
                "https://www.coursera.org/learn/progfun1",
                "03/2013",
                "05/2013",
                "\"Functional Programming Principles in Scala\" by Martin Odersky",
                ""));
        educations.add(new Company("Luxoft",
                "https://www.luxoft-training.ru/kurs/obektno-orientirovannyy__analiz_is_kontseptualnoe_modelirovanie_na_uml_dlya_sistemnyh_analitikov_.html",
                "03/2011",
                "04/2011",
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                ""));
        educations.add(new Company("Siemens AG",
                "https://www.siemens.com/ru/ru/home.html",
                "01/2005",
                "04/2005",
                "3 месяца обучения мобильным IN сетям (Берлин)",
                ""));
        educations.add(new Company("Alcatel",
                "http://www.alcatel.ru/",
                "09/1997",
                "03/1998",
                "6 месяцев обучения цифровым телефонным сетям (Москва)",
                ""));
        educations.add(new Company("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "http://www.ifmo.ru/ru/",
                "09/1993",
                "07/1996",
                "Аспирантура (программист С, С++)",
                ""));
        educations.add(new Company("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "http://www.ifmo.ru/ru/",
                "09/1987",
                "07/1993",
                "Инженер (программист Fortran, C)",
                ""));
        educations.add(new Company("Заочная физико-техническая школа при МФТИ",
                "http://www.school.mipt.ru/",
                "09/1984",
                "06/1987",
                "Закончил с отличием",
                ""));
        resume.getSectionsMap().put(SectionType.EDUCATION, new CompanySection(educations));
        System.out.println(resume.toString());
    }
}