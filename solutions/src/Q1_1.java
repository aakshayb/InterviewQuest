import java.util.HashMap;

/**
 * Created by spiff on 1/16/16.
 */
public class Q1_1
{
   private String inputString = "This is an interview";
   private boolean hasUnique(String input)
   {
       HashMap hash = new HashMap();
       for(char c : input.toCharArray())
       {
           if(hash.containsKey(c))
               return false;
           hash.put(c, 1);
       }
       return true;
   }
   public static void main(String args[])
   {
       Q1_1 one = new Q1_1();
       System.out.println(one.hasUnique("Akshlin"));
       System.out.println(one.hasUnique("Quick brown fox jumped over the lazy dog"));
   }
   private boolean hasUniqueCharsOptimal(String input)
   {
       for(int i =0; i < input.length() ; i++)
       {
           for(int j=0; j <input.length(); j++)
           {
               if(i == j)
                   continue;
               if(input.charAt(i) == input.charAt(j))
                   return true;
           }
       }
      return false;
   }

}
