package org.kaspars.pasakumaBE.controller;

import java.util.List;

import org.kaspars.pasakumaBE.Services.UserServices;
import org.kaspars.pasakumaBE.model.UserDTO;
import org.kaspars.pasakumaBE.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // Lai spring boot zinatu ka tas ir kontrolieris
@AllArgsConstructor
@RequestMapping("/api/v1")

// jāraksta metode, kas pievieno lietotāju. Ķer, ienākošo trafiku un nodod to
// servisam
// CRUD operatori - Create, Read, Update, Delete
// POST, GET, PUT, DELETE - šor raksta frontendā

public class UserController {
    private final UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserModel user) {
        try {
            UserDTO userDTO = userServices.findOrSaveUser(user);
            if (userDTO == null) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (Exception _) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/user")
    // public List<UserModel> getAllUsers() { // @RequestParam(required = false)
    // String name
    // return userServices.getAllUsers(); // name
    // }
}
