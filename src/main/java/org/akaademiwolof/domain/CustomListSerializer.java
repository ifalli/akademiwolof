/**
 * 
 */
package org.akaademiwolof.domain;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.akaademiwolof.entity.WordSens;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

/**
 * @author Ibrahima Fall
 *
 */
public class CustomListSerializer extends StdSerializer<List<WordSens>>{
	 
	   public CustomListSerializer() {
	        this(null);
	    }
	 
	    public CustomListSerializer(Class<List<WordSens>> t) {
	        super(t);
	    }
	 
	    @Override
	    public void serialize(
	    	List<WordSens> items, 
	      JsonGenerator generator, 
	      SerializerProvider provider) 
	      throws IOException, JsonProcessingException {
	        
	    	List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	    	
	        for (WordSens item : items) {
	        	Map<String,String> ids = new HashMap<String,String>();
	            ids.put("idwordSenses",""+item.getIdwordSenses());
	            ids.put("word",item.getWord());
	            list.add(ids);
	        }
	        generator.writeObject(list);
	    }

}
