package org.akaademiwolof.Dao;

import org.akaademiwolof.entity.Example;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.math.BigInteger;

import org.akaademiwolof.Dao.GenericApplicationRepository;
/**
 * @author Ibrahima Fall
 *
 */
@Transactional
public interface ExampleRepository extends GenericApplicationRepository<Example,BigInteger> {
	
}
