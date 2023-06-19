/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* 	Taktik turu
* </p>
*/

package Odev3;

import java.util.Random;

public class ATaktik implements Taktik
{

	public ATaktik()
	{
		
	}
	
	@Override
	public int Savas(int populasyon)
	{  	
		Random random = new Random();
		int randomNumber=-1;
 
		if(populasyon>=500)
			randomNumber= random.nextInt(201)+800;
		else if(populasyon>=250&&populasyon<500)
			randomNumber= random.nextInt(201)+600;
		else if(populasyon>=100&&populasyon<250)
			randomNumber= random.nextInt(201)+400;

		else if(populasyon<100)
			randomNumber= random.nextInt(201);
		
		return randomNumber;
	}
	

}
 