/**
 * This is called the union find. One of the tree algorithm to find a connection between 2 item. Here we pass 2 keys and check if their id are the same.
 * if it is then, we do nothing and if not then we change the id of the first one to the second. If the first one is in a tree then we only change of the id of the root to the second one's id.
 * if both of them are in the tree then, we just change the id of the first root to the second (here root is the parent node)
 */
public class Main {

    private static int[] array= new int[10];
    public static void main(String[] args) {
        //this is for the unit test
        initialisequickfind(array);
        union(4,3);
        union(3,8);
        union(6,5);
        union(9,4);
        System.out.println(connected(8,9));
        System.out.println(connected(5,4));
        union(5,0);
        union(2,1);
        union(7,2);
        union(6,1);
        union(7,3);

        System.out.println(connected(6,8));
        System.out.println(connected(5,9));
    }

    /**
     * Here I am initialising an array acnd the counter array and assigning the index of the array as the value
     * @param array is the input
     *The use of the counter array would be in the counting process of the counting the number of the nodes below the parent node.
     */
    public static void initialisequickfind(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = i;
        }
    }

    /**
     * here I am making sure that the id of first parameter matches with the root parent of the second parameter
     * @param id1
     * @param id2
     * @return the tree where the id of the first parameter is now changed to id of the second parameter
     */
    public static void union(int id1, int id2){
        int rootoid1=findroot(id1);
        //System.out.println("The root of "+id1+" is "+rootoid1);
        int roottoid2=findroot(id2);
        //System.out.println("The root of "+id2+" is "+roottoid2);
        if(!connected(rootoid1,roottoid2)){
            array[rootoid1]=roottoid2;
            //System.out.println("the new idvalue of root "+ rootoid1 +" is "+roottoid2);
        }


    }

    /**
     *making sure that the root id of the index are the same.
     */
    public static boolean connected(int index1,int index2){
        return array[findroot(index1)]==array[findroot(index2)];
    }

    /**
     * Here I am finding the parent root of the node because in some of the union we are joining the inner nodes of 2 trees and in that case we change the root node id of the first tree to the second root node of another tree
     * thus, here I am finding the root of the trees
     * @param num1 is the node (may be independent or in a tree)
     * @return the root node of the passed parameter node
     */
    public static int findroot(int num1){
        while(array[num1]!=num1){
            num1=array[num1];
            if(num1==array[num1]){
                return num1;
            }
        }
        return num1;
        }

}
