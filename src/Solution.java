public class Solution {
    public static long[] xgcd(long a, long b){
		long[] retvals={0,0,0};
                System.out.println("Hello friends");
		long aa[]={1,0}, bb[]={0,1}, q=0;
		while(true) {
    		q = a / b; a = a % b;
	    	aa[0] = aa[0] - q*aa[1];  bb[0] = bb[0] - q*bb[1];
    		if (a == 0) {
      			retvals[0] = b; retvals[1] = aa[1]; retvals[2] = bb[1];
      			return retvals;
	    	};
    		q = b / a; b = b % a;
    		aa[1] = aa[1] - q*aa[0];  bb[1] = bb[1] - q*bb[0];
	    	if (b == 0) {
    	  		retvals[0] = a; retvals[1] = aa[0]; retvals[2] = bb[0];
      			return retvals;
	    	};
    	}
    }
    
    public static void main(String[] args){
	/*if(args.length < 2){
	    System.out.println("Usage: xgcd(a,b)"); System.exit(-1);};*/
	long a = 11;
	long b = (long)Math.pow(10,9)+7;
	long[] retvals;
	retvals = xgcd(a,b);
        System.out.println(retvals.length);
	System.out.println(retvals[0]+","+(retvals[1]+b)+","+retvals[2]);
        long r=(long)60*(retvals[1]+b);
        System.out.println(r%b);
    };
}