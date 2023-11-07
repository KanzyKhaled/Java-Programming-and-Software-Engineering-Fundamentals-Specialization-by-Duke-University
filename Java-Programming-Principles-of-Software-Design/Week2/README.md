# WEEK 2 NOTES

## Exercise1 - Programming Exercise - Implementing Selection Sort

## Assignment 1: Sort by Depth

### Modify the QuakeSortInPlace class:
A) - Write the method getLargestDepth 
   - This method has two parameters( ArrayList of type QuakeEntry named quakeData,  int named from representing an index position in the ArrayList)
   - This method returns an integer representing the index position of the QuakeEntry with the largest depth considering only those QuakeEntry’s from position from to the end of the ArrayList.

B) - Write the void method sortByLargestDepth
   - This method has one parameter( ArrayList of type QuakeEntry named in)
   - This method sorts the QuakeEntry’s in the ArrayList by depth using the selection sort algorithm, 
	 but in reverse order from largest depth to smallest depth (the QuakeEntry with the largest depth should be in the 0th position in the ArrayList).
   - This method should call the method getLargestDepth repeatedly until the ArrayList is sorted. 

C) - Modify the testSort method
   - comment out the line sortByMagnitude and add below this line a call to sortByLargestDepth. 
   - Run your program on any data file and you should see the earthquakes in sorted order from largest depth to smallest depth. 


## Assignment 2: Bubble Sort

### Modify the QuakeSortInPlace class:
A) - Write the void method onePassBubbleSort
   - This method has two parameters( ArrayList of type QuakeEntry named quakeData, int named numSorted 
	 "that represents the number of times this method has already been called on this ArrayList 
	  and thus also represents the number of the elements that are guaranteed to already be where they belong when the ArrayList is sorted by magnitude."
   - This method makes one pass of bubble sort on the ArrayList.
   - It should take advantage of the fact that the last numSorted elements are already in sorted order.

B) - Write the void method sortByMagnitudeWithBubbleSort
   - This method has one parameter( ArrayList of type QuakeEntry named in)
   - If the ArrayList in has N elements in it, this method should call onePassBubbleSort N – 1 times to sort the elements in in.  

C) - Modify the testSort method 
   - comment out the line sortByLargestDepth, and add below this line a call to sortByMagnitudeWithBubbleSort. 
   - Run your program on any data file and you should see the earthquakes in sorted order from smallest to largest magnitude. 


## Assignment 3: Check for Completion

### Modify the QuakeSortInPlace class:
A) - Write the method checkInSortedOrder 
   - This method has one parameter( ArrayList of type QuakeEntry named quakes)
   - This method returns true if the earthquakes are in sorted order by magnitude from smallest to largest. Otherwise this methods returns false.

B) - Write the void method sortByMagnitudeWithBubbleSortWithCheck
   - This method has one parameter( ArrayList of type QuakeEntry named in)
   - If the ArrayList in has N elements in it, this method should call onePassBubbleSort at most N – 1 times.
   - This method should call checkInSortedOrder and stop early if the ArrayList is already sorted.
   - This method should print how many passes were needed to sort the elements. 

C) - Modify the testSort method to call to sortByMagnitudeWithBubbleSortWithCheck. 

D) - Write the void method sortByMagnitudeWithCheck 
   - This method has one parameter( ArrayList of type QuakeEntry named in)
   - This method sorts earthquakes by their magnitude from smallest to largest using selection sort similar to the sortByMagnitude method.
   - This method should call checkInSortedOrder and stop early if the ArrayList is already sorted. 
   - This method should print how many passes were needed to sort the elements. For selection sort, one pass has exactly one swap.

E) - Modify the testSort method to call to sortByMagnitudeWithCheck.


## Exercise2 - Programming Exercise - Sorting at Scale

## Assignment 1: compareTo Method

### Modify the compareTo method to sort quakes in a different way. 
 
A) - Modify the compareTo method in the QuakeEntry class. 
   - The compareTo method should now sort quake by magnitude first, from smallest magnitude to largest magnitude,
   - Then break ties by depth, from smallest (most negative) depth to largest depth.
   - Test the compareTo method by running the sortWithCompareTo method.
   
## Assignment 2: Title Comparator

### Write a Comparator to sort earthquakes by title first and break ties by depth. 

A) - Write the TitleAndDepthComparator class that implements a Comparator of type QuakeEntry.
   - In this class you should write the compare method that has two parameters( QuakeEntry named q1, QuakeEntry named q2)
   - This method should compare the title of q1 and q2. 
   - If q1’s title comes before q2’s title in alphabetical order.
   - Then this method should return a negative integer. 
   - If q1’s title comes after q2’s title, then this method should return a positive integer. 
   - If q1’s title is the same as q2’s title, then this method should compare the depth of the two earthquakes. 
   - If q1’s depth is less than q2’s depth, then this method should return a negative number. 
   - If q1’s depth is greater than q2’s depth, then this method should return a positive integer. 
   - Otherwise, this method should return 0. 

B) - Write the void method sortByTitleAndDepth in the DifferentSorters class. 
   - This method should create an EarthQuakeParser, read data from a file on earthquakes and create an ArrayList of QuakeEntry’s. 
   - Then this method should call Collections.sort on this ArrayList and use the TitleAndDepthComparator to sort the earthquakes. 
   - You should be able to see that the earthquakes are sorted by title first, and those with the same title are sorted by depth. 
   - Modify this method to print out the QuakeEntry in the ArrayList in position 10 after sorting and printing out all the elements.