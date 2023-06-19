package Odev1;

/**
*
* @author Enes Buğra Turğut bugra.turgut@ogr.sakarya.edu.tr
* @since 05.04.2023
* <p>
* Programin calistirilmasi
* </p>
*/

public class Main {
 
	public static void main(String[] args)
	{		 				 		
		String arg = args[0];				
		RegexControl rgx = new RegexControl(arg);
		rgx.longFunctionNames();
		rgx.curlyCount();
		rgx.functionsControl();
		rgx.classNameRegex();
		rgx.matchFunctionsFunctionsNames();
		rgx.matchSingleLineComments();
		rgx.matchMultiLineComments();
		rgx.matchJavaDocComments();
		rgx.yazdir();
	}	
   
} 
