import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import models.Hotel;
import models.Reservation;
import models.enums.ClientType;

public class HotelTest {
    private Hotel hotel1;

    @Before
    public void setUp() {
        hotel1 = new Hotel("hotel 1", 3, new BigDecimal("100.0"), new BigDecimal("120.0") 
                            , new BigDecimal("150.0") , new BigDecimal("100.0"));
    }


    @Test
    public void ShouldGetTheCorrectRatingForRegularWeekday() {
        assertEquals(new BigDecimal("100.0"), hotel1.getPriceOfDay(ClientType.REGULAR, new GregorianCalendar(2022, Calendar.MAY, 9).getTime()));
    }

    @Test
    public void ShouldGetTheCorrectRatingForRegularWeekend() {
        assertEquals(new BigDecimal("120.0"), hotel1.getPriceOfDay(ClientType.REGULAR, new GregorianCalendar(2022, Calendar.MAY, 8).getTime()));
    }

    @Test
    public void ShouldGetTheCorrectRatingForRewardsWeekday() {
        assertEquals(new BigDecimal("150.0"), hotel1.getPriceOfDay(ClientType.REWARDS, new GregorianCalendar(2022, Calendar.MAY, 9).getTime()));
    }

    @Test
    public void ShouldGetTheCorrectRatingForRewardsWeekend() {
        assertEquals(new BigDecimal("100.0"), hotel1.getPriceOfDay(ClientType.REWARDS, new GregorianCalendar(2022, Calendar.MAY, 8).getTime()));
    }


    @Test
    public void shouldGetCorrectValueForReservation() {
        List<Date> dateList = new ArrayList<>();
        
        dateList.add( new GregorianCalendar(2022, Calendar.MAY, 8).getTime());
        dateList.add( new GregorianCalendar(2022, Calendar.MAY, 9).getTime());

       Reservation reservation = new Reservation(ClientType.REGULAR, dateList);

        assertEquals(new BigDecimal("220.0"), hotel1.getPriceOfReservation(reservation));
    }



}
