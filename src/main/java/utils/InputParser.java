package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.InvalidClientTypeException;
import models.enums.ClientType;

public class InputParser {
    
    public static ClientType parseClientType(String rawInput) throws InvalidClientTypeException{

        Pattern regex = Pattern.compile("^(Regular|Rewards)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(rawInput);
        

        if (!matcher.find())
            throw new InvalidClientTypeException(
                "client_type must be 'Regular' or 'Rewards' and appear at the beginning of the input (<client_type>: <date_1>, <date_2>...)");
        
        return matcher.group().toUpperCase().equals("REGULAR") ? ClientType.REGULAR : ClientType.REWARDS;
        }
    
    public static List<String> parseDateList(String rawInput){

        List<String> dateList = new ArrayList<>();
        
        Pattern regex = Pattern.compile("[0-9]{1,2}[a-zA-Z]{3}[0-9]{4}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(rawInput);
        
        while( matcher.find() )
            dateList.add(matcher.group());

        return dateList;
    }
        
            

}
