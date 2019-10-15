package com.isaquehfs.financas.model.repository;

import com.isaquehfs.financas.contract.repository.AccountRepository;
import com.isaquehfs.financas.model.entity.Account;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

import static com.isaquehfs.financas.util.Constants.KEYS.UUID;

public class AccountRepositoryImpl implements AccountRepository {

    @Override
    public void saveObject(final Account account) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(account);
            }
        });

        realm.close();
    }

    @Override
    public void removeObject(final Account account) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Account accountFromRealm = realm.where(Account.class).equalTo(UUID, account.getUuid()).findFirst();
                if (accountFromRealm != null)
                    accountFromRealm.delete();
            }
        });

        realm.close();
    }

    @Override
    public Observable<Account> loadFirstObject() {
        Realm realm = Realm.getDefaultInstance();

        Account account = realm.where(Account.class).findFirst();

        Observable<Account> accountObservable = account != null ?
                Observable.just(realm.copyFromRealm(account)) : Observable.<Account>empty();

        realm.close();

        return accountObservable;
    }

    @Override
    public Observable<Account> loadObjectByKey(String key) {
        Realm realm = Realm.getDefaultInstance();

        Account account = realm.where(Account.class).equalTo(UUID, key).findFirst();

        Observable<Account> accountObservable = account != null ?
                Observable.just(realm.copyFromRealm(account)) : Observable.<Account>empty();

        realm.close();

        return accountObservable;
    }

    @Override
    public Observable<List<Account>> loadObjects() {
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Account> accounts = realm.where(Account.class).findAll();

        Observable<List<Account>> accountsObservable = (accounts != null && !accounts.isEmpty()) ?
                Observable.just(realm.copyFromRealm(accounts)) : Observable.just(Collections.<Account>emptyList());

        realm.close();

        return accountsObservable;
    }

}
