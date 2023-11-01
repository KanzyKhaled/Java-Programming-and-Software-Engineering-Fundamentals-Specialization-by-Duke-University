Assignment 1: Implementing Filters

1) create several new filters:
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



Assignment 2: MatchAllFilter and Modification to the Interface

1) Write a class named MatchAllFilter that can store and apply many filters:
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