/*
Problem Statement :
Create dynamic array.
*/

//Driver Code :
public class DynamicArray
{
    public static void main(String args[])
    {
        dynamicArray d = new dynamicArray();
        //System.out.println(d.isEmpty());
        d.add(5);
        /*
        d.add(2);
        d.add(10);
        d.add(13);
        d.add(2);
        d.add(6);
        d.add(1);
        */
       // System.out.println(d.isEmpty());
       // System.out.println(d.get(0));
       // System.out.println(d.size());
        //d.print();
       // d.remove();
        //d.print();
        //System.out.println(d.size());
        System.out.println(d.remove());
        System.out.println(d.remove());
        //d.print();
        //System.out.println(d.size());
    }
    
}



class dynamicArray 
{
    private int data[];
    private int nextElementIndex;
    public DynamicArray()
    {
        data = new int[5];
        nextElementIndex = 0;
    }

    public int size()
    {
        return nextElementIndex;
    }

    public boolean isEmpty()
    {
        if(nextElementIndex == 0)
            return true;
        return false;
    }

    public void add(int val)
    {
        if(nextElementIndex == data.length)
        {
            //double the size of the current array.
            doubleCapacity();
        }
        data[nextElementIndex] = val;
        nextElementIndex++;
    }

    private void doubleCapacity()
    {
        int temp[] = data;
        data = new int[2 * temp.length];
        for(int i = 0; i < temp.length; i++)
        {
            data[i] = temp[i];
        }
    }

    public int remove()
    {
        if(nextElementIndex == 0)
            return -1;
        nextElementIndex--;
        return data[nextElementIndex];

    }

    public int get(int i)
    {
        if(i >= nextElementIndex)
            return -1;
        return data[i];
    }

    public void print()
    {
        for(int i = 0; i < nextElementIndex; i++)
        {
            System.out.println(data[i]);
        }
    }
}
