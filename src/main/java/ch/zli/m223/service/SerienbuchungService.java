package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.model.Serienbuchung;


@ApplicationScoped
public class SerienbuchungService {
  @Inject
  EntityManager entitymanager;

	public List<Serienbuchung> findAll() {
		var query = entitymanager.createQuery("FROM Buchung", Serienbuchung.class);
    return query.getResultList();
	}

  public Serienbuchung findId(Long id) {
    var serienbuchung = entitymanager.find(Serienbuchung.class, id);
    return serienbuchung;
  }

  public Serienbuchung create(Serienbuchung serienbuchung) {
    entitymanager.persist(serienbuchung);
      return serienbuchung;
  }

	public Serienbuchung update(Long id, Serienbuchung serienbuchung) {
		return entitymanager.merge(serienbuchung);
	}

	public void delete(Long id) {
    var serienbuchung = entitymanager.find(Serienbuchung.class, id);
      entitymanager.remove(serienbuchung);
	}
  
}
