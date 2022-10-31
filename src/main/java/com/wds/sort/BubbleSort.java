package com.wds.sort;

import com.wds.beans.Student;

public class BubbleSort implements Sort {

	//Takes an unordered array of Student objects and performs bubble sort based on their test scores
	@Override
	public Student[] sort(Student []  unsortedArray) {
	
		int n = unsortedArray.length;
			
			for (int i =0; i< n -1; i++) {
				  for (int j = 0; j < n - i - 1; j++) {
					 
					if ((Double)unsortedArray[j].getScore() > (Double)unsortedArray[j+1].getScore() )   {
						Student  temp = unsortedArray[j+1];
						unsortedArray[j+1] = unsortedArray[j];
						unsortedArray[j] = temp;
					}
				}
			  }
			return unsortedArray;
			}
	  }

