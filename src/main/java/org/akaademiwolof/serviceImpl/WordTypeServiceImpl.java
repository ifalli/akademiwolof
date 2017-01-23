package org.akaademiwolof.serviceImpl;

import java.math.BigInteger;

import org.akaademiwolof.Dao.WordTypeRepository;
import org.akaademiwolof.entity.WordSens;
import org.akaademiwolof.entity.WordType;
import org.akaademiwolof.serviceInterface.WordSenseService;
import org.akaademiwolof.serviceInterface.WordTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Fall
 *
 */
	

@Service
public class WordTypeServiceImpl extends GenericServiceImpl<WordType, BigInteger> implements WordTypeService{

	@Autowired
	private WordTypeRepository wordTypeRepository;
	
	public WordTypeServiceImpl(){
		
	}
	
	@Override
	public WordType findByType(String type){
		return wordTypeRepository.findByType(type);
	}
}
