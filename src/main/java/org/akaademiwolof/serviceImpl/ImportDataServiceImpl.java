package org.akaademiwolof.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImportDataServiceImpl implements  ImportDataService{
	
	@Autowired
	SearchManager searchManager;

	private Language  langAr;
	private Language  langEn;
	private Language  langWo;
	private Language  langFr;
	
	@Override
	public boolean importDataFromFile(String fileName) {
		
		boolean isOk = false;
		List<RowObject> lineList = new ArrayList<RowObject>();
		try {
			lineList = ReadExcellFile.parseFile(fileName);
			isOk = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isOk;
		
	}
	
	@Override
	public void addwordsToDb(List<RowObject> lineList) {
		
		for(RowObject ro : lineList){
			try{
				WordSens w = new WordSens();
				w.setWord(ro.getWord());
				
				Definition def = new Definition(ro.getSense());
				def.setWordSenses(w);
				w.getDefinition().add(def);
				
				List<Example> ex = new ArrayList<Example>();	
				
				for(String example : ro.getExamples()){
					if(!example.isEmpty()){
						Example e = new Example(example);
						e.setDefinition(def);
						ex.add(e);
					}
				}
				
				 def.setExamples(ex);
				
				 //find languages
				 if(langWo == null )
					 langWo = searchManager.getLanguageService().findByName("WO");
				 
				 if(langFr == null ) 
					 langFr = searchManager.getLanguageService().findByName("FR");
				 
				 if(langEn == null )
					 langEn = searchManager.getLanguageService().findByName("AR");
				 
				 if(langAr == null ) 
					 langAr = searchManager.getLanguageService().findByName("AR");
				
				
				
				 //if languages doesn't exist it may create it
				if(langFr == null){
					langFr = new Language("FR");
					searchManager.getLanguageService().save(langFr);
				}
				
				if(langAr == null){
					langAr = new Language("AR");
					searchManager.getLanguageService().save(langAr);
				}

				if(langEn == null){
					langEn = new Language("EN");
					searchManager.getLanguageService().save(langEn);
				}
				
				WordType type = searchManager.getWordTypeService().findByType(ro.getType().toLowerCase());
				
				if(langWo == null){
					String[] types = {"tur","jëf"};
					init(types); // create lang and types
					langWo = searchManager.getLanguageService().findByName("WO");
					type = (type == null) ? searchManager.getWordTypeService().findByType(ro.getType().toLowerCase()) : type;
					w.setLanguage(langWo);
					w.setWordType(type);
				}else{
					w.setLanguage(langWo);
					w.setWordType(type);
				}

				//set roots
				List<WordSens> root = setRelationship(langFr,ro.getRoot());
				w.setRoot(root);
				
				//set French relationship
				List<WordSens> fr = setRelationship(langFr,ro.getFrench());
				
				//set english relationship
				List<WordSens> en = setRelationship(langFr,ro.getEnglish());
				
				//set arabic relationship
				List<WordSens> ar =setRelationship(langAr,ro.getArabic());
				
				//Synonyms relationship
				List<WordSens> syn =setRelationship(langAr,ro.getSynonyms());
				
				//antonyms relationship
				List<WordSens> ant =setRelationship(langAr,ro.getAntonyms());
				
				//SeeAlso relationship
				List<WordSens> see =setRelationship(langAr,ro.getSeeAlso());
				
				
				w.setWoFr(fr);
				w.setWoEn(en);
				w.setWoAr(ar);
				w.setAntonyms(ant);
				w.setSynonyms(syn);
				w.setSeeAlso(see);
					
				
				searchManager.getWordSenseService().save(w);
			}catch(Exception e){
				System.out.print(ro.getWord() + " "+e.getMessage());
			}
		}
		
	}

	public List<WordSens> setRelationship(Language lang, List<String> word) {

		List<WordSens> wordSens = new ArrayList<WordSens>();
		
		
		for(String l : word){
			//if word doesn't exist in db, it may create it at first
			if(!l.isEmpty()){
				WordSens wd = searchManager.getWordSenseService().findByWord(l);
				if( wd != null)
					wordSens.add(wd);
				else
					wordSens.add(searchManager.getWordSenseService().save(new WordSens(l,lang)));
			}
		}
		return wordSens;
	}
	
	public WordSens setRelationship(Language lang, String word) {

		WordSens wd = searchManager.getWordSenseService().findByWord(word);
		//if word doesn't exist in db, it may create it at first
		if( wd != null)
			return wd;
		else
			return searchManager.getWordSenseService().save(new WordSens(word,lang));
	
		
	}
	
	public Language createLanguage(String lang){
		Language l = new Language(lang);
		searchManager.getLanguageService().save(l);
		return l;
	}

	public void createType(String type,Language lang){
		WordType wordType= new WordType(type,lang);
		try{
			searchManager.getWordTypeService().save(wordType);
		}catch(Exception e){
			System.out.print(type + " "+e.getMessage());
		}
	}
	
	public void init(String[] types){
		Language lang = createLanguage("WO");
		for(String type : types){
			createType(type,lang);
		}
		
	}

}
