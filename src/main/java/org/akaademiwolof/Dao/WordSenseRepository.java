package org.akaademiwolof.Dao;


import org.akaademiwolof.entity.WordSens;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

import org.akaademiwolof.Dao.GenericApplicationRepository;
import java.lang.String;

/**
 * @author Ibrahima Fall
 *
 */
@Transactional
public interface WordSenseRepository extends GenericApplicationRepository<WordSens, BigInteger>, WordSenseRepositoryCustom {
	
	WordSens findByWord(String word);
}
