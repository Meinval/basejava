package basejava.sql;

import java.util.LinkedList;

public class DbSet extends LinkedList<DbSetRow> {
    public DbSetRow row(int i) {
        try {
            return this.get(i - 1);
        } catch (IndexOutOfBoundsException e) {
            //значит такого ряда нет
            return null;
        }
    }

    @Override
    public DbSetRow get(int i) {
        return super.get(i);
    }

}