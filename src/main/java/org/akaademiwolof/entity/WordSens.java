package org.akaademiwolof.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * Ibrahima Fall
 * 
 */
@Entity
@Table(name="wordSenses")
@NamedQuery(name="WordSens.findAll", query="SELECT w FROM WordSens w")
public class WordSens implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private BigInteger idwordSenses;

	@Column(nullable=false, length=45)
	private String word;
	
	@ManyToOne
	@JoinColumn(name="idlanguage")
	private Language language;

	@ManyToOne
	@JoinColumn(name="idwordType")
	private WordType wordType;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="wordSenses", cascade = CascadeType.ALL)
	private List<Definition>  definition ;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="wordSenses", cascade = CascadeType.ALL)
	private List<Example>  examples ;
		
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany()
	@JoinTable(
		name="antonyms"
		, joinColumns={
			@JoinColumn(name="idwordSenses2", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idwordSenses1", nullable=false)
			}
		)
	private List<WordSens> antonyms;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy="antonyms")
	private List<WordSens> wordSensesAntonym;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany()
	@JoinTable(
		name="derivated"
		, joinColumns={
			@JoinColumn(name="idwordSenses2", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idwordSenses1", nullable=false)
			}
		)
	private List<WordSens> derivated;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy="derivated")
	private List<WordSens> wordSensesDerivated;

	@ManyToMany()
	@JoinTable(
		name="seeAlso"
		, joinColumns={
			@JoinColumn(name="idwordSenses2", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idwordSenses1", nullable=false)
			}
		)
	private List<WordSens> seeAlso;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy="seeAlso")
	private List<WordSens> wordSensesSeeAlso;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany()
	@JoinTable(
		name="synonyms"
		, joinColumns={
			@JoinColumn(name="idwordSenses2", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idwordSenses1", nullable=false)
			}
		)
	private List<WordSens> synonyms;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy="synonyms")
	private List<WordSens> wordSensesSynonyms;

	public WordSens() {
		examples= new ArrayList<Example>();
		definition = new ArrayList<Definition>();
	}

	public BigInteger getIdwordSenses() {
		return this.idwordSenses;
	}

	public void setIdwordSenses(BigInteger idwordSenses) {
		this.idwordSenses = idwordSenses;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public List<Example> getExamples() {
		return this.examples;
	}

	public void setExamples(List<Example> examples) {
		this.examples = examples;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public List<WordSens> getAntonyms() {
		return antonyms;
	}

	public void setAntonyms(List<WordSens> antonyms) {
		this.antonyms = antonyms;
	}

	public WordType getWordType() {
		return this.wordType;
	}

	public void setWordType(WordType wordType) {
		this.wordType = wordType;
	}

	public List<WordSens> getDerivated() {
		return derivated;
	}

	public void setDerivated(List<WordSens> derivated) {
		this.derivated = derivated;
	}

	public List<WordSens> getSeeAlso() {
		return seeAlso;
	}

	public void setSeeAlso(List<WordSens> seeAlso) {
		this.seeAlso = seeAlso;
	}

	public List<WordSens> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(List<WordSens> synonyms) {
		this.synonyms = synonyms;
	}

	public List<Definition> getDefinition() {
		return definition;
	}

	public void setDefinition(List<Definition> definition) {
		this.definition = definition;
	}

	public List<WordSens> getWordSensesAntonym() {
		return wordSensesAntonym;
	}

	public void setWordSensesAntonym(List<WordSens> wordSensesAntonym) {
		this.wordSensesAntonym = wordSensesAntonym;
	}

	public List<WordSens> getWordSensesSeeAlso() {
		return wordSensesSeeAlso;
	}

	public void setWordSensesSeeAlso(List<WordSens> wordSensesSeeAlso) {
		this.wordSensesSeeAlso = wordSensesSeeAlso;
	}

	public List<WordSens> getWordSensesSynonyms() {
		return wordSensesSynonyms;
	}

	public void setWordSensesSynonyms(List<WordSens> wordSensesSynonyms) {
		this.wordSensesSynonyms = wordSensesSynonyms;
	}

	public List<WordSens> getWordSensesDerivated() {
		return wordSensesDerivated;
	}

	public void setWordSensesDerivated(List<WordSens> wordSensesDerivated) {
		this.wordSensesDerivated = wordSensesDerivated;
	}

	
}