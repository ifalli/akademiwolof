/**
 * 
 */
package org.akaademiwolof.Dao;

import java.io.Serializable;
import java.math.BigInteger;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * @author Ibrahima Fall
 *
 */
@NoRepositoryBean
public interface GenericReadOnlyApplicationRepository<T, Id extends Serializable > extends Repository<T, Id> {

}
