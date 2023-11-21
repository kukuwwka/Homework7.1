package Request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BookingRequest {
    static String baseUrl = "https://restful-booker.herokuapp.com/";

    public static Response createToken(String bodyAuth) {
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
                .response();
    }

    public static void getBookingID(String idBooking) {
         RestAssured.given()
                .baseUri(baseUrl + "booking/" + idBooking)
                .when()
                .get(baseUrl + "booking/" + idBooking)
                .then()
                .extract()
                .response();
    }
    public static Response createBooking(String bodyBooking) {
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
                .response();
    }

    public static Response updateBooking(String bodyUpdate, String checkoutDate, String idBooking, String token) {
        return RestAssured.given()
                .given().header("Cookie", "token=" + token)
                .baseUri(baseUrl + "booking/" + idBooking)
                .body(bodyUpdate)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .put(baseUrl + "booking/" + idBooking)
                .then().
                statusCode(200)
                .log()
                .body()
                .extract()
                .response();
    }

    public static Response deleteBooking(String bodyAuth, String idBooking, String token) {
        return RestAssured.given()
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

