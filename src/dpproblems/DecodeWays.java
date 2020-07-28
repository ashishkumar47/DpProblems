import java.util.*;

//recursive solution will fail on this testCase:
//"1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"
//problem link: https://leetcode.com/problems/decode-ways/

public class DecodeWays{

static int numDecodingsRecursion(String s) {
        return helperRecursion(s);
    }
static int helperRecursion(String s){
        if(s.length()==0)
            return 1;
        if(s.charAt(0)=='0')
            return 0;
        int chooseOne=helperRecursion(s.substring(1));
        int chooseTwo=0;
        if(s.length()>=2){
            String str=""+s.charAt(0)+s.charAt(1);
            if(Integer.parseInt(str)<=26)
            chooseTwo=helperRecursion(s.substring(2));
        }
            
        return chooseOne+chooseTwo;
    }

static int numDecodingsMemo(String s) {
        int[] dp=new int[s.length()+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return helperMemo(s,dp);
    }
    static int helperMemo(String s,int[] dp){
        if(s.length()==0)
            return 1;
        if(s.charAt(0)=='0')
            return 0;
        if(dp[s.length()]!=Integer.MAX_VALUE)
            return dp[s.length()];
        int chooseOne=helperMemo(s.substring(1),dp);
        int chooseTwo=0;
        if(s.length()>=2){
            String str=""+s.charAt(0)+s.charAt(1);
            if(Integer.parseInt(str)<=26)
            chooseTwo=helperMemo(s.substring(2),dp);
        }
         dp[s.length()]=chooseOne+chooseTwo;
        return chooseOne+chooseTwo;
    }


	public static void main(String[] args) {
		System.out.println(numDecodingsRecursion("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
		System.out.println(numDecodingsMemo("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
	}
}