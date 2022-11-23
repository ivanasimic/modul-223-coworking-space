package ch.zli.m223.controller;


import java.util.List;

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

import ch.zli.m223.model.Serienbuchung;
import ch.zli.m223.service.SerienbuchungService;

@Path("/serienbuchung")
public class SerienbuchungController {

  
  @Inject
  SerienbuchungService serienbuchungService;
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Serienbuchung> getBuchungen() {
      return serienbuchungService.findAll();
  }
  @Path("/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Serienbuchung getOneBuchung(@PathParam("id") Long id) {
      if (id >= 1) {
          return serienbuchungService.findId(id);
      } else {
          throw new IllegalArgumentException("Id should be greater than 1");
      }
  }
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Serienbuchung create(Serienbuchung serienbuchung) {
      return serienbuchungService.create(serienbuchung);
  }
  @Path("/{id}")
  @PUT
  public Serienbuchung update(@PathParam("id") Long id, Serienbuchung serienbuchung) {
      if (id >= 1) {
          return serienbuchungService.update(id, serienbuchung);
      } else {
          throw new IllegalArgumentException("Id should be greater than 1");
      }
  }
  @Path("/{id}")
  @DELETE
  public void delete(@PathParam("id") Long id) {
    serienbuchungService.delete(id);
  }
  
}
