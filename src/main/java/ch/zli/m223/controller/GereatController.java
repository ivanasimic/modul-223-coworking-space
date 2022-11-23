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

import ch.zli.m223.model.Gereat;
import ch.zli.m223.service.GereatService;

@Path("/gereat")
public class GereatController {

  @Inject
  GereatService gereatService;
  @GET
  @RolesAllowed({"mitglied", "administrator"})
  @Produces(MediaType.APPLICATION_JSON)
  public List<Gereat> getBuchungen() {
      return gereatService.findAll();
  }
  @Path("/{id}")
  @GET
  @RolesAllowed({"mitglied", "administrator"})
  @Produces(MediaType.APPLICATION_JSON)
  public Gereat getOneBuchung(@PathParam("id") Long id) {
      if (id >= 1) {
          return gereatService.findId(id);
      } else {
          throw new IllegalArgumentException("Id should be greater than 1");
      }
  }
  @POST
  @RolesAllowed({"mitglied", "administrator"})
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Gereat create(Gereat buchung) {
      return gereatService.create(buchung);
  }
  @Path("/{id}")
  @PUT
  @RolesAllowed({"mitglied", "administrator"})
  public Gereat update(@PathParam("id") Long id, Gereat buchung) {
      if (id >= 1) {
          return gereatService.update(id, buchung);
      } else {
          throw new IllegalArgumentException("Id should be greater than 1");
      }
  }
  @Path("/{id}")
  @DELETE
  @RolesAllowed({"mitglied", "administrator"})
  public void delete(@PathParam("id") Long id) {
    gereatService.delete(id);
  }
  
}
