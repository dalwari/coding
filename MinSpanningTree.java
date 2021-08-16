import java.util.*;
class Sol {
    public static int minKey(int[] key,boolean[] mstSet)
    {
        int min_ind=-1,min_key=Integer.MAX_VALUE;
        for(int v=0;v<mstSet.length;++v)
        {
            if(mstSet[v]==false && key[v]<min_key)
            {
                min_key=key[v];
                min_ind=v;
            }
        }
        return min_ind;
    }
    public static void printMst(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        int[] parent=new int[V];
        int[] key=new int[V];
        boolean[] mstSet=new boolean[V];
        Arrays.fill(key,Integer.MAX_VALUE);
        Arrays.fill(mstSet,false);
        key[0]=0;
        parent[0]=-1;
        //System.out.println("Arrays.toString(key)-> "+Arrays.toString(key));
        //System.out.println("Arrays.toString(parent)-> "+Arrays.toString(parent));
        //System.out.println("Arrays.toString(mstSet)-> "+Arrays.toString(mstSet));
        for(int c=0;c<adj.size();++c)
        {
            int u=minKey(key,mstSet);
            mstSet[u]=true;
            for(int v=0;v<adj.get(u).size();++v)
            {
                //if(adj.get(u).get(v).get(1)!=0 && mstSet[v]==false && adj.get(u).get(v).get(1)<key[v])
                int des=adj.get(u).get(v).get(0);
                if(adj.get(u).get(v).get(1)!=0 && mstSet[des]==false && adj.get(u).get(v).get(1)<key[des])
                {
                    parent[des]=u;
                    key[des]=adj.get(u).get(v).get(1);
                }
            }
        }
        
        //System.out.println("Arrays.toString(key)-> "+Arrays.toString(key));
        //System.out.println("Arrays.toString(parent)-> "+Arrays.toString(parent));
        //System.out.println("Arrays.toString(mstSet)-> "+Arrays.toString(mstSet));
        int cost=0;
        for(int k=0;k<key.length;++k)
        {
            cost+=key[k];
        }
        System.out.println("cost-> "+cost);
    }
  public static void main(String[] args) {
    ArrayList<ArrayList<ArrayList<Integer>>> adj=new ArrayList<>();
    ArrayList<Integer> list1=new ArrayList<Integer>();
    list1.add(1);
    list1.add(5);
    ArrayList<Integer> list2=new ArrayList<Integer>();
    list2.add(2);
    list2.add(1);
    ArrayList<ArrayList<Integer>> blist1=new ArrayList<>();
    blist1.add(list1);
    blist1.add(list2);
    ArrayList<Integer> list3=new ArrayList<Integer>();
    list3.add(0);
    list3.add(5);
    ArrayList<Integer> list4=new ArrayList<Integer>();
    list4.add(2);
    list4.add(3);
    ArrayList<ArrayList<Integer>> blist2=new ArrayList<>();
    blist2.add(list3);
    blist2.add(list4);
    ArrayList<Integer> list5=new ArrayList<Integer>();
    list5.add(1);
    list5.add(3);
    ArrayList<Integer> list6=new ArrayList<Integer>();
    list6.add(0);
    list6.add(1);
    ArrayList<ArrayList<Integer>> blist3=new ArrayList<>();
    blist3.add(list5);
    blist3.add(list6);
    adj.add(blist1);
    adj.add(blist2);
    adj.add(blist3);
   /**************************************************/
    /*for(int i=0;i<adj.size();++i)
    {
        System.out.println("-> "+adj.get(i));
    }*/
    printMst(adj.size(),adj);
    }
}
