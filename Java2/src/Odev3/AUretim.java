/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* 	Uretim turu
* </p>
*/

package Odev3;

import java.util.Random;

public class AUretim implements Uretim
{
	public AUretim()
	{
		
	}
	@Override
	public int Uret(int populasyon)
	{
		Random random = new Random();
		int randomNumber=-1;
 
		if(populasyon>=500)
			randomNumber= random.nextInt(3)+8;
		else if(populasyon>=250&&populasyon<500)
			randomNumber= random.nextInt(3)+6;
		else if(populasyon>=100&&populasyon<250)
			randomNumber= random.nextInt(3)+4;

		else if(populasyon<100)
			randomNumber= random.nextInt(3) + 1;
		
		return randomNumber;
	}

}
