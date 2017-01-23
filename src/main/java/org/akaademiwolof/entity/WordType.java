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
@Table(name="wordType")
@NamedQuery(name="WordType.findAll", query="SELECT w FROM WordType w")
public class WordType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private BigInteger idwordType;

	@Column(length=45)
	private String type;

	//bi-directional many-to-one association to WordSens
	@OneToMany(mappedBy="wordType", fetch=FetchType.LAZY)
	private List<WordSens> wordSenses;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="idlanguage")
	private Language language;

	public WordType() {
	}
	
	public WordType(String type, Language language) {
		this.language = language;
		this.type = type;
	}
	
	public BigInteger getIdwordType() {
		return this.idwordType;
	}

	public void setIdwordType(BigInteger idwordType) {
		this.idwordType = idwordType;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<WordSens> getWordSenses() {
		return this.wordSenses;
	}

	public void setWordSenses(List<WordSens> wordSenses) {
		this.wordSenses = wordSenses;
	}

	public WordSens addWordSens(WordSens wordSens) {
		getWordSenses().add(wordSens);
		wordSens.setWordType(this);

		return wordSens;
	}

	public WordSens removeWordSens(WordSens wordSens) {
		getWordSenses().remove(wordSens);
		wordSens.setWordType(null);

		return wordSens;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}