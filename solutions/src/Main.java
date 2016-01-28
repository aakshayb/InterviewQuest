import static java.lang.System.out;

/**
 * Created by spiff on 1/16/16.
 */
public class Main {
    private static String testInput1 = "Interview work for Akshay";
    public static void main(String args[])
    {
        Q1_2 two = new Q1_2();
        out.println(two.reverse(testInput1));
        out.println(two.recursiveReverse(testInput1));
        out.println(two.swapReverse(testInput1));

        InversionCounter ic = new InversionCounter();
        int output = ic.getInversionCount(ic.FileReader("/Users/spiff/InterviewQuest/Cracking_the_coding_interview/Cracking_the_coding_interview/input.txt"));
        out.println(output);

        Node first = new Node(1);
        out.println(first.toString());
        first.appendTo(new Node(100)).appendTo(new Node(250))
                .appendTo(new Node(150)).appendTo(new Node(175))
                .appendTo(new Node(230)).appendTo(new Node(200));
        out.println(first.toString());
        first.deleteLast();
        out.println(first.toString());
        first.deleteByElement(250);
        out.println(first.toString());
        first.deleteByElement(20);
        out.println(first.toString());
        first.deleteByElement(1);
        out.println(first.toString());

        Node firstElement = new Node(10);
        LinkedList linkedList = new LinkedList(firstElement);
        Node abc = new Node(200);
        linkedList.append(abc).append(new Node(250))
                .append(new Node(140)).append(new Node(90));
        out.println(linkedList);
        linkedList.deleteLast();
        out.println(linkedList);
        linkedList.deleteElement(abc);
        out.println(linkedList);
        linkedList.deleteElement(firstElement);
        out.println(linkedList);

        String oneStr = "Command";
        String twoStr = "and";
        out.println(" Result is : " + new StringMatcher().match(oneStr, twoStr));
        out.println(" Result is : " + new StringMatcher().match(testInput1, "Akshay"));
        out.println(" Result is : " + new StringMatcher().match(testInput1, "Shalini"));

        Integer[] ints = new Integer[]{1, 8, 4, 7, 2, 0};
        out.println("Unsorted array -> "+ toString(ints) + "Sorted array -> " + toString(new Sorter().Sort(ints)));
        ints = new Integer[]{1, 8, 4, 7, 2, 0};
        out.println("Unsorted array -> "+ toString(ints) + "Sorted array -> " + toString(new Sorter().BubbleSort(ints)));

        PalindromeChecker checker = new PalindromeChecker();
        out.println("Akshay is a palindrome? " + checker.check("Akshay"));
        out.println("Is it? " + checker.check("Detartrated"));
        out.println("Is it? "+ checker.check("Detartrated"));

        BaseConverter converter = new BaseConverter();
        out.println("Convert 52220 to binary is : " + converter.convert(52220,2));
        out.println("Convert 52220 to hexa is : " + converter.convert(52220,16));
        out.println("Convert 52220 to octa is : " + converter.convert(52220,8));
    }
    private static String toString(Integer[] array)
    {
        StringBuffer  sb = new StringBuffer();
        for(int i=0; i < array.length; i++)
        {
            sb.append(array[i] + ", ");
        }
        return sb.toString();
    }
}
