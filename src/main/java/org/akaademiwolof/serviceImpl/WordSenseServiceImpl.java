package org.akaademiwolof.serviceImpl;

import java.math.BigInteger;
import java.util.List;

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

	@Override
	public List<WordSens> findListWordsbyName(String word, String lang) {
		return wordSenseRepository.findListWordsbyName(word, lang);
	}

	@Override
	public List<String> findListNamebyName(String word, String lang, int limit) {
		return wordSenseRepository.findListNamebyName(word, lang,limit);
	}

	@Override
	public List<String> findListRangNamebyName(String word, String lang, int up, int down) {
		return wordSenseRepository.findListRangNamebyName(word, lang, up, down);
	}
}
