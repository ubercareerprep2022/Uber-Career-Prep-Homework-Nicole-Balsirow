import java.util.*;

public class Part2{
    public static void main(String args[]){
        //this is the main function-->testing the function
        Scanner scan = new Scanner(System.in);
        System.out.println("Testing for Permutation, input 2 strings");
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        boolean yes = isStringPermutation(s1, s2);
        System.out.println(yes);

        System.out.println("Testing for Pairs, input TargetSum");
        int target = scan.nextInt();
        int[] p = {1, 4, 2, 3, 6, 10, 9, 5, 8};
        ArrayList<Integer> pt = new ArrayList<Integer>(p.length);
        for (int i : p){
            pt.add(i);
        }
        List<List<Integer>> r = pairsThatEqualSum(pt, Integer.valueOf(target));
        System.out.print("[");
        for(int i = 0; i<r.size()-1; i++){
            System.out.print("(" + r.get(i).get(0).toString() + ", " + r.get(i).get(1).toString() + "), ");
        }
        System.out.print("(" + r.get(r.size()-1).get(0).toString() + ", " + r.get(r.size()-1).get(1).toString() + ")]");
        System.out.println();

    }


    public static boolean isStringPermutation(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        HashMap<Character, Integer> check = new HashMap<>();
        for(int i = 0; i<s1.length(); i++){
            Character k = Character.valueOf(s1.charAt(i));
    	    if(check.containsKey(k)){
	            int v = check.get(k)+1;
                check.put(k, v);
    	    }else{
                check.put(k, 1);
            }
        }
        for(int i = 0; i<s2.length(); i++){
            Character k = Character.valueOf(s2.charAt(i));
            if(check.containsKey(k)){
                int v = check.get(k)-1;
                if(v>=0){
                    check.put(k, v);
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
    
    public static List<List<Integer>> pairsThatEqualSum(List<Integer> inputArray, Integer targetSum) {
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        if(inputArray.size()<2){
            return pairs;
        }
        int target = targetSum.intValue();
        for (int i = 0; i<inputArray.size(); i++){
            int comp1 = inputArray.get(i).intValue();
            for (int j = i+1; j<inputArray.size(); j++){
                int comp2 = inputArray.get(j).intValue();
                if(comp2 + comp1 == targetSum){
                    List<Integer> pair = new ArrayList<Integer>(2); 
                    pair.add(Integer.valueOf(comp1));
                    pair.add(Integer.valueOf(comp2));
                    pairs.add(pair);
                }
            }
        }
        return pairs;
    
    }
 
}
