package com.ank.spring5webapp.section2_Maven.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;


@Entity
public class Publisher {

	private String pubName;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String publisherId;
	private String description;
	
	@OneToMany
//	@JoinTable(name="publisher_books",joinColumns= { @JoinColumn(name="publisher_id")},
	//inverseJoinColumns=@JoinColumn(name="book_id"))
	@JoinColumn(name="publisher_id")
	private Set<Book> books=new HashSet<>();
	
	public Set<Book> getBooks() {
		return books;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public Publisher() {
		super();
	}
	public Publisher(String pubName,  String description) {
		super();
		this.pubName = pubName;
		//this.publisherId = publisherId;
		this.description = description;
	}
	public String getPubName() {
		return pubName;
	}
	public void setPubName(String pubName) {
		this.pubName = pubName;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
