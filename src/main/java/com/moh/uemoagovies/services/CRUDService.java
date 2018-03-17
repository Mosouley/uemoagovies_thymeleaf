package com.moh.uemoagovies.services;


public interface CRUDService<T> {

	Iterable<?> listAll();
	 
    T getById(Long id);
 
    T saveOrUpdate(T domainObject);
 
    void delete(Long id);
}
