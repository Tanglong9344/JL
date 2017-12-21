package something_interesting;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int numOdd,numEven,num4;
		int number,n;
		int i,j;
		for(i=0;i<t;i++){
			n = sc.nextInt();
			numOdd=0;
			numEven=0;
			num4=0;
			for(j=0;j<n;j++){
				number = sc.nextInt();
				if(0 != (number%2)){
					numOdd++;
				}else if(0 == (number%4)){
					num4++;
				}else{
					numEven++;
				}
			}
			sc.close();
			if(n == (num4+numEven)){
				System.out.println("Yes");
			}else if(num4>=(numOdd+1) && n == (num4+numOdd)){
				System.out.println("Yes");
			}else if(num4>=numOdd){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
}