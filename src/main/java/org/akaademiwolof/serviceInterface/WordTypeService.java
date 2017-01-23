package org.akaademiwolof.serviceInterface;

import java.math.BigInteger;

import org.akaademiwolof.entity.WordType;

/**
 * @author Ibrahima Fall
 *
 */


public interface WordTypeService extends GenericService<WordType, BigInteger>{
		
	public WordType findByType(String type);

}
