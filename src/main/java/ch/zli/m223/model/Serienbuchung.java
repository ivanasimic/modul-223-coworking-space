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
 * Die Klasse für die Serienbuchung
 */


@Entity 
public class Serienbuchung {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;


  @Column(nullable = false)
  private String von;

  @Column(nullable = false)
  private String bis;

  @Column(nullable = false)
  private String zeitinterval;
  
  @ManyToOne
  @JsonIgnore
  private Benutzer benutzer;
  



  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getVon() {
    return this.von;
  }

  public void setVon(String von) {
    this.von = von;
  }

  public String getBis() {
    return this.bis;
  }

  public void setBis(String bis) {
    this.bis = bis;
  }

  public String getZeitinterval() {
    return this.zeitinterval;
  }

  public void setZeitinterval(String zeitinterval) {
    this.zeitinterval = zeitinterval;
  }

  public Benutzer getBenutzer() {
    return this.benutzer;
  }

  public void setBenutzer(Benutzer benutzer) {
    this.benutzer = benutzer;
  }
 
}
