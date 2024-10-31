# Problem link: https://leetcode.com/problems/design-a-food-rating-system/description
# Time: O(n log n)
# Space: O(n)
from sortedcontainers import SortedSet

class FoodRatings:

    def __init__(self, foods: List[str], cuisines: List[str], ratings: List[int]):
        self.cuisines_foods = defaultdict(SortedSet)
        self.food_cuisine = {}
        self.rating = {}

        for index in range(len(foods)):
            self.cuisines_foods[cuisines[index]].add((-ratings[index], foods[index]))
            self.food_cuisine[foods[index]] = cuisines[index]
            self.rating[foods[index]] = ratings[index]

    def changeRating(self, food: str, newRating: int) -> None:
        cuisine, rating = self.food_cuisine[food], self.rating[food]

        self.cuisines_foods[cuisine].remove((-rating, food))
        self.cuisines_foods[cuisine].add((-newRating, food))
        self.rating[food] = newRating
        
    def highestRated(self, cuisine: str) -> str:
        return self.cuisines_foods[cuisine][0][1]
