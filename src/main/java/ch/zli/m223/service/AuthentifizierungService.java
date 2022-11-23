package ch.zli.m223.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.eclipse.microprofile.jwt.JsonWebToken;
import ch.zli.m223.model.Benutzer;
import io.smallrye.jwt.build.Jwt;


@ApplicationScoped
public class AuthentifizierungService {
@Inject
EntityManager entitymanager;

@Inject
BenutzerService benutzerservice;

@Inject
JsonWebToken jwt;

@Transactional
public String find(String email, String passwort) {
    List<Benutzer> benutzers = benutzerservice.findAll();
    String jwt = "";
    for (Benutzer benutzer : benutzers) {
        if (benutzer.getEmail().equals(email) && benutzer.getPasswort().equals(passwort)) {
            String token = Jwt.issuer("https://example.com/issuer")
                    .upn(benutzer.getEmail())
                    .groups(benutzer.getRollen().getName())
                    .expiresIn(Integer.MAX_VALUE)
                    .sign();
            return jwt = token;
        }
    }
    throw new IllegalArgumentException("Passwort oder E-Mail stimmt nicht");
}
}
