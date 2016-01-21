/**
 * Created by spiff on 1/16/16.
 */
public class Q1_2
{
    public String reverse(String input)
    {
        StringBuffer result = new StringBuffer();
        for(int i=input.length() -1 ; i >= 0 ; i--)
        {
            result.append(input.charAt(i));
        }
        return result.toString();
    }

    public StringBuffer recursiveReverse(String input)
    {
        StringBuffer result = new StringBuffer();
        char first = input.charAt(0);
        if(input.length() > 2)
            return result.append(recursiveReverse(input.substring(1, input.length()))).append(first);
        return result.append(input.charAt(1)).append(first);
    }

    public String swapReverse(String input)
    {
        char [] arr = input.toCharArray();
        for(int i = 0; i < input.length()/2 ; i++)
        {
            swap(arr, i, input.length()-1-i);
        }
        return new String(arr);
    }

    private void swap(char[] arr, int i, int j)
    {
        char temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }


}
