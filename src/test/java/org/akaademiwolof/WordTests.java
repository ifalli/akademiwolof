/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.akaademiwolof;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.akaademiwolof.common.ReadExcellFile;
import org.akaademiwolof.common.RowObject;
import org.akaademiwolof.entity.Definition;
import org.akaademiwolof.entity.Example;
import org.akaademiwolof.entity.Language;
import org.akaademiwolof.entity.WordSens;
import org.akaademiwolof.entity.WordType;
import org.akaademiwolof.manager.SearchManager;
import org.akaademiwolof.serviceInterface.ImportDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * Basic integration tests for service demo application.
 *
 * @author Ibrahima Fall
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class WordTests {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;
	
	@Autowired
	SearchManager searchManager;
	
	@Autowired
	ImportDataService importDataService;

	
	@Test
	public void readFileTest() throws IOException
	{
		 String myFile = "C://Users//sdieng//Desktop//gag.xlsx";
		 
		 List<RowObject>  lineList = ReadExcellFile.parseFile(myFile);
              
		 assertThat(lineList).isNotEmpty();
	}

	
	
	@Test
	public void importDataFromFileTest(){		
		
		//init();
		
		boolean isOk = false;
		String myFile = "src/test/java/org/akaademiwolof/testfiles/gag_cut.xlsx";
		File f = new File(myFile);
		if(f.exists() && !f.isDirectory()) { 
			isOk = importDataService.importDataFromFile(myFile);
		}
		
		assertThat(isOk).isTrue();
		
	}
	

	@Test
	public void crudTest(){
		
		//WordSens wordSens = createWordSens();
		List<WordSens> ws = (List<WordSens>) searchManager.getWordSenseService().findAll();
		//WordSens ws =  searchManager.getWordSenseService().findByWord("Paaka");

	}
	
	
	public WordSens createWordSens(){
		
		Example ex = new Example();
		ex.setExample("jox ma paaka bi ma dagg mburu mi");
		
		Language lang = searchManager.getLanguageService().findByName("Wo");
		
		WordType tur = searchManager.getWordTypeService().findByType("Tur");
		
		Definition definition = new Definition();
		definition.setDefinition("Jumtukaay booy daggee am mbir");
		
		WordSens wordSens = new WordSens();
		definition.setWordSenses(wordSens);
		ex.setWordSenses(wordSens);
		
		wordSens.getExamples().add(ex);
		wordSens.setLanguage(lang);
		wordSens.setWordType(tur);
		wordSens.getDefinition().add(definition);
		wordSens.setWord("Paaka");
		searchManager.getWordSenseService().save(wordSens);
		return wordSens;
	}

	public void createType(String type,Language lang){
		WordType wordType= new WordType(type,lang);
		searchManager.getWordTypeService().save(wordType);		
	}
	
	public Language createLanguage(String lang){
		Language l = new Language(lang);
		searchManager.getLanguageService().save(l);
		return l;
	}

	public void init(){
		Language lang = createLanguage("Wo");
		createType("Tur",lang);
		createType("jef",lang);
	}
}
