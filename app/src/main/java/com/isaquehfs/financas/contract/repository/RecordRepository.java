package com.isaquehfs.financas.contract.repository;

import com.isaquehfs.financas.model.entity.Record;

import io.reactivex.Observable;

public interface RecordRepository extends BaseRepository<Record> {

    Observable<Record> loadCurrent();

}
