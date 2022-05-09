package repositories;

import java.util.List;
import models.Hotel;

public interface IHotelRepository {
    Hotel getHotelByName(String name);
    List<String> getHotelNames();
    List<Hotel> getHotels();
}
