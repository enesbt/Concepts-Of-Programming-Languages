package Odev1;
import java.io.*;
import java.util.*;

/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 03.04.2023
* <p>
* 	dosya okuma islemleri
* </p>
*/

public class ReadJarFile implements IReadJarFile 
{
	private String fileName;
	private String file;
	
	public ReadJarFile(String fileName) { 
        this.fileName = fileName; 
        file="";  
    }
  
     
    public String getFile() {
        return file;
    }
 
	
    @Override
    public void readFile() //java dosyasini okuyup string hale getirir
    {
    	try (BufferedReader br = new BufferedReader(new FileReader(fileName)))  {
            String satir;
            while ((satir = br.readLine()) != null) {
                file += satir + "\n";
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
    
    
    @Override
    public Map<String,Integer> curlyCount(List<String> list) //fonksiyon suslu parantez sayisi tespiti
    {
    	Map<String,Integer> mapgec = new LinkedHashMap<>();
    	for(int i=0;i<list.size();i++)     //fonksiyon uzun isimleri ekle 
    	{
    		mapgec.put(list.get(i), 0);
    	}
    	
    	Stack<String> stack = new Stack<>();
    	for(int i=0;i<list.size();i++)
       	{    
         	int sayac = 0;          	
           	int index = file.indexOf(list.get(i));  //dosyada fonksiyon isminin indexi
           	
           	String yeni =file.substring(index);  //yeni string bulunan fonksiyon ismi ve sonrasi

           	try (Scanner scanner = new Scanner(yeni)) {
				while (scanner.hasNextLine()) {
				    String line = scanner.nextLine();
				    if(list.get(i).contains(";"))
				    {
				    	mapgec.put(list.get(i), 1);
						break;
				    }
					if(line.contains("{"))
				   	{
				  		stack.push("{");			          		
				  		sayac++;			    				  		
				  	} 
					if(line.contains("}"))
				   	{
				   		stack.pop();
				   		if(stack.isEmpty()) //stack bossa tum parantezler eslesir ve fonksiyonun sonu tespit edilir
				   		{               			
				   			mapgec.put(list.get(i), sayac);
				   			break;
				   		}	
				   	}  	      	          	   
				}
			}        	        	
       	}   	
    	return mapgec;
    }
    
}
