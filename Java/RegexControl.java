package Odev1;
import java.util.*;

/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 06.04.2023
* <p>
* 	Regex ifadlerin belirlenmesi eslesme icin gonderilmesi ve eslesen verilerin veri yapılarinda tutulmasi
* </p>
*/


public class RegexControl implements IRegexControl
{
	private String className;
	public Match match;
	public List<String> functions; //eslesen fonksiyonlar	
	public Map<String,String> functionsNamesFunctions; // fonksiyon isimleri ile fonksiyon eslesmesi
	public Map<String,List<String>> functionsNamesSingleComments; //fonskiyon ismi ile yorumların eşlemesi
	public Map<String,List<String>> functionsNamesMultiComments;
	public Map<String,List<String>> functionsNamesJavaDocComments;
	public List<String> functionNames;
	public Map<String,Integer>functionCurlyCount; //fonksiyon suslu parantez sayisi
	
	 
	 
	public RegexControl(String fileName) 
	{
	    match = new Match(fileName);
	    this.className = null;
	    functions = new ArrayList<>();	  
	    functionsNamesFunctions = new LinkedHashMap<>();
	    functionsNamesSingleComments = new LinkedHashMap<>();
	    functionsNamesMultiComments =  new LinkedHashMap<>();
	    functionsNamesJavaDocComments =  new LinkedHashMap<>();	    
	    functionNames= new ArrayList<>();
	    functionCurlyCount = new LinkedHashMap<>();
	} 
	 
	 
	@Override
	public void longFunctionNames() //uzun fonksiyon ismi
	{
		String regex = "((public|protected|private)+\\s*\\w*\\s*\\w*\\s*\\w*\\([^()]*\\)\\s*\\;?\\{?)";
		functionNames = match.matchesGroup(regex);
	}
	@Override
	public void curlyCount()
	{
		functionCurlyCount =  match.readJarFile.curlyCount(functionNames);		
	}
	

	@Override
	public void classNameRegex() // sinif ismi bulunmasi
	{
		String regex = "\\bclass\\b\\s+([a-zA-Z0-9]*)";
		className = match.matchesSingle(regex, 1);
	}
	
	
	@Override
	public void functionsControl() // fonksiyonların tespiti
	{	
		functions =  match.functionMatch(functionCurlyCount);		
	}
	
	
	@Override
	public void matchFunctionsFunctionsNames() // fonksiyon ismi ve fonksiyonlarin tespiti
	{		
		String regex = "([a-zA-Z0-9]*)\\s*\\(";
		functionsNamesFunctions = match.functionsNamesFunction(regex,functionNames, functions);
	}
	
	@Override
	public void matchSingleLineComments() //tek satir yorumlarin fonksiyon ismi ile eslesmesi ve dosyaya kaydedilmesi
	{
		String regex =  "(\\/\\/.+)";
		functionsNamesSingleComments=match.matchesCommentsFuncitonName(regex, functionsNamesFunctions);
		WriteFile.writeFile("teksatir.txt", functionsNamesSingleComments);		
	}
	

	@Override
	public void matchMultiLineComments() //cok satir yorumlarin fonksiyon ismi ile eslesmesi ve dosyaya kaydedilmesi
	{
		String regex =  "(\\/\\*([^*][\\s\\S]*?)\\*\\/)";
		functionsNamesMultiComments=match.matchesCommentsFuncitonName(regex, functionsNamesFunctions);
		WriteFile.writeFile("coksatir.txt", functionsNamesMultiComments);		
	}
	

	@Override
	public void matchJavaDocComments() //javadoc yorumlarin fonksiyon ismi ile eslesmesi ve dosyaya kaydedilmesi
	{
		String regex =  "(\\/\\*\\*([\\s\\S]*?)\\*\\/)"; 
		functionsNamesJavaDocComments=match.matchesCommentsFuncitonName(regex, functionsNamesFunctions);
		WriteFile.writeFile("javadoc.txt", functionsNamesJavaDocComments);		
	}


	public String getClassName() 
	{
	       return className;
	}
	
	@Override
	public void yazdir() 
	{	
		Print.PrintScreen(className,functionsNamesSingleComments, functionsNamesMultiComments, functionsNamesJavaDocComments,functionsNamesFunctions);			
	}

}
