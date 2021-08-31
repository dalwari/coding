import java.util.*;
class Sol { 
public static void main(String[] args) {
int arr[]={900,940,950,1100,1500,1800};
int dep[]={910,1200,1100,1130,1900,2000};
Arrays.sort(dep);
int n=arr.length;
int i=0,j=0,p=0,mp=0;
while(i<n && j<n)
{
    if(arr[i]<=dep[j])
    {
        p++;
        i++;
    }else if(arr[i]>dep[j])
    {
        p--;
        j++;
    }
    mp=Math.max(p,mp);
}
System.out.println("mp-> "+mp);
}
}
