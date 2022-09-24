package com.makson.FiscalCodeApp.dao;

import com.makson.FiscalCodeApp.entity.Commune;
import org.springframework.data.repository.CrudRepository;

public interface CommuneDao extends CrudRepository<Commune, Long> {
    Commune findByName(String name);
}
