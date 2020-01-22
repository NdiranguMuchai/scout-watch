package com.ndirangu.scoutwatch.service.crud;

import com.ndirangu.scoutwatch.model.BaseEntity;

import java.util.*;

public abstract class AbstractServiceMap <TypE extends BaseEntity, ID extends Long> {
    protected Map<Long, TypE> map = new HashMap<>();

    Set<TypE> findAll(){
        return new HashSet<>(map.values());
    }
    TypE findById(ID id){
        return map.get(id);
    }
    TypE save(TypE object){
        if (object != null){
            if (object.getId() ==null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }else{
            throw new RuntimeException("Object cannot be null");
        }

        return object;
    }
    void delete(TypE object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
    void deleteById(ID id){
        map.remove(id);
    }
    private Long getNextId(){
        Long nextId;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
}
