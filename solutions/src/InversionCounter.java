import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by spiff on 1/17/16.
 */
public class InversionCounter
{
    public List FileReader(String filePath)
    {
        //Open file
        ArrayList<Integer> retList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String readLine;
            while((readLine =  br.readLine())!=null)
            {
                retList.add(Integer.parseInt(readLine ));
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  retList;
        //Read each line to array
        //Return List
    }
    public int getInversionCount(List<Integer> input)
    {
        int inversionCount =0;
        for(int i=0; i<input.size(); i++)
        {
            if(i<2)
                continue;

            if((input.get(i-1) > input.get(i-2) && input.get(i-1) > input.get(i)) ||
                    (input.get(i-1) < input.get(i-2) && input.get(i-1) < input.get(i))
                    )
            inversionCount ++;
        }
        return inversionCount;
    }
}
