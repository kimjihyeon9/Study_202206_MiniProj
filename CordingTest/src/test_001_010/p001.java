package test_001_010;

import java.util.Arrays;

public class p001 {

	public static void main(String[] args) {
        int[] arr1 = {1,1,3,3,0,1,1};
//        int[] arr1 = {1,1,3,3,0,1,1};
//        int[] arr2 = {4,4,4,3,3};
        
        int a = 0;
        int[] b = new int[4];
        
//        for(int i = 0; i < arr1.length; i++) {
////        	a = arr1[i];
//        	
//        	for(int j = 1; j < arr1.length-1; j++) {
//        		
//        		if(arr1[i] != arr1[j]) {
//        			b[i] = arr1[i];
//        			
//        		}
//        	}
//        }
        int j = 0;
        
        for(int i = 0; i < arr1.length; i++){
        	if(i == arr1.length-1) {
        		a = arr1[i];        		
        	} else {
        		a = arr1[i-1];
        	}

            if(arr1[i] != a){
                b[j] = a;
                j++;
            } 
            System.out.print(a);
            System.out.println(arr1[i]);
        }
        System.out.println(Arrays.toString(b));
	}

}
