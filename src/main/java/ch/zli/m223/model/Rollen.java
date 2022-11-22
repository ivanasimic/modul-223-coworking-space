package ch.zli.m223.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * @author Ivana Simic
 * @date 22.11.2022
 * Die Klasse für die Rollen
 */

@Entity
public class Rollen {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "rollen")
  @JsonIgnore
  private Set<Benutzer> benutzer;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Benutzer> getBenutzer() {
    return this.benutzer;
  }

  public void setBenutzer(Set<Benutzer> benutzer) {
    this.benutzer = benutzer;
  }
}
