
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import java.util.*;

public class MarkovOne {
    private String myText;
    private Random myRandom;
    
    public MarkovOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-1);
        String key = myText.substring(index, index+1);
        sb.append(key);
        for(int k=0; k < numChars; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            
            int indexFollows = myRandom.nextInt(follows.size());
            String next = follows.get(indexFollows);
            sb.append(next);
            key = next;
        }
        
        return sb.toString();
    }
    
    public ArrayList<String> getFollows(String key){
        int pos = 0;
        ArrayList<String> follows = new ArrayList<String>();
        while(pos < myText.length()){
            int i = myText.indexOf(key, pos);
            if(i == -1 || i+key.length()+1 > myText.length()){
                break;
            }
            String next = myText.substring(i+key.length(),i+key.length()+1);
            follows.add(next);
            pos = i+key.length();
        }
        return follows;
    }
}
