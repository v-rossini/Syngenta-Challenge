package services;

import java.util.List;

import models.Hotel;
import models.Reservation;


public interface IReservationService {
    public String getBestValueHotelName(Reservation reservation, List<Hotel> hotelList);
}
