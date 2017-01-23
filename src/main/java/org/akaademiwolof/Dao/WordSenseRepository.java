package org.akaademiwolof.Dao;


import org.akaademiwolof.entity.WordSens;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

import org.akaademiwolof.Dao.GenericApplicationRepository;
import java.lang.String;

/**
 * @author Ibrahima Fall
 *
 */
@Transactional
public interface WordSenseRepository extends GenericApplicationRepository<WordSens, BigInteger> {
	
	WordSens findByWord(String word);
}
