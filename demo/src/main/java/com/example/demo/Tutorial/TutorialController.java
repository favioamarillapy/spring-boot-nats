/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Tutorial;

import io.nats.client.Connection;
import io.nats.client.Nats;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Favio Amarilla
 */
@CrossOrigin(origins = "*")
@RestController
@Slf4j
public class TutorialController {

    @GetMapping("/nats")
    public ResponseEntity<String> createTutorial() {
        try {
            Connection nc = Nats.connect();
            nc.publish("example", "Message from NATs".getBytes(StandardCharsets.UTF_8));
            nc.close();

            return new ResponseEntity<>("", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
