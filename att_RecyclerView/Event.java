package com.example.agenda.compromissos;

public class Event {
    private String title;
    private String date;
    private String local;
    private String time;

    // Constructor
    public Event(String title, String date, String local, String time) {
        this.title = title;
        this.date = date;
        this.local = local;
        this.time = time;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
