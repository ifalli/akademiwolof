/**
 * 
 */
package org.akaademiwolof.Dao;

import java.math.BigInteger;

import org.akaademiwolof.entity.Language;
import org.springframework.transaction.annotation.Transactional;
import java.lang.String;

/**
 * @author Ibrahima Fall
 *
 */
@Transactional
public interface LanguageRepository extends GenericApplicationRepository<Language, BigInteger>{
	
	public Language findByName(String name);
	
}
