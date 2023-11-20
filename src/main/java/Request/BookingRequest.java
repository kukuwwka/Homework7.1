package Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BookingRequest {
    static String baseUrl = "https://restful-booker.herokuapp.com/";

    public static String getToken(String bodyAuth) {
        return RestAssured.given()
                .baseUri(baseUrl + "auth")
                .body(bodyAuth)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .post(baseUrl + "auth")
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response().jsonPath().getString("token");
    }

    public static String createBooking(String bodyBooking) {
        return RestAssured.given()
                .baseUri(baseUrl + "booking")
                .body(bodyBooking)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .post(baseUrl + "booking")
                .then()
                .statusCode(200)
                .log()
                .body()
                .extract()
                .response().jsonPath().getString("bookingid");
    }

    public static String updateBooking(String bodyUpdate, String idBooking, String token) {
        return RestAssured.given()
                .given().header("Cookie", "token=" + token)
                .baseUri(baseUrl + "booking/" + idBooking)
                .body(bodyUpdate)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .put(baseUrl + "booking/" + idBooking)
                .then()
                .log()
                .body()
                .extract()
                .response().jsonPath().getString("checkout");
    }

    public static void deleteBooking(String idBooking, String token) {
        RestAssured.given()
                .given().header("Cookie", "token=" + token)
                .baseUri(baseUrl + "booking/" + idBooking)
                .when()
                .contentType(ContentType.JSON)
                .delete(baseUrl + "booking/" + idBooking)
                .then()
                .log()
                .body()
                .statusCode(201)
                .extract()
                .response();
    }
}

