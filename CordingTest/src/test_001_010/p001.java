package test_001_010;

import java.util.ArrayList;
import java.util.Arrays;

/*
문제 설명
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,

arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요 
*/

public class p001 {

	// 내코드
	public static void test(String[] args) {
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
	
	// 내코드에서 대준님이 풀어주신 코드
	public static void main(String[] args) { 
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
				
		int count =1;
        
        for (int i =1; i<arr.length; i++){
            if(arr[i-1] != arr[i]){
                count++;            
            }
        }
        //arr = [1, 1, 3, 3, 0, 1, 1]
        //count = 4
        
        int[] answer = new int[count];
        
        answer[0] = arr[0];
        
        int num = 1;
        
        for(int j=1; j<arr.length; j++){
            if(arr[j-1] != arr[j]){
              answer[num] = arr[j]; 
              num++;
            }    
        }
        
            
        System.out.println(Arrays.toString(answer));
        // [1, 3, 0, 1]

	}
	
	// 광민이 코드
	public static void main2(String[] args) {
		long test = 0;
	    int[] answer=null;
	      
	    ArrayList<Integer> list = new ArrayList<Integer>();
	      
	    for(;(test/10) != 0;) {
	       list.add( (int) (test%10) ); 
	       System.out.println("??");
	       test /= 10;
	    }
	    list.add( (int) test%10);
	      
	    answer = list.stream().mapToInt(i -> i).toArray();
	      
	    System.out.println(Arrays.toString(answer));
	}

}
