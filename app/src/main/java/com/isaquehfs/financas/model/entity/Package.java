package com.isaquehfs.financas.model.entity;

import java.util.UUID;

import io.realm.RealmObject;

public class Package extends RealmObject {

    private String uuid;
    private String userId;
    private String description;
    private long updated_at;
    private long deleted_at;

    public Package() {

    }

    public Package(String userId, String description) {
        this.uuid = UUID.randomUUID().toString();
        this.userId = userId;
        this.description = description;
        this.updated_at = System.currentTimeMillis();
    }

    public void save() {
        this.updated_at = System.currentTimeMillis();
    }

    public void delete() {
        this.deleted_at = System.currentTimeMillis();
        this.deleteFromRealm();
    }

    public String getUuid() {
        return uuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }
}
