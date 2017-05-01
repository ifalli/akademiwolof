package org.akaademiwolof.serviceInterface;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.akaademiwolof.entity.WordSens;
import org.akaademiwolof.entity.WordType;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Fall
 *
 */


public interface WordSenseService extends GenericService<WordSens, BigInteger>{
		
	public WordSens findByWord(String type);
	public List<WordSens> findListWordsbyName(String word, String lang);
	public List<String> findListRangNamebyName(String word, String lang, int up, int down);
	public List<String> findListNamebyName(String word, String lang, int lim);

}
