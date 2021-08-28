import java.util.*;
class Sol {    
    public static Long power(Long X,Long Y) {
        if(Y==1)
        {
            return 1l;
        }
        if(X==1 || X>Y)
        {
            return (long)0; 
        }
        long i=0l;
        for(i=X;i<Y;i*=X);
        if(i==Y)
        {
            return 1l;
        }
        return 0l;
    }
    public static void main(String[] args) {
      // code here
      long r=power(9l, 63l);
      System.out.println("power=> "+r);
}
}
