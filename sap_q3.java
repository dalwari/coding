import java.util.*;
class Sol {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        String s="i.love.coding.very.much";
        String ts="";
        ArrayList<String> alist=new ArrayList<>();
        for(int i=0;i<s.length();++i)
        {
            
            if(s.charAt(i)!='.')
            {
                ts+=s.charAt(i);
            }else
            {
                //sb.append(ts+".");
                alist.add(ts);
                ts="";
            }
            
        }
        alist.add(ts);
        Collections.reverse(alist);
        for(String t:alist)
        {
            sb.append(t+".");
        }

        System.out.println("-> "+sb.toString().substring(0,sb.length()-1));
        //System.out.println("-> "+alist);
    }

}
