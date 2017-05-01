package org.akaademiwolof.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.akaademiwolof.entity.WordSens;
import org.akaademiwolof.manager.SearchManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/akademiWolof")
public class MainController {


    @Autowired
    private SearchManager searchManager;

    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @CrossOrigin
	@RequestMapping(value ="/gaggantikaay/baat",method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<WordSens> getWord(@RequestParam(value="word", required=false) String word) {
    	if(word != null && !word.isEmpty()){
    		WordSens wt = null;
    		try {
    			wt = searchManager.getWordSenseService().findByWord(word);
			} catch (Exception e) {
				return new ResponseEntity(null, HttpStatus.NOT_FOUND); 
			}
	    	
    		if (wt != null)
	    		return new ResponseEntity<WordSens>(wt, HttpStatus.OK);
	    	else
	    		return new ResponseEntity<WordSens>(wt, HttpStatus.NOT_FOUND);
    	}else{
    		return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    	}
    		
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @CrossOrigin
   	@RequestMapping(value ="/gaggantikaay/baatlim",method=RequestMethod.GET)
       public @ResponseBody ResponseEntity<List<String>> getWordList(@RequestParam(value="word", required=false) String word, @RequestParam(value="lang", defaultValue="wo", required=false) String lang,
    		   														@RequestParam(value="num", defaultValue="4", required=false) int num) {
       	if(word != null && !word.isEmpty() && lang != null && !lang.isEmpty()){
       		List<String> wt = new ArrayList<String>();
       		try {
       			wt = searchManager.getWordSenseService().findListRangNamebyName(word, lang, num, num+1);
			} catch (Exception e) {
				return new ResponseEntity(null, HttpStatus.NOT_FOUND);
			}
       		 
   	    	if (wt.size() > 0)
   	    		return new ResponseEntity<List<String>>(wt, HttpStatus.OK);
   	    	else
   	    		return new ResponseEntity<List<String>>(wt, HttpStatus.NOT_FOUND);
       	}else{
       		return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
       	}
       		
       }
   
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @CrossOrigin
   	@RequestMapping(value ="/gaggantikaay/baatsub",method=RequestMethod.GET)
       public @ResponseBody ResponseEntity<List<String>> getWordAutocomplete(@RequestParam(value="word", required=false) String word, @RequestParam(value="lang", defaultValue="wo", required=false) String lang) {
    	if(word != null && !word.isEmpty() && lang != null && !lang.isEmpty()){
    		List<String>  wt = new ArrayList<String>();
    		try {
       			wt = searchManager.getWordSenseService().findListNamebyName(word, lang,3);
			} catch (Exception e) {
				return new ResponseEntity(null, HttpStatus.NOT_FOUND);
			}
    		
   	    	if (wt.size() > 0)
   	    		return new ResponseEntity<List<String>>(wt, HttpStatus.OK);
   	    	else
   	    		return new ResponseEntity<List<String>>(wt, HttpStatus.NOT_FOUND);
       	}else{
       		return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
       	}
       		
       }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(Exception.class)
    public ResponseEntity errorhandler(HttpServletRequest req, Exception e){
    	return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value = "/gaggantikaay/soppibaat", method = RequestMethod.POST)
	public ResponseEntity process(@RequestBody(required = false) String json) throws Exception {
    	
    	
    		ObjectMapper mapper = new ObjectMapper();
    		WordSens word;
    		try {
    			word = mapper.readValue(json, WordSens.class);
        		searchManager.getWordSenseService().save(word);
			} catch (Exception e) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity(HttpStatus.OK, HttpStatus.OK);
	}
}