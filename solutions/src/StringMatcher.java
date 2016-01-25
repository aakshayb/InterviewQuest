/**
 * Created by spiff on 1/16/16.
 */
public class StringMatcher
{
    public boolean match(String one, String two)
    {
        char [] smallerArray = one.toCharArray();
        char [] largerArray = two.toCharArray();
        int difference = Math.abs(smallerArray.length - largerArray.length);
        if(one.length() > two.length())
        {
            smallerArray = two.toCharArray();
            largerArray = one.toCharArray();
        }
        for(int i=0; i<= difference; i++ )
        {
            int matchedChars = 0;
            for(int j=0; j< smallerArray.length; j++)
            {
                if(largerArray[i+j] != smallerArray [j])
                    break;
                matchedChars++;
            }
            if(matchedChars == smallerArray.length)
                return true;
        }
        return false;
    }
}
