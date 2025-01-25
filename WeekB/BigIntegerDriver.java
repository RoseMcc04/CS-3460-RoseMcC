package WeekB;

public class BigIntegerDriver 
{
    public static void main(String[] args) 
    {
        BigInteger a = new BigInteger("1234567");
        BigInteger b = new BigInteger("7654321");

        System.out.println(BigInteger.add(a, b));
    }    
}
