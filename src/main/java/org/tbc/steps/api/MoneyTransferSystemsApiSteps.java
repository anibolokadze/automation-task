package org.tbc.steps.api;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.tbc.data.Constants;
import org.tbc.models.TransferSystems;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.emptyOrNullString;

public class MoneyTransferSystemsApiSteps {
    private Response response;
    private List<TransferSystems> transferSystems;
    public MoneyTransferSystemsApiSteps getTransferSystems(){
        response = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .accept(ContentType.JSON)
                .when()
                .get(Constants.PATH_MONEY_TRANSFERS);
        return this;
    }

    public MoneyTransferSystemsApiSteps deserializeTransferSystems(){
        this.transferSystems = Arrays.asList(response.as(TransferSystems[].class));
        return this;
    }

    public List<String> getTransferSystemsNames(){
        List<String> names = transferSystems.stream()
                .map(TransferSystems::getName)
                .toList();
        return names;
    }

    public List<String> getTransferSystemsCurrencies(){
        List<String> currencies = transferSystems.stream()
                .map(t -> "currency - " + String.join("/", t.getCurrencies()))
                .toList();
        return currencies;
    }

    public MoneyTransferSystemsApiSteps assertField(){
        response.then()
                .assertThat()
                .statusCode(200)
                .body("name", everyItem(not(emptyOrNullString())));
        return this;
    }

}
