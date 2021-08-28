class Solution
{
    public static int getGcd(int n1,int n2) {
        if(n2==0)
        {
            return n1;
        }else
        {
            return getGcd(n2, n1%n2);
        }
    }
    public int gcd(int N , int arr[]) 
    { 
       //code here.
       if(arr.length<=1)
       {
           return arr[0];
       }
       int gcd=getGcd(arr[0],arr[1]);
       int i=2;
       while(i<N)
       {
           gcd=getGcd(gcd,arr[i]);
           ++i;
       }
       return gcd;
    } 
}
