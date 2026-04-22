package designpattern;


import java.util.*;

final public class ImmutableClass {

    private final int id;
    private final String name;
    private final Date date;
    private final List<String> names;

    public ImmutableClass(int id, String name, Date date, List names) {

        this.id = id;
        this.name = name;
        this.date = new Date(date.getDate());
        this.names = new ArrayList<>(names);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public List<String> getNames() {
        return new ArrayList<>(names);
    }
}
