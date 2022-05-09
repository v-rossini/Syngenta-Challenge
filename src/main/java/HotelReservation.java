import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import models.Reservation;
import models.enums.ClientType;
import repositories.DefaultHotelRepository;
import repositories.IHotelRepository;
import services.ReservationService;
import utils.InputParser;
import utils.DateParser;

public class HotelReservation {
    IHotelRepository hotelRepository = new DefaultHotelRepository();

    public String getCheapestHotel (String input) {

        ReservationService reservationService = new ReservationService();

        ClientType clientType = null;
        List<Date> dateList = new ArrayList<>();

        for(String date : InputParser.parseDateList(input)){
            try{
                dateList.add(DateParser.parseDate(date));
            }
            catch (Exception e){  
            }
        }

        try {
            clientType = InputParser.parseClientType(input);
        }
        catch (Exception e) {
        }

        if (clientType != null && !dateList.isEmpty())
            return reservationService.getBestValueHotelName(new Reservation(clientType, dateList),
            this.hotelRepository.getHotels() );
        
        return "";
    }

}
