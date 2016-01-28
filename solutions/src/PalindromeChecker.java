public class PalindromeChecker
{
    public boolean check(String input)
    {
        char[] array = input.toLowerCase().toCharArray();
        int length = array.length;
        for(int i=0; i< length/2; i++)
        {
            if(array[i] != array[length-i-1])
            {
                return false;
            }
        }
        return true;
    }
}
