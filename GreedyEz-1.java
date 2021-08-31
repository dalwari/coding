import java.util.*;
class Sol { 
public static void main(String[] args) {
    int n=5,S=12;
    String r="";
    for(int i=0;i<n;++i)
    {
        if(S>=9)
        {
            r+="9";
            S-=9;
        }else if(S<9)
        {
            r+=String.valueOf(S);
            S-=S;
        }
    }
    if(9*n<S)
    {
        System.out.println("-1");    
    }else
    {
        System.out.println("-> "+r);
    }
    
}
}
