package com.ank.spring5webapp.section2_Maven.repositories;


import org.springframework.data.repository.CrudRepository;

import com.ank.spring5webapp.section2_Maven.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
