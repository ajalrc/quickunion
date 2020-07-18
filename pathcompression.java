/**
 * Improvement 2
 * We used the weighted weightedquick union to flatted up the tree by joining the smaller tree to the larger tree but we can do some more to that. Why not connect all the id node to
 * the root node itself. In that way the tree gets flatten up a lot. This is only one line of the code in the findroot method. After we find the parent node, we just connect all the nodes above the searhing
 * node to the parent node.
 */
public class pathcompression {

    private static int[] array= new int[10];
    private static int[] counterarray= new int[10];
        public static void main(String[] args) {
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
         * Here I am initialising an array and assigning the index of the array as the value
         * @param array is the input
         * here counterarry is to count the number of nodes in the tree
         */
        public static void initialisequickfind(int[] array){
            for(int i = 0; i < array.length; i++){
                counterarray[i]=1;
                array[i] = i;
            }
        }

    /**
     * here I am making sure that the id of first parameter matches with the root parent of the second parameter
     * @param id1 node 1
     * @param id2 node 2
     * See here how I am using the counter array here to find the largest tree. Initially I initialised the array where all the value at the index was 1 which is all the nodes are
     * present independently but as we add new node or a smaller tree then we add that many number of nodes in the root position of the counter array.That root position is used to compare
     * the size of the tree and join it.
     */
        public static void union(int id1, int id2){
            int roottoid1=findroot(id1);
            //System.out.println("The root of "+id1+" is "+roottoid1);
            int roottoid2=findroot(id2);

            //System.out.println("The root of "+id2+" is "+roottoid2);

            if(!connected(roottoid1,roottoid2)){

                if(counterarray[roottoid1] < counterarray[roottoid2]){
                    //System.out.println("the new idvalue of first root tree  "+ roottoid1 +" is "+roottoid2);
                    array[roottoid1]=roottoid2;
                }
                else{
                    //System.out.println("the new idvalue of second root tree "+ roottoid2 +" is "+roottoid1);
                    array[roottoid2]=roottoid1;
                }

            }
        }


        /**
         *making sure that the root id of the index are the same.
         */
        public static boolean connected(int index1,int index2){
            return array[findroot(index1)]==array[findroot(index2)];
        }

    /**
     *Finding the parent root node and connecting the upper node of the searching node to the parent node.
     * @param num1- node
     * @return returns the parent node if in a tree else return the same node.
     */
        public static int findroot(int num1){

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
}
