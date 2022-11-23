package ch.zli.m223.controller;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.Mittagsmenue;
import ch.zli.m223.service.MittagsmenueService;

@Path("/mittagsmenue")
public class MittagsmenueController {

   
  @Inject
  MittagsmenueService mittagsmenueService;
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Mittagsmenue> getBuchungen() {
      return mittagsmenueService.findAll();
  }
  @Path("/{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Mittagsmenue getOneBuchung(@PathParam("id") Long id) {
      if (id >= 1) {
          return mittagsmenueService.findId(id);
      } else {
          throw new IllegalArgumentException("Id should be greater than 1");
      }
  }
  
}
