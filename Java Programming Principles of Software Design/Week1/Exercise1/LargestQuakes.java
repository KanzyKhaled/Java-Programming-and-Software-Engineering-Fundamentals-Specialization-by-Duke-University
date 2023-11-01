
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class LargestQuakes {
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size());
        //ArrayList<QuakeEntry> answer  = new ArrayList<QuakeEntry>();
        /*for(QuakeEntry qe : list){
            System.out.println(qe);            
        }*/
        
        /*
        int index = indexOfLargest(list);
        QuakeEntry largestQuake = list.get(index);
        System.out.println("Quake index " + index + " mag = " + largestQuake.getMagnitude());
        */
        ArrayList<QuakeEntry> answer  = getLargest(list,50);
        for(QuakeEntry qe : answer){
            System.out.println(qe);
        }
        
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> data){
        int index = 0;
        QuakeEntry largestQuake = data.get(0);
        for(int k=0; k< data.size();k++){
                QuakeEntry quake = data.get(k);
                if(quake.getMagnitude() > largestQuake.getMagnitude() ){
                    largestQuake = quake;
                    index = k;
                }
            }
        return index;
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = quakeData;
        for(int j=0; j< howMany; j++){
            int largestQuakeIndex = indexOfLargest(quakeData); 
            QuakeEntry quake = copy.get(largestQuakeIndex);
            answer.add(quake);    
            copy.remove(quake);
        }
        return answer;
    } 
    
    
}
