
/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* 	Konsola yazdirma
* </p>
*/

package Odev3;
import java.util.*;

public class Yazdir 
{
	public static void Yaz(ArrayList<Koloni> koloniler,int tur)
	{
		System.out.println("------------------------------------------------");
        System.out.printf("Tur Sayisi:%d%n", tur);
        System.out.printf("%-10s%-15s%-15s%-10s%-10s%n", "Koloni", "Populasyon", "YemekStogu", "Kazanma", "Kaybetme");


        for (int i = 0; i < koloniler.size(); i++) {
            if (koloniler.get(i).YasiyorMu()) {
                System.out.printf("%-10c%-15d%-15d%-10d%-10d%n",
                        koloniler.get(i).sembol,
                        koloniler.get(i).populasyon,
                        koloniler.get(i).yemekStogu,
                        koloniler.get(i).kazanmaSayisi,
                        koloniler.get(i).kaybetmeSayisi);
            } else {
                System.out.printf("%-10c%-15s%-15s%-10s%-10s%n",
                		koloniler.get(i).sembol,
                        "--",
                        "--",
                        "--",
                        "--");
            }
        }

        System.out.println("------------------------------------------------");
		
	}

}
