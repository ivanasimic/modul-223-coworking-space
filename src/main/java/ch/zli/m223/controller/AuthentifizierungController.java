package ch.zli.m223.controller;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.model.Benutzer;
import ch.zli.m223.service.AuthentifizierungService;
import ch.zli.m223.service.BenutzerService;

@Path("/authentifizierung")
public class AuthentifizierungController {
  @Inject
  BenutzerService benutzerservice;

  @Inject
  AuthentifizierungService authentifizierungService;


  
   //Login 
   @Path("/anmelden")
   @POST
   @PermitAll
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public String login(@QueryParam("e-mail")String email, @QueryParam("passwort") String passwort) {
       return authentifizierungService.find(email, passwort);
   }
   //Register
   @Path("/registrieren")
   @POST
   @PermitAll
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public Benutzer create(Benutzer benutzer) {
       return benutzerservice.create(benutzer);
   }


}
