/**
 * Created by spiff on 1/24/16.
 */
public class Sorter
{
    public Integer[] BubbleSort(Integer[] array)
    {
        for(int i = 0; i < array.length - 1 ; i++)
        {
            for(int j = i+1; j < array.length; j++ )
            {
                if(array[i] > array[j])
                {
                    Integer temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
