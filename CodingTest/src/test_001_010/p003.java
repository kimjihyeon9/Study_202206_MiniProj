package test_001_010;

/*
문제 설명
길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 
예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
*/

public class p003 {

	public static void main(String[] args) {
		int n = 3;
		
        String answer = "";
        String a = "수";
        String c = "수박";
        String d = "";
        int b = n / 2;
        
        if (n % 2 == 1){
            
            d = c.repeat(b) + a;
            
        } else {
            d = c.repeat(b);
        }
        
        System.out.println(d);
        // 수박수
	}

}
