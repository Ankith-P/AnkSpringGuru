package com.ank.spring5webapp.section2_Maven.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ank.spring5webapp.section2_Maven.domain.Author;
import com.ank.spring5webapp.section2_Maven.domain.Book;
import com.ank.spring5webapp.section2_Maven.domain.Publisher;
import com.ank.spring5webapp.section2_Maven.repositories.AuthorRepository;
import com.ank.spring5webapp.section2_Maven.repositories.BookRepository;
import com.ank.spring5webapp.section2_Maven.repositories.PublisherRepository;

@Component
public class BootStrapLoader implements CommandLineRunner{

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	

	public BootStrapLoader(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Author author1=new Author("Eric","Evans");
		Book book1=new Book("Domain Driven Design","1PI10IS019");
		
		Author author2=new Author("Rod","Johnson");
		Book book2=new Book("J2EE Development without EJB","1PI10IS28");
		
		authorRepository.save(author1);
		authorRepository.save(author2);
		

		
		bookRepository.save(book1);
		bookRepository.save(book2);
		
		Publisher publisher =new Publisher("Sapna Book House","Sapna is popular book house in India");
		publisher.getBooks().add(book1);
		publisher.getBooks().add(book2);
		

		bookRepository.save(book1);
		bookRepository.save(book2);
		publisherRepository.save(publisher);
		book1.setPublisher(publisher);
		book2.setPublisher(publisher);
		System.out.println("printing in memory book and author details");
		System.out.println(authorRepository.count());
		System.out.println(bookRepository.count());
		System.out.println("Publisher repository is "+publisher.getBooks().size());

}
}
