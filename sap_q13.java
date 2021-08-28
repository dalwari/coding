class Solution {
    
    public static Long getGcd(Long n1,Long n2) {
        if(n2==0)
        {
            return n1;
        }else
        {
            return getGcd(n2, n1%n2);
        }
    }
    static Long[] lcmAndGcd(Long A , Long B) {
        Long gcd=getGcd(A,B);
        Long lcm=(A*B)/gcd;
        Long[] l=new Long[2];
        l[0]=Long.valueOf(lcm);
        l[1]=Long.valueOf(gcd);
        return l;
    }
};
