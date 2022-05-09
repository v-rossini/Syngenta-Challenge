package services;

import java.util.List;

import models.Hotel;
import models.Reservation;


public class ReservationService implements IReservationService{



    @Override
    public String getBestValueHotelName(Reservation reservation, List<Hotel> hotelList)
    {
        String bestHotelName = "";
        Integer bestHotelRating = 0;
        double bestValue = Double.POSITIVE_INFINITY;

        for (Hotel hotel : hotelList){ 
            if (hotel.getPriceOfReservation(reservation).doubleValue() < bestValue){
                bestHotelName = hotel.getName();
                bestValue = hotel.getPriceOfReservation(reservation).doubleValue();
                bestHotelRating = hotel.getRating();              
            }
            if (hotel.getPriceOfReservation(reservation).doubleValue() == bestValue
                && hotel.getRating() > bestHotelRating)
            {
                    bestHotelName = hotel.getName();
                    bestValue = hotel.getPriceOfReservation(reservation).doubleValue();
                    bestHotelRating = hotel.getRating();        
            }

        }
        
        return bestHotelName;
    }
    
}
