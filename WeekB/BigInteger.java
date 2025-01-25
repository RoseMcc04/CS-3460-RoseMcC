package WeekB;

public class BigInteger 
{
    public static class Node 
    {
        public int digit;
        public Node next;

        public Node(int digit, Node next) 
        {
            this.digit = digit;
            this.next = next;
        }

        public String toString() 
        {
            if (this.next == null) return ""+this.digit;
            return this.next.toString() + this.digit;
        }
    }
    private Node head;

    public BigInteger() 
    {
        head = new Node(0, null);
    }

    public BigInteger(String v) 
    {
        for (int i = 0; i < v.length(); i++) 
        {
            head = new Node(v.charAt(i) - '0', head);
        }
    }

    public BigInteger(int v) 
    {
        this(""+v);
    }

    public String toString() 
    {
        return this.head.toString();
    }

    public static BigInteger add(BigInteger a, BigInteger b) 
    {
        BigInteger c = new BigInteger(0);
        Node ci = c.head;
        Node ai = a.head;
        Node bi = b.head;
        int carry = 0;

        while (ai != null || bi != null || carry != 0) 
        {
            int result = carry;
            if (ai != null) result += ai.digit;
            if (bi != null) result += bi.digit;
            ci = ci.next = new Node(result % 10, null);
            carry = result / 10;
            if (ai != null) ai = ai.next;
            if (bi != null) bi = bi.next;
        }
        c.head = c.head.next;
        return c;
    }

    private static BigInteger mul(BigInteger a, int b) 
    {
        BigInteger c = new BigInteger(0);
        Node ci = c.head;
        Node ai = a.head;
        Node bi = b.head;
        int carry = 0;

        while (ai != null || bi != null || carry != 0) 
        {
            int result = carry;
            if (ai != null) result += ai.digit;
            if (bi != null) result += bi.digit;
            ci = ci.next = new Node(result % 10, null);
            carry = result / 10;
            if (ai != null) ai = ai.next;
            if (bi != null) bi = bi.next;
        }
        c.head = c.head.next;
        return c;
    }
}