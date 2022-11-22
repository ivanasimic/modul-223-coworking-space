package ch.zli.m223.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

/*
 * @author Ivana Simic
 * @date 22.11.2022
 * Die Klasse für das Mittagsmenü
 */

@Entity
public class Mittagsmenue {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private String menue;



  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMenue() {
    return this.menue;
  }

  public void setMenue(String menue) {
    this.menue = menue;
  }


}
