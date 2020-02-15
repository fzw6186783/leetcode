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
	        // �Ȼ�þ���ֵ����֤����Ҳ������
	        num1 = Math.abs(num1);
	        num2 = Math.abs(num2);
	        // ������ֵ��С��Ϊ������ֹ������׼��
	        int min = num1 > num2 ? num2 : num1;
	        int max = num1 > num2 ? num1 : num2;
	        // ���ʼ���Լ��Ϊ 1
	        int gcd = 1;
	        // ��������������Ĺ�Լ�������ۻ���ֱ�����������ʣ�����1��û��������Լ����
	        // ��ֹ�������ǵ� i һֱ�жϵ� ��С���Ǹ���������û���ֹ�Լ���������϶�����
	        int i = 2;
	        while (i <= min) {
	            // ��� i ����������Լ��������ж̳�
	            if (min % i == 0 && max % i == 0) {
	                min /= i;   // �̳�һ�κ����
	                max /= i;
	                gcd *= i;   // ��Լ���ۻ�
	                i = 2;      // i �� 2 ��ʼ�����¿�ʼ���̵�Լ��
	            }
	            // ��������ж�
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
