package com.example.semana14;

public class Note
{
    private String noteName, description, id;

    public Note()
    {

    }

    public Note(String noteName, String description, String id) {
        this.noteName = noteName;
        this.description = description;
        this.id = id;
    }

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
