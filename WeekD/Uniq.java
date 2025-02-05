package WeekD;

import java.util.Scanner;

public class Uniq 
{
    public static void main(String[] args) 
    {
        Scanner kb = new Scanner(System.in);
        HashTable h = new HashTable(10000);

        while (kb.hasNext()) 
        {
            h.insert(kb.nextInt());
        }
        kb.close();
        h.print();
    }
}
