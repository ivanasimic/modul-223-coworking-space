package ch.zli.m223.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * @author Ivana Simic
 * @date 22.11.2022
 * Die Klasse für die Geräte
 */

@Entity
public class Gereat {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;
  

  @Column(nullable = false)
  private String gereatetyp;

  @ManyToOne
  @JsonIgnore
  private Benutzer benutzer;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGereatetyp() {
    return this.gereatetyp;
  }

  public void setGereatetyp(String gereatetyp) {
    this.gereatetyp = gereatetyp;
  }

  public Benutzer getBenutzer() {
    return this.benutzer;
  }

  public void setBenutzer(Benutzer benutzer) {
    this.benutzer = benutzer;
  }

}
