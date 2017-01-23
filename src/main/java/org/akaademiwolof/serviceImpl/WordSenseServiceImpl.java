package org.akaademiwolof.serviceImpl;

import java.math.BigInteger;

import org.akaademiwolof.Dao.WordSenseRepository;
import org.akaademiwolof.entity.WordSens;
import org.akaademiwolof.serviceInterface.WordSenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Fall
 *
 */
	
@Service
public class WordSenseServiceImpl extends GenericServiceImpl<WordSens, BigInteger> implements WordSenseService{

	@Autowired
	private WordSenseRepository wordSenseRepository;
	
	@Override
	public WordSens findByWord(String word) {
		return wordSenseRepository.findByWord(word);
	}
}
