import java.util.*;
class Sol { 
public static void main(String[] args) {
    int[][] tab=new int[5][5];
    for(int i=0;i<tab.length;++i)
    {
        tab[i][i]=2;
    } 
    int cl=1;
    int n=tab.length;
    while(cl<n)
    {
        int j=cl;
        for(int i=0;i<n-cl;++i)
        {
            tab[i][j]=9;
            j++;
        }
        cl++;
    }   
    for(int i[]:tab)
    {
        System.out.println(Arrays.toString(i));
    }
}
}
