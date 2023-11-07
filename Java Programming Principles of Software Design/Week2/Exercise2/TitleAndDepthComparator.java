import java.util.*;
/**
 * Write a description of TitleAndDepthComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleAndDepthComparator implements Comparator<QuakeEntry>{
    
    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        int compString = qe1.getInfo().compareTo(qe2.getInfo());
        if (compString == 0){
            return Double.compare(qe1.getDepth(), qe2.getDepth());
        }
        return compString;
    }


}
