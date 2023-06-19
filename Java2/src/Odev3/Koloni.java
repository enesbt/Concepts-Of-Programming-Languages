/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* 	Koloni gosterim
* </p>
*/

package Odev3;

public class Koloni 
{
	public int populasyon;
	public int yemekStogu;
	public int kazanmaSayisi;
	public int kaybetmeSayisi;
	public char sembol;
	public Taktik taktik;
	public Uretim uretim;
	
	public Koloni(int populasyon,char sembol,Taktik taktik,Uretim uretim)
	{
		this.populasyon = populasyon;
		this.taktik = taktik;
		this.uretim = uretim;
		this.yemekStogu = populasyon*populasyon;
		this.kaybetmeSayisi = 0;
		this.kazanmaSayisi = 0;
		this.sembol = sembol;			
	}
	
	public boolean YasiyorMu()
	{
		if(this.populasyon<=0||this.yemekStogu<=0)
			return false;
		return true;
	}

}
