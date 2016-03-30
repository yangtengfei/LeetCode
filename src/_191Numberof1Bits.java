
/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
 * so the function should return 3
 * @author ytf
 *
 */
public class _191Numberof1Bits {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int num = 0;
       while(0 != n){
    	   num += (n & 1);
    	  n =  n >>> 1;
       }
    	return num;
    }
}
