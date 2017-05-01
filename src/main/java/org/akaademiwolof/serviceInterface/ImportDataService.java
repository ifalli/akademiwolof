package org.akaademiwolof.serviceInterface;

import java.util.List;

import org.akaademiwolof.common.RowObject;

public interface ImportDataService {
	
	public boolean importDataFromFile(String fileName);
	public void addwordsToDb(List<RowObject> lineList);

}
