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
  private Long von;

  @Column(nullable = false)
  private Long bis;

  @Column(nullable = false)
  private Long zeitinterval;
  
  @ManyToOne
  @JsonIgnore
  private Benutzer benutzer;
  
}
