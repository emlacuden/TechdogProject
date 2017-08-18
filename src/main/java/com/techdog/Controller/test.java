package com.techdog.Controller;

import java.util.LinkedList;
import java.util.Queue;

import com.techdog.model.ImageFromCamera;

public class test {

	public static void main(String[] args) {
		Queue queue = new LinkedList();
		    
	    //you add elements to queue using add method
	    
		// TODO Auto-generated method stub
		Thread test1 = new Thread() {
			public void run() {
				while(true) {
					ImageFromCamera imgFromCamera = new ImageFromCamera(true, null);
					queue.add(imgFromCamera);
					//System.out.println("java is added");
				}
				
				
			}
		};
		Thread test2 = new Thread() {
			public void run() {
				while(true) {
					if(!queue.isEmpty()) {
						ImageFromCamera img = (ImageFromCamera)queue.element();
						System.out.println("value : " +img.getState());
						queue.remove();
						}
				}
				
				
			}
		};
		test1.start();
		test2.start();
		
	}

}
