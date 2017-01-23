package org.akaademiwolof.serviceInterface;

import java.math.BigInteger;

import org.akaademiwolof.entity.Language;

/**
 * @author Ibrahima Fall
 *
 */


public interface LanguageService extends GenericService<Language, BigInteger>{
		
	public Language findByName(String name);

}
