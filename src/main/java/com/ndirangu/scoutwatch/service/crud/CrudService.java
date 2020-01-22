package com.ndirangu.scoutwatch.service.crud;

import java.util.Set;

public interface CrudService<TypE, Id> {
    Set<TypE> findAll();
    TypE findById(Id id);
    TypE save(TypE object);
    void delete(TypE object);
    void deleteById(Id id);
}