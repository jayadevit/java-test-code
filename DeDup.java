



import java.util.ArrayList;

import java.util.HashSet;

import java.util.LinkedHashSet;

import java.util.List;

import java.util.Set;







public class DeDup {

public static int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,

		20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,

		13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

public static void main(String[] args) {

	DeDup dedup = new DeDup();

	

	System.out.println("de duping int array using hashset");

	for(int i:dedup.deDupeArrayInt(randomIntegers)){

		System.out.print(i+",");

	}

	System.out.println("\nde duping int array preserving order using linkedhashset");

	for(int i:dedup.orderedDeDupeArrayInt(randomIntegers)){

		System.out.print(i+",");

	}

	System.out.println("\nde duping int array preserving order using arraylist");

	for(int i:dedup.orderedDeDupeArrayIntViaList(randomIntegers)){

		System.out.print(i+",");

	}




}



/*

 * Efficient way for de duping the array with complexity n. this does not maintain order

 * overall complexity O(n) for loop * O(m) m being size of hashset plus O(1) for adding element

 */

public Integer[] deDupeArrayInt(int[] inputIntArray){

	long startTime = System.nanoTime();

	Set<Integer> intSet = new HashSet<Integer>();

	for(int i:inputIntArray){

			intSet.add(i);

	}

	long endTime = System.nanoTime();

	System.out.println("Time taken : "+(endTime-startTime));

	return intSet.toArray(new Integer[0]);

}



/*

 * Efficient way of de-duping list while maintaining order using LinkedHashSet introduced since Java 6.

 * this might be bit slower than hashset as complexity of hashset contain is (size of hashset) while that if LinkedHashSet is O(n)

 * Complexity O(n) for looping and plus O(1) for adding element

 */

public Integer[] orderedDeDupeArrayInt(int[] inputIntArray){

	long startTime = System.nanoTime();

	Set<Integer> intSet = new LinkedHashSet<Integer>();

	for(int i:inputIntArray){

			intSet.add(i);

	}

	long endTime = System.nanoTime();

	System.out.println("Time taken : "+(endTime-startTime));

	return intSet.toArray(new Integer[0]);

}



/*

 * Regular way of de-duping list while maintaining order using ArrayList can be used prior to Java 6 too

 * this will be slower than other two implementations to to complexity being O(n) however contains actually invokes equals method instead of hashcode way of above methods.

 * overall complexity would be O(n) for loop * O(n) for contanins menthod plus O(1) for addition, however the hashsets are far efficeint in deduping as they are based on hashcodes

 */

public Integer[] orderedDeDupeArrayIntViaList(int[] inputIntArray){

	long startTime = System.nanoTime();

	List<Integer> intList = new ArrayList<Integer>();

	for(int i:inputIntArray){

		if(!intList.contains(i))

			intList.add(i);

	}

	long endTime = System.nanoTime();

	System.out.println("Time taken : "+(endTime-startTime));

	return intList.toArray(new Integer[0]);

}




}
