package com.isaquehfs.financas.model.repository;

import com.isaquehfs.financas.contract.repository.RecordRepository;
import com.isaquehfs.financas.model.entity.Record;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

import static com.isaquehfs.financas.util.Constants.KEYS.SELECTED;
import static com.isaquehfs.financas.util.Constants.KEYS.UUID;

public class RecordRepositoryImpl implements RecordRepository {

    @Override
    public void saveObject(final Record record) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(record);
            }
        });

        realm.close();
    }

    @Override
    public void removeObject(final Record record) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Record recordFromRealm = realm.where(Record.class).equalTo(UUID, record.getUuid()).findFirst();
                if (recordFromRealm != null)
                    recordFromRealm.delete();
            }
        });

        realm.close();
    }

    @Override
    public Observable<Record> loadCurrent() {
        Realm realm = Realm.getDefaultInstance();

        Record record = realm.where(Record.class).equalTo(SELECTED, true).findFirst();

        Observable<Record> registryObservable = record != null ?
                Observable.just(realm.copyFromRealm(record)) : Observable.<Record>empty();

        realm.close();

        return registryObservable;
    }

    @Override
    public Observable<Record> loadFirstObject() {
        Realm realm = Realm.getDefaultInstance();

        Record record = realm.where(Record.class).findFirst();

        Observable<Record> registryObservable = record != null ?
                Observable.just(realm.copyFromRealm(record)) : Observable.<Record>empty();

        realm.close();

        return registryObservable;
    }

    @Override
    public Observable<Record> loadObjectByKey(String key) {
        Realm realm = Realm.getDefaultInstance();

        Record record = realm.where(Record.class).equalTo(UUID, key).findFirst();

        Observable<Record> registryObservable = record != null ?
                Observable.just(realm.copyFromRealm(record)) : Observable.<Record>empty();

        realm.close();

        return registryObservable;
    }

    @Override
    public Observable<List<Record>> loadObjects() {
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Record> record = realm.where(Record.class).findAll();

        Observable<List<Record>> recordsObservable = (record != null && !record.isEmpty()) ?
                Observable.just(realm.copyFromRealm(record)) : Observable.just(Collections.<Record>emptyList());

        realm.close();

        return recordsObservable;
    }
}
