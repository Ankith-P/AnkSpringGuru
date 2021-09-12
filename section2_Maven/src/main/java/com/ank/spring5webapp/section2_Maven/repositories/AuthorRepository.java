package com.ank.spring5webapp.section2_Maven.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ank.spring5webapp.section2_Maven.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
