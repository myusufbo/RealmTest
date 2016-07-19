package com.fieldbuzz.realmtest;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by FieldBuzz on 7/19/2016.
 */
public class Books extends RealmObject {

    private String title;
    @PrimaryKey
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
