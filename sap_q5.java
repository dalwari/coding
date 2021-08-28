import java.util.*;
class Mycomparator implements Comparator<Integer>
{
    public int compare(Integer i,Integer j)
    {
        return i-j;
    }
}
class Sol {
    public static void main(String[] args) {
        int a[] = {12, 35, 1, 10, 34, 1};
        Stack<Integer> st=new Stack<>();
        for(int x:a)
        {
            st.push(x);
        }
        Collections.sort(st,new Mycomparator());
        st.pop();
        System.out.println("2nd largest-> "+st.peek());
      }
}
