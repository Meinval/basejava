package basejava.storage.serializer;

import basejava.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            Map<ContactType, String> contacts = r.getContactsMap();
            dos.writeInt(contacts.size());
            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }
            Map<SectionType, AbstractSection> sectionMap = r.getSectionsMap();
            dos.writeInt(sectionMap.size());
            for (Map.Entry<SectionType, AbstractSection> entry : sectionMap.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                if (entry.getValue() instanceof TextSection) {
                    dos.writeUTF(((TextSection) entry.getValue()).getContent());
                }
                if (entry.getValue() instanceof TextListSection) {
                    TextListSection textListSection = (TextListSection) entry.getValue();
                    dos.writeInt(textListSection.getLines().size());
                    for (String s : textListSection.getLines()) {
                        dos.writeUTF(s);
                    }
                }
                if (entry.getValue() instanceof OrganizationSection) {
                    OrganizationSection organizationSection = (OrganizationSection) entry.getValue();
                    dos.writeInt(organizationSection.getOrganizations().size());
                    for (Organization organization : organizationSection.getOrganizations()) {
                        dos.writeUTF(organization.getName());
                        dos.writeUTF(organization.getUrl());
                        dos.writeInt(organization.getPositions().size());
                        for (Position position : organization.getPositions()) {
                            dos.writeUTF(position.getDateStart().toString());
                            dos.writeUTF(position.getDateEnd().toString());
                            dos.writeUTF(position.getTitle());
                            dos.writeUTF(position.getText());
                        }
                    }
                }
            }
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF());
            }
            size = dis.readInt();
            for (int i = 0; i < size; i++) {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                switch (sectionType) {
                    case OBJECTIVE:
                        addTextSection(dis, resume, sectionType);
                        break;
                    case PERSONAL:
                        addTextSection(dis, resume, sectionType);
                        break;
                    case ACHIEVEMENT:
                        addTextListSection(dis, resume, sectionType);
                        break;
                    case QUALIFICATIONS:
                        addTextListSection(dis, resume, sectionType);
                        break;
                    case EDUCATION:
                        addOrganizationSection(dis, resume, sectionType);
                        break;
                    case EXPERIENCE:
                        addOrganizationSection(dis, resume, sectionType);
                        break;
                }
            }
            return resume;
        }
    }

    private void addOrganizationSection(DataInputStream dis, Resume resume, SectionType sectionType) throws IOException {
        int size = dis.readInt();
        OrganizationSection organizationSection = new OrganizationSection();
        List<Organization> organizations = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Organization organization = new Organization();
            organization.setName(dis.readUTF());
            organization.setUrl(dis.readUTF());
            int positionsSize = dis.readInt();
            List<Position> positions = new ArrayList<>();
            for (int n = 0; n < positionsSize; n++) {
                Position position = new Position();
                position.setDateStart(LocalDate.parse(dis.readUTF()));
                position.setDateEnd(LocalDate.parse(dis.readUTF()));
                position.setTitle(dis.readUTF());
                position.setText(dis.readUTF());
                positions.add(position);
            }
            organization.setPositions(positions);
            organizations.add(organization);
        }
        organizationSection.setOrganizations(organizations);
        resume.addSection(sectionType, organizationSection);
    }

    private void addTextListSection(DataInputStream dis, Resume resume, SectionType sectionType) throws IOException {
        int size = dis.readInt();
        TextListSection textListSection = new TextListSection();
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lines.add(dis.readUTF());
        }
        textListSection.setLines(lines);
        resume.addSection(sectionType, textListSection);
    }

    private void addTextSection(DataInputStream dis, Resume resume, SectionType sectionType) throws IOException {
        resume.addSection(sectionType, new TextSection(dis.readUTF()));
    }
}