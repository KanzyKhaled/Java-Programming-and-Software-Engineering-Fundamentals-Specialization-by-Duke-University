import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        //Filter f = new MinMagFilter(4.0);
        
        Filter f1 = new MagnitudeFilter(3.5,4.5); 
        ArrayList<QuakeEntry> ans1  = filter(list, f1); 
        Filter f2 = new DepthFilter(-55000.0,-20000.0); 
        ArrayList<QuakeEntry> ans2  = filter(ans1, f2); 
        
       /*
        Location Denver  = new Location(39.7392, -104.9903);
        Filter f1 = new DistanceFilter(Denver,1000000.0); 
        ArrayList<QuakeEntry> ans1  = filter(list, f1); 
        Filter f2 = new PhraseFilter("end","a"); 
        ArrayList<QuakeEntry> ans2  = filter(ans1, f2); 
        */
       for (QuakeEntry qe: ans2) { 
            System.out.println(qe);
        } 
        System.out.println("There are  "+ans2.size()+" quakes that match that criteria");
    }
    
    public void testMatchAllFilter(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        /*for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } */
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(1.0 , 4.0));
        maf.addFilter(new DepthFilter(-180000.0 , -30000.0 ));
        maf.addFilter(new PhraseFilter("any", "o"));
        ArrayList<QuakeEntry> quakes = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }
        System.out.println("There are  "+quakes.size()+" quakes that match that criteria");

        System.out.println("Filters used are: " + maf.getName());
    }

        public void testMatchAllFilter2(){
        EarthQuakeParser parser = new EarthQuakeParser(); 
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        /*for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } */
        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter(0.0 , 5.0));
        Location Denmark = new Location(55.7308, 9.1153);
        maf.addFilter(new DistanceFilter(Denmark , 3000000));
        maf.addFilter(new PhraseFilter("any", "e"));
        ArrayList<QuakeEntry> quakes = filter(list, maf);
        for (QuakeEntry qe: quakes) { 
            System.out.println(qe);
        }
        System.out.println("There are  "+quakes.size()+" quakes that match that criteria");

    }
    
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
