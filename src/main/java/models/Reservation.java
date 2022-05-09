package models;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import models.enums.ClientType;

public class Reservation {
    private ClientType clientType;
    private List<Date> dateList;
    
    
    public Reservation(ClientType clientType, List<Date> dateList) {
        this.clientType = clientType;
        this.dateList = dateList.stream().collect(Collectors.toList());
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public List<Date> getDateList() {
        return dateList;
    }

    public void setDateList(List<Date> dateList) {
        this.dateList = dateList;
    }
    

}
