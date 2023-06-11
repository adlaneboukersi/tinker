package com.example.pfev2;

public class employé {

    private String nom , prenom , mail , password, numero , service , wilaya ;
    private float rating ;
    private int numrate;

    public employé(String nom, String prenom, String mail, String password, String numero, String service, String wilaya ,float rating,int numrate) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
        this.numero = numero;
        this.service = service;
        this.wilaya = wilaya;
        this.rating = rating;
        this.numrate = numrate;
    }

    public employé() {

    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getWilaya() {
        return wilaya;
    }

    public void setWilaya(String wilaya) {
        this.wilaya = wilaya;
    }

    public int getNumrate() { return numrate; }

    public void setNumrate(int numrate) { this.numrate = numrate; }
}
