import java.util.*;
class Sol {
    public static int count(int x)
    {
        int s=0;
        while(x>0)
        {
            int r=x%2;
            s+=r;
            //s++;
            x/=2;
            
        }
        return s;
    }
    public static void main(String[] args) {
        int n=3;
        int x=0,r=0;
        for(x=1;x<=n;++x)
        {
            r=x+count(x);
            System.out.println("x-> "+x+" r-> "+r);
            if(r==n)
            {
                r=0;
                break;
            }
        }

        System.out.println("r-> "+(r>0?1:0));
    }

}
