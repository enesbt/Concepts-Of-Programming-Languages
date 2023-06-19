package Odev1;
import java.util.*;
public interface IMatch 
{
	
	public String matchesSingle(String regex,int group);
	public List<String> matchesGroup(String regex);
	public Map<String,String> functionsNamesFunction(String regex,List<String>names,List<String>functions);
	public Map<String, List<String>> matchesCommentsFuncitonName(String regex,Map<String,String> map);	
	public List<String> functionMatch(Map<String,Integer> map);
}
