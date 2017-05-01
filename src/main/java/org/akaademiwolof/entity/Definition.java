package org.akaademiwolof.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.math.BigInteger;
import java.util.List;


/**
 * Ibrahima Fall
 * 
 */
@Entity
@Table(name="definitions")
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

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="definition", cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Example> examples ;
	
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

	public List<Example> getExamples() {
		return examples;
	}

	public void setExamples(List<Example> examples) {
		this.examples = examples;
	}

}