package com.bao.doan.example;

/*
 * A TrainComposition is built by attaching and detaching wagons from the left and the right sides.

For example, if we start by attaching wagon 7 from the left followed by attaching wagon 13, again from the left, we get a composition of two wagons (13 and 7 from left to right). Now the first wagon that can be detached from the right is 7 and the first that can be detached from the left is 13.

Implement a TrainComposition that models this problem.
https://www.testdome.com/files/resources/12362/0836c9ed-ed30-4f11-8a8f-9ac1b5296b02.png
*/
public class TrainComposition {
	TrainComposition head, last;
	int value;
	
    public void attachWagonFromLeft(int wagonId) {
    	TrainComposition train = new TrainComposition();
    	train.value = wagonId;
    	if(head == null) {
    		head = last = train;
    		head.last = last; 
    		last.head = head;
    	}
    	else {  
    	  head.head = train;
    	  train.last = head;
    	  head = train;
    	}
    }

    public void attachWagonFromRight(int wagonId) {
    	TrainComposition train = new TrainComposition();
    	train.value = wagonId;
    	if(last == null) {
    		head = last = train;
    		head.last = last; 
    		last.head = head;
    	}
    	else {
    	  last.last = train;
    	  train.head = last;
    	  last = train;
    	}
    }

    public int detachWagonFromLeft() {
      int value = head.value;
       head = head.last;
       return value;
    }

    public int detachWagonFromRight() {
    	 int value = last.value;
         last = last.head;
         return value;
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7 
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}
