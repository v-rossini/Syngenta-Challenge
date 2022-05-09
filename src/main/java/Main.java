
public class Main {
    public static void main(String[] args) {
        HotelReservation hotelReservation = new HotelReservation();

        StringBuilder rawInput = new StringBuilder();
        
            for (String arg : args)
                rawInput.append(arg);
            
            System.out.println( hotelReservation.getCheapestHotel(rawInput.toString()));
        }        
}