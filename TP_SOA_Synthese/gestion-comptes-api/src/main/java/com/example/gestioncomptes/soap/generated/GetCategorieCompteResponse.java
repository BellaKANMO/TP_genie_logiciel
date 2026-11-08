package com.example.gestioncomptes.soap.generated;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "getCategorieCompteResponse", namespace = "http://example.com/soap/compte")
@XmlType(name = "", namespace = "http://example.com/soap/compte", propOrder = {"categorie", "message"})
public class GetCategorieCompteResponse {

    @XmlElement(namespace = "http://example.com/soap/compte", required = true)
    private String categorie;

    @XmlElement(namespace = "http://example.com/soap/compte", required = true)
    private String message;
}
