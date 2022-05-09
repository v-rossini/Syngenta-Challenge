package models;

import java.math.BigDecimal;
import java.util.Date;

import models.enums.ClientType;
import utils.DateUtil;


public class Hotel {
    private String name;
    private Integer rating;
    private BigDecimal weekdayRegularRating;
    private BigDecimal weekendRegularRating;
    private BigDecimal weekdayRewardsRating;
    private BigDecimal weekendRewardsRating;


    public Hotel(String name, Integer rating, BigDecimal weekdayRegularRating, BigDecimal weekendRegularRating,
            BigDecimal weekdayRewardsRating, BigDecimal weekendRewardsRating) {
        this.name = name;
        this.rating = rating;
        this.weekdayRegularRating = weekdayRegularRating;
        this.weekendRegularRating = weekendRegularRating;
        this.weekdayRewardsRating = weekdayRewardsRating;
        this.weekendRewardsRating = weekendRewardsRating;
    }

    public BigDecimal getPriceOfDay(ClientType client, Date date) {
        if (DateUtil.isWeekend(date) && client == ClientType.REWARDS){
            return this.getWeekendRewardsRating();
        }
        if (!DateUtil.isWeekend(date) && client == ClientType.REWARDS){
            return this.getWeekdayRewardsRating();
        }
        if (DateUtil.isWeekend(date) && client == ClientType.REGULAR){
            return this.getWeekendRegularRating();
        }
        
        return this.getWeekdayRegularRating();  
    }

    public BigDecimal getPriceOfReservation(Reservation reservation) {
        BigDecimal totalValue = new BigDecimal("0.0");

        for (Date date: reservation.getDateList())
            totalValue = totalValue.add(
                    this.getPriceOfDay(reservation.getClientType(), date));
        
        return totalValue;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Integer getRating() {
        return rating;
    }


    public void setRating(Integer rating) {
        this.rating = rating;
    }


    public BigDecimal getWeekdayRegularRating() {
        return weekdayRegularRating;
    }


    public void setWeekdayRegularRating(BigDecimal weekdayRegularRating) {
        this.weekdayRegularRating = weekdayRegularRating;
    }


    public BigDecimal getWeekendRegularRating() {
        return weekendRegularRating;
    }


    public void setWeekendRegularRating(BigDecimal weekendRegularRating) {
        this.weekendRegularRating = weekendRegularRating;
    }


    public BigDecimal getWeekdayRewardsRating() {
        return weekdayRewardsRating;
    }


    public void setWeekdayRewardsRating(BigDecimal weekdayRewardsRating) {
        this.weekdayRewardsRating = weekdayRewardsRating;
    }


    public BigDecimal getWeekendRewardsRating() {
        return weekendRewardsRating;
    }


    public void setWeekendRewardsRating(BigDecimal weekendRewardsRating) {
        this.weekendRewardsRating = weekendRewardsRating;
    }
 
}
