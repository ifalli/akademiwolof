/**
 * 
 */
package org.akaademiwolof.Dao;

import java.math.BigInteger;

import org.akaademiwolof.entity.Definition;
import org.springframework.transaction.annotation.Transactional;
import org.akaademiwolof.Dao.GenericApplicationRepository;

/**
 * @author Ibrahima Fall
 *
 */

@Transactional
public interface DefinitionRepository extends GenericApplicationRepository<Definition, BigInteger> {
	

}
