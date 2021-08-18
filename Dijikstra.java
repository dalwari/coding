import java.util.*;
class Node
    {
        int vert;
        int dist;
    }
    class Mycomparator implements Comparator<Node>
    {
        public int compare(Node x,Node y)
        {
            return x.dist-y.dist;
        }
    }
class Sol {
    public static Node find(int v,PriorityQueue<Node> q)
    {
        PriorityQueue<Node> tq=new PriorityQueue<>(q.size(),new Mycomparator());
        //(or)
        //PriorityQueue<Node> tq=new PriorityQueue<>(new Mycomparator());
        Node t=new Node();
        while(q.size()>0)
        {
            t=q.peek();
            if(t.vert==v)
            {
                break;
            }else
            {
                tq.add(q.poll());
            }
        }
        if(tq.size()>0)//works even without this condition
        {
            q.addAll(tq);
        }
        return t;
    }
    public static void dijikstra(ArrayList<ArrayList<ArrayList<Integer>>> adj,int S)
    {
        int V=adj.size();
        int[] w=new int[V];
        int[] p=new int[V];
        PriorityQueue<Node> queue=new PriorityQueue<>(V,new Mycomparator());
        for(int i=0;i<adj.size();++i)
        {
           
                Node n=new Node();
                n.vert=i;
                if(S==i)
                {
                    n.dist=0;
                    w[i]=0;
                    p[i]=-1;
                }else
                {
                    n.dist=Integer.MAX_VALUE;
                    w[i]=Integer.MAX_VALUE;
                }
                queue.add(n);
        }
        while(queue.size()>0)
        {
            Node u=queue.poll();
            for(int i=0;i<adj.get(u.vert).size();++i)
            {
                int des=adj.get(u.vert).get(i).get(0);
                int wt=adj.get(u.vert).get(i).get(1);
                if(w[des]>u.dist+wt)
                {
                    w[des]=u.dist+wt;
                    p[des]=u.vert;
                    Node r=find(des,queue);
                    /*--------------------*/
                    r.vert=des;
                    r.dist=w[des];
                    queue.add(r);
                    /*--------------------*/
                }
            }
        }
        //System.out.println("w[]=> "+Arrays.toString(w));
        //System.out.println("p[]=> "+Arrays.toString(p));
        System.out.println("src  dist  parent");
        for(int i=0;i<V;++i)
        {
            System.out.println(i+"     "+w[i]+"      "+p[i]);
        }
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj=new ArrayList<>();
        ArrayList<Integer> list1 =new ArrayList<Integer>();
        list1.add(1);
        list1.add(1);
        ArrayList<Integer> list2 =new ArrayList<Integer>();
        list2.add(2);
        list2.add(6);
        ArrayList<ArrayList<Integer>> blist1=new ArrayList<>();
        blist1.add(list1);
        blist1.add(list2);
        /******************************************************/
        ArrayList<Integer> list3 =new ArrayList<Integer>();
        list3.add(0);
        list3.add(1);
        ArrayList<Integer> list4 =new ArrayList<Integer>();
        list4.add(2);
        list4.add(3);
        ArrayList<ArrayList<Integer>> blist2=new ArrayList<>();
        blist2.add(list3);
        blist2.add(list4);
        /******************************************************/
        ArrayList<Integer> list5 =new ArrayList<Integer>();
        list5.add(1);
        list5.add(3);
        ArrayList<Integer> list6 =new ArrayList<Integer>();
        list6.add(0);
        list6.add(6);
        ArrayList<ArrayList<Integer>> blist3=new ArrayList<>();
        blist3.add(list5);
        blist3.add(list6);
        /******************************************************/
        adj.add(blist1);
        adj.add(blist2);
        adj.add(blist3);
        /******************************************************/
        dijikstra(adj,2);
    }

}
