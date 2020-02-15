package t1240;

import java.util.HashMap;
import java.util.Map;

public class Solution {



    private int  ans=Integer.MAX_VALUE;  //记录最小完成步数
    private Map<Long,Integer>  rem=new HashMap<>(); //记录之前走过的路径，避免重复

    private void  dfs(int n,int m,int []h,int step){ //h 以n为宽，m为高的数组，记录填充状态
        if(step>=ans){  //当前步数已经超过之前完成的最小值，返回
            return;
        }
        boolean full=true;   //填充完成标识位
        int pos=-1,minH=Integer.MAX_VALUE; //记录当前填充竖向最小值的起始位置和高度
        long key=0,base=m+1;   //计算当前填充状态的哈希值
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
            ans=Math.min(ans,step);   //如果填充完成，比较填充步数
            return;
        }
        if(rem.containsKey(key) && rem.get(key)<=step){ //如果之前填充过这个路径则返回
            return;
        }
        rem.put(key,step);  //记录路径
        
        int end=pos;   //计算填充最大结束位置
        while(end+1<=n && h[end+1]==minH && end+1-pos+1+minH<=m) end++;

        for(int i=end;i>=pos;i--){  //从大到小依次开始填充方块
            int curH=i-pos+1;//当前填充方块的宽高
            for(int j=pos;j<=i;j++){ //填充
                h[j]+=curH;
            }
            dfs(n,m,h,step+1);   //继续填充
            for(int j=pos;j<=i;j++){ //回溯状态
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
