# WEEK 3 NOTES

## Project 1 - Programming Exercise: Generating Random Text

## Assignment 1: MarkovZero and MarkovOne

### For this assignment, you will create several other Markov classes to generate text that use characters that follow other characters to predict the next possible character. The more characters you use in the prediction, the more likely the text will appear like the training text.

### Experiment with the MarkovZero class, and then create a MarkovOne class.:
A) - Create MarkovZero generated texts by running the method runMarkovZero in MarkovRunner. 
   - Run the program twice and note that the output is different each time you run it. 

B) - Modify the runMarkovZero method to call the setRandom method with the seed 42.
   - Run this method at least twice. What do you observe? 
   - change to seed to 101. Run it at least twice. You should get different text than you got with the seed 42, but every time you run it you get the same text. 
   
C) - Create a new class called MarkovOne. 
   - Copy the body of MarkovZero into MarkovOne. 
   - Change the name of the constructor to MarkovOne and add the same import that MarkovZero had, and then it should compile.
   - MarkovOne is only doing what MarkovZero did, since it is a copy of it. We will fix it shortly to use one character to predict text. 
   - In the class MarkovRunner, make a copy of the method runMarkovZero, and name this method runMarkovOne. Then change the line MarkovZero markov = new MarkovZero(); to MarkovOne markov = new MarkovOne();.

D) - Fix up the class MarkovOne to generate text randomly by predicting the next character based on one character.
   - In the class MarkovOne, write the method getFollows that has one String parameter named key.
   - This method should find all the characters from the private variable myText in MarkovOne that follow key and put all these characters into an ArrayList and then return this ArrayList. 
   - For example, if myText were “this is a test yes this is a test.”, then the call getFollows(“t”) should return an ArrayList with the Strings “h”, “e”, “ “, “h”, “e”, “.” as “t” appears 6 times. The call getFollows(“e”) should return an ArrayList with the Strings “s”, “s”, “s”. Your method should work even if key is a word. Thus, getFollows(“es”) should return an ArrayList with the Strings “t”, “ “, “t”.
   
E) - Create a new class in this project named Tester and a void method in this class named testGetFollows with no parameters. 
   - This method should create a MarkovOne object, set the training text as “this is a test yes this is a test.”. Then have it call getFollows and print out the resulting ArrayList and also its size.

F) - In the Tester class, write the void method testGetFollowsWithFile with no parameters.
   - This method should create a MarkovOne object, set the training text to a file the user selects (similar to the methods in MarkovRunner), and then call getFollows. Run your program on confucius.txt and look for the characters that follow “t”. You should get 11548. 

G) - In the class MarkovOne modify the method getRandomText so that it works for the way it should for MarkovOne.
   - It should predict the next character, by finding all the characters that follow the current character in the training text, and then randomly picking one of them as the next character. 

H) - You already modified the runMarkovOne method in the class MarkovRunner. Run this method with the random seed as 42 and the file confucius.txt. The first line of MarkovOne random text generated starts with:  "nd are, Prevedowalvism n thastsour tr ndsang heag ti. the ffinthe"



## Assignment 2: MarkovFour and MarkovModel

A) - Create the class MarkovFour to use four characters to predict the next character.\

B) - In the MarkovRunner class, create the method runMarkovFour to generate random text using the MarkovFour class.
   - If you set the random seed with 25 and run this method on confucius.txt, the first line of text should start with: "ouses the people Minister said the that a many Project of it"

C) - Create the class MarkovModel to use N characters to predict the next character. 
   - An integer should be passed in with the constructor to specify the number of characters to use to predict the next character. 
   
D) - In the MarkovRunner class, create the method runMarkovModel to generate random text using the MarkovModel class.
   - If you set the random seed with 38 and run this method with N = 6 on confucius.txt, the first line of text should start with: "sters I could thrice before downloading, and his lord, might"
   
   
   
   
## Project 2 - Programming Exercise: Interface and Abstract Class

## Assignment 1: IMarkovModel Interface

A) - Copy over four of the .java files from the the work you did with the previous assignment.
   - Specifically you should copy over the four Java files: MarkovZero.java, MarkovOne.java, MarkovFour.java, and MarkovModel.java.
   - You can ignore the following files from the previous lesson—MarkovRunner.java and Tester.java. We will modify the program to organize it in a different way, using an interface and an abstract class.
   
B) - Modify your classes MarkovZero, MarkovOne, MarkovFour, and MarkovModel to implement the IMarkovModel interface. 
   - Each of these classes should already have the two required methods setTraining and getRandomText, so the only change needed is the first line to add "implement IMarkovModel"
   
C) - Run the method runMarkov that is in the MarkovRunnerWithInterface class.
   - This method should run several Markov objects and generate random text for a MarkovZero, a MarkovOne, a MarkovModel with number 3, and a MarkovFour. 
   - Notice that runMarkov is called with each one of these. You can observe that the text gets more like the training text as you move from MarkovZero to MarkovFour. 
   
## Assignment 2: AbstractMarkovModel Abstract Class

A) - Integrate the AbstractMarkovModel abstract class
   - The method getFollows you wrote is the same everywhere. You should move it into the AbstractMarkovModel class and change this method from public to protected. 

B) - Anything that is protected in AbstractMarkovModel should be deleted in the other files they are in.
   - In each of MarkovZero, MarkovOne, MarkovFour and MarkovModel, delete the declarations of the two private variables myText and myRandom, and delete the getFollows method if it has one. 

C) - Each of MarkovZero, MarkovOne, MarkovFour, and MarkovModel need to change in their definition “implements IMarkovModel” to “extends AbstractMarkovModel”

D) - Run the method runMarkov that is in the MarkovRunnerWithInterface class. It should run as before. 

E) - Notice that when you print any markov object, you get its name and an address location. These objects don’t know how to print themselves. 
   - Write a toString method, so each one prints out “MarkovModel of order n,” where n is the number. For example, a MarkovFour object should print out “MarkovModel of order 4.”

F) - Modify your program so that you can set a seed in the runMarkov method in the MarkovRunnerWithInterface class
   - And and pass it to the runModel method (add a 4th parameter named seed) to set the random seed for any markov object.
   - In the runModel class you should be able to set this seed with the line: markov.setRandom(seed).             



## Assignment 3: HashMap for Efficiency

### It was noted that the getRandomText method is inefficient. Suppose it sees the String “he” 50 times. Each time, it will calculate the follow set again, which could take a long time, each time if the training text is long. 

A) - Write a new class named EfficientMarkovModel (make a copy of MarkovModel to start with)
   - That extends AbstractMarkovModel
   - And that builds a HashMap to calculate the follows ArrayList for each possible substring only once
   - And then uses the HashMap to look at the list of characters following when it is needed.
   
B) - This class should include:
	 - A toString method to print that this is the EfficientMarkovModel class of a specific number
	 - A method named buildMap to build the HashMap Be sure to handle the case where there may not be a follow character. 
	 - If that key is not in the HashMap yet, then it should be put in mapped to an empty ArrayList. 
	 - Think carefully about where to call this method, considering that you will want to build a map for each new training text.
	 - A getFollows method, but this getFollows method should be much shorter, as it can look up the ArrayList of Strings, instead of computing it each time.
   
C) - To test your HashMap to make sure it is built correctly, write the void method printHashMapInfo in the EfficientMarkovModel class.
   - Make sure to call this method immediately after building the map. This method should print out the following information about the HashMap:
	 - Print the HashMap (all the keys and their corresponding values). Only do this if the HashMap is small.
	 - Print the number of keys in the HashMap
	 - Print the size of the largest value in the HashMap—that is, the size of the largest ArrayList of characters
	 - Print the keys that have the maximum size value.
	
D)  - Write a new method named testHashMap in the MarkovRunnerWithInterface class.
    - This method should create an order-2 EfficientMarkovModel with
	 - Seed 42
	 - The training text is “yes-this-is-a-thin-pretty-pink-thistle”
	 - The size of the text generated is 50
	 - Note that “le” occurs only once at the end of the training text

E)  - In the MarkovRunnerWithInterface class, call testHashMap. You should see that the HashMap has the following information:
	 - It has 25 keys in the HashMap
	 - The maximum number of keys following a key is 3
	 - Keys that have the largest ArrayList (of size 3 in this case) are: “hi”, “s-”, “-t”, “is”, and “th”
	 - After running it, you’ll probably want to comment out the call to printHashMapInfo in the EfficientMarkovModel class.
	 
F)  - In the MarkovRunnerWithInterface class, create a void method named compareMethods that runs a MarkovModel and an EfficientMarkovModel. In particular, 
	 - Make both order-2 Markov models
	 - Use seed 42 and set the length of text to generate to be 1000
	 - Both should call runModel that generates random text three times for each.
	 - Run the MarkovModel first and then the EfficientMarkovModel with the file “hawthorne.txt” as the training text. 
	 - One of them should be noticeably faster. You can calculate the time each takes by using System.nanoTime() for the current time.
	 
	
	
## Project 3 - Programming Exercise: Word N-Grams

## Assignment 1: Generating Random Words with Prediction

A) -  First complete the MarkovWordOne class.
   -  Write a getFollows method that is given a word and returns all the single words that immediately follow that word in the training text.
   -  Write a helper function indexOf that will work like the String indexOf method, but here it returns the index location of a word in the String array.

B) -  In the MarkovWordOne class :

	1)  - Write the private method indexOf that has three parameters( String array named words, String named target, integer named start)
		- This method starts looking at the start position and returns the first index location in words that matches target. 
		- If no word is found, then this method returns -1. The signature for this method should be:  private int indexOf(String[] words, String target, int start)
		
	2)  - Write a public void method named testIndexOf that has no parameters. 
	    - This method is only for testing the indexOf method. 
		- This method should create a simple String array with the words “this is just a test yes this is a simple test” 
		- Then look for the words: “this” starting at 0, “this” starting at 3, “frog” starting at 0, “frog” starting at 5, “simple” starting at 2 and “test” starting at 5. 
		
	3)  - Complete the method named getFollows that has been started for you with String parameter key. 
	    - This method should return an ArrayList of all the single words that immediately follow the key in the training text. 
		- This method should call the indexOf method. 

	4)  - You can test the getFollows method by adding a print statement in the getRandomText method to print out a key and the result from calling getFollows to see all the words that follow the key. 
	    - Then write a testing method in the MarkovRunner class. 
		- This method should create a simple String instead of using a file for testing and call runModel. 
		- For example, for the String above, the word “test” is followed by “yes”, the word “is” is followed by “just” and “a”. 
		
C) - Once you have MarkovWordOne working, modify the runMarkov method in the MarkovRunner class to use the random seed set to 175, and generate 120 words. 
   - Then run this method on the file confucius.txt. You should get the output (first five lines shown):

		teacher. 12. He that his doings from the free distribution of

		Ling, the people by learning; then those over with this or hate

		daring and hates his muttering a belief in war. He refused all

		likelihood, between men. Fan Ch'ih did not go with you? The Master

		said, At his best pupil, who notifies you may ignore propriety;
		

## Assignment 2: MarkovWordTwo

A) - Create a new class named MarkovWordTwo. 
   - Copy the code from MarkovWordOne into MarkovWordTwo, and then modify the code to work for two consecutive words. 
   - You should have two keys: key1 and key2 that are consecutive words in the text, and then getFollows returns the list of single words that follow these two words. 
   - For example if the text was “this is just a test yes this is a simple test”, then getFollows of “this” “is” would return an ArrayList with “just” and “a”, and getFollows of “just” “a” returns an ArrayList with “test”. 
   - getFollows should have two String parameters, key1 and key2
   - indexOf should have four parameters: a String array words, a String target1, a String target2, and an integer start. 
   - It returns the first location of target1 such that target2 immediately follows it, and the search starts looking at index start.
   
B) - Write a new method runMarkovTwo in the MarkovRunner class to generate random text with MarkovWordTwo. 
   - Run this on confucius.txt with the random number seed 549. The first line of your output should be: <b> the minister know me? Because I was not so great; xix. 21, says </b>



## Project 3 - Programming Exercise: WordGram Class

## Assignment 1: Complete WordGram

A) - Complete the WordGram class that has been started for you.
   - Write the method length that has no parameters and returns the length of the WordGram.
   - The method toString that has no parameters. It prints a WordGram out, showing all the words in the WordGram on one line separated by spaces.
   - Write the method equals that has one parameter of type Object named o. This method returns true if two WordGrams are equal and false otherwise. 
   - Write the method shiftAdd that has one String parameter word. 
   - This method should return a new WordGram the same size as the original, consisting of each word shifted down one index 
   - For example the word in slot 1 would move to slot 0, the word in slot 2 would move to slot 1, etc.) and word added to the end of the new WordGram. 
   - Be sure to test this method. For example, if a WordGram of size 4 is “this” “is” “a” “test”, and shiftAdd is called with the argument “yes”, then the method would return a new WordGram ”is” “a” “test” “yes”. 
   - This method should not alter the WordGram on which it is called.
   
   
## Assignment 2: MarkovWord with WordGram

### Create a MarkovWord class that works for any number of words and uses the WordGram class to handle those words. 

A) - Create the MarkovWord class that implements IMarkovModel. 
   - This class should have three private variables, a String array named myText, a Random variable named myRandom, and an integer variable named myOrder. 
   - This class should have the following methods, similar to what the MarkovWordOne class had, but extended for handling a larger number of words.
   
B) - The methods in MarkovWord are:
   - A constructor with one integer parameter that is the order (how many words to use in prediction). This method should initialize myOrder and myRandom.
   - The void method setRandom has one integer parameter named seed. Using this method will allow you to generate the same random text each time
   - The void method setTraining has one String parameter named text. The String text is split into words and stored in myText. The words are used to initialize the training text
   - The indexOf method has three parameters, a String array of all the words in the training text named words, a WordGram named target, and an integer named start indicating where to start looking for a WordGram match in words. 
   - This method should return the first position from start that has words in the array words that match the WordGram target. If there is no such match then return -1.
   - The getFollows method has one WordGram parameter named kGram. 
   - This method returns an ArrayList of all the single words that immediately follow an instance of the WordGram parameter somewhere in the training text. 
   - This method should call indexOf to find these matches.
   - The getRandomText method has one integer parameter named numWords. 
   - This method generates and returns random text that has numWords words. 
   - This class generates each word by randomly choosing a word from the training text that follows the current word(s) in the training text. 
   - When you copied the body of MarkovWordOne into the MarkovWord class, you copied this method from MarkovWordOne. 
   - Much of the code from the copied method will still be correct for MarkovWord, but you will need to make a few changes so that it works for any order (not just order one), and uses WordGram objects. 
   - You may want to use the shiftAdd method you wrote in WordGram.
   

## Assignment 3: EfficientMarkovWord with WordGram

A) - Create a HashMap of a WordGram to a follow set. 
   - HashMap does not know how to hash a WordGram. 
   - In the WordGram class, you will need to add a method named hashCode that has no parameters. 
   - This method should return an integer that is a hash code that represents the WordGram. Note that String has a method hashCode. 
   - You may want to create a String from the WordGram and use the String hashCode method.
   - Write a new class named EfficientMarkovWord (make a copy of MarkovWord to start with) that implements IMarkovModel and that builds a HashMap to calculate the follows ArrayList for each possible WordGram only once.
   - And then uses the HashMap to look at the list of characters following when it is needed. This class should include:
		- A method named buildMap to build the HashMap (Be sure to handle the case at the end where there is not a follow character. 
		- If that WordGram is not in the HashMap yet, then it should be put in mapped to an empty ArrayList. 
		- If that key is already in the HashMap, then do not enter anything for this case.)
		- a getFollows method, but this getFollows method should be much shorter, as it can look up the WordGram, instead of computing it each time.
		- To test your HashMap to make sure it is built correctly, write the void method printHashMapInfo in the EfficientMarkovWord class. 
		- This method should print out the following information about the HashMap: 
			- Print the HashMap (all the keys and their corresponding values). Only do this if the HashMap is small.
			- Print the number of keys in the HashMap
			- Print the size of the largest value in the HashMap—that is, the size of the largest ArrayList of characters
			- Print the keys that have the maximum size value.