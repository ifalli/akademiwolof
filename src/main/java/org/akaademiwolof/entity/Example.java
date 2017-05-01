package org.akaademiwolof.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * Ibrahima Fall
 * 
 */
@Entity
@Table(name="example")
public class Example implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private String idexample;

	@Column(length=45)
	private String example;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="definition") 
	@JsonIgnore
	private Definition definition; 

	public Example() {
	}
	
	public Example(String example) {
		this.example = example;
	}
	public String getIdexample() {
		return this.idexample;
	}

	public void setIdexample(String idexample) {
		this.idexample = idexample;
	}

	public String getExample() {
		return this.example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public Definition getDefinition() {
		return definition;
	}

	public void setDefinition(Definition definition) {
		this.definition = definition;
	}
}