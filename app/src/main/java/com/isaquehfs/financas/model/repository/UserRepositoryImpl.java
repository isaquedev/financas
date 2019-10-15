package com.isaquehfs.financas.model.repository;

import com.isaquehfs.financas.contract.repository.UserRepository;
import com.isaquehfs.financas.model.entity.User;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

import static com.isaquehfs.financas.util.Constants.KEYS.UUID;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepository mUserRepository = new UserRepositoryImpl();

    public static UserRepository getInstance() {
        return mUserRepository;
    }

    @Override
    public void saveObject(final User user) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(realm1 -> realm1.copyToRealmOrUpdate(user));

        realm.close();
    }

    @Override
    public void removeObject(final User user) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(realm1 -> {
            User userFromRealm = realm1.where(User.class).equalTo(UUID, user.getUuid()).findFirst();
            if (userFromRealm != null)
                userFromRealm.deleteFromRealm();
        });

        realm.close();
    }

    @Override
    public Observable<User> loadFirstObject() {
        Realm realm = Realm.getDefaultInstance();

        User user = realm.where(User.class).findFirst();

        Observable<User> userObservable = user != null ?
                Observable.just(realm.copyFromRealm(user)) : Observable.<User>empty();

        realm.close();

        return userObservable;
    }

    @Override
    public Observable<User> loadObjectByKey(String key) {
        Realm realm = Realm.getDefaultInstance();

        User user = realm.where(User.class).equalTo(UUID, key).findFirst();

        Observable<User> userObservable = user != null ?
                Observable.just(realm.copyFromRealm(user)) : Observable.<User>empty();

        realm.close();

        return userObservable;
    }

    @Override
    public Observable<List<User>> loadObjects() {
        Realm realm = Realm.getDefaultInstance();

        RealmResults<User> user = realm.where(User.class).findAll();

        Observable<List<User>> usersObservable = (user != null && !user.isEmpty()) ?
                Observable.just(realm.copyFromRealm(user)) : Observable.just(Collections.<User>emptyList());

        realm.close();

        return usersObservable;
    }
}
