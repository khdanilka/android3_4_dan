package ru.geekbrains.android3_4.model.entity;

/**
 * Created by android on 4/12/18.
 */

public class Repository {

    private Long id;
    private String name;
    private String full_name;

//    "id": 119539290,
//            "name": "Accounting",
//            "full_name": "khdanilka/Accounting",

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
