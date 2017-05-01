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
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
/**
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

	
	//@Test
	public void readFileTest() throws IOException
	{
		 String myFile = "src/test/java/org/akaademiwolof/testfiles/complete.xlsx";
		 
		 List<RowObject>  lineList = ReadExcellFile.parseFile(myFile);
         
		 assertThat(lineList).isNotEmpty();
	}

	
	
	//@Test
	public void importDataFromFileTest(){		
		
		//init();
		
		boolean isOk = false;
		String myFile = "src/test/java/org/akaademiwolof/testfiles/complete.xlsx";
		File f = new File(myFile);
		if(f.exists() && !f.isDirectory()) { 
			isOk = importDataService.importDataFromFile(myFile);
		}
		
		assertThat(isOk).isTrue();
		
	}
	@Test
	public void initDbTest() throws IOException{
		List<RowObject> lineList = readFileCreateRowObject();
		importDataService.addwordsToDb(lineList);
		assertThat(lineList.size() > 0);
	}
	
	//@Test
	public void crudTest() throws IOException{

		//WordSens ws =  searchManager.getWordSenseService().findByWord("Paaka");
		
		//List<WordSens> ws = (List<WordSens>) searchManager.getWordSenseService().findListWordsbyName("ca", "Wo");
		
		//List<String> w = (List<String>) searchManager.getWordSenseService().findListRangNamebyName("bijji", "Wo",4,4);
		//assertThat(w.size() > 0);
		
		List<WordSens> allwords = (List<WordSens>) searchManager.getWordSenseService().findAll();
		WordSens ws = createWordsensRelations(allwords);
		assertThat(ws.getSynonyms().size() > 0 );
		
	}
	
	public WordSens createWordsensRelations(List<WordSens> allwords){
		
		WordSens ws = searchManager.getWordSenseService().findByWord("bijji");
		
		if(ws != null){
			ws.getSynonyms().add(allwords.get(3));
			ws.getAntonyms().add(allwords.get(2));
			ws.getSeeAlso().add(allwords.get(1));
			ws.getDerivated().add(allwords.get(0));
			searchManager.getWordSenseService().save(ws); // makes update
		}
		return ws;
	}	
	
	public List<RowObject> readFileCreateRowObject() throws IOException
	{	String myFile = "src/test/java/org/akaademiwolof/testfiles/complete.xlsx";
		 
		List<RowObject>  lineList = ReadExcellFile.parseFile(myFile);
              
		return lineList;
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
