/*
Problem Statement :
Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move all disks from source rod to destination rod using third rod (say auxiliary). The rules are :
1) Only one disk can be moved at a time.
2) A disk can be moved only if it is on the top of a rod.
3) No disk can be placed on the top of a smaller disk.
Print the steps required to move n disks from source rod to destination rod.
Source Rod is named as 'a', auxiliary rod as 'b' and destination rod as 'c'.

Input Format :
Integer n

Output Format :
Steps in different lines (in one line print source and destination rod name separated by space)
*/

//Driver Code :
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		solution.towerOfHanoi(n, 'a', 'b', 'c');
	}
}


public class solution 
{
	public static void towerOfHanoi(int disks, char source, char auxiliary, char destination)  //(number of disks, name of source tower, name of helper tower, name of destination tower)
    {
        if(disks == 0)
        {
            return;
        }
		if(disks == 1)
        {
			System.out.println(source + " " + destination);
            return;
        }
        //here we are moving (n-1)disks from source to auxiliary. Therefore, destination will act as helper.
        towerOfHanoi(disks - 1, source, destination, auxiliary); 
        //moving nth disk from source to destination.
        System.out.println(source + " " + destination);
          //here we are moving (n-1)disks from auxiliary to destination. Therefore, source will act as helper.
        towerOfHanoi(disks - 1, auxiliary, source, destination);
	}
}

