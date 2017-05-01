package org.akaademiwolof.common;

import java.util.ArrayList;
import java.util.List;

public class RowObject {
	
	String word;
	String type;
	List<String> root;
	String sense;
	List<String> examples;
	List<String> seeAlso;
	List<String> synonyms;
	List<String> antonyms;
	List<String>  french;
	List<String> english;
	List<String> arabic;
	
	public RowObject(){
		examples =new ArrayList<String>();
		seeAlso =new ArrayList<String>();
		synonyms =new ArrayList<String>();
		antonyms =new ArrayList<String>();
		french =new ArrayList<String>();
		english =new ArrayList<String>();
		arabic =new ArrayList<String>();
		root =new ArrayList<String>();
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getRoot() {
		return root;
	}
	public void setRoot(List<String> root) {
		this.root = root;
	}
	public String getSense() {
		return sense;
	}
	public void setSense(String sense) {
		this.sense = sense;
	}
	

	public List<String> getFrench() {
		return french;
	}
	public void setFrench(List<String> french) {
		this.french = french;
	}

	public List<String> getEnglish() {
		return english;
	}
	public void setEnglish(List<String> english) {
		this.english = english;
	}
	public List<String> getArabic() {
		return arabic;
	}
	public void setArabic(List<String> arabic) {
		this.arabic = arabic;
	}
	public List<String> getExamples() {
		return examples;
	}
	public void setExamples(List<String> examples) {
		this.examples = examples;
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
	public List<String> getAntonyms() {
		return antonyms;
	}
	public void setAntonyms(List<String> antonyms) {
		this.antonyms = antonyms;
	}
	
	@Override
	public String toString() {
		return word;
	}
}
