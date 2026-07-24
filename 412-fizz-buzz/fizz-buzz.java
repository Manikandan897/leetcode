class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> arr = new ArrayList<>(n);
        
        
        for (int i = 1; i <= n; i++) {
            boolean divBy3 = i % 3 == 0;
            boolean divBy5 = i % 5 == 0;
            
            
            if (!divBy3 && !divBy5)
                arr.add(Integer.toString(i));
            else if (divBy5 && divBy3)
                arr.add("FizzBuzz");
            else if (divBy3)
                arr.add("Fizz");
            else
                arr.add("Buzz");
        }
        
        
        return arr;
    }
}