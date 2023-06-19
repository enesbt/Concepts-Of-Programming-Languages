/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 23.05.2023
* <p>
* 	Oyun baslatma savas islemleri
* </p>
*/

package Odev3;
import java.util.*;
public class Oyun 
{
	ArrayList<Koloni> koloniler;
	ArrayList<Taktik> taktikler;
	ArrayList<Uretim> uretimler;
	
	public Oyun()
	{
		koloniler = new ArrayList<>();
		taktikler = new ArrayList<>();
		uretimler = new ArrayList<>();		
	}
	
	public void KoloniUret(ArrayList<Integer> populasyonlar)
	{   
		Random random = new Random();
		taktikler.add(new ATaktik());
		taktikler.add(new BTaktik());
		uretimler.add(new AUretim());
		uretimler.add(new BUretim());
				
		for(int i=0;i<populasyonlar.size();i++)
		{
			int randomTaktik = random.nextInt(taktikler.size());
			int randomUretim = random.nextInt(uretimler.size());
			int randomAscii = random.nextInt(126 - 32 + 1) + 32; 
	        char sembol = (char) randomAscii;
			Koloni koloni = new Koloni(populasyonlar.get(i),sembol,taktikler.get(randomTaktik),uretimler.get(randomUretim));
			this.koloniler.add(koloni);			
			
		}
		
	}
	
	public int YasayanSayisi()
	{
		int yasayan = 0;
		for(int i=0;i<koloniler.size();i++)
		{
			if(koloniler.get(i).YasiyorMu())
				yasayan++;
		}
		return yasayan;
		
	}
	public void Tur()
	{

	    int tur = 0;
	    while(YasayanSayisi()!=1&&YasayanSayisi()!=0)
	    {
	        	      
	        Oyna();
	        for(int i =0;i < koloniler.size();i++)
	        {
	            
	            if(koloniler.get(i).YasiyorMu())
	            {
	                
	            	koloniler.get(i).yemekStogu+=koloniler.get(i).uretim.Uret(koloniler.get(i).populasyon);
	            	koloniler.get(i).populasyon +=  (koloniler.get(i).populasyon *20)/100;
	            	koloniler.get(i).yemekStogu -=  koloniler.get(i).populasyon *2;
	            }
	        }
	        tur++;
	        
	        try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	       for (int i = 0; i < 100; i++) {
	            System.out.println();
	        }
	        Yazdir.Yaz(koloniler,tur);         
	    }
	}
	
	public void Oyna()
	{
		int kol1=0;
		int kol2=0;
		int fark,yuzde =0;
		for(int i=0;i<koloniler.size()-1;i++)
		{
			if(koloniler.get(i).YasiyorMu())
			{
				for(int j=i+1;j<koloniler.size();j++)
				{
					kol1 = koloniler.get(i).taktik.Savas(koloniler.get(i).populasyon);
					if(koloniler.get(j).YasiyorMu())
					{
						kol2 = koloniler.get(j).taktik.Savas(koloniler.get(j).populasyon);
						
						fark = Math.abs(kol1-kol2);
						yuzde = fark/10;
						if(kol1>kol2)
	                    {  
							EslesmeSonu(koloniler.get(i),koloniler.get(j),yuzde);	                                                        
	                    }
	                    else if(kol2>kol1)
	                    {
	                    	EslesmeSonu(koloniler.get(j),koloniler.get(i),yuzde);
	                    }
	                    else
	                    { 
	                    	if(koloniler.get(i).populasyon>koloniler.get(j).populasyon)
	                    		EslesmeSonu(koloniler.get(i),koloniler.get(j),yuzde);	
	                        else if(koloniler.get(i).populasyon<koloniler.get(j).populasyon)
	                        	EslesmeSonu(koloniler.get(j),koloniler.get(i),yuzde);
	                        else
	                        {
	                        	Random random = new Random();
	                        	int rand = random.nextInt(2);
	                        	if(rand==1)
	                        		EslesmeSonu(koloniler.get(i),koloniler.get(j),yuzde);
	                        	else
	                        		EslesmeSonu(koloniler.get(j),koloniler.get(i),yuzde);
	                        		
	                        }
	                            
	                        
	                    }
						
					}
				}
			}
		}
	}
	public void EslesmeSonu(Koloni kazanan,Koloni kaybeden,int yuzde)
	{
		int azalt =  (kaybeden.populasyon *yuzde)/100;
		    
	    if(azalt>0)
	    {
	        int yemeks = 0;
	        kaybeden.populasyon -=  azalt;
	        yemeks = (kaybeden.yemekStogu *yuzde)/100;
	        kaybeden.yemekStogu -= yemeks;
	        kaybeden.kaybetmeSayisi++;
	        kazanan.kazanmaSayisi++;
	        kazanan.yemekStogu +=yemeks;              
	    }
	    else
	    {
	    	kaybeden.populasyon -=1;
	    	kaybeden.yemekStogu -= 10;
	    	kaybeden.kaybetmeSayisi++;
	    	kazanan.kazanmaSayisi++;
	    	kazanan.yemekStogu +=10;            
	    }
	}
	

}
