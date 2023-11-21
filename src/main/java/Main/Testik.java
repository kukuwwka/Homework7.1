package Main;

import Request.BookingRequest;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class Testik {

    static String bodyAuth = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    static String bodyBooking = "{\"firstname\" : \"Jim\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"}";
    static String checkoutDate = "\"2056-01-01\"";
    static String bodyUpdate = "{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : " + checkoutDate + "\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

// Positive tests
    @Test
    public void getNewToken() {
        String token = BookingRequest.getToken(bodyAuth).jsonPath().getString("token");
        System.out.println("Получили токен: " + token);
    }


    @Test
    public void createCheckBooking() {
        String idBooking = BookingRequest.createBooking(bodyBooking).jsonPath().getString("bookingid");
        System.out.println("Создали бронирование с id: " + idBooking);
    }

    @Test
    public void createUpdateCheckBooking() {
        String token = BookingRequest.getToken(bodyAuth).jsonPath().getString("token");
        System.out.println("Получили токен: " + token);

        String idBooking = BookingRequest.createBooking(bodyBooking).jsonPath().getString("bookingid");
        System.out.println("Создали бронирование с id: " + idBooking);

        BookingRequest.updateBooking(bodyUpdate, checkoutDate, idBooking, token);
        System.out.println("Обновили дату бронирования: " + checkoutDate);
    }

    @Test
    public void createDeleteCheckBooking() {
        String token = BookingRequest.getToken(bodyAuth).jsonPath().getString("token");
        System.out.println("Получили токен: " + token);

        String idBooking = BookingRequest.createBooking(bodyBooking).jsonPath().getString("bookingid");
        System.out.println("Создали бронирование с id: " + idBooking);

        BookingRequest.deleteBooking(bodyAuth, idBooking, token);
        System.out.println("Удалили бронирование с id: " + idBooking);
        }
    //Negative tests

//    @Test
//    public void negativeGetToken() {
//        String token = BookingRequest.getToken(bodyAuth).jsonPath().getString("token");
//        Response response = BookingRequest.getToken(bodyAuth);
//        Assert.assertEquals(400, response.statusCode());
//    }
}




