/**
 *
 * Given a social network containing N members and a log file containing M
 * timestamps at which times pairs of members formed friendships, design an
 * algorithm to determine the earliest time at which all members are connected
 * (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an
 * equivalence relation. The running time of your algorithm should be MlogN or
 * better and use extra space proportional to N.
 */

/**
 * For the solution I was using the union find operation with improvement made using weighted quick union and the path compression
 * I am using the counterarry to keep count of the smaller tree nodes that gets added to the bigger tree node and if the size of the bigger tree contains the nodes equal to the
 * size of the array that means all that nodes are connected to one root points i.e all the people in the social network are now connected and we print that timestep.
 */
public class socialconnectivityproblemusingunionfind {
    public static void main(String[] args){
        social problem= new social(6);
        problem.union(1, 5, "2019-08-14 18:00:00");
        problem.union(2, 4, "2019-08-14 18:00:01");
        problem.union(1, 3, "2019-08-14 18:00:02");
        problem.union(5, 2, "2019-08-14 18:00:03");
        problem.union(0, 3, "2019-08-14 18:00:04");
        problem.union(2, 1, "2019-08-14 18:00:05");
    }

}
class social{
    private int[] array;
    private int count,count1;
    private int[] counterarray;
    private int size=0;
    public social(int size){
        this.size=size;
        array = new int[size];
        counterarray= new int[size];
        for(int i=0;i<array.length;i++){
            array[i]=i;
            counterarray[i]=1;
        }
    }

    public void union(int i,int j,String timestamp){
        /*
        Here look at the addition at the counter array that is the number of the node that is being attacted to the bigger tree
         */
        int root1=root(i);
        int root2=root(j);
        //System.out.println("The first parent root value is "+root1);
        //System.out.println("The second parent root value is " + root2);
        if(counterarray[root1] < counterarray[root2])
        {
            array[root1]=root2;
            counterarray[root2]+=counterarray[root1];
            //System.out.println("The biggest tree is of size "+ counterarray[root2]);
            if(counterarray[root2]==array.length){
                System.out.println("All members are connected at time "+timestamp);
            }
        }
        else{
            array[root2]=root1;
            counterarray[root1]+=counterarray[root2];
            //System.out.println("The biggest tree is of size "+ counterarray[root1]);
            if(counterarray[root1]==array.length){
                System.out.println("All members are connected at time "+timestamp);
            }
            }


    }
    public int root (int i){
        while(i!=array[i]){
            array[i]=array[array[i]];
            i=array[i];
        }
        return i;
    }




}

