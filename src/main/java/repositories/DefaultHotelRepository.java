package repositories;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import models.Hotel;

public class DefaultHotelRepository implements IHotelRepository {
    
    private HashMap<String, Hotel> defaultHotels = new HashMap<String, Hotel>();

    public DefaultHotelRepository() {
        this.defaultHotels.put("Lakewood", 
            new Hotel("Lakewood", 3, 
                new BigDecimal("110.00"), new BigDecimal("90.00"),
                new BigDecimal("80.00"), new BigDecimal("80.00") ) );

        this.defaultHotels.put("Bridgewood", 
            new Hotel("Bridgewood", 4, 
                new BigDecimal("160.00"), new BigDecimal("60.00"), 
                new BigDecimal("110.00"), new BigDecimal("50.00") ) );

        this.defaultHotels.put("Ridgewood", 
            new Hotel("Ridgewood", 5, 
                new BigDecimal("220.00"), new BigDecimal("150.00"),
                new BigDecimal("100.00"), new BigDecimal("40.00") ) );

    
    }

    @Override
    public Hotel getHotelByName(String name) {

        return this.defaultHotels.get(name);
    }

    @Override
    public List<String> getHotelNames() {

        return new ArrayList<String>( this.defaultHotels.keySet() );
    }

    @Override
    public List<Hotel> getHotels() {

        return new ArrayList<Hotel>( this.defaultHotels.values() );
    }


    
    
}
