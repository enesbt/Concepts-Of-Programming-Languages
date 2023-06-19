package Odev1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 07.04.2023
* <p>
* 	Dosya yazma islemi
* </p>
*/  
 
public final class WriteFile
{
	private WriteFile() {} // private constructor
	public static void  writeFile(String fileName,Map<String,List<String>> map)
	{
		 try { 
	            File dosya = new File(fileName);
	            if (dosya.exists()) {
	            	dosya.delete();
	            	dosya.createNewFile();
	            }
	            else
	            {
	            	dosya.createNewFile();
	            }
	            
	            FileWriter fileWriter = new FileWriter(dosya, true);
	            BufferedWriter bWriter = new BufferedWriter(fileWriter);
	            
	            Set<String> keySet = map.keySet(); //map keyleri yani fonksiyon isimleri sete eklenir
	            for (String key : keySet) 
	            {
	            	String content = ""; 
	                List<String> values = map.get(key);
	                content +="Fonksiyon: "+key.toString().substring(0,key.toString().indexOf(" "))+"\n\n";
	                for (String i : values) //liste tipindeki yorumlar dosyaya yazilir.
	                {
	                    content += i+"\n";
	                }
	                content+="\n--------------------------------------------------------------\n";
	                bWriter.write(content);
	            }          
	           
	            bWriter.newLine();
	            bWriter.close();	            
	        } catch (IOException e) {
	            System.err.println("Hata: " + e.getMessage());
	        }		 
	}


}
