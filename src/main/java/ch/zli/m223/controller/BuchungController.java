package ch.zli.m223.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.Buchung;
import ch.zli.m223.service.BuchungService;

/*
 * @author Ivana Simic
 * @date 22.11.2022
 * Der Controller für die Buchung
 */


@Path ("/buchung")
public class BuchungController {
  @Inject
  BuchungService buchungService;
  @GET
  @RolesAllowed({"mitglied", "administrator"})
  @Produces(MediaType.APPLICATION_JSON)
  public List<Buchung> getBuchungen() {
      return buchungService.findAll();
  }
  @Path("/{id}")
  @GET
  @RolesAllowed({"mitglied", "administrator"})
  @Produces(MediaType.APPLICATION_JSON)
  public Buchung getOneBuchung(@PathParam("id") Long id) {
      if (id >= 1) {
          return buchungService.findId(id);
      } else {
          throw new IllegalArgumentException("Id should be greater than 1");
      }
  }
  @POST
  @RolesAllowed({"mitglied", "administrator"})
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Buchung create(Buchung buchung) {
      return buchungService.create(buchung);
  }
  @Path("/{id}")
  @PUT
  @RolesAllowed({"administrator"})
  public Buchung update(@PathParam("id") Long id, Buchung buchung) {
      if (id >= 1) {
          return buchungService.update(id, buchung);
      } else {
          throw new IllegalArgumentException("Id should be greater than 1");
      }
  }
  @Path("/{id}")
  @DELETE
  @RolesAllowed({"mitglied", "administrator"})
  public void delete(@PathParam("id") Long id) {
      buchungService.delete(id);
  }
}
