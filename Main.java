import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Course: EECS 114 Fall 2015
 *
 * First Name: Stefan
 * Last Name: Cao
 * Lab Section: 1A
 * email address: stefanc1@uci.edu
 *
 *
 * Assignment: lab4
 * Filename : Main.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 
 


public class Main {

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println("No input file provided. Expected Usage: java <executable> input.txt");
			System.exit(1);
		} 
		else {
			
			if (args[0].equals("input_int_small.txt")){
				File intfile = new File(args[0]);
				
				int lcCounter = 0;
					
				// Test MaxHeap
		
				System.out.println("We are going to test MaxHeap first...");
				System.out.println("Let's create an empty MaxHeap");
				System.out.println("MaxHeap newMaxHeap = new MaxHeap();");
				MaxHeap newMaxHeap = new MaxHeap();
				
				
				// Testing heapExtractMax() with an empty heap 
				System.out.println("\nNow, let's try 'heapExtractMax' on an empty heap...");
				System.out.println("newMaxHeap.heapExtractMax()");
				try{
					newMaxHeap.heapExtractMax();
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				
				// Testing heapMax() with an empty heap
				System.out.println("\nNow, let's try 'heapMax()' on an empty heap...");
				
				System.out.println("newMaxHeap.heapMax();");
				try{
					newMaxHeap.heapMax();
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				
				System.out.println("\nNow let's try to build a minHeap...");
				System.out.println("Let's read " + args[0] + "...");
				
				try {
					Scanner inNums = new Scanner(intfile).useDelimiter(" ");
					while(inNums.hasNextInt()) {
						lcCounter++;
						inNums.nextInt();
					}
					inNums.close();
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				int[] intArray = new int[lcCounter];
				
				int lcIndex = 0;
				try {
					Scanner inNums = new Scanner(intfile).useDelimiter(" ");
					while(inNums.hasNextInt()) {
						intArray[lcIndex] = inNums.nextInt();
						lcIndex++;
					}
					inNums.close();
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				System.out.println("Read file sucessfully and store the numbers in 'intArray'");
				
				System.out.println("Now let's build the MaxHeap...");
				System.out.println("newMaxHeap = new MaxHeap(intArray);");
				try{
				
					newMaxHeap = new MaxHeap(intArray);
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				
				System.out.println("Let's print the MaxHeap...");
				newMaxHeap.printMaxHeap();
				
				System.out.println("\n\nNow, let's try to insert '21' onto the max Heap...");
				System.out.println("newMaxHeap.maxHeapInsert(21);");
				try{
					
					newMaxHeap.maxHeapInsert(21);
				} catch(IndexOutOfBoundsException e){
					System.out.println(e.getMessage());
				}
				System.out.println("Here is the updated MaxHeap...");
				newMaxHeap.printMaxHeap();
				
				
				// Testing 'heapMax()' and 'heapExtractMax()'
				System.out.println("\n\nNow let's try the methods 'heapMax()' and 'heapExtractMax()'..");
				for(int i = 0; i < intArray.length+1; i++){
					System.out.println("heapMax() = " + newMaxHeap.heapMax());
					System.out.println("newMaxHeap.heapExtractMax();");
					try{
						newMaxHeap.heapExtractMax();
					} catch(IndexOutOfBoundsException e){
						System.err.println(e.getMessage());
						e.printStackTrace();
					}
					System.out.println("Here is the updated MaxHeap...");
					newMaxHeap.printMaxHeap();
					System.out.println("\n");
				}
				
				
				// Testing MinHeap
				System.out.println("\n\n\n");
				
				System.out.println("Now we are going to test MinHeap...");
			
				System.out.println("Let's create an empty MinHeap");
				System.out.println("MinHeap newMinHeap = new MinHeap();");
				MinHeap newMinHeap = new MinHeap();
				
				// Testing heapExtractMin() with an empty heap 
				System.out.println("\nNow, let's try 'heapExtractMin' on an empty heap...");
				System.out.println("newMinHeap.heapExtractMin()");
				try{
					newMinHeap.heapExtractMin();
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				
				// Testing heapMin() with an empty heap
				System.out.println("\nNow, let's try 'heapMin()' on an empty heap...");
				
				System.out.println("newMinHeap.heapMin();");
				try{
					newMinHeap.heapMin();
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				
				System.out.println("\nNow let's try to build a minHeap...");
				System.out.println("Let's reuse the the values read for the MaxHeap before...");

				System.out.println("newMinHeap = new MinHeap(intArray);");
				try{
				
					newMinHeap = new MinHeap(intArray);
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				
				System.out.println("Let's print the MinHeap...");
				newMinHeap.printMinHeap();
				
				System.out.println("\n\nNow, let's try to insert '2' into the min Heap...");
				System.out.println("newMinHeap.minHeapInsert(2);");
				try{
					
					newMinHeap.minHeapInsert(2);
				} catch(IndexOutOfBoundsException e){
					System.out.println(e.getMessage());
				}
				System.out.println("Here is the updated MinHeap...");
				newMinHeap.printMinHeap();
				
				
				// Testing 'heapMin()' and 'heapExtractMin()'
				System.out.println("\n\nNow let's try the methods 'heapMin()' and 'heapExtractMin()'..");
				for(int i = 0; i < intArray.length+1; i++){
					System.out.println("heapMin() = " + newMinHeap.heapMin());
					System.out.println("newMinHeap.heapExtractMin();");
					try{
						newMinHeap.heapExtractMin();
					} catch(IndexOutOfBoundsException e){
						System.err.println(e.getMessage());
						e.printStackTrace();
					}
					System.out.println("Here is the updated MinHeap...");
					newMinHeap.printMinHeap();
					System.out.println("\n");
				}
				
				
				
				//Testing Insert on a full heap
				System.out.println("\n\nLast thing, we are going to test 'maxHeapInsert(int key)' and 'minHeapInsert(int key)' on a full heap...");
				System.out.println("The CAPCACITY of both the heaps are 100");
				System.out.println("Now I will create another array with 100 elements...");
				System.out.println("int[] newintArray = new int[100];");	
				int[] newintArray = new int[100];
				
				System.out.println("I'm going to fill the newintArray with 100 elements of value 1...");
				System.out.println("Arrays.fill(newintArray, 1);");
				Arrays.fill(newintArray, 1);
				
				System.out.println("Now I will create new MaxHeap with that new int array");
				System.out.println("MaxHeap newMaxHeap2 = new MaxHeap(newintArray);");
				MaxHeap newMaxHeap2 = new MaxHeap(newintArray);
				
				System.out.println("Now I will try to Insert one element to heap which is supposed to be full...");
				System.out.println("newMaxHeap2.maxHeapInsert(21);");
				try{
					newMaxHeap2.maxHeapInsert(21);
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				
				System.out.println("Now I will do the same but with MinHeap with...");
				System.out.println("MinHeap newMinHeap2 = new MinHeap(newintArray);");
				MinHeap newMinHeap2 = new MinHeap(newintArray);
				
				System.out.println("Now I will try to Insert one element to heap which is supposed to be full...");
				System.out.println("newMinHeap2.minHeapInsert(2);");
				try{
					newMinHeap2.minHeapInsert(2);
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
			
			
			
			else if(args[0].equals("input_int_large.txt")){
				File intfile = new File(args[0]);
				
				int lcCounter = 0;
						
				//Testing large file
				
				System.out.println("Let's read " + args[0] + "...");
				
				try {
					Scanner inNums = new Scanner(intfile).useDelimiter("\n");
					while(inNums.hasNextInt()) {
						lcCounter++;
						inNums.nextInt();
					}
					inNums.close();
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				int[] intArray = new int[lcCounter];
				
				int lcIndex = 0;
				try {
					Scanner inNums = new Scanner(intfile).useDelimiter("\n");
					while(inNums.hasNextInt()) {
						intArray[lcIndex] = inNums.nextInt();
						lcIndex++;
					}
					inNums.close();
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				MaxHeap newMaxHeap = new MaxHeap();
				System.out.println("Read file sucessfully and store the numbers in 'intArray'");
				System.out.println("Now let's build the MaxHeap...");
				System.out.println("newMaxHeap = new MaxHeap(intArray);");
				
				
				try{
				
					newMaxHeap = new MaxHeap(intArray);
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				
				System.out.println("Let's print the MaxHeap...");
				newMaxHeap.printMaxHeap();
				
				System.out.println("\n\nNow, let's try to insert '21' onto the max Heap...");
				System.out.println("newMaxHeap.maxHeapInsert(21);");
				try{
					
					newMaxHeap.maxHeapInsert(21);
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				
				
				
				
				MinHeap newMinHeap = new MinHeap();
				System.out.println("Now let's do the same but with MinHeap...");
				System.out.println("Now let's build the MinHeap...");
				System.out.println("newMinHeap = new MinHeap(intArray);");
				
				
				try{
				
					newMinHeap = new MinHeap(intArray);
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
				
				System.out.println("Let's print the MinHeap...");
				newMinHeap.printMinHeap();
				
				System.out.println("\n\nNow, let's try to insert '21' onto the min Heap...");
				System.out.println("newMinHeap.minHeapInsert(21);");
				try{
					
					newMinHeap.minHeapInsert(21);
				} catch(IndexOutOfBoundsException e){
					System.err.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}
	

	}

}
