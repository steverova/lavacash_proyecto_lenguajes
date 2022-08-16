package com.lavacash.app.interfaces;

import com.lavacash.app.domain.ServicioJPA;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServicio extends CrudRepository<ServicioJPA, Integer>{}