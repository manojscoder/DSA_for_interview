# Problem link: https://leetcode.com/problems/integer-to-english-words/description
# Time: O(n), where n is the number of digits
# Space: O(1)

class Solution:
    def numberToWords(self, num: int) -> str:
        if not num:
            return "Zero"

        between = ["", "Thousand", "Million", "Billion"]
        result, index = [], 0
        store = {1 : "One", 2 : "Two", 3 : "Three", 4 : "Four", 5 : "Five",
                6 : "Six", 7 : "Seven", 8 : "Eight", 9 : "Nine", 10 : "Ten",
                11 : "Eleven", 12 : "Twelve", 13 : "Thirteen", 14 : "Fourteen",
                15 : "Fifteen", 16 : "Sixteen", 17 : "Seventeen", 18 : "Eighteen",
                19 : "Nineteen", 20 : "Twenty", 30 : "Thirty", 40 : "Forty", 50: "Fifty",
                60 : "Sixty", 70 : "Seventy", 80 : "Eighty", 90 : "Ninety"}
        
        def word(num):
            if num in store:
                return store[num]
            
            sen, place = [], 1

            while num > 0:

                if num % 10 != 0:
                    if place == 100:
                        sen.append("Hundred")
                        sen.append(store[num % 10])

                    elif num // 100 > 0 and num % 100 in store:
                        sen.append(store[num % 100])
                        num, place = num // 10, place * 10

                    else:
                        sen.append(store[(num % 10) * place])

                num, place = num // 10, place * 10
            
            return " ".join(sen[::-1])
        

        while num > 0:
            sen = word(num % 1000)

            if sen:
                result.append(between[index])
                result.append(sen)
            
            index += 1
            num //= 1000
        
        return " ".join(result[::-1]).strip()
