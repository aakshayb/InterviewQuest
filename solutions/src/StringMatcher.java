/**
 * Created by spiff on 1/16/16.
 */
public class StringMatcher
{
    public boolean match(String one, String two)
    {
        if(!one.contains(two))
            if(!two.contains(one))
                return false;
        char [] smallerArray, largerArray;
        if(one.length()>two.length())
        {
            smallerArray = two.toCharArray();
            largerArray = one.toCharArray();
        }
        return true;

    }
}
