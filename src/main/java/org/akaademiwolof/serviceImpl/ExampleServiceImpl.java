package org.akaademiwolof.serviceImpl;

import java.math.BigInteger;

import org.akaademiwolof.Dao.LanguageRepository;
import org.akaademiwolof.entity.Example;
import org.akaademiwolof.entity.Language;
import org.akaademiwolof.entity.WordSens;
import org.akaademiwolof.serviceInterface.ExampleService;
import org.akaademiwolof.serviceInterface.LanguageService;
import org.akaademiwolof.serviceInterface.WordSenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Fall
 *
 */

@Service
public class ExampleServiceImpl extends GenericServiceImpl<Example, BigInteger> implements ExampleService{
	
 
}
