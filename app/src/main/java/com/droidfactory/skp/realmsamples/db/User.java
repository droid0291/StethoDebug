package com.droidfactory.skp.realmsamples.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Shashi Pal on 5/19/2017.
 */

public class User extends RealmObject {

    @PrimaryKey
    private String      name;

    private int         age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
