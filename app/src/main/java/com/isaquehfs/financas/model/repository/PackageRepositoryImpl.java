package com.isaquehfs.financas.model.repository;

import com.isaquehfs.financas.contract.repository.PackageRepository;
import com.isaquehfs.financas.model.entity.Package;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

import static com.isaquehfs.financas.util.Constants.KEYS.UUID;

public class PackageRepositoryImpl implements PackageRepository {

    @Override
    public void saveObject(final Package pack) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(pack);
            }
        });

        realm.close();
    }

    @Override
    public void removeObject(final Package pack) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Package packageFromRealm = realm.where(Package.class).equalTo(UUID, pack.getUuid()).findFirst();
                if (packageFromRealm != null)
                    packageFromRealm.delete();
            }
        });

        realm.close();
    }

    @Override
    public Observable<Package> loadFirstObject() {
        Realm realm = Realm.getDefaultInstance();

        Package pack = realm.where(Package.class).findFirst();

        Observable<Package> packageObservable = pack != null ?
                Observable.just(realm.copyFromRealm(pack)) : Observable.<Package>empty();

        realm.close();

        return packageObservable;
    }

    @Override
    public Observable<Package> loadObjectByKey(String key) {
        Realm realm = Realm.getDefaultInstance();

        Package pack = realm.where(Package.class).equalTo(UUID, key).findFirst();

        Observable<Package> packageObservable = pack != null ?
                Observable.just(realm.copyFromRealm(pack)) : Observable.<Package>empty();

        realm.close();

        return packageObservable;
    }

    @Override
    public Observable<List<Package>> loadObjects() {
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Package> pack = realm.where(Package.class).findAll();

        Observable<List<Package>> packagesObservable = (pack != null && !pack.isEmpty()) ?
                Observable.just(realm.copyFromRealm(pack)) : Observable.just(Collections.<Package>emptyList());

        realm.close();

        return packagesObservable;
    }
}
