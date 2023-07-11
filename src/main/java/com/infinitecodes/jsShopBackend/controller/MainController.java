package com.infinitecodes.jsShopBackend.controller;

import com.infinitecodes.jsShopBackend.dao.ProduktRepository;
import com.infinitecodes.jsShopBackend.dao.UserRepository;
import com.infinitecodes.jsShopBackend.model.Produkt;
import com.infinitecodes.jsShopBackend.model.User;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class MainController {

    @Autowired
    private ProduktRepository produktRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/adduser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> neuenUserAnlegen(@RequestBody String responseFromClient) {
        
        JSONObject json = new JSONObject(responseFromClient);
        String jsonString = "";

        User u = new User();
        List<User> userFiltered = userRepository.findByEmail(json.getString("email"));

        u.setU_Vorname(json.getString("vorname"));
        u.setU_Nachname(json.getString("nachname"));
        u.setU_Geburtsdatum(json.getString("geburtsdatum"));
        u.setU_Adresse(json.getString("adresse"));
        u.setU_Hausnummer(json.getInt("hausnummer"));
        u.setU_PLZ(json.getInt("plz"));
        u.setU_Ort(json.getString("ort"));
        u.setU_Email(json.getString("email"));
        u.setU_Nutzername(json.getString("username"));
        u.setU_Passwort(json.getString("password"));

        if (!userFiltered.isEmpty()) {
            jsonString = new JSONObject().put("isRegistered", "true").toString();
        }
        else {
            jsonString = new JSONObject().put("registeredSuccessfully", "true").toString();
            userRepository.save(u);
        }

        return new ResponseEntity<String>(jsonString, HttpStatus.OK);
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<String> userEinloggen(@RequestBody String responseFromClient) {

        JSONObject json = new JSONObject(responseFromClient);
        String jsonString = "";

        User u = new User();
        List<User> userFiltered = userRepository.findByEmail(json.getString("email"));

        u.setU_Vorname(json.getString("vorname"));
        u.setU_Nachname(json.getString("nachname"));
        u.setU_Geburtsdatum(json.getString("geburtsdatum"));
        u.setU_Adresse(json.getString("adresse"));
        u.setU_Hausnummer(json.getInt("hausnummer"));
        u.setU_PLZ(json.getInt("plz"));
        u.setU_Ort(json.getString("ort"));
        u.setU_Email(json.getString("email"));
        u.setU_Nutzername(json.getString("username"));
        u.setU_Passwort(json.getString("password"));

        if (userFiltered.isEmpty()) {
            jsonString = new JSONObject().put("isRegistered", "false").toString();
        }
        else if (userFiltered.get(0).getU_Passwort().equals(json.getString("password"))) {
            jsonString = new JSONObject().put("doesItWork", "true").toString();
            System.out.println("it works!");
        }
        
        return new ResponseEntity<String>(jsonString, HttpStatus.OK);
    }


    @PostMapping(path = "/addproduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String neuesProduktAnlegen(@RequestBody String responseFromClient) {
        
        JSONObject json = new JSONObject(responseFromClient);

        Produkt p = new Produkt();
        p.setP_Artikelnummer(json.getInt("artikelnummer"));
        p.setP_Produktname(json.getString("produktname"));
        p.setP_Produktpreis(json.getInt("produktpreis"));
        p.setP_Hersteller(json.getString("hersteller"));
        p.setP_Bild(json.getString("bildpfad"));

        produktRepository.save(p);
        
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody List<Produkt> alleProdukteAusgeben() {
        // curl infinitecodes.de:8080/api/all
        return produktRepository.findAll();
    }
}
