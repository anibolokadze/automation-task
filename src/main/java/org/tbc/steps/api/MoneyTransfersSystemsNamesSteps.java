package org.tbc.steps.api;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.tbc.data.Constants;
import org.tbc.models.TransferSystems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.emptyOrNullString;

public class MoneyTransfersSystemsNamesSteps {
    private Response response;
    private List<TransferSystems> transferSystems;
    public MoneyTransfersSystemsNamesSteps getTransferSystems(){
        response = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .accept(ContentType.JSON)
                .when()
                .get("/api/v1/moneyTransfer/systems?locale=ka-GE");
        return this;
    }

    public MoneyTransfersSystemsNamesSteps deserializeTransferSystems(){
        this.transferSystems = Arrays.asList(response.as(TransferSystems[].class));
        return this;
    }

    public List<String> getTransferSystemsNames(){
        return transferSystems.stream()
                .map(TransferSystems::getName)
                .collect(Collectors.toList());
    }

    public MoneyTransfersSystemsNamesSteps assertField(){
        response.then()
                .assertThat()
                .statusCode(200)
                .body("name", everyItem(not(emptyOrNullString())));
        return this;
    }
}
