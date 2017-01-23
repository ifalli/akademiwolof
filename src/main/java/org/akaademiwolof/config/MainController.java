package org.akaademiwolof.config;


import org.akaademiwolof.entity.Language;
import org.akaademiwolof.entity.WordSens;
import org.akaademiwolof.entity.WordType;
import org.akaademiwolof.manager.SearchManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/akademiWolof")
public class MainController {


    @Autowired
    private SearchManager searchManager;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<WordSens> getWord(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
    	//test ---> http://localhost:9000/akademiWolof?name=Paaka.
    	
    	//WordType wt = searchManager.getWordTypeService().findByType("Tur");
    	if(name != null && !name.isEmpty()){
    			
	    	WordSens wt = searchManager.getWordSenseService().findByWord(name);
	    	if (wt != null)
	    		return new ResponseEntity<WordSens>(wt, HttpStatus.FOUND);
	    	else
	    		return new ResponseEntity<WordSens>(wt, HttpStatus.NOT_FOUND);
    	}else{
    		return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    	}
    		
    }
    
   /* @RequestMapping(method=RequestMethod.PUT)
    public @ResponseBody Language insertWord(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return null;
    }
    
    @RequestMapping(method=RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<Language> removeWord(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return null;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody Language editWord(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return null;
    }*/
    
public void createType(){
		
		WordType tur = new WordType();
		tur.setType("Tur");
		
		WordType jef= new WordType();
		jef.setType("Jëf");
		
		searchManager.getWordTypeService().save(tur);
		searchManager.getWordTypeService().save(jef);		
	}
	
	public void createLanguage(){
		Language lang = new Language();
		lang.setName("Wo");
		
		searchManager.getLanguageService().save(lang);
		
	}

}
