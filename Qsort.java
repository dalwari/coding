import java.util.*;
class Sol {    
    public static void swap(int[] a,int i,int j)
    {
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public static int partition(int[] a,int low,int high) {
        int i=low-1;
        int pivot=a[high];
        for(int j=low;j<high;++j)
        {
            if(a[j]<pivot)
            {
                swap(a,++i,j);
            }
        }
        swap(a,i+1,high);
        return i+1;
    }
    public static void qsort(int[] a,int low,int high)
    {
        if(low<high)
        {
            int pi=partition(a,low,high);
            qsort(a,low,pi-1);
            qsort(a,pi+1,high);
        }
    }
    public static void main(String[] args) {
        int a[]={9,1,8,2,7,3,6,4,5,10};
        qsort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
      }
}
