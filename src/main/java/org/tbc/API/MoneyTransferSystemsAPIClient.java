package org.tbc.API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.tbc.data.Constants;

public class MoneyTransferSystemsAPIClient {
    private Response response;

    public MoneyTransferSystemsAPIClient getTransferSystems() {
        response = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .accept(ContentType.JSON)
                .when()
                .get(Constants.PATH_MONEY_TRANSFERS);
        return this;
    }
    public Response getResponse() {
        return response;
    }
}
