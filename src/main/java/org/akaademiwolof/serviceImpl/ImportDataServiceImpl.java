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

	@Override
	public boolean importDataFromFile(String fileName) {
		
		boolean isOk = false;
		List<RowObject> lineList = new ArrayList<RowObject>();
		try {
			lineList = ReadExcellFile.parseFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (RowObject ro : lineList)
		{
			Example ex = new Example();			
			ex.setExample(ro.getExample());
			
			Language lang = searchManager.getLanguageService().findByName("Wo");
			
			WordType type = searchManager.getWordTypeService().findByType(ro.getType());			
						
			Definition definition = new Definition();
			definition.setDefinition(ro.getSense());
			
			WordSens wordSens = new WordSens();
			definition.setWordSenses(wordSens);
			ex.setWordSenses(wordSens);
			
			wordSens.getExamples().add(ex);
			wordSens.setLanguage(lang);
			wordSens.setWordType(type);
			wordSens.getDefinition().add(definition);
			wordSens.setWord(ro.getWord());

			searchManager.getWordSenseService().save(wordSens);
			
			
		}
		isOk = true;
		return isOk;
		
	}

}
