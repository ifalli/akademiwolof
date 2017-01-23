package org.akaademiwolof.serviceImpl;

import java.math.BigInteger;

import org.akaademiwolof.entity.Definition;
import org.akaademiwolof.serviceInterface.DefinitionService;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Fall
 *
 */
	

@Service
public class DefinitionServiceImpl extends GenericServiceImpl<Definition, BigInteger> implements DefinitionService{

}
