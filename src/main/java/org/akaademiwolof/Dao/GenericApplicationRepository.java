/**
 * 
 */
package org.akaademiwolof.Dao;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Ibrahima Fall
 *
 */
@NoRepositoryBean
public interface GenericApplicationRepository<T, Id extends Serializable> extends PagingAndSortingRepository<T, Id> {
 
	/*@Override
	public <S extends T> Iterable<S> save(Iterable<S> arg0);

	@Override
	public <S extends T> S save(S arg0);
	
	@Override
	public long count();

	@Override
	public void delete(Iterable<? extends T> arg0);

	@Override
	public void delete(Id arg0);

	@Override
	public void delete(T arg0);

	@Override
	public void deleteAll();

	@Override
	public boolean exists(Id arg0);

	@Override
	public Iterable<T> findAll();

	@Override
	public Iterable<T> findAll(Iterable<Id> arg0);

	@Override
	public T findOne(Id arg0);

	@Override
	public Page<T> findAll(Pageable arg0);

	@Override
	public Iterable<T> findAll(Sort arg0);
	*/
	
	//@Query("select k from Kassa k where k.geld = ?1")
	
//	@Override
//	public List<T> findAll();
//	public List<T> findByDefinition(List<T> definition);
//	@Override
//	public Page<T> findAll(Pageable arg0);
//	@Override
//	public Iterable<T> findAll(Sort arg0);
//	@Override
//	public long count();
//	@Override
//	public void delete(T arg0);
//	@Override
//	public void deleteAll();
//	@Override
//	public void delete(E arg0);
//	@Override
//	public void delete(List<T> arg0);
//	@Override
//	public boolean exists(BigDecimal arg0)
//	@Override
//	public List<T> findAll(List<BigDecimal> arg0);
//	@Override
//	public T findOne(BigDecimal arg0);
//	@Override
//	public T save(T arg0);
}
