// Problem link: https://leetcode.com/problems/integer-to-english-words/description
// Time: O(n), where n is the number of digits in the given input
// Space: O(1)

class Solution {
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        
        Map<Integer, String> mapping = new HashMap<>();
        StringBuilder result = new StringBuilder();
        int number = 1, index = 0;


        String[] store = {"", "Thousand", "Million", "Billion", "One", "Two", 
                        "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
                        "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", 
                        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


        for(int idx = 4; idx < store.length; idx++) { 
            mapping.put(number, store[idx]);
            number += (idx >= 23 ? 10 : 1);
        }


        while(num > 0) {
            String sen = this.generate(num % 1000, mapping);

            if(sen.length() > 0)
                result.insert(0, sen + " " + store[index] + " ");

            num /= 1000;
            index++;
        }

        return result.toString().trim();
    }


    private String generate(int num, Map<Integer, String> mapping) {
        if(mapping.containsKey(num)) {
            return mapping.get(num);
        }

        int place = 1;
        StringBuilder sen = new StringBuilder();

        while(num > 0) {
            if(num % 10 != 0) {
                if(place == 100) {
                    sen.insert(0, mapping.get(num % 10) + " Hundred");
                }
                else if(num / 100 > 0 && mapping.containsKey(num % 100)) {
                    sen.insert(0, " " + mapping.get(num % 100));
                    place *= 10;
                    num /= 10;
                }
                else {
                    sen.insert(0, " " + mapping.get(num % 10 * place));
                }
            }

            place *= 10;
            num /= 10;
        }

        return sen.toString().trim();
    }
}
