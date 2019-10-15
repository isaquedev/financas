package com.isaquehfs.financas.model.entity;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Record extends RealmObject {

    @PrimaryKey
    private String uuid;
    private String userId;
    private boolean isSelected;
    private int type;
    private String description;
    private long date;
    private boolean isRecieved;
    private String packageId;
    private String categoryId;
    private long updated_at;
    private long deleted_at;

    public Record() {

    }

    public Record(String userId, boolean isSelected, int type, String description, long date, boolean isRecieved, String packageId, String categoryId) {
        this.uuid = UUID.randomUUID().toString();
        this.userId = userId;
        this.isSelected = isSelected;
        this.type = type;
        this.description = description;
        this.date = date;
        this.isRecieved = isRecieved;
        this.packageId = packageId;
        this.categoryId = categoryId;
        this.updated_at = System.currentTimeMillis();
    }

    public void save() {
        this.updated_at = System.currentTimeMillis();
    }

    public void delete() {
        this.deleted_at = System.currentTimeMillis();
        this.deleteFromRealm();
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public boolean isRecieved() {
        return isRecieved;
    }

    public void setRecieved(boolean recieved) {
        isRecieved = recieved;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
