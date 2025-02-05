package WeekD;

public class HashTable 
{
    private static class Node
    {
        int data;
        Node next;

        public Node() 
        {
            this.data = 0;
            this.next = null;
        }

        public Node(int data, Node next) 
        {
            this.data = data;
            this.next = next;
        }
    }

    private Node[] table;

    public HashTable(int m) 
    {
        table = new Node[m];
    }

    public int hash(int key) 
    {
        return ((2971 * key) + 101923) % this.table.length;
    }

    public boolean find(int key) 
    {
        int hash = hash(key);
        for (Node p = this.table[hash]; p != null; p = p.next) 
        {
            if (p.data == key) 
            {
                return true;
            }
        }
        return false;
    }

    public void insert(int key) 
    {
        if (find(key)) 
        {
            return;
        }
        int hash = hash(key);
        this.table[hash] = new Node(key, this.table[hash]);
    }

    public void print() 
    {
        for (Node head : this.table) 
        {
            for (Node p = head; p != null; p = p.next) 
            {
                System.out.println(p.data);
            }
        }
    }
}