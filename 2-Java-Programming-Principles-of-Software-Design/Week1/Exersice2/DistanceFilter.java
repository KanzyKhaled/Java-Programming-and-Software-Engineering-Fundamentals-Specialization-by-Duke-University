
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class DistanceFilter implements Filter{
    private Location MyLocation;
    private double maxDistance;
    
    public DistanceFilter(Location loc, double max){
        MyLocation = loc;
        maxDistance = max;   
    }
    
    public boolean satisfies(QuakeEntry qe){
        return qe.getLocation().distanceTo(MyLocation) < maxDistance;
    }
    public String getName(){
        return " Distance Filter ";
    }
}
