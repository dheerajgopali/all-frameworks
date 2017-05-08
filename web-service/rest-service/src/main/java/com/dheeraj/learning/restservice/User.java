package com.dheeraj.learning.restservice;

/**
 * Created by gopad on 24-03-2017.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty
    private int id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String profession;

    public User() {
    }

    public User(int id, String name, String profession) {
        this.id = id;
        this.name = name;
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    @XmlElement
    public void setProfession(String profession) {
        this.profession = profession;
    }
}
