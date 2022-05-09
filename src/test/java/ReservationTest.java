import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import models.Hotel;
import models.Reservation;
import models.enums.ClientType;
import services.ReservationService;

public class ReservationTest {

    private Hotel hotel1;
    private Hotel hotel2;
    private Hotel hotel3;
    private Reservation reservation;


    @Before
    public void setUp() {
        hotel1 = new Hotel("hotel 1", 3, new BigDecimal("100.0"), new BigDecimal("120.0") 
                            , new BigDecimal("150.0") , new BigDecimal("100.0"));

        //same values, higher rating
        hotel2 = new Hotel("hotel 2", 4, new BigDecimal("100.0"), new BigDecimal("120.0") 
                            , new BigDecimal("150.0") , new BigDecimal("100.0"));
        
        //same rating, strictly more expensive
        hotel3 = new Hotel("hotel 3", 3, new BigDecimal("110.0"), new BigDecimal("130.0") 
                            , new BigDecimal("160.0") , new BigDecimal("110.0"));


        List<Date> dateList = new ArrayList<>();
        
        dateList.add( new GregorianCalendar(2022, Calendar.MAY, 7).getTime());
        dateList.add( new GregorianCalendar(2022, Calendar.MAY, 8).getTime());
        dateList.add( new GregorianCalendar(2022, Calendar.MAY, 9).getTime());

       reservation = new Reservation(ClientType.REGULAR, dateList);       
    }

    @Test
    public void shouldReturnTheCheapestOption() {
        List<Hotel> hotelList = new ArrayList<>();

        hotelList.add(hotel1);
        hotelList.add(hotel3);

        ReservationService service = new ReservationService();
        assertEquals("hotel 1", service.getBestValueHotelName(reservation, hotelList));
    
    }

    @Test
    public void shouldBreakTiesByHigherRating() {
        List<Hotel> hotelList = new ArrayList<>();

        hotelList.add(hotel1);
        hotelList.add(hotel2);

        ReservationService service = new ReservationService();
        assertEquals("hotel 2", service.getBestValueHotelName(reservation, hotelList));
    
    }

}
