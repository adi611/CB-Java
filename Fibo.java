import java.util.ArrayList;
import java.util.List;

/**
 * Fibo
 */
public class Fibo {
    public static int Fib(int n){
        if(n==0)
        return 0;
        if(n==1)
        return 1;

        return Fib(n-1)+Fib(n-2);
    }

    public static int power(int x,int n){
        
        if(n==0){
            return 1;
        }

        return x*power(x,n-1);
    }

    public static boolean isSorted(int arr[], int si) {
        if(si == arr.length-1){
            return true;
        }
        if(arr[si]>arr[si+1]){
            return false;
        }
        else{
            return isSorted(arr, si+1);
        }
    }

    public static int firstIndex(int arr[], int si, int data) {
        if(si==arr.length){
            return -1;
        }
        if(arr[si]==data){
            return si;
        }
        return firstIndex(arr, si+1, data);
    }

    public static int lastIndex(int arr[], int si, int data) {
        if(si==arr.length){
            return -1;
        }
        int index = lastIndex(arr, si+1, data);
        if(index==-1){
            if(arr[si]==data){
                return si;
            }
            else{
                return -1;
            }
        }
        else{
            return index;
        }
    }

    public static int[] allIndices(int arr[], int si, int data, int c){
        if(si==arr.length){
            return new int[c+1];
        }
        if(arr[si]==data){
            c++;
        }
        int arr2[] = allIndices(arr, si+1, data, c);
        if(arr[si]==data){
            arr2[c] = si;
        }
        return arr2;
    }

    public static void pattern(int N, int row, int c){

        if(row>N){
            return;
        }
        if(row==1){
            System.out.print("*");
        }
        else{
            pattern(N,row-1,0);
            System.out.print("*");
        }
        if(c==1){
            System.out.println("");
            pattern(N,row+1,c);
        }
    }
    /*  CODING BLOCKS SOLUTION BELOW-->
    public static void pattern(int N, int row, int col){
        if(row>N){
            return;
        }
        if(col>row){
            System.out.println("");
            pattern(N, row+1, 1);
            return;
        }
        System.out.print("*");
        pattern(N, row, col+1);
    }
    */

    public static void BubbleSort(int arr[], int si, int li) {
        
        if(li==0){
            return;
        }

        if(si==li){
            BubbleSort(arr, 0, li-1);
            return;
        }

        if(arr[si]>arr[si+1]){
            int temp = arr[si];
            arr[si] = arr[si+1];
            arr[si+1] = temp;
        }
        BubbleSort(arr, si+1, li);
    }

    public static ArrayList<String> getSS(String str) {
        if(str.length()==0){
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        char cc = str.charAt(0);
        String rs = str.substring(1);
        ArrayList<String> myResult = new ArrayList<>();
        ArrayList<String> recResult = getSS(rs);
        for (int i = 0; i <recResult.size(); i++) {
            myResult.add(recResult.get(i));
            myResult.add(cc+recResult.get(i));
        }
        return myResult;
    }

    public static ArrayList<String> getPermutation(String str){

        if(str.length()==0){
            ArrayList<String> br = new ArrayList<>();

            /* adding a string so that size of mr grows otherwise length will be 0 
                and final answer will be empty arraylist */
            br.add("");  
            return br;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rr = getPermutation(ros);
        ArrayList<String> mr = new ArrayList<>();

        for(String rrs : rr){
            for (int i = 0; i <= rrs.length(); i++) {
                String val = rrs.substring(0, i) + ch + rrs.substring(i);
                mr.add(val);
            }
        }

        return mr;
    }

    public static ArrayList<String> getBoardPath(int curr, int end){

        if(curr == end){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        if(curr > end){
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        ArrayList<String> mr = new ArrayList<>();

        for (int dice = 1; dice <= 6; dice++) {
            ArrayList<String> rr = getBoardPath(curr + dice, end);
            for (String rrs : rr) {
                mr.add(dice + rrs);
            }
        }

        return mr;
    }

    public static ArrayList<String> getMazePath(int cc, int cr, int ec, int er){
        /*  cc = current column
            cr = current row
            ec = end column
            er = end row  */
        
        if(cc == ec && cr == er){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        if(cc > ec || cr > er){
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        ArrayList<String> mr = new ArrayList<>(); // mr = my result

        ArrayList<String> rrh = getMazePath(cc + 1, cr, ec, er); // rrh = recursion result horizontal
        for (String rrhs : rrh) {  // rrhs = recursion result horizontal string
            mr.add("H" + rrhs);
        }

        ArrayList<String> rrv = getMazePath(cc, cr + 1, ec, er);
        for (String rrvs : rrv) {
            mr.add("V" + rrvs);
        }

        return mr;
    }

    public static ArrayList<String> getMazePathD(int cc, int cr, int ec, int er){

        if(cc == ec && cr == er){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        if(cc > ec || cr > er){
            ArrayList<String> br = new ArrayList<>();
            return br;
        }

        ArrayList<String> mr = new ArrayList<>();

        ArrayList<String> rrh = getMazePathD(cc + 1, cr, ec, er);
        for (String rrhs : rrh) {
            mr.add("H"+rrhs);
        }

        ArrayList<String> rrv = getMazePathD(cc, cr + 1, ec, er);
        for (String rrvs : rrv) {
            mr.add("V"+rrvs);
        }

        ArrayList<String> rrd = getMazePathD(cc + 1, cr + 1, ec, er);
        for (String rrds : rrd) {
            mr.add("D"+rrds);
        }

        return mr;
    }

    public static void printSS(String str, String res){

        if(str.length() == 0){
            System.out.println(res);
            return;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        /* There are two choice: each character is in the string or not, hence, 2^n
            subsequences are there for string of length n
            (Remeber Permutaion and Combination in Maths)
            (Refer: https://www.youtube.com/watch?v=EJwCUCjb9HM) */
        printSS(ros, res); // ch is not included in result
        printSS(ros, res + ch); // ch is included in result
    }

    public static void printPermutations(String ques, String ans){

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < ques.length(); i++) {
            char ch = ques.charAt(i);
            String roq = ques.substring(0, i) + ques.substring(i+1); // roq = rest of question

            printPermutations(roq, ans + ch);
        }
    }

    public static void printBoardPath(int curr, int end, String ans){

        if(curr == end){
            System.out.println(ans);
            return;
        }

        if(curr > end){
            return;
        }

        for (int dice = 1; dice <= 6; dice++) {
            printBoardPath(curr + dice, end, ans + dice);
        }
    }

    public static void displayArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        // System.out.println(Fib(7));
        // System.out.println(power(3,3));
        int arr[] = {2,1,4,9,10,2,9,1,1};
        // System.out.println(isSorted(arr, 0));
        // System.out.println(firstIndex(arr, 0, 20));
        // System.out.println(lastIndex(arr, 0, 2));
        // int arr2[] = allIndices(arr, 0, 2, -1);
        // for (int i : arr2) {
        //     System.out.println(i);
        // }
        // pattern(5, 1, 1);
        // BubbleSort(arr, 0, arr.length-1);
        // displayArray(arr);
        // System.out.println(getSS("abc"));
        // System.out.println(getPermutation("abc"));
        // System.out.println(getBoardPath(0, 10));
        // System.out.println(getMazePath(0, 0, 2, 2));
        // System.out.println(getMazePathD(0, 0, 2, 2));
        // printSS("abc", "");
        // printPermutations("abc", "");
        printBoardPath(0, 10, "");
    }
}