# WEEK 1 NOTES

## Project 1 - Programming Exercise - Searching Earthquake Data

## Assignment 1: Filtering by Magnitude and Distance

### Modify one class, the EarthQuakeClient class:
A) - Write the method filterByMagnitude 
   - This method has two parameters( ArrayList of type QuakeEntry named quakeData, double named magMin)
   - This method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData that have a magnitude larger than magMin. 
B) - Modify the method bigQuakes that has no parameters to use filterByMagnitude and print earthquakes above a certain magnitude, , and also print the number of such earthquakes.
C) - Write the method filterByDistanceFrom
   - This method has three parameters( ArrayList of type QuakeEntry named quakeData, double named distMax, Location named from)
   - This method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData that are less than distMax from the location from.
D) - Modify the method closeToMe that has no parameters to call filterByDistance to print out the earthquakes within 1000 Kilometers to a specified city (such as Durham, NC).


## Assignment 2: Filtering by Depth

### Add new methods to one class, the EarthQuakeClient class:
A) - Write the method filterByDepth.
   - This method has three parameters( ArrayList of type QuakeEntry named quakeData, double named minDepth, double named maxDepth)
   - This method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData whose depth is between minDepth and maxDepth, exclusive. (Do not include quakes with depth exactly minDepth or maxDepth.)
B) - Write the void method quakesOfDepth 
   - This method has no parameters to use filterByDepth and print all the earthquakes from a data source whose depth is between a given minimum and maximum value. You should also print out the number of earthquakes found.


## Assignment 3: Filtering by Phrase in Title

### Add new methods to one class, the EarthQuakeClient class:
A) - Write the method filterByPhrase
	   - This method has three parameters( ArrayList of type QuakeEntry named quakeData, String named where that indicates where to search in the title and has one of three values: [“start”, ”end”, or “any”],  String named phrase indicating the phrase to search for in the title of the earthquake)
	   - This  method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData whose titles have the given phrase found at location where (“start” means the phrase must start the title, “end” means the phrase must end the title and “any” means the phrase is a substring anywhere in the title.)
B) - Write the void method quakesByPhrase to use filterByPhrase and print all the earthquakes from a data source that have phrase in their title in a given position in the title. You should also print out the number of earthquakes found.


## Assignment 4: Finding the Closest Earthquakes to a Location

###  Modify one class, the ClosestQuakes class:
A) - Complete the method getClosest
   - This method has three parameters( ArrayList of type QuakeEntry named quakeData, Location named current, int named howMany)
	   - This method should find the closest number of howMany earthquakes to the current Location and return them in an ArrayList of type QuakeEntry.
   - The earthquakes should be in the ArrayList in order with the closest earthquake in index position 0.  If there are fewer then howMany earthquakes in quakeData, then the ArrayList returned would be the same size as quakeData.  


## Project 2 - Programming Exercise - Filtering Data

## Assignment 1: Implementing Filters

###  Create several new filters:
A) - Write the class MagnitudeFilter that implements Filter.
	-This class should include private instance variables for a minimum and maximum magnitude.
	-A constructor to initialize those variables.
	-And a satisfies method that returns true if a QuakeEntry’s magnitude is between the minimum and maximum magnitudes, or equal to one of them. Otherwise it should return false.

B) - Write the class DepthFilter that implements Filter. 
	-This class should include private instance variables for a minimum and maximum depth.
	-A constructor to initialize those variables. 
	-And a satisfies method that returns true if a QuakeEntry’s depth is between the minimum and maximum depths, or equal to one of them. Otherwise it should return false. 

C) - Write the class DistanceFilter that implements Filter.
	-This class should include private instance variables for a location and a maximum distance. 
	-A constructor to initialize those variables.
	-And a satisfies method that returns true if a QuakeEntry’s distance from the given location is less than the specified maximum distance. Otherwise it should return false.

D) - Write the class PhraseFilter that implements Filter.
	-This class should include two private instance variables for 
		1) a String representing the type of request that indicates where to search in the title and has one of three values: (“start”, ”end”, or “any”).
		2) a String indicating the phrase to search for in the title of the earthquake (Note the title of the earthquake can be obtained through the getInfo method). 
	-This class also has a constructor to initialize those variables
	-And a satisfies method that returns true if the phrase is found at the requested location in the title. If the phrase is not found, this method should return false.

E) - Modify the code in the quakesWithFilter method in the EarthQuakeClient2 class to filter earthquakes using two criteria
	-Those with magnitude between 4.0 and 5.0 and depth between -35000.0 and -12000.0. You’ll need to use both the MagnitudeFilter and the DepthFilter.
	-Use one and then use the other on the result from the first.

F) - Comment out the previous code in quakesWithFilter in the EarthQuakeClient2 class 
	-Add additional code to the quakesWithFilter method in the EarthQuakeClient2 class to filter earthquakes using two criteria
	-Those that are 10,000,000 meters (10,000 km) from Tokyo, Japan whose location is (35.42, 139.43), and that are in Japan (this means "Japan" should be the last word in the title).



## Assignment 2: MatchAllFilter and Modification to the Interface

###  Write a class named MatchAllFilter that can store and apply many filters:
A) - Write the class MatchAllFilter that implements Filter. 
	- This class has a private ArrayList of Filters that is created in the constructor that has no parameters. 
	- This class has two methods
		 1) a void method named addFilter with one Filter parameter that adds the Filter to its private ArrayList.
		 2) a method named satisfies that has one QuakeEntry parameter and returns true if the QuakeEntry satisfies all the filter conditions, otherwise it returns false. 

B) - Write a new void method named testMatchAllFilter in the EarthQuakeClient2 class.
	- This method reads in earthquake data from a source and stores them into an ArrayList of type QuakeEntry. 
	- Then it prints all the earthquakes and how many earthquakes that were from the source. 
	- After this works you should comment out the printing of all the earthquakes, but continue to print out the total number of earthquakes read in. 
	- Then create a MatchAllFilter named maf and use the addFilter method to add three Filters to test the magnitude between 0.0 and 2.0, 
	  to test the depth between -100000.0 and -10000.0, and if the letter “a” is in the title. 
	- Then use filter(list, maf) to use all three filters and print out the resulting list of earthquakes.

C) - Write a new void method named testMatchAllFilter2 in the EarthQuakeClient2 class.
	- This method should be identical to the method testMatchAllFilter, but will create different Filters.
	- Then create a MatchAllFilter named maf, and use the addFilter method to add three Filters 
	  to test the magnitude between 0.0 and 3.0, to test for the distance from Tulsa, Oklahoma at location (36.1314, -95.9372) is less than 10000000 meters (10000 km), and if the substring “Ca” is in the title. 
	- Then use filter(list, maf) to use all three filters and print out the resulting list of earthquakes.

D) - Modify the Filter interface to include a new method named getName
	- This method returns the name of the filter. The line added to the Filter interface should be: public String getName(); 
	  What changes need to be made to all the Filter classes?
	  - The user should be able to specify what they want the name of the filter to be when they create a specific filter. 
	  - For the MatchAllFilter class, a getName method should return a String of all the Filter names in its ArrayList.

E) - Add to the end of the method testMatchAllFilter a call to the MatchAllFilter getName method to print out all the Filter names used. 
	-For the example above, printing “Filters used are: “ 