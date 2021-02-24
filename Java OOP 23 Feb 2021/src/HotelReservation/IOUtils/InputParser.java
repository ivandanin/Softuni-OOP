package HotelReservation.IOUtils;

public class InputParser {

    public static String[] parseArray(String input, String pattern) {
        return input.split(pattern);
    }
}
