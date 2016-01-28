/**
 * Created by spiff on 1/24/16.
 */
public class Sorter
{
    public Integer[] Sort(Integer[] array)
    {
        for(int i = 0; i < array.length - 1 ; i++)
        {
            for(int j = i+1; j < array.length; j++ )
            {
                if(array[i] > array[j])
                {
                    array[i] = array[i] ^ array[j];
                    array[j] = array[j] ^ array[i];
                    array[i] = array[i] ^ array[j];
                }
            }
        }
        return array;
    }
    public Integer[] BubbleSort(Integer[] array)
    {
        for(int i=1; i< array.length ; i++)
        {
            for(int j=0; j< array.length - i; j++)
            {
                if(array[j] > array [j+1])
                {
                    array[j] = array[j] ^ array[j+1];
                    array[j+1] = array[j+1] ^ array[j];
                    array[j] = array[j] ^ array[j+1];
                }
            }
        }
        return array;
    }
}
