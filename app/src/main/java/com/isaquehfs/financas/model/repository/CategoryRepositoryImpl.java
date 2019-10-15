package com.isaquehfs.financas.model.repository;

import com.isaquehfs.financas.contract.repository.CategoryRepository;
import com.isaquehfs.financas.model.entity.Category;
import com.isaquehfs.financas.util.Constants;

import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;

import static com.isaquehfs.financas.util.Constants.KEYS.UUID;

public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public void saveObject(final Category category) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(category);
            }
        });

        realm.close();
    }

    @Override
    public void removeObject(final Category category) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Category categoryFromRealm = realm.where(Category.class).equalTo(UUID, category.getUuid()).findFirst();
                if (categoryFromRealm != null)
                    categoryFromRealm.delete();
            }
        });

        realm.close();
    }

    @Override
    public Observable<Category> loadFirstObject() {
        Realm realm = Realm.getDefaultInstance();

        Category user = realm.where(Category.class).findFirst();

        Observable<Category> categoryObservable = user != null ?
                Observable.just(realm.copyFromRealm(user)) : Observable.<Category>empty();

        realm.close();

        return categoryObservable;
    }

    @Override
    public Observable<Category> loadObjectByKey(String key) {
        Realm realm = Realm.getDefaultInstance();

        Category user = realm.where(Category.class).equalTo(UUID, key).findFirst();

        Observable<Category> categoryObservable = user != null ?
                Observable.just(realm.copyFromRealm(user)) : Observable.<Category>empty();

        realm.close();

        return categoryObservable;
    }

    @Override
    public Observable<List<Category>> loadObjects() {
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Category> category = realm.where(Category.class).findAll();

        Observable<List<Category>> categoriesObservable = (category != null && !category.isEmpty()) ?
                Observable.just(realm.copyFromRealm(category)) : Observable.just(Collections.<Category>emptyList());

        realm.close();

        return categoriesObservable;
    }
}
