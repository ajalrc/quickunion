/**
 * add a method delete() that does this
 * Given a set of n integers S = { 0, 1, ... , n-1} and a sequence of requests of the following form:
 * Remove x from S
 * Find the successor of x: the smallest y in S such that y≥x.
 * design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
 */
public class successorwithdelete {
    public static void main(String[] args) {
        successorwithdelete test = new successorwithdelete(10);
        test.remove(2);
        System.out.println(test.successor(2) == 3);
        test.remove(3);
        System.out.println(test.successor(2) == 4);
        System.out.println(test.successor(8) == 8);
        test.remove(8);
        System.out.println(test.successor(8) == 9);
        test.remove(9);
        System.out.println(test.successor(8) == -1);
        test.remove(5);
        test.remove(4);
        System.out.println(test.successor(3) == 6);
    }
    private int size;
    private boolean[] data;
    private findingthelargest find;
    public successorwithdelete(int size){
        this.size=size;
        data = new boolean[size];
        for(int i=0;i<size;i++){
            data[i]=true;
        }
        find = new findingthelargest(size);

    }
    public void remove(int x) {
        data[x] = false;
        if (x > 0 && !data[x-1])
            find.union(x, x-1);
        if (x < size - 1 && !data[x+1])
            find.union(x, x+1);
    }
    public int successor(int x){
        if(data[x]){
            return x;
        }
        else{
            int ans=find.find(x)+1;
            System.out.println("The largest is "+ans);
            if(ans>=size){
                System.out.println("Out of bound");
                return -1;
            }
            else return ans;
        }
    }


}
