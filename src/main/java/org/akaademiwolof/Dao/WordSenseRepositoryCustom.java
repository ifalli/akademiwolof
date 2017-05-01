package org.akaademiwolof.Dao;

import org.akaademiwolof.entity.WordSens;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.lang.String;
import java.math.BigInteger;

/**
 * @author Ibrahima Fall
 *
 */

@NoRepositoryBean
public interface WordSenseRepositoryCustom{
	public List<String> findListNamebyName(String word, String lang,int lim); // find a list of wordSense.word by given substring
	public List<String> findListRangNamebyName(String word, String lang, int up, int down); // find a list of wordSens.word and an up and down interval by by given word
	public List<WordSens> findListWordsbyName(String word, String lang); // find a list of wordSens.word, wordSens.idwordSenses  by given substring
}
