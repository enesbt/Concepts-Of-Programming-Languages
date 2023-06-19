package Odev1;

/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 03.04.2023
* <p>
* 	 Rastgele string ifade olusturur
* </p>
*/

import java.util.Random;

public final class RandomString 
{
	public static String generateRandomString(int length, Random random)  //random string olustur
	{
	        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?~\\-``^#$+-/*!^^%|><.,";
	        StringBuilder sb = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length());
	            sb.append(characters.charAt(index));
	        }
	        return sb.toString();
	}

}
 