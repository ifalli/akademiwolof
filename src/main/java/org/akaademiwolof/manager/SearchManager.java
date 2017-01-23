/**
 * 
 */
package org.akaademiwolof.manager;

import org.akaademiwolof.serviceInterface.DefinitionService;
import org.akaademiwolof.serviceInterface.ExampleService;
import org.akaademiwolof.serviceInterface.LanguageService;
import org.akaademiwolof.serviceInterface.WordSenseService;
import org.akaademiwolof.serviceInterface.WordTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Fall
 *
 */
@Service("searchManager")
public class SearchManager {
	
	@Autowired
	ExampleService exampleService;
	@Autowired
	DefinitionService definitionService;
	@Autowired
	WordTypeService wordTypeService;
	@Autowired
	LanguageService languageService;
	@Autowired
	WordSenseService wordSenseService;
	
	public SearchManager(){
		
		
	}

	public WordSenseService getWordSenseService() {
		return wordSenseService;
	}

	public void setWordSenseService(WordSenseService wordSenseService) {
		this.wordSenseService = wordSenseService;
	}

	public ExampleService getExampleService() {
		return exampleService;
	}

	public void setExampleService(ExampleService exampleService) {
		this.exampleService = exampleService;
	}

	public DefinitionService getDefinitionService() {
		return definitionService;
	}

	public void setDefinitionService(DefinitionService definitionService) {
		this.definitionService = definitionService;
	}

	public WordTypeService getWordTypeService() {
		return wordTypeService;
	}

	public void setWordTypeService(WordTypeService wordTypeService) {
		this.wordTypeService = wordTypeService;
	}

	public LanguageService getLanguageService() {
		return languageService;
	}

	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}
	
}
