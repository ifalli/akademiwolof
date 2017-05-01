package org.akaademiwolof.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Ibrahima Fall
 * 
 */

public class WordSensJson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length=45)
	private String word;
	
	private String language;

	private String wordType;
	
	private List<String>  definition ;

	private List<String> examples ;
	
	private List<String> antonyms;

	private List<String> derivated;

	private List<String> seeAlso;

	private List<String> synonyms;

	
	public WordSensJson() {
		examples= new ArrayList<String>();
		definition = new ArrayList<String>();
		antonyms= new ArrayList<String>();
		derivated = new ArrayList<String>();
		seeAlso= new ArrayList<String>();
		synonyms = new ArrayList<String>();
	}


	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getWordType() {
		return wordType;
	}


	public void setWordType(String wordType) {
		this.wordType = wordType;
	}


	public List<String> getDefinition() {
		return definition;
	}


	public void setDefinition(List<String> definition) {
		this.definition = definition;
	}


	public List<String> getExamples() {
		return examples;
	}


	public void setExamples(List<String> examples) {
		this.examples = examples;
	}


	public List<String> getAntonyms() {
		return antonyms;
	}


	public void setAntonyms(List<String> antonyms) {
		this.antonyms = antonyms;
	}


	public List<String> getDerivated() {
		return derivated;
	}


	public void setDerivated(List<String> derivated) {
		this.derivated = derivated;
	}


	public List<String> getSeeAlso() {
		return seeAlso;
	}


	public void setSeeAlso(List<String> seeAlso) {
		this.seeAlso = seeAlso;
	}


	public List<String> getSynonyms() {
		return synonyms;
	}


	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}

	
	
}