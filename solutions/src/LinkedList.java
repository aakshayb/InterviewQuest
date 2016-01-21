/**
 * Created by spiff on 1/19/16.
 */
public class LinkedList
{
    private Node head;
    private Node tail;
    public LinkedList(Node n)
    {
        head = n;
        tail = n;
        head._next = null;
    }
    public LinkedList append(Node node)
    {
        tail._next = tail = node;
        return this;
    }
    public void deleteLast()
    {
        if(head == tail)
            head = tail = null; // throw error
        Node current = head;
        while(current._next != tail)
        {
            current = current._next;
        }
        current._next= null;
        tail = current;
    }
    public void deleteElement(Node element)
    {
        Node current = head;
        if(head == tail)
            head = tail = null;
        Node previousNode = head;
        while(current._next != tail)
        {
            if(current == element)
            {
                previousNode._next = current._next;
            }
            previousNode = current;
            current = current._next;
        }
    }
}
