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
 * Filename : MinHeap.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 


public class MinHeap {
	
	// Private fields for MinHeap
	private int currentSize;	// number of items currently in heap	
	private int [] h;	//internal array to hold heap items
	
	// Max size for heap is set to 100
	public static final int CAPACITY = 10000;
	
	
	// remove later
	public int [] getArray(){
		return h;
	}
	
	// Default Constructor - constructs an empty min heap
	public MinHeap(){
		h = new int [CAPACITY];		
		currentSize = 0;	
	}
	
	// constructs a binary min heap given an array
	public MinHeap(int[] A){
		
		h = new int [CAPACITY];
		currentSize = A.length;
		
		//copy A array into h array
		for(int i = 0; i < A.length; i++){
			if(i == CAPACITY){
				throw new IndexOutOfBoundsException("The Heap is Full!");
			}
			h[i] = A[i];
		}
		
		// call buildMinHeap
		buildMinHeap();	
	}
	
	
	// Methods for MinHeap
	
	// build a MinHeap 
	void buildMinHeap(){
		
		// starting with the last parent in heap
		for(int i = (currentSize/2) - 1; i >= 0; i--){
			
			// call trickleDown which maintains the heap property
			trickleDown(i);
		}	
	}
	
	// Returning the minimum key in heap
	int heapMin(){
		if(currentSize == 0){
			throw new IndexOutOfBoundsException("The Heap is Empty!");
		}
		
		// if the heap is not empty, return the first element which is the min
		else{
			return h[0];
		}
	}
	
	// Removing the minimum key in the heap
	void heapExtractMin(){
		
		if(currentSize == 0){
			throw new IndexOutOfBoundsException("The Heap is Empty!");
		}
		else{
			// overwrite the last element in array to first element in heap
			h[0] = h[currentSize-1];
			currentSize--;
			
			// call buildMinHeap to maintain the heap property
			buildMinHeap();
		}
	}
	
	// Insert a key into the heap
	void minHeapInsert(int key){
		
		if(currentSize == CAPACITY){
			throw new IndexOutOfBoundsException("The Heap is Full!");
		}
		else{
		
			// trickling up and maintaining the heap property
			trickleUp(key);
		}
		
	}
	
	// Trickling down - Maintains the heap property between 
	//		a parent node located at index in array, and its children. 
	void trickleDown(int index){
		
		// defining smaller child which is either left or right child
		int smallerChild;
		
		// set the key of parent 
		int parentKey = h[index];
	
		while(index < currentSize/2){
		
			// getting the left child and right child
			int leftChild = 2*index + 1;
			int rightChild = 2*index + 2;
		
			// if rightChild <  currentSize test if there is a right child 
			// check if leftChild's key is greater, if so but smallerChild as right Child
			if((rightChild < currentSize) && (h[leftChild] > h[rightChild])){
				smallerChild = rightChild;
			}
			
			// else leftChild is smaller child
			else{
				smallerChild = leftChild;
				
			}
			
			// if the parent key is smaller than the key of smallerChild then break
			// 		don't need to trickle down anymore
			if(parentKey <= h[smallerChild]){
				break;
			}
			
			// replace smallerChild's key with parent's key
			h[index] = h[smallerChild];
			
			// current index is now smaller child's index
			index = smallerChild;
		}
		
		// setting 'initial' parent's key in the new index in array
		h[index] = parentKey;
		
	}
	
	// Trickle Up maintains the heap property between a node located in index, and its parent
	void trickleUp(int index){
		
		int x = currentSize;
		
		while(x > 0 && h[(x-1)/2] > index){
			h[x] = h[(x-1)/2];
			x = (x-1)/2;
		}
		
		h[x] = index;
		currentSize++;
	
	}
	
	
	//printing method 
	void printMinHeap(){
		
		int x = 0;
		int y = 0;
		for(int i = 0; i < currentSize; i++){
			
			System.out.print(h[i] + " ");
			if(i + 1 - y == Math.pow(2, x)){
				System.out.print("\n");
				x++;
				y = i + 1;
			}
		
		}
		System.out.print("");

	}
	
}
