package Odev1;

import java.util.*;

/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 05.04.2023
* <p>
* 	Konsol ekranina yazdirma
* </p>
*/
 

public final class Print 
{
	private Print() {} 
	public static void PrintScreen(String ClassName,Map<String,List<String>> map1,Map<String,List<String>> map2,Map<String,List<String>> map3,Map<String,String>functionName)
	{
		HashSet<String> commonKeys = new HashSet<>(map1.keySet()); 
        
		for (Object key : functionName.keySet()) {
		    commonKeys.add(key.toString()); 
		}

        System.out.println("Sinif: "+ClassName);
        for (String key : functionName.keySet()) 
        {
        	Integer value1=0;
        	Integer value2=0; 
        	Integer	value3 =0;
        	if(map1.containsKey(key)) {
        		 value1 = map1.get(key).size();
        	}
        	if(map2.containsKey(key)) {
       		 	value2 = map2.get(key).size();
        	}
        	if(map3.containsKey(key)) {
       		 	value3 =  map3.get(key).size();
        	}

            System.out.println("\t"+"Fonksiyon: "+key.toString().substring(0,key.toString().indexOf(" ")) 
            		+"\n\t\t"+"Tek Satir Yorum Sayisi:   "+value1
            		+"\n\t\t"+"Cok Satirli Yorum Sayisi: "+value2
            		+"\n\t\t"+"Javadoc Yorum Sayisi:     "+value3+
            		"\n----------------------------------------------");
        }
		
	}

}
 