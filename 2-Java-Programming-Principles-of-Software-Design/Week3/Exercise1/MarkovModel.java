
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.util.Random;
import java.util.*;

public class MarkovModel {
    private String myText;
    private Random myRandom;
    private int N;
    
    public MarkovModel(int Num) {
         N = Num;
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
        int index = myRandom.nextInt(myText.length()-N);
        String key = myText.substring(index, index+N);
        sb.append(key);
        for(int k=0; k < numChars-N; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            
            int indexFollows = myRandom.nextInt(follows.size());
            String next = follows.get(indexFollows);
            sb.append(next);
            key = key.substring(1) + next;
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
