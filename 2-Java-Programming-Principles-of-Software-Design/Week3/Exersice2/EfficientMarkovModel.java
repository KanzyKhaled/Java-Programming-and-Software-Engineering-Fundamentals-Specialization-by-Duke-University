
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel {
    private int N;
    private HashMap<String,ArrayList<String>> hashMap;
    
    public EfficientMarkovModel(int Num) {
         N = Num;
         myRandom = new Random();
         hashMap = new HashMap<String,ArrayList<String>> ();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
    }
    
    public String toString() {
         return "EfficientMarkovModel class of order " + N;
    }
    
    public void buildMap(){
        for(int k=0; k < myText.length()-N; k++){
            String key = myText.substring(k, k+N);
           
            if (! hashMap.containsKey(key)) {
                ArrayList<String> nextArr = new ArrayList<String> ();
                nextArr.add(myText.substring(k+N, k+N+1));
                
                hashMap.put(key, nextArr);
            } else if (hashMap.containsKey(key)) {
                ArrayList<String> nextArr = hashMap.get(key);
                nextArr.add(myText.substring(k+N, k+N+1));
            }
        }
    
    }
    
    public void printHashMapInfo(){
        int maxSize = 0;
        ArrayList<String> maxSizeKeys = new ArrayList();
        
        for (String key : hashMap.keySet()) {
            ArrayList<String> values = hashMap.get(key);
            //System.out.println("For key: " + key + " corresponding values are: " + values);
            if (values.size() > maxSize) {
                maxSize = values.size();
            }                   
        }
        
        for (String key : hashMap.keySet()) {
            int valueSize = hashMap.get(key).size();
            
            if (valueSize == maxSize) {
                maxSizeKeys.add(key);
            }
        }
        
        System.out.println("Number of keys in the HashMap: " + hashMap.size()+1);
        System.out.println("Size of the largest value in the HashMap: " + maxSize);
        System.out.println("Keys that have the maximum size value: " + maxSizeKeys);
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
}
