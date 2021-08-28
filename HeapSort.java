import java.util.*;
class Sol {    
    public static void swap(int[] a,int i,int j)
    {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public static void heapSort(int[] a) {
        int n=a.length;
        for(int i=n/2;i>=0;--i)
        {
            heapify(a,n,i);
        }
        for(int i=n-1;i>=0;--i)//(i>0)is also correct
        {
            swap(a,i,0);
            heapify(a,i,0);
        }
    }
    public static void heapify(int[] a,int n,int i) {
        int lar=i;
        int l=2*i+1;
        int r=2*i+2;
        if(l<n && a[lar]<a[l])
        {
            lar=l;
        }
        if(r<n && a[lar]<a[r])
        {
            lar=r;
        }
        if(lar!=i)
        {
            swap(a, lar, i);
            heapify(a, n, lar);
        }
    }
    public static void main(String[] args) {
        int a[]={9,1,8,2,7,3,6,4,5,10};
        heapSort(a);
        System.out.println(Arrays.toString(a));
      }
}
