/**
 * Created by spiff on 1/27/16.
 */
public class BaseConverter
{
    public String convert(int input, int base)
    {
        StringBuffer retString = new StringBuffer();
        int checkerVal =input;
        do
        {
            retString.append(getNumber(""+checkerVal%base));
            checkerVal = checkerVal/base;
        } while(checkerVal != 0);

        return retString.reverse().toString();
    }
    private String getNumber(String number)
    {
        switch (number)
        {
            case "10":
                return "A";
            case "11":
                return "B";
            case "12":
                return "C";
            case "13":
                return "D";
            case "14":
                return "E";
            case "15":
                return "F";
            default:
                return number;
        }
    }
}
