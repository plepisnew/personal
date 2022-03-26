package me.plepis.accenture.bootcamp.spring_boot;

public class Bean {
    private int id;
    private String name;
    private String language;

    public Bean(int id, String name, String language) {
        this.id = id;
        this.name = name;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
