package org.akaademiwolof.serviceInterface;

import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author Ibrahima Fall
 *
 */


public interface GenericService<T, Id extends Serializable> {		
	
	
	public <S extends T> Iterable<S> save(Iterable<S> arg0);

	
	public <S extends T> S save(S arg0);
	
	
	public long count();

	
	public void delete(Iterable<? extends T> arg0);

	
	public void delete(Id arg0);

	
	public void delete(T arg0);

	
	public void deleteAll();

	
	public boolean exists(Id arg0);

	
	public Iterable<T> findAll();

	
	public Iterable<T> findAll(Iterable<Id> arg0);

	
	public T findOne(Id arg0);

	
	public Page<T> findAll(Pageable arg0);

	
	public Iterable<T> findAll(Sort arg0);

}
