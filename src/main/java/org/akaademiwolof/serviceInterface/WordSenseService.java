package org.akaademiwolof.serviceInterface;

import java.io.Serializable;
import java.math.BigInteger;

import org.akaademiwolof.entity.WordSens;
import org.akaademiwolof.entity.WordType;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Fall
 *
 */


public interface WordSenseService extends GenericService<WordSens, BigInteger>{
		
	public WordSens findByWord(String type);

}
