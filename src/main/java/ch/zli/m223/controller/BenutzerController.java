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

import ch.zli.m223.model.Benutzer;
import ch.zli.m223.service.BenutzerService;

/*
 * @author Ivana Simic
 * @date 23.11.2022
 * Der Controller für die Benutzer
 */

@Path("/benutzer")
public class BenutzerController {

  @Inject
  BenutzerService benutzerservice;


  @GET
    @Produces(MediaType.APPLICATION_JSON)  
    public List<Benutzer> getUsers() {
        return benutzerservice.findAll();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Benutzer getOneUser(@PathParam("id") Long id) {
        if (id instanceof Long || id >= 1) {
            return benutzerservice.findId(id);
        } else {
            throw new IllegalStateException(id + "is not a Long or is not equal or greater than 1");
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Benutzer create(Benutzer user) {
        return benutzerservice.create(user);
    }

    @Path("/{id}")
    @PUT
    public Benutzer update(@PathParam("id") Long id, Benutzer user){
        if (id instanceof Long || id >= 1) {
            return benutzerservice.update(id, user);
        } else {
            throw new IllegalStateException(id + "is not a Long or is not equal or greater than 1");
        }
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") Long id) {
      benutzerservice.delete(id);
    }
  
}
