package org.akaademiwolof.entity;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.*;

import org.akaademiwolof.domain.CustomListSerializer;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * Ibrahima Fall
 * 
 */
@Entity
@Table(name="wordSenses")
@JsonIdentityInfo(property="@id", generator=ObjectIdGenerators.IntSequenceGenerator.class)
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
	@OneToMany(mappedBy="wordSenses", cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Definition>  definition ;
	
	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany()
	@JoinTable(
		name="roots"
		, joinColumns={
			@JoinColumn(name="idwordSenses2", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idwordSenses1", nullable=false)
			}
		)
	@JsonSerialize(using = CustomListSerializer.class)
	private List<WordSens> root;

	@ManyToMany(mappedBy="root")
	@JsonIgnore
	private List<WordSens> wordSensesroot;
	
		
	@LazyCollection(LazyCollectionOption.TRUE)
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
	@JsonSerialize(using = CustomListSerializer.class)
	private List<WordSens> antonyms;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany(mappedBy="antonyms")
	@JsonIgnore
	private List<WordSens> wordSensesAntonym;

	@LazyCollection(LazyCollectionOption.TRUE)
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
	@JsonSerialize(using = CustomListSerializer.class)
	private List<WordSens> derivated;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany(mappedBy="derivated")
	@JsonIgnore
	private List<WordSens> wordSensesDerivated;

	@LazyCollection(LazyCollectionOption.TRUE)
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
	@JsonSerialize(using = CustomListSerializer.class)
	private List<WordSens> seeAlso;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany(mappedBy="seeAlso")
	@JsonIgnore
	private List<WordSens> wordSensesSeeAlso;

	@LazyCollection(LazyCollectionOption.TRUE)
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
	@JsonSerialize(using = CustomListSerializer.class)
	private List<WordSens> synonyms;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany(mappedBy="synonyms")
	@JsonIgnore
	private List<WordSens> wordSensesSynonyms;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany()
	@JoinTable(
		name="wo_fr"
		, joinColumns={
			@JoinColumn(name="idwordSenses2", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idwordSenses1", nullable=false)
			}
		)
	@JsonSerialize(using = CustomListSerializer.class)
	private List<WordSens> woFr;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany(mappedBy="woFr")
	@JsonIgnore
	private List<WordSens> wordSenseswoFr;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany()
	@JoinTable(
		name="wo_en"
		, joinColumns={
			@JoinColumn(name="idwordSenses2", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idwordSenses1", nullable=false)
			}
		)
	@JsonSerialize(using = CustomListSerializer.class)
	private List<WordSens> woEn;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany(mappedBy="woEn")
	@JsonIgnore
	private List<WordSens> wordSenseswoEn;
	
	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany()
	@JoinTable(
		name="wo_ar"
		, joinColumns={
			@JoinColumn(name="idwordSenses2", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idwordSenses1", nullable=false)
			}
		)
	@JsonSerialize(using = CustomListSerializer.class)
	private List<WordSens> woAr;

	@LazyCollection(LazyCollectionOption.TRUE)
	@ManyToMany(mappedBy="woAr")
	@JsonIgnore
	private List<WordSens> wordSenseswoAr;
	
	public WordSens() {
		//examples= new ArrayList<Example>();
		definition = new ArrayList<Definition>();
	}

	public WordSens(String word, Language l) {
		this.language = l;
		this.word = word;
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

//	public List<Example> getExamples() {
//		return this.examples;
//	}
//
//	public void setExamples(List<Example> examples) {
//		this.examples = examples;
//	}

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
	
	public List<WordSens> getRoot() {
		return root;
	}

	public void setRoot(List<WordSens> root) {
		this.root = root;
	}

	public List<WordSens> getWoFr() {
		return woFr;
	}

	public void setWoFr(List<WordSens> woFr) {
		this.woFr = woFr;
	}

	public List<WordSens> getWordSenseswoFr() {
		return wordSenseswoFr;
	}

	public void setWordSenseswoFr(List<WordSens> wordSenseswoFr) {
		this.wordSenseswoFr = wordSenseswoFr;
	}

	public List<WordSens> getWoEn() {
		return woEn;
	}

	public void setWoEn(List<WordSens> woEn) {
		this.woEn = woEn;
	}

	public List<WordSens> getWordSenseswoEn() {
		return wordSenseswoEn;
	}

	public void setWordSenseswoEn(List<WordSens> wordSenseswoEn) {
		this.wordSenseswoEn = wordSenseswoEn;
	}

	public List<WordSens> getWoAr() {
		return woAr;
	}

	public void setWoAr(List<WordSens> woAr) {
		this.woAr = woAr;
	}

	public List<WordSens> getWordSenseswoAr() {
		return wordSenseswoAr;
	}

	public void setWordSenseswoAr(List<WordSens> wordSenseswoAr) {
		this.wordSenseswoAr = wordSenseswoAr;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idwordSenses != null ? idwordSenses.hashCode() : 0);
        return hash;
    }
	
	@Override
    public boolean equals(Object object) {
        if (!(object instanceof WordSens)) {
            return false;
        }
        WordSens other = (WordSens) object;
        if ((this.idwordSenses == null && other.idwordSenses != null) || (this.idwordSenses != null && !this.idwordSenses.equals(other.idwordSenses))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ word=" + word + " ]";
    }
}