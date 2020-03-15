package src;
import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
public class MaxHeapTest {
    /*Tests run time of the nlogn max heap creator in the MaxHeap class. I created 5 different heaps with sizes 10, 100, 500, 
     * 2,000, and 10,000. I then filled them with random integers and each time i ran the method using these Integer arrays, i
     * called start time and end time and subtracted the start time from the end time in my print statement to find the runtime
     * of each queue size.
     */
    public static void testNLogN()
    {
        MaxHeap heap10 = new MaxHeap(10);
        Integer[] int10 = new Integer[10];
        
        MaxHeap heap100 = new MaxHeap(100);
        Integer[] int100 = new Integer[100];
        
        MaxHeap heap500 = new MaxHeap(500);
        Integer[] int500 = new Integer[500];
        
        MaxHeap heap2000 = new MaxHeap(2000);
        Integer[] int2000 = new Integer[2000];
        
        MaxHeap heap10000 = new MaxHeap(10000);
        Integer[] int10000 = new Integer[10000];
        Random r = new Random();
        for(int i = 0; i < 10000; i++)
        {
            if(i < 10)
            {
                int10[i] = new Integer(r.nextInt(30));
            }
            if(i < 100)
            {
                int100[i] = new Integer(r.nextInt(300));
            }
            if(i < 500)
            {
                int500[i] = new Integer(r.nextInt(1500));
            }
            if(i < 2000)
            {
                int2000[i] = new Integer(r.nextInt(6000));
            }
            if(i < 10000)
            {
                int10000[i] = new Integer(r.nextInt(30000));
            }
        }
        long st10 = System.nanoTime();
        heap10.MaxHeapLogN(int10);
        long et10 = System.nanoTime();
        
        long st100 = System.nanoTime();
        heap100.MaxHeapLogN(int100);
        long et100 = System.nanoTime();
        
        long st500 = System.nanoTime();
        heap500.MaxHeapLogN(int500);
        long et500 = System.nanoTime();
        
        long st2000 = System.nanoTime();
        heap2000.MaxHeapLogN(int2000);
        long et2000 = System.nanoTime();
        
        long st10000 = System.nanoTime();
        heap10000.MaxHeapLogN(int10000);
        long et10000 = System.nanoTime();
        
        System.out.println("ForO(nlogn): ");
        System.out.println("N = 10, Time Was: " + (et10-st10));
        System.out.println("N = 100, Time Was: " + (et100-st100));
        System.out.println("N = 500, Time Was: " + (et500-st500));
        System.out.println("N = 2000, Time Was: " + (et2000-st2000));
        System.out.println("N = 10000, Time Was: " + (et10000-st10000));
    }
    /*Exactly the same as the method above however instead of calling the nlogn function, I call the MaxHeapN function inbetween
     * the start and end time calls. 
     */
    public static void testN()
    {
        MaxHeap heap10 = new MaxHeap(10);
        Integer[] int10 = new Integer[10];
        
        MaxHeap heap100 = new MaxHeap(100);
        Integer[] int100 = new Integer[100];
        
        MaxHeap heap500 = new MaxHeap(500);
        Integer[] int500 = new Integer[500];
        
        MaxHeap heap2000 = new MaxHeap(2000);
        Integer[] int2000 = new Integer[2000];
        
        MaxHeap heap10000 = new MaxHeap(10000);
        Integer[] int10000 = new Integer[10000];
        Random r = new Random();
        for(int i = 0; i < 10000; i++)
        {
            if(i < 10)
            {
                int10[i] = new Integer(r.nextInt(30));
            }
            if(i < 100)
            {
                int100[i] = new Integer(r.nextInt(300));
            }
            if(i < 500)
            {
                int500[i] = new Integer(r.nextInt(1500));
            }
            if(i < 2000)
            {
                int2000[i] = new Integer(r.nextInt(6000));
            }
            if(i < 10000)
            {
                int10000[i] = new Integer(r.nextInt(30000));
            }
        }
        long st10 = System.nanoTime();
        heap10.MaxHeapN(int10);
        long et10 = System.nanoTime();
        
        long st100 = System.nanoTime();
        heap100.MaxHeapN(int100);
        long et100 = System.nanoTime();
        
        long st500 = System.nanoTime();
        heap500.MaxHeapN(int500);
        long et500 = System.nanoTime();
        
        long st2000 = System.nanoTime();
        heap2000.MaxHeapN(int2000);
        long et2000 = System.nanoTime();
        
        long st10000 = System.nanoTime();
        heap10000.MaxHeapN(int10000);
        long et10000 = System.nanoTime();
        
        System.out.println("ForO(n): ");
        System.out.println("N = 10, Time Was: " + (et10-st10));
        System.out.println("N = 100, Time Was: " + (et100-st100));
        System.out.println("N = 500, Time Was: " + (et500-st500));
        System.out.println("N = 2000, Time Was: " + (et2000-st2000));
        System.out.println("N = 10000, Time Was: " + (et10000-st10000));
    }
    @Test
    /*Test method to see if max heaps were properly created. This is done by creating an unsorted array of Integers and calling
     * the logn function on it then comparing its toString to the presorted expected array of Integers posting an assertEquals
     * crashing the program if they are not equal.
     */
    public void isMaxLogN()
    {
        MaxHeap newHeap = new MaxHeap(8);
        Integer[] data = new Integer[8];
        data[0] = (new Integer(5));
        data[1] = (new Integer(12));
        data[2] = (new Integer(16));
        data[3] = (new Integer(2));
        data[4] = (new Integer(10));
        data[5] = (new Integer(16));
        data[6] = (new Integer(50));
        newHeap.MaxHeapLogN(data);
        Integer[] expected = new Integer[8];
        expected[0] = (new Integer(50));
        expected[1] = (new Integer(10));
        expected[2] = (new Integer(16));
        expected[3] = (new Integer(2));
        expected[4] = (new Integer(5));
        expected[5] = (new Integer(12));
        expected[6] = (new Integer(16));//16 can be the child of the other 16
        assertEquals(Arrays.toString(newHeap.data), Arrays.toString(expected));
    }
    @Test
    public void isMaxN()
    {
        MaxHeap newHeap = new MaxHeap(8);
        Integer[] data = new Integer[8];
        data[0] = (new Integer(5));
        data[1] = (new Integer(12));
        data[2] = (new Integer(16));
        data[3] = (new Integer(2));
        data[4] = (new Integer(10));
        data[5] = (new Integer(16));
        data[6] = (new Integer(50));
        newHeap.MaxHeapN(data);
        Integer[] expected = new Integer[8];
        expected[0] = (new Integer(50));
        expected[1] = (new Integer(12));
        expected[2] = (new Integer(16));
        expected[3] = (new Integer(2));
        expected[4] = (new Integer(10));
        expected[5] = (new Integer(5));
        expected[6] = (new Integer(16));//16 can be the child of the other 16
        assertEquals(Arrays.toString(newHeap.data), Arrays.toString(expected));
    }
    @Test
    public void testPop()
    {
        MaxHeap heap = new MaxHeap(8);
        heap.add(new Integer(5));
        heap.add(new Integer(12));
        heap.add(new Integer(16));
        heap.add(new Integer(2));
        heap.add(new Integer(10));
        heap.add(new Integer(16));
        heap.add(new Integer(50));
        assertEquals(heap.pop(), (Integer)50);
        Integer[] expected = new Integer[8];//new expected values after the pop
        expected[0] = (new Integer(16));
        expected[1] = (new Integer(10));
        expected[2] = (new Integer(16));
        expected[3] = (new Integer(2));
        expected[4] = (new Integer(5));
        expected[5] = (new Integer(12));
        assertEquals(Arrays.toString(heap.data), Arrays.toString(expected));
    }
}