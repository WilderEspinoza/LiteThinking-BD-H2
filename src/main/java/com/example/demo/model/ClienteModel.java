package com.example.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentType;
    private Integer numberDocument;
    private String firstName;
    private String secondName;
    private String numberPhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Integer getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(Integer numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
