package org.akaademiwolof.serviceImpl;

import java.io.Serializable;

import org.akaademiwolof.Dao.GenericApplicationRepository;
import org.akaademiwolof.serviceInterface.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Ibrahima Fall
 *
 */

@NoRepositoryBean
public class GenericServiceImpl<T,  Id extends Serializable> implements GenericService<T, Id>{

	@Autowired
	private GenericApplicationRepository<T, Id> genericApplicationRepository;
	
	public GenericServiceImpl(){
	}
	
	@Override
	public <S extends T> Iterable<S>  save(Iterable<S> arg0) {
		return genericApplicationRepository.save(arg0);
	}

	@Override
	public <S extends T> S save(S arg0) {
		return genericApplicationRepository.save(arg0);
	}

	@Override
	public long count() {
		return genericApplicationRepository.count();
	}

	@Override
	public void delete(Iterable<? extends T> arg0) {
		genericApplicationRepository.delete(arg0);
	}

	@Override
	public void delete(Id arg0) {
		genericApplicationRepository.delete(arg0);
		
	}

	@Override
	public void delete(T arg0) {
		genericApplicationRepository.delete(arg0);
		
	}

	@Override
	public void deleteAll() {
		genericApplicationRepository.deleteAll();
		
	}

	@Override
	public boolean exists(Id arg0) {
		
		return genericApplicationRepository.exists(arg0);
	}

	@Override
	public Iterable<T> findAll() {
		
		return genericApplicationRepository.findAll();
	}

	@Override
	public Iterable<T> findAll(Iterable<Id> arg0) {

		return genericApplicationRepository.findAll(arg0);
	}

	@Override
	public T findOne(Id arg0) {
		return genericApplicationRepository.findOne(arg0);
	}

	public Page<T> findAll(Pageable arg0) {
		return genericApplicationRepository.findAll(arg0);
	}

	@Override
	public Iterable<T> findAll(Sort arg0) {
		return genericApplicationRepository.findAll(arg0);
	} 

}
