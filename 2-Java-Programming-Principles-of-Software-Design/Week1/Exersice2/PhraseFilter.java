
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class PhraseFilter implements Filter{
    private String where;
    private String phrase ;
    
    public PhraseFilter(String w, String p){
        where = w;
        phrase = p;   
    }
    
    public boolean satisfies(QuakeEntry qe){
          if(where == "start"){
            if(qe.getInfo().startsWith(phrase)){
                return true;
            }
            
        }else if(where == "end"){
            if(qe.getInfo().endsWith(phrase)){
                return true;
            }
            
        }else if(where == "any"){
            if(qe.getInfo().contains(phrase)){
                return true;
            }
        }
        return false; 
    }
    
    public String getName(){
        return " Phrase Filter ";
    }
}
