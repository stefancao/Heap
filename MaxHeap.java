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
 * Filename : MaxHeap.java
 *
 * I hereby certify that the contents of this file represent
 * my own original individual work. Nowhere herein is there 
 * code from any outside resources such as another individual,
 * a website, or publishings unless specifically designated as
 * permissible by the instructor or TA.
 */ 


public class MaxHeap {

	// private fields for MaxHeap class
	private int currentSize;
	private int[] h;
	
	// Max size for heap is set to 100
	public static final int CAPACITY = 10000;
	
	
	// Default Constructor - constructs an empty max heap
	public MaxHeap(){
		h = new int [CAPACITY];		//change the size later
		currentSize = 0;
	}
	
	// constructs a binary max heap given an array
	public MaxHeap(int[] A){
		
		h = new int [CAPACITY];
		currentSize = A.length;
		
		//copy A into h
		for(int i = 0; i < A.length; i++){
			if(i == CAPACITY){
				throw new IndexOutOfBoundsException("The Heap is Full!");
			}
			h[i] = A[i];
		}
		
		// call buildMaxHeap
		buildMaxHeap();
		
	}
	
	
	// building a max heap from unsorted array
	void  buildMaxHeap(){
		
		// starting with the last parent in heap
		for(int i = (currentSize/2)-1; i >= 0; i--){
			
			// call trickleDown which maintains the heap property
			trickleDown(i);
		}
		
	}
	
	// returning the max key in heap which is the first element in the array
	int heapMax(){
		if(currentSize == 0){
			throw new IndexOutOfBoundsException("The Heap is Empty!");
		}
		else{
			return h[0];
		}
	}
	
	// removes the max key (first element in array) and need to make sure to keep the heap property
	void heapExtractMax(){
		
		if(currentSize == 0){
			throw new IndexOutOfBoundsException("The Heap is Empty!");
		}
		else{
		
			// overwrite the last element's key to the first element
			h[0] = h[currentSize-1];
			currentSize--;
			
			// call buildMaxHeap to make sure to keep the max heap property
			buildMaxHeap();
		}
	}
	
	
	// insert a key into heap
	void maxHeapInsert(int key){
		if(currentSize == CAPACITY){
			throw new IndexOutOfBoundsException("The Heap is Full!");
		}
		else{
			trickleUp(key);
		}
	}
	
	// Trickling down - Maintains the heap property between 
	//		a parent node located at index in array, and its children.
	void trickleDown(int index){
		
		int largerChild;
		int parentKey = h[index];
		
		while(index < currentSize/2){
		
			// find the left and right child given the index
			int leftChild = 2*index + 1;
			int rightChild = 2*index + 2;
			
			// if the right child exists and the rightChild is larger than the left child, largerChild is rightChild
			if((rightChild < currentSize) && (h[leftChild] < h[rightChild])){
				largerChild = rightChild;
			}
			
			// else the leftChild is the larger child
			else{
				largerChild = leftChild;
				
			}
			
			// if the paret's key is larger than largerChild's key then break from loop
			if(parentKey >= h[largerChild]){
				break;
			}
			
			// replace largerChild's key with parent's key
			h[index] = h[largerChild];
			
			// current index is now smaller child's index
			index = largerChild;
			
		}
		
		// setting 'initial' parent's key in the new index in array
		h[index] = parentKey;
	}
	
	// Trickle Up maintains the heap property between a node located in index, and its parent
	void trickleUp(int index){
		
		int x = currentSize;
		
		while(x > 0 && h[(x-1)/2] < index){
			h[x] = h[(x-1)/2];
			x = (x-1)/2;
		}
		
		h[x] = index;
		currentSize++;
		
	}
	
	//printing method 
	void printMaxHeap(){
		
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
