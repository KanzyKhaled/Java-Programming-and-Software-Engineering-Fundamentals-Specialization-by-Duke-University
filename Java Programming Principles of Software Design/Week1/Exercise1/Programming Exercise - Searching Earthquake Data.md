# Assignment 1: Filtering by Magnitude and Distance #

1)  modify one class, the EarthQuakeClient class:
	A) - Write the method filterByMagnitude 
	   - This method has two parameters( ArrayList of type QuakeEntry named quakeData, double named magMin)
	   - This method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData that have a magnitude larger than magMin. 

        B) - Modify the method bigQuakes that has no parameters to use filterByMagnitude and print earthquakes above a certain magnitude, , and also print the number of such earthquakes.

	C) - Write the method filterByDistanceFrom
	   - This method has three parameters( ArrayList of type QuakeEntry named quakeData, double named distMax, Location named from)
	   - This method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData that are less than distMax from the location from.

	D) - Modify the method closeToMe that has no parameters to call filterByDistance to print out the earthquakes within 1000 Kilometers to a specified city (such as Durham, NC).


Assignment 2: Filtering by Depth

1) add new methods to one class, the EarthQuakeClient class:
	A) - Write the method filterByDepth.
	   - This method has three parameters( ArrayList of type QuakeEntry named quakeData, double named minDepth, double named maxDepth)
	   - This method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData whose depth is between minDepth and maxDepth, exclusive. (Do not include quakes with depth exactly minDepth or maxDepth.)

	B) - Write the void method quakesOfDepth 
	   - This method has no parameters to use filterByDepth and print all the earthquakes from a data source whose depth is between a given minimum and maximum value. You should also print out the number of earthquakes found.


Assignment 3: Filtering by Phrase in Title

1) add new methods to one class, the EarthQuakeClient class:
	A) - Write the method filterByPhrase
           - This method has three parameters( ArrayList of type QuakeEntry named quakeData, String named where that indicates where to search in the title and has one of three values: [“start”, ”end”, or “any”],  String named phrase indicating the phrase to search for in the title of the earthquake)
           - This  method should return an ArrayList of type QuakeEntry of all the earthquakes from quakeData whose titles have the given phrase found at location where (“start” means the phrase must start the title, “end” means the phrase must end the title and “any” means the phrase is a substring anywhere in the title.)

	B) - Write the void method quakesByPhrase to use filterByPhrase and print all the earthquakes from a data source that have phrase in their title in a given position in the title. You should also print out the number of earthquakes found.


Assignment 4: Finding the Closest Earthquakes to a Location

1) modify one class, the ClosestQuakes class:
	A) - Complete the method getClosest
	   - This method has three parameters( ArrayList of type QuakeEntry named quakeData, Location named current, int named howMany)
           - This method should find the closest number of howMany earthquakes to the current Location and return them in an ArrayList of type QuakeEntry.
	   - The earthquakes should be in the ArrayList in order with the closest earthquake in index position 0.  If there are fewer then howMany earthquakes in quakeData, then the ArrayList returned would be the same size as quakeData.  


Assignment 5: Finding the Largest Magnitude Earthquakes

1) Write a new class named  LargestQuakes:
	A) - Write a void method named findLargestQuakes that reads in earthquake data from a source and storing them into an ArrayList of type QuakeEntry. 
	   - Then it prints all the earthquakes and how many earthquakes that were from the source. You should read in earthquakes from the small file nov20quakedatasmall.atom 
	   - Print all the earthquakes and also print how many there are. After this works you should comment out the printing of all the earthquakes, but continue to print out the total number of earthquakes read in. 

	B) - Write a method named indexOfLargest 
	   - This method has one parameter( ArrayList of type QuakeEntry named data) 
	   - This method returns an integer representing the index location in data of the earthquake with the largest magnitude.
           - Test out this method by adding code to the method  findLargestQuakes to print the index location of the largest magnitude earthquake in the file nov20quakedatasmall.atom and the earthquake at that location. You will see that the largest such earthquake is at location 3 and has magnitude 5.50. Once this works you may want to comment this out. 

	C) - Write a method named getLargest
	   - This method has two parameters( ArrayList of type QuakeEntry named quakeData, integer named howMany)
	   - This method returns an ArrayList of type QuakeEntry of the top howMany largest magnitude earthquakes from quakeData. The quakes returned should be in the ArrayList in order by their magnitude, with the largest magnitude earthquake in index position 0.
	   - This method should call the method indexOfLargest.

	D) - Modify the method findLargestQuakes to call getLargest
