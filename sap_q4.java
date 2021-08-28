import java.util.*;
class Sol {
    public static void main(String[] args) {
        String S = "geeks for geeks";
        String r="";
        for(int i=0;i<S.length();++i)
        {
            if(!Character.isWhitespace(S.charAt(i)))
            {
                r+=S.charAt(i);
            }
        }
        System.out.println("- "+r);
            }

}
