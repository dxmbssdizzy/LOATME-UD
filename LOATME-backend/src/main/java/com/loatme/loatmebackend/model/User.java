package com.loatme.loatmebackend.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Email(message = "Correo electrónico inválido")
    @NotBlank(message = "El correo electrónico es obligatorio")
    private String email;

    @Min(value = 1, message = "La edad debe ser mayor o igual a 1")
    private int age;

    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    public User() {
    }

    public User(String name, String email, int age, String password) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
