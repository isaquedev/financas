package com.isaquehfs.financas.contract.repository;

import java.util.List;

import io.reactivex.Observable;

public interface BaseRepository<T> {

    void saveObject(T object);

    void removeObject(T object);

    Observable<T> loadFirstObject();

    Observable<T> loadObjectByKey(String key);

    Observable<List<T>> loadObjects();

}
