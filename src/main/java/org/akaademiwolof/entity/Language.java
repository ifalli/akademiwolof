package org.akaademiwolof.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * Ibrahima Fall
 * 
 */
@Entity
@Table(name="language")
@NamedQuery(name="Language.findAll", query="SELECT l FROM Language l")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private BigInteger idlanguage;

	@Column(length=3)
	private String name;

	@OneToMany(mappedBy="language", fetch=FetchType.LAZY)
	private List<WordSens> wordSenses;
	
	@OneToMany(mappedBy="language", fetch=FetchType.LAZY)
	private List<WordType> wordTypes;

	public Language() {
	}
	
	public Language(String name) {
		this.name = name;
	}
	
	public Language(BigInteger idlanguage, String name) {
		this.idlanguage = idlanguage;
		this.name = name;
	}

	public BigInteger getIdlanguage() {
		return this.idlanguage;
	}

	public void setIdlanguage(BigInteger idlanguage) {
		this.idlanguage = idlanguage;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WordSens> getWordSenses() {
		return this.wordSenses;
	}

	public void setWordSenses(List<WordSens> wordSenses) {
		this.wordSenses = wordSenses;
	}

	public WordSens addWordSens(WordSens wordSens) {
		getWordSenses().add(wordSens);
		wordSens.setLanguage(this);

		return wordSens;
	}

	public WordSens removeWordSens(WordSens wordSens) {
		getWordSenses().remove(wordSens);
		wordSens.setLanguage(null);

		return wordSens;
	}

	public List<WordType> getWordTypes() {
		return this.wordTypes;
	}

	public void setWordTypes(List<WordType> wordTypes) {
		this.wordTypes = wordTypes;
	}

	public WordType addWordType(WordType wordType) {
		getWordTypes().add(wordType);
		wordType.setLanguage(this);

		return wordType;
	}

	public WordType removeWordType(WordType wordType) {
		getWordTypes().remove(wordType);
		wordType.setLanguage(null);

		return wordType;
	}
	


}