package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.model.Mittagsmenue;



@ApplicationScoped
public class MittagsmenueService {
  @Inject
  EntityManager entitymanager;

  public List<Mittagsmenue> findAll() {
		var query = entitymanager.createQuery("FROM Buchung", Mittagsmenue.class);
    return query.getResultList();
	}

  public Mittagsmenue findId(Long id) {
    var mittagsmenue = entitymanager.find(Mittagsmenue.class, id);
    return mittagsmenue;
  }
  
}
