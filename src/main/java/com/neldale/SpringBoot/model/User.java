package com.neldale.SpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    @JsonIgnore
    private String password;
    @Column(nullable = false,name = "Prenom")
    private String Prenom;
    @Column(nullable = false,name = "Nom")
    private String Nom;
    @Column(nullable = false,name = "Telephone")
    private String Telephone;
    @Column(nullable = false,name = "Adresse")
    private String Adresse;
    @Column(nullable = true,name = "Image")
    private String Image;
    @Column(nullable = true,name = "Statut")
    private String Statut;
    @Column(nullable = false,name = "Roles")
    private String Roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String statut) {
        Statut = statut;
    }

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String roles) {
        Roles = roles;
    }

    public User(String username, String password, String prenom, String nom, String telephone, String adresse, String image, String statut, String roles) {
        this.username = username;
        this.password = password;
        Prenom = prenom;
        Nom = nom;
        Telephone = telephone;
        Adresse = adresse;
        Image = image;
        Statut = statut;
        Roles = roles;
    }
    public User(){}

}
