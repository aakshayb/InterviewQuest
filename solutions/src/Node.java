public class Node
{
    public Node _next;
    private int data;
    public Node(int d)
    {
        data = d;
        _next = null;
    }
    public Node appendTo(Node newNode)
    {
        Node current = this;
        while(current.next() != null)
        {
            current = current.next();
        }
        current._next = newNode;
        return newNode;
    }
    public void deleteLast()
    {
        Node current = this;
        Node newLastNode = null;
        while(current._next != null)
        {
            newLastNode = current;
            current = current._next;
        }
        newLastNode._next =null;
    }
    public Node deleteByElement(int data)
    {
        Node current = this;
        Node previousNode = null;
        while(current._next != null )
        {
            if( current.data == data )
            {
                if(previousNode !=null)
                {
                    previousNode._next = current._next;
                    return current;
                }
                current._next = null;
                return current;
            }
            current = current._next;
        }
        return null;
    }


    public Node next()
    {
        return _next;
    }
}
