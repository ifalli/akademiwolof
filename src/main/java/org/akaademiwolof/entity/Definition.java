package org.akaademiwolof.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import java.math.BigInteger;
import java.util.List;


/**
 * Ibrahima Fall
 * 
 */
@Entity
@Table(name="definitions")
@NamedQuery(name="Definition.findAll", query="SELECT d FROM Definition d")
public class Definition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private BigInteger iddefinitions;

	@Lob
	private String definition;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="idwordSenses")
	private WordSens wordSenses;

	public Definition() {
	}
	
	public Definition(String definition) {
		this.definition = definition ; 
	}
	
	public BigInteger getIddefinitions() {
		return this.iddefinitions;
	}

	public void setIddefinitions(BigInteger iddefinitions) {
		this.iddefinitions = iddefinitions;
	}

	public String getDefinition() {
		return this.definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public WordSens getWordSenses() {
		return this.wordSenses;
	}

	public void setWordSenses(WordSens wordSenses) {
		this.wordSenses = wordSenses;
	}

}