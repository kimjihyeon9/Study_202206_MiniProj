package test_001_010;

/*
문제 설명
새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다. 
이 놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 하였습니다. 
즉, 처음 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록 solution 함수를 완성하세요.
단, 금액이 부족하지 않으면 0을 return 하세요.

입출력 예 #1
이용금액이 3인 놀이기구를 4번 타고 싶은 고객이 현재 가진 금액이 20이라면, 
총 필요한 놀이기구의 이용 금액은 30 (= 3+6+9+12) 이 되어 10만큼 부족하므로 10을 return 합니다.
*/

/* 정답.. (못품)
long long solution(int price, int money, int count) {
    long long answer = -1;
    long long all_price=0;
    for (int i = 1;i<=count;i++){
        all_price += price *i;
    }
    if (all_price>money){
        answer = all_price - money;
    }
    else{
        answer = 0;
    }
    return answer;
}
 */

public class p004 {

	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;
		
		long answer = -1;
		
		int a = 3;
		int b = 0;
		int c = 0;
		int d = 0;
		
		for(int i = 1; i < count; i++) {
			if(b < money) {
//				a = b + price;
//				price += price;
				
//				if(b == 0) {
//					a = price;
//				}else {
//					a = b;					
//				}
				
				if(b != 0) {
					a = b;
				}
				
//				System.out.print(a + "\t");
//				System.out.print(price + " ");
//				System.out.print(b);
//				System.out.println();
			} 
			b = a + price;
//			else if(price > money) {
//				answer = price - money;
//			}
//			if((a + b) > money) {
//				answer = (a + b) - money;
//			}
			if(i != 1) {
				c = b + price;
				d = c;
			}
			if(i < count) {
				answer = c - money;
			}
		}
		System.out.println(d);
//		System.out.println(a+b);
//		System.out.println(answer);
//		System.out.println(b);
	}

}
