package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.model.Buchung;

import javax.transaction.Transactional;

/*
 * @author Ivana Simic
 * @date 22.11.2022
 * Der Service für die Buchung
 */

 @ApplicationScoped
public class BuchungService {
  @Inject
  EntityManager entityManager;
  public List<Buchung> findAll() {
      var query = entityManager.createQuery("FROM Buchung", Buchung.class);
      return query.getResultList();
  }
  public Buchung findId(Long id){
      var buchung = entityManager.find(Buchung.class, id);
      return buchung;
  }
  @Transactional
  public Buchung create(Buchung buchung) {
      entityManager.persist(buchung);
      return buchung;
  }
  @Transactional
  public Buchung update(Long id, Buchung buchung) {
      return entityManager.merge(buchung);
  }
  @Transactional
  public void delete(Long id) {
      var buchung = entityManager.find(Buchung.class, id);
      entityManager.remove(buchung);
  }
  
}
