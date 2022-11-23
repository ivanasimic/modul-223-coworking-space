package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.model.Rollen;


@ApplicationScoped
public class RollenService {
  @Inject
  EntityManager entitymanager;

  public List<Rollen> findAll() {
    var query = entitymanager.createQuery("FROM Role", Rollen.class);
    System.out.println(query.getResultList());
    return query.getResultList();
  }

  public Rollen findId(Long id) {
    var role = entitymanager.find(Rollen.class, id);
        return role;
  }

  public Rollen create(Rollen role) {
    entitymanager.persist(role);
    return role;
  }
  
}
