package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.model.Gereat;


@ApplicationScoped
public class GereatService {
  @Inject
  EntityManager entitymanager;

	public List<Gereat> findAll() {
    var query = entitymanager.createQuery("FROM Buchung", Gereat.class);
    return query.getResultList();
	}

  public Gereat findId(Long id) {
    var gereat = entitymanager.find(Gereat.class, id);
    return gereat;
  }

  public Gereat update(Long id, Gereat gereat) {
    return entitymanager.merge(gereat);
  }

  public void delete(Long id) {
    var gereat = entitymanager.find(Gereat.class, id);
      entitymanager.remove(gereat);
  }

  public Gereat create(Gereat gereat) {
    entitymanager.persist(gereat);
      return gereat;
  }
  
}
