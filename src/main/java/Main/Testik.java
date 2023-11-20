package Main;

import Request.BookingRequest;
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
    static String checkoutDate = "2056-01-01";
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


    @Test
    public void getNewToken() {
        String token = BookingRequest.getToken(bodyAuth);
        System.out.println("Получили токен: " + token);
    }


    @Test
    public void createCheckBooking() {
        String idBooking = BookingRequest.createBooking(bodyBooking);
        System.out.println("Создали бронирование с id: " + idBooking);
    }

//    @Test
//    public void createUpdateCheckBooking() {
//        String idBooking = BookingRequest.createBooking(bodyBooking);
//        String token = BookingRequest.getToken(bodyAuth);
//        BookingRequest.updateBooking(bodyUpdate, idBooking, token);
//    }
}




