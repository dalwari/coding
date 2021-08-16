import java.util.*;
class Huffman
    {
        char c;
        int freq;
        Huffman left,right;
    }
    class MyCompare implements Comparator<Huffman>
    {
     public  int compare(Huffman a,Huffman b) {
            return a.freq-b.freq;
        }
    }
class Sol {
    public static void print(Huffman node,String s) {
        if(node.left==null && node.right==null && Character.isLetter(node.c))
        {
            System.out.println(" "+node.c+" : "+s);
            return;
        }
        print(node.left,s+"0");
        print(node.right,s+"1");
    }
    public static void main(String[] args) {
        String S = "qwertyuiopasdfghjklzxcvbn";
int f[]=new int[]{8, 9 ,14 ,19 ,20 ,21 ,21 ,25 ,33 ,45 ,50 ,50 ,66 ,68 ,70 ,73 ,74 ,75 ,76 ,82 ,85 ,90 ,94 ,97, 100
        };        
        int N=f.length;
        PriorityQueue<Huffman> que=new PriorityQueue<Huffman>(N,new MyCompare());
        for(int i=0;i<f.length;++i)
        {
            Huffman node=new Huffman();
            node.c=S.charAt(i);
            node.freq=f[i];
            node.left=null;
            node.right=null;
            que.add(node);
        }
        Huffman root=null;
        while(que.size()>1)
        {
            Huffman n1=que.poll();
            Huffman n2=que.poll();
            Huffman n=new Huffman();
            n.c='-';
            n.freq=n1.freq+n2.freq;
            n.left=n1;
            n.right=n2;
            //que.add(n);
            root=n;
            que.add(root);
        }
        print(root,"");
    }    
}
