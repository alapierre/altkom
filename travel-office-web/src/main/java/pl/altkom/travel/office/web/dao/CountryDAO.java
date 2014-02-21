/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.travel.office.web.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import pl.altkom.travel.office.web.model.Country;

/**
 *
 * @author altkom
 */
public interface CountryDAO extends CrudRepository<Country, Integer>{
   
    public List<Country> findByName(String name);
    
}
