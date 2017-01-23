package org.akaademiwolof.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;


/**
 * Ibrahima Fall
 * 
 */
@Entity
@Table(name="example")
@NamedQuery(name="Example.findAll", query="SELECT e FROM Example e")
public class Example implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private String idexample;

	@Column(length=45)
	private String example;

	//bi-directional many-to-many association to WordSens
	@ManyToOne()
	@JoinColumn(name="wordSense") 
	private WordSens wordSenses; 

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

	public WordSens getWordSenses() {
		return this.wordSenses;
	}

	public void setWordSenses(WordSens wordSenses) {
		this.wordSenses = wordSenses;
	}

}