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
            readItems(dis, () -> resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF()));
            readItems(dis, () -> {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                resume.addSection(sectionType, readSection(dis, sectionType));
            });
            return resume;
        }
    }

    private AbstractSection readSection(DataInputStream dis, SectionType sectionType) throws IOException {
        switch (sectionType) {
            case OBJECTIVE:
            case PERSONAL:
                return new TextSection(dis.readUTF());
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                return new TextListSection(readList(dis, dis::readUTF));
            case EDUCATION:
            case EXPERIENCE:
                return new OrganizationSection(
                        readList(dis, () -> new Organization(
                                dis.readUTF(),
                                dis.readUTF(),
                                readList(dis, () -> new Position(readLocalDate(dis), readLocalDate(dis), dis.readUTF(), dis.readUTF()))
                        ))
                );
            default:
                throw new IllegalStateException();
        }
    }

    private LocalDate readLocalDate(DataInputStream dis) throws IOException {
        return LocalDate.parse(dis.readUTF());
    }


    private interface Reader<T> {
        T read() throws IOException;
    }

    private <T> List<T> readList(DataInputStream dis, Reader<T> reader) throws IOException {
        int size = dis.readInt();
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(reader.read());
        }
        return list;
    }

    private void readItems(DataInputStream dis, ElementProcessor processor) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            processor.process();
        }
    }

    private interface ElementProcessor {
        void process() throws IOException;
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