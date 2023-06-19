/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* 	Programin calistirilmasi
* </p>
*/


package Odev3;
import java.util.*;

public class Program {
	public static void main(String[] args) 
	{
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Sayıları girin: ");
			String input = scanner.nextLine();
			String[] numbers = input.split("\\s+");
			
			ArrayList<Integer> sayilar = new ArrayList<>();
			for (int i = 0; i < numbers.length; i++) {
				sayilar.add(Integer.parseInt(numbers[i]));
			} 
      
			Oyun oyun = new Oyun();
			oyun.KoloniUret(sayilar);
			oyun.Tur();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
      
	}
}
  