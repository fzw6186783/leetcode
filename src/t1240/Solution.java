package t1240;

import java.util.HashMap;
import java.util.Map;

public class Solution {



    private int  ans=Integer.MAX_VALUE;  //��¼��С��ɲ���
    private Map<Long,Integer>  rem=new HashMap<>(); //��¼֮ǰ�߹���·���������ظ�

    private void  dfs(int n,int m,int []h,int step){ //h ��nΪ��mΪ�ߵ����飬��¼���״̬
        if(step>=ans){  //��ǰ�����Ѿ�����֮ǰ��ɵ���Сֵ������
            return;
        }
        boolean full=true;   //�����ɱ�ʶλ
        int pos=-1,minH=Integer.MAX_VALUE; //��¼��ǰ���������Сֵ����ʼλ�ú͸߶�
        long key=0,base=m+1;   //���㵱ǰ���״̬�Ĺ�ϣֵ
        for(int i=1;i<=n;i++){
            if(h[i]<m){
                full=false;
            }
            if(h[i]<minH){
                pos=i;
                minH=h[i];
            }
            key+=h[i]*base;
            base*=m+1;
        }
        if(full){
            ans=Math.min(ans,step);   //��������ɣ��Ƚ���䲽��
            return;
        }
        if(rem.containsKey(key) && rem.get(key)<=step){ //���֮ǰ�������·���򷵻�
            return;
        }
        rem.put(key,step);  //��¼·��
        
        int end=pos;   //�������������λ��
        while(end+1<=n && h[end+1]==minH && end+1-pos+1+minH<=m) end++;

        for(int i=end;i>=pos;i--){  //�Ӵ�С���ο�ʼ��䷽��
            int curH=i-pos+1;//��ǰ��䷽��Ŀ��
            for(int j=pos;j<=i;j++){ //���
                h[j]+=curH;
            }
            dfs(n,m,h,step+1);   //�������
            for(int j=pos;j<=i;j++){ //����״̬
                h[j]-=curH;
            }
        }
        
        
        
    }
    
    
    public int tilingRectangle(int n, int m) {
        if(n==m){
            return 1;
        }
        if(n>m){
            int tmp=n;
            n=m;
            m=tmp;
        }
        dfs(n,m,new int[n+1],0);
        return ans;
    }
    }
