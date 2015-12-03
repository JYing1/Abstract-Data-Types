public class UtilityOperations {
    
    public static int overflow(int t) {
        int o = t/100000000;
        return o;
    }
    
    public static int underflow(int t) {
    	int u = t%100000000;
        return u;
    }
    
    public static int upperHalf(int t) {
    	int uH = t/10000;
    	return uH;
    }
    
    public static int lowerHalf(int t) {
        int lH = t%10000;
        return lH;
    }
    
    public static int digits(int t) {
    	int d = 0;
    	while (t > 0){
    		t = t/10;
    		d++;
    	}
    	return d;
    }
}