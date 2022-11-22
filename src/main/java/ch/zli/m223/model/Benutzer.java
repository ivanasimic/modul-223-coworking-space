package ch.zli.m223.model;

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
  private Rollen rollen;
}
