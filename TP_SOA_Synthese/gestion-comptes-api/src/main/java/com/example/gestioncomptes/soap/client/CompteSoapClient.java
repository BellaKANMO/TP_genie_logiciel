package com.example.gestioncomptes.soap.client;

import com.example.gestioncomptes.soap.generated.GetCategorieCompteRequest;
import com.example.gestioncomptes.soap.generated.GetCategorieCompteResponse;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class CompteSoapClient {

    private final WebServiceTemplate webServiceTemplate;

    public CompteSoapClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public GetCategorieCompteResponse getCategorie(String numeroCompte, Double solde) {
        GetCategorieCompteRequest request = new GetCategorieCompteRequest();
        request.setNumeroCompte(numeroCompte);
        request.setSolde(solde);
        return (GetCategorieCompteResponse) webServiceTemplate
                .marshalSendAndReceive("http://localhost:8080/ws", request);
    }
}
