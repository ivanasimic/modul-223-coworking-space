package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.model.Benutzer;

@ApplicationScoped
public class BenutzerService {
@Inject
EntityManager entitymanager;

public List<Benutzer> findAll() {
	var query = entitymanager.createQuery("FROM User", Benutzer.class);
        return query.getResultList();
}

public Benutzer findId(Long id) {
  var user = entitymanager.find(Benutzer.class, id);
        return user;
}

public Benutzer create(Benutzer user) {
  entitymanager.persist(user);
        return user;
}

public Benutzer update(Long id, Benutzer user) {
  return entitymanager.merge(user);
}

public void delete(Long id) {
  var user = entitymanager.find(Benutzer.class, id);
  entitymanager.remove(user);
}
  
}
