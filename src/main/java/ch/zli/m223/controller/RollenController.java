package ch.zli.m223.controller;


import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.Rollen;
import ch.zli.m223.service.RollenService;

/*
 * @author Ivana Simic
 * @date 22.11.2022
 * Der Controller für die Rollen
 */

@Path("/role")
public class RollenController {

   
  @Inject
  RollenService rollenservice;

  @GET
  @RolesAllowed({"administrator"})
  @Produces(MediaType.APPLICATION_JSON)   
  public List<Rollen> getRole() {
      return rollenservice.findAll();
  }

  @Path("/{id}")
  @GET
  @RolesAllowed({"administrator"})
  @Produces(MediaType.APPLICATION_JSON)
  public Rollen getOneRole(@PathParam("id") Long id) {
      return rollenservice.findId(id);
  }

  @POST
  @RolesAllowed({"administrator"})
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Rollen create(Rollen role) {
      return rollenservice.create(role);
  }
  
}
