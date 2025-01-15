package WeekA;

import java.util.Arrays;

/**
 * This class will hold some sorts and searches from CS 2440.
 * 
 * @author Rose McCormack
 * @version CS-3460-
 *  
 */
public class Review 
{
    int[] arr;

    public static boolean linearSearch(int[] arr, int element) 
    {
        for (int i = 0; i < arr.length; i++) 
        {
            if (arr[i] == element) 
            {
                return true;
            }
        }
        return false;
    }
}