package basejava.storage.serializer;

import basejava.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(r.getUuid());
            dos.writeUTF(r.getFullName());
            writeCollection(dos, r.getContactsMap().entrySet(), entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });
            writeCollection(dos, r.getSectionsMap().entrySet(), entry -> {
                SectionType sectionType = entry.getKey();
                AbstractSection abstractSection = entry.getValue();
                dos.writeUTF(sectionType.name());
                switch (sectionType) {
                    case OBJECTIVE:
                    case PERSONAL:
                        dos.writeUTF(((TextSection) abstractSection).getContent());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeCollection(dos, ((TextListSection) abstractSection).getLines(), dos::writeUTF);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        writeCollection(dos, ((OrganizationSection) abstractSection).getOrganizations(), organization -> {
                            dos.writeUTF(organization.getName());
                            dos.writeUTF(Objects.isNull(organization.getUrl()) ? "" : organization.getUrl());
                            writeCollection(dos, organization.getPositions(), position -> {
                                dos.writeUTF(position.getDateStart().toString());
                                dos.writeUTF(position.getDateEnd().toString());
                                dos.writeUTF(position.getTitle());
                                dos.writeUTF(Objects.isNull(position.getText()) ? "" : position.getText());
                            });
                        });
                        break;
                }
            });
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
                    case PERSONAL:
                        addTextSection(dis, resume, sectionType);
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        addTextListSection(dis, resume, sectionType);
                        break;
                    case EDUCATION:
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

    private interface Writer<T> {
        void write(T t) throws IOException;
    }

    private <T> void writeCollection(DataOutputStream dos, Collection<T> collection, Writer<T> writer) throws IOException {
        dos.writeInt(collection.size());
        for (T item : collection) {
            writer.write(item);
        }
    }
}