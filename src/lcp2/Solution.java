package lcp2;

import org.junit.Test;

public class Solution {
	 public int[] fraction(int[] cont) {
	        fenshu a=new fenshu(cont[cont.length-1], 1);
	        for(int i=cont.length-1;i>-1;i--){
              a.fanzhuan();
              a=a.add(a, new fenshu(cont[i], 1));
	        }
	        return new int[]{a.getFenzi(),a.getFenmu()};
	    }
	 private class fenshu{
		 private int fenzi;
		 private int fenmu;
		 public fenshu(int a,int b) {
			if(b==0) {b=1;}
			fenzi=a;fenmu=b;
		}
		 public void fanzhuan() {
			 if(fenzi==0) {return;}
			 int temp=0;temp=fenzi;fenzi=fenmu;fenmu=temp;
		 }
		 public fenshu add(fenshu a1,fenshu a2) {
			 if(a1.fenzi==0) {return a2;}
			 if(a2.fenzi==0) {return a1;}
			 if(a2.fenmu==a1.fenmu) {return new fenshu(a1.fenzi+a2.fenzi, a1.fenmu);}
			 a1.fenzi*=a2.fenmu;a2.fenzi*=a1.fenmu;
			 a1.fenmu*=a2.fenmu;
			
			 return new fenshu((a1.fenzi+a2.fenzi), a1.fenmu);
		 }
		public int getFenzi() {
			return fenzi;
		}
	
		public int getFenmu() {
			return fenmu;
		}
	
		 
	 }
	 public static int getGCD(int num1, int num2) {
	        // 先获得绝对值，保证负数也可以求
	        num1 = Math.abs(num1);
	        num2 = Math.abs(num2);
	        // 区分数值大小，为后面终止条件做准备
	        int min = num1 > num2 ? num2 : num1;
	        int max = num1 > num2 ? num1 : num2;
	        // 设初始最大公约数为 1
	        int gcd = 1;
	        // 连续求出两个数的公约数，并累积，直到两个数互质（除了1，没有其它公约数）
	        // 终止条件就是当 i 一直判断到 较小的那个数，都还没发现公约数，即可认定互质
	        int i = 2;
	        while (i <= min) {
	            // 如果 i 是两个数的约数，则进行短除
	            if (min % i == 0 && max % i == 0) {
	                min /= i;   // 短除一次后的商
	                max /= i;
	                gcd *= i;   // 公约数累积
	                i = 2;      // i 从 2 开始，重新开始找商的约数
	            }
	            // 否则继续判断
	            i++;
	        } // while
	        return gcd;
	    }
	 @Test
	 public void ss() {
		int[] cont= {3,2,0,2};
		 System.out.println(fraction(cont));
	 }
}
