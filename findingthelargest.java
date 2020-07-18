
import java.util.Arrays;

/**
 * Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing i. The operations, union(),connected(), and find() should all take logarithmic time or better.
 * For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9 for each of the four elements in the connected components.
 */

public class findingthelargest {
    private static int[] array= new int[10];
    private static int[] counterarray= new int[10];
    private static int[] largest=new int[10];
    /**
     * Here I am initialising an array and assigning the index of the array as the value
     * @param size is the input
     * here counterarray is to count the number of nodes in the tree
     */
    public findingthelargest(int size){
        for(int i = 0; i < size; i++){
            counterarray[i]=1;
            array[i] = i;
            largest[i]=i;
        }
    }

    public static void main(String[] args) {
        findingthelargest findingthelargest=new findingthelargest(10);
        findingthelargest.union(0, 2);
        findingthelargest.union(8, 4);
        findingthelargest.union(2,4);
        System.out.println("the largest in the connected components is "+findingthelargest.find(0));
        System.out.println("the largest in the connected components is "+findingthelargest.find(0));

    }




    /**
     * here I am making sure that the id of first parameter matches with the root parent of the second parameter
     * @param id1 node 1
     * @param id2 node 2
     * See here how I am using the counter array here to find the largest tree. Initially I initialised the array where all the value at the index was 1 which is all the nodes are
     * present independently but as we add new node or a smaller tree then we add that many number of nodes in the root position of the counter array.That root position is used to compare
     * the size of the tree and join it.
     */
    public  void union(int id1, int id2){
        int roottoid1=findroot(id1);
        //System.out.println("The root of "+id1+" is "+roottoid1);
        int roottoid2=findroot(id2);
        /**
         * To find the largest node in the tree. First I am finding the root node index and comparing the value in the fixed initial
         * array whose value were from 0 to 9 and then comparing that value, after union we change the smaller root node index value to the
         * bigger root note index value.
         */
        int largestid1=largest[roottoid1];
        int largestid2=largest[roottoid2];
        //System.out.println("The root of "+id2+" is "+roottoid2);

        if(!connected(roottoid1,roottoid2)){

            if(counterarray[roottoid1] < counterarray[roottoid2]){
                //System.out.println("the new idvalue of first root tree  "+ roottoid1 +" is "+roottoid2);
                array[roottoid1]=roottoid2;
                counterarray[roottoid2]+=counterarray[roottoid1];
                if(largestid1 > largestid2){
                    largest[roottoid2]=roottoid1;
                    //System.out.println("The largest first find "+roottoid1);
                }
            }
            else{
                //System.out.println("the new idvalue of second root tree "+ roottoid2 +" is "+roottoid1);
                array[roottoid2]=roottoid1;
                counterarray[roottoid1]+=counterarray[roottoid2];

                if(largestid2 > largestid1){
                    largest[roottoid1]=roottoid2;
                    //System.out.println("The largest second find "+roottoid2);
                }
            }

        }
    }


    /**
     *making sure that the root id of the index are the same.
     */
    public boolean connected(int index1,int index2){
        return array[findroot(index1)]==array[findroot(index2)];
    }

    /**
     *Finding the parent root node and connecting the upper node of the searching node to the parent node.
     * @param num1- node
     * @return returns the parent node if in a tree else return the same node.
     */
    public  int findroot(int num1){

        while(array[num1]!=num1){
            //this below single line of code is enough to flatten the tree because it is just connecting the upper root value of the searched index to the top root.
            //kind of confusing but you will be clear if you see the figure.
            array[num1]=array[array[num1]];
            num1=array[num1];
            if(num1==array[num1]){
                return num1;
            }
        }

        return num1;
    }
    public  int find(int largestvalue){
        return largest[largestvalue];
    }
    public int delete(int[] array,int x){
        Arrays.sort(array);

        int returnindex=Arrays.binarySearch(array,x);
        array[returnindex]= Integer.parseInt(null);
        System.out.println("I deleted "+x +" and made it to "+array[returnindex]);
        return array[returnindex+1];

    }
}
