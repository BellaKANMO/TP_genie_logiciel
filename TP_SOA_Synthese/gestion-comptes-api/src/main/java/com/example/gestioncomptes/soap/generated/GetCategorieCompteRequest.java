package com.example.gestioncomptes.soap.generated;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getCategorieCompteRequest", namespace = "http://example.com/soap/compte")
@XmlType(name = "", namespace = "http://example.com/soap/compte", propOrder = {"numeroCompte", "solde"})
public class GetCategorieCompteRequest {

    @XmlElement(namespace = "http://example.com/soap/compte", required = true)
    private String numeroCompte;

    @XmlElement(namespace = "http://example.com/soap/compte")
    private double solde;
}
