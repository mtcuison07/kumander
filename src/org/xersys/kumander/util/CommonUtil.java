package org.xersys.kumander.util;

import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CommonUtil {
    /**
     * Gets the name of the computer.
     * 
     * @return the computer name.
     */
    public static String getPCName(){
        try{
            return InetAddress.getLocalHost().getHostName();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String[] splitName(String fsName){
        String laNames[] = {"", "", ""};
        fsName = fsName.trim();

        if(fsName.length() > 0){
            String laNames1[] = fsName.split(",");
            laNames[0] = laNames1[0].trim();
            laNames[1] = laNames1[1].trim();
            
            if(laNames1.length > 1){
                String lsFrstName = laNames1[1].trim();
                
                if(lsFrstName.length() > 0){
                    laNames1 = lsFrstName.split("»");
                    laNames[1] = laNames1[0];
                    
                    if(laNames1.length > 1)
                        laNames[2] = laNames1[1];
                    }       
                }

            if(laNames[0].trim().length() == 0)
                laNames[0] = "%";
            if(laNames[1].trim().length() == 0)
                laNames[1] = "%";
            if(laNames[2].trim().length() == 0)
                laNames[2] = "%";
        }
        return laNames;
    }
    
    public static Object createInstance(String classname){
        Class<?> x;
        Object obj = null;
        
        try {
            x = Class.forName(classname);
            obj = x.newInstance();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        
        return obj;
    }
    
    public static int getRandom(int num){
        Random rand = new Random();
        return rand.nextInt(num) + 1;
    }
    
    public static int getRandom(int fnLow, int fnHigh){
        Random r = new Random();
        return r.nextInt(fnHigh - fnLow) + fnLow;
    }
    
    public static Date dateAdd(Date date, int toAdd){
        return dateAdd(date, Calendar.DATE, toAdd);
    }
   
    public static Date dateAdd(Date date, int field, int toAdd){
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        c1.add(field, toAdd);
        return c1.getTime();
    }
    
    public static String StringToHex(String str) {
        char[] chars = Hex.encodeHex(str.getBytes(StandardCharsets.UTF_8));

        return String.valueOf(chars);
    }
    
    public static String HexToString(String hex) {
        String result = "";
        try {
            byte[] bytes = Hex.decodeHex(hex);
            result = new String(bytes, StandardCharsets.UTF_8);
        } catch (DecoderException e) {
            throw new IllegalArgumentException("Invalid Hex format!");
        }
        return result;
    }
    
    public static String SerializeNumber(long value){
        return Dec2Radix(value, 36);
    }
    
    public static String SerializeNumber(long value, int number){
        return Dec2Radix(value, number);
    }
    
    public static long DeSerializeNumber(String value){
        return Radix2Dec(value, 36);
    }
    
    public static long DeSerializeNumber(String value, int number){
        return Radix2Dec(value, number);
    }
    
    private static String Dec2Radix(long value, int radix){
        return Long.toString(value, radix).toUpperCase();
    }
    
    private static long Radix2Dec(String value, int radix){
        return Long.parseLong(value, radix);
    }
    
    public static long dateDiff(Date date1, Date date2){
        return (date1.getTime() - date2.getTime()) / (1000 * 60 * 60 * 24);
    }
}
