package main.java.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String extractNumberFromString(String text) {
        
        String numberFound = "";
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(text);

        if(m.find()) {
           numberFound = m.group();
        }
        return numberFound;
    }

}
