package io.github.eperatis.model;

public class Jegyzet {
    private int id;
    private String jegyzet;

    public Jegyzet() {
    }

    public Jegyzet(String jegyzet) {
        this.jegyzet = jegyzet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJegyzet() {
        return jegyzet;
    }

    public void setJegyzet(String jegyzet) {
        this.jegyzet = jegyzet;
    }

    @Override
    public String toString() {
        return "Jegyzet{" +
                "jegyzet='" + jegyzet + '\'' +
                '}';
    }
}
