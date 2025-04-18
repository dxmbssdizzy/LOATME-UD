package com.loatme.loatmebackend.controller;

import com.loatme.loatmebackend.model.User;
import com.loatme.loatmebackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        boolean registered = userService.registerUser(user);
        if (!registered) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo electrónico ya está registrado.");
        }
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
        boolean authenticated = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        if (!authenticated) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo electrónico o contraseña incorrectos.");
        }
        return ResponseEntity.ok("Inicio de sesión exitoso.");
    }
}
