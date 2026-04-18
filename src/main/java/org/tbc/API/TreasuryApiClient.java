package org.tbc.API;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.tbc.data.Constants;


public class TreasuryApiClient {
    private Response response;

    public TreasuryApiClient getTreasuryRates() {
        response = RestAssured.given()
                .baseUri(Constants.BASE_URL)
                .accept(ContentType.JSON)
                .when()
                .get(Constants.PATH_TREASURY_PRODUCTS);
        return this;
    }

    public Response getResponse() {
        return response;
    }
}
