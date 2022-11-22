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
 * Die Klasse für die Benutzer
 */

@Entity 
public class Benutzer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private String vorname;

  @Column(nullable = false)
  private String nachname;

  @Column(nullable = false)
  private String passwort;

  @Column(nullable = false)
  private String email;


  @OneToMany
  @JsonIgnore
  private Set<Rollen> rollen;

  @OneToMany
  @JsonIgnore
  private Set<Serienbuchung> serienbuchung;


  @OneToMany(mappedBy = "benutzer")
  @JsonIgnore
  private Set<Buchung> buchung;

 @OneToMany
 @JsonIgnore
 private Set<Gereat> gereat;


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getVorname() {
    return this.vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getNachname() {
    return this.nachname;
  }

  public void setNachname(String nachname) {
    this.nachname = nachname;
  }

  public String getPasswort() {
    return this.passwort;
  }

  public void setPasswort(String passwort) {
    this.passwort = passwort;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Rollen> getRollen() {
    return this.rollen;
  }

  public void setRollen(Set<Rollen> rollen) {
    this.rollen = rollen;
  }

  public Set<Serienbuchung> getSerienbuchung() {
    return this.serienbuchung;
  }

  public void setSerienbuchung(Set<Serienbuchung> serienbuchung) {
    this.serienbuchung = serienbuchung;
  }

  public Set<Buchung> getBuchung() {
    return this.buchung;
  }

  public void setBuchung(Set<Buchung> buchung) {
    this.buchung = buchung;
  }

  public Set<Gereat> getGereat() {
    return this.gereat;
  }

  public void setGereat(Set<Gereat> gereat) {
    this.gereat = gereat;
  }
}
