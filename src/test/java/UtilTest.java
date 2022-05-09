import org.junit.Test;

import exceptions.InvalidClientTypeException;
import models.enums.ClientType;
import utils.DateParser;
import utils.DateUtil;
import utils.InputParser;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class UtilTest {

    @Test
    public void shouldParseRegularClientCaseInsensitive() {
        try{
            assertEquals(ClientType.REGULAR, InputParser.parseClientType("regular: 12mar2009, 7oct2014, 08jun2001"));
            assertEquals(ClientType.REGULAR, InputParser.parseClientType("REGULAR: 12mar2009, 7oct2014, 08jun2001"));
            assertEquals(ClientType.REGULAR, InputParser.parseClientType("Regular: 12mar2009, 7oct2014, 08jun2001"));
        }catch (Exception e){
            fail("Should not have thrown exception");
        }      
    }

    @Test
    public void shouldParseRewardsClientCaseInsensitive() {
        try{
            assertEquals(ClientType.REWARDS, InputParser.parseClientType("rewards: 12mar2009, 7oct2014, 08jun2001"));
            assertEquals(ClientType.REWARDS, InputParser.parseClientType("REWARDS: 12mar2009, 7oct2014, 08jun2001"));
            assertEquals(ClientType.REWARDS, InputParser.parseClientType("Rewards: 12mar2009, 7oct2014, 08jun2001"));
        
        }catch (Exception e){
            fail("Should not have thrown exception");
        }      
    }
    
    @Test(expected = InvalidClientTypeException.class)
    public void shouldThrowExceptionWithInvalidClientTypeInput() throws Exception {
        try{
            InputParser.parseClientType("Jorge: 12mar2009, 7oct2014, 08jun2001");
        }catch (Exception e){
            throw e;
        }      
    }

    @Test
    public void shouldGetListOfStringsInTheCorrectFormatFromInput() {
        List<String> dates = new ArrayList<>();
        dates.add("12mar2009");
        dates.add("7oct2014");
        dates.add("08jun2001");

        try{
            assertEquals(dates, InputParser.parseDateList("rewards: 12mar2009, 7oct2014, 08jun2001"));  
        }catch (Exception e){
            fail("Should not have thrown exception");
        }      
    }


    @Test
    public void shouldParseDateFromStringInTheCorrectFormat() throws Exception {
        Date date = new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime(); 
        try{
            assertEquals(date, DateParser.parseDate("11feb2014"));
        }catch (Exception e){
            throw e;
        }      
    }


    @Test(expected = ParseException.class)
    public void shouldThrowExceptionWithInvalidDateInput() throws Exception {
        try{
            DateParser.parseDate("12abril2009");
        }catch (Exception e){
            throw e;
        }      
    }

    @Test
    public void shouldReturnTrueIfWeekend()  {
        Date date = new GregorianCalendar(2022, Calendar.MAY, 8).getTime();
        assertTrue(DateUtil.isWeekend(date));    
    }

    @Test
    public void shouldReturnFalseIfNotWeekend()  {
        Date date = new GregorianCalendar(2022, Calendar.MAY, 9).getTime();
        assertFalse(DateUtil.isWeekend(date));    
    }

    
}
