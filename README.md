# Minimum-number-of-descending-subarrays--Greedy
Decomposition in minimal number of decreasing subsequences, using Greedy algorithm.  
  
*Author: Ioana-Sofia Pascu  
University of Bucharest, Faculty of Mathematics and Computer Science, Department of Computer Science  
Created: 11/11/2016*


##Task
Given a sequence of natural numbers, decompose it in a minimum number of decreasing subsequences (not strictly) and print these subsequences.  
Required complexity: **O(n log n)**  

##Sample input
6  
11 13 10 15 12 7

##Sample output
11 10 7  
13 12  
15

##Algorithm description
-We go through each element of the sequence.  
-We try to find a sequence to add it to (we use binary search through the top elements of the existing subsequences).
 -If we do find such a sequence we add the element to it.  
 -If we don't, then we create a new sequence.  
-If, at some point, there are multiple choices (we can add it to more than one subsequence) we pick the one with the lowest top element.


###Example
We consider the sample input above.  
-First we have no subsequences, so we need to create a new one for element **11**.  

*Result:   
**11***  
  
-We can't add **13** after 11, so we need another subsequence.  

*Result:   
11  
**13***  
  
-We can add **10** to both existing subsequences, but we will choose the first one, as 11 < 13.  
  
*Result:   
11 **10**  
13*  
  
-We continue the reasoning until we have added all elements.   

##Use of variables/functions
-**n** -> number of elements  
-**arr** -> the array of elements  
-**nrS** -> number of created subarrays at some point  
-**top** -> holds the tops of the subarrays (the minimal element in each)  
-**s** -> array where s[i] is the index of the subarray arr[i] belongs to  
-**search(int s, int f, int what)** -> uses binary search and returns the index of the subarray where we should put 'what', or -1 if we don't find any  
-**buildSubarrays()** -> builds the actual subsequences  
