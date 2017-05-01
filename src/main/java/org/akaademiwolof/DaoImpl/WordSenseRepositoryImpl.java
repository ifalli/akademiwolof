package org.akaademiwolof.DaoImpl;

import org.akaademiwolof.Dao.WordSenseRepositoryCustom;
import org.akaademiwolof.entity.WordSens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.String;

/**
 * @author Ibrahima Fall
 *
 */
@Transactional
@Repository
@Scope("prototype") 
public class WordSenseRepositoryImpl implements WordSenseRepositoryCustom{
	private static String SEARCH_WORDS_BY_WORD = "SELECT w.idwordSenses, w.word FROM wordSenses w "+
											 "			WHERE LOWER(w.word) LIKE LOWER(CONCAT(:word,'%')) and w.idlanguage "+
											 			"in (select l.idlanguage from language l where l.name = :lang ) ORDER BY w.word ASC limit :limit";
 
	private static final String SEARCH_NAMES_BY__STRING = "SELECT w.word FROM wordSenses w "+
														  "WHERE LOWER(w.word) LIKE LOWER(CONCAT(:word,'%')) and w.idlanguage "+
												 		  "in (select l.idlanguage from language l where l.name = :lang ) ORDER BY w.word ASC";
	
	private String SEARCH_NAMES_RANG_BY__STRING = "select li.word from ((SELECT distinct(w.word),w.idlanguage FROM wordSenses w "+
																"where w.word <= :word order by w.word DESC limit down) "+
																"union "+
																"(SELECT distinct(w.word),w.idlanguage FROM wordSenses w "+
																"where w.word > :word order by w.word ASC limit up )) li "+
																"join language l on l.name = :lang "+
																"and l.idlanguage = li.idlanguage "+
																"join wordSenses w2 on w2.word =  :word order by li.word ASC";

	@Autowired
    private  NamedParameterJdbcTemplate jdbcTemplate;
    
   
   
    public WordSenseRepositoryImpl() {
    	
    }
 
    @Transactional(readOnly = true)
    @Override
	public List<String> findListNamebyName(String word, String lang, int limit){
    	 Map<String, String> queryParams = new HashMap<>();
         queryParams.put("word", word);
         queryParams.put("lang", lang);
         SEARCH_WORDS_BY_WORD = SEARCH_WORDS_BY_WORD.replace(":limit", String.valueOf(limit));
    	List<String> words = jdbcTemplate.queryForList(SEARCH_NAMES_BY__STRING,
                queryParams,
                String.class); 
		return words;
	}

    @Transactional(readOnly=true)
    @Override
	public List<WordSens> findListWordsbyName(String word, String lang) {
    	 Map<String, String> queryParams = new HashMap<>();
         queryParams.put("word", word);
         queryParams.put("lang", lang);
         
    	List<WordSens> words = jdbcTemplate.query(SEARCH_WORDS_BY_WORD,
                queryParams,
                new BeanPropertyRowMapper<>(WordSens.class)
        );
		return words;
	}

    @Transactional(readOnly=true)
    @Override
	public List<String> findListRangNamebyName(String word, String lang, int up, int down) {
		Map<String, String> queryParams = new HashMap<>();
        queryParams.put("word", word);
        queryParams.put("lang", lang);
       
        //it's not possible to use ? for limit operator, for that I inject variables in the query string, soooo Ugly (i know)
        String withUp= SEARCH_NAMES_RANG_BY__STRING.replace("up", String.valueOf(up));
        String withDown = withUp.replace("down", String.valueOf(down));
        //SEARCH_NAMES_RANG_BY__STRING = SEARCH_NAMES_RANG_BY__STRING.replace("up", String.valueOf(up));
        //SEARCH_NAMES_RANG_BY__STRING = SEARCH_NAMES_RANG_BY__STRING.replace("down", String.valueOf(down));
        //queryParams.put("up", String.valueOf(up)); 
        //queryParams.put("down", String.valueOf(down));
        
        List<String> words = jdbcTemplate.queryForList(withDown,
               queryParams,
               String.class); 
		return words;
	}
}
