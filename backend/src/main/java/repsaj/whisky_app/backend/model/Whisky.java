package repsaj.whisky_app.backend.model;

import java.io.Serializable;

public class Whisky implements Serializable {

    private String id;
    private String name;
    private String subName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
