package com.makson.FiscalCodeApp.entity;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "communes")
@Getter
public class Commune {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonSetter(value = "nome")
    @Column(name = "name")
    private String name;
    @JsonSetter(value = "codiceCatastale")
    @Column(name = "codice_catastale")
    private String codiceCatastale;
}
