package Odev1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 04.04.2023
* <p>
* 	Verilen regex ifadelerin dosya ile karsilastirilmasi ve eslesen ifadeler üzerinde islemler
* </p>
*/


public class Match implements IMatch 
{
	public ReadJarFile readJarFile;
	  
	  
	public Match(String fileName) //dosya okunur.
	{
		readJarFile = new ReadJarFile(fileName); 
		readJarFile.readFile();
	}
	  
	  
	@Override
    public String matchesSingle(String regex,int group) //eslesen ve istenilen grup dondurulur
    {
    	Pattern pattern = Pattern.compile(regex,Pattern.MULTILINE);
       
    	Matcher matcher = pattern.matcher(readJarFile.getFile());
        while (matcher.find()) {
            return matcher.group(group);
        }                  
         return null;
    }
	

	
	@Override
    public Map<String,String> functionsNamesFunction(String regex,List<String>names,List<String>functions) //fonksiyon ile fonskiyon ismini eslestir
    {
		Map<String,String> result = new LinkedHashMap<>();
		
		Pattern pattern = Pattern.compile(regex,Pattern.MULTILINE);
		for (int i = 0; i < names.size();i++)  //fonksiyon ismi tek ve ozel olmasi icin yanina random eklenmistir
	    { 
			Random random = new Random();
			String randomString = RandomString.generateRandomString(10, random);
			Matcher matcher = pattern.matcher(names.get(i));
			while (matcher.find()) 
    		{				
				result.put(matcher.group(1)+" "+randomString,functions.get(i));                  
            }
	    }
		

		return result;
    }
	 
	
	

	@Override
    public Map<String, List<String>> matchesCommentsFuncitonName(String regex,Map<String,String> map)
    {
		Map<String,List<String>> mapgec = new LinkedHashMap<>();	
		
		Pattern pattern = Pattern.compile(regex,Pattern.MULTILINE);
		for (Map.Entry<String,String> mapEleman : map.entrySet()) //fonksiyonlari gez
		{		
	     		Matcher matcher = pattern.matcher(mapEleman.getValue().toString());	     		
	     		List<String> comments = new ArrayList<>();
	     		while (matcher.find())  
	    		{
	     			 comments.add(matcher.group(1));
	     			 mapgec.put(mapEleman.getKey().toString(), comments);
	            }	     		
		}   	    
    	return mapgec;
    }
	
	
	
	@Override
    public  List<String> matchesGroup(String regex) //eslesen grup listeye eklenir.
    {
		List<String> matches = new ArrayList<>();
		
		
    	Pattern pattern = Pattern.compile(regex,Pattern.MULTILINE);
       
    	Matcher matcher = pattern.matcher(readJarFile.getFile());
        while (matcher.find()) {      	  
        	matches.add(matcher.group(1));        		                         
        }                  
         return matches;
    }
	
	
	@Override
	public List<String> functionMatch(Map<String,Integer> map)//fonksiyon eslesmesi suslu parantez sayisina gore regex eslesir
	{
		
		List<String> matches = new ArrayList<>();
		 for (Map.Entry<String, Integer> entry : map.entrySet()) {
			 
			 	String function = Pattern.quote(entry.getKey().toString());			 	
			 	Integer count = entry.getValue()-1;		
			 	

			 	String regex = "(s*(\\/\\*\\*([\\s\\S]*?)\\*\\/)?+\\s*(@Override)?\\s*+\\s*"+function+"\\s*(?:[^\\}]*\\}){"+count+"}[^\\}]*?\\})";
			 	Pattern pattern = Pattern.compile(regex,Pattern.MULTILINE);
			 	
		    	Matcher matcher = pattern.matcher(readJarFile.getFile());
		        while (matcher.find()) {
		            
		        	matches.add(matcher.group(1));        		                         
		        }       
	            
	        }			
    	           
         return matches;
		
		
	}
	
	

}
