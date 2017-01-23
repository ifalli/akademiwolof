package org.akaademiwolof.Dao;


import org.akaademiwolof.entity.WordType;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

import org.akaademiwolof.Dao.GenericApplicationRepository;
import java.lang.String;
import java.util.List;
/**
 * @author Ibrahima Fall
 *
 */
@Transactional
public interface WordTypeRepository extends GenericApplicationRepository<WordType, BigInteger> {
	
	public WordType findByType(String type);
}
