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

        StringMatcher sm = new StringMatcher();
        out.println(sm.match(testInput1, "Akshay"));
        out.println(sm.match("work", testInput1));

        InversionCounter ic = new InversionCounter();
        int output = ic.getInversionCount(ic.FileReader("/Users/spiff/InterviewQuest/Cracking_the_coding_interview/Cracking_the_coding_interview/input.txt"));
        out.println(output);

        Node first = new Node(1);
        first.appendTo(new Node(100)).appendTo(new Node(250))
                .appendTo(new Node(150)).appendTo(new Node(175))
                .appendTo(new Node(230)).appendTo(new Node(200));





    }
}
