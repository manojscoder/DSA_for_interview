// Problem link: https://leetcode.com/problems/design-a-food-rating-system/description
// Time: O(n log n)
// Space: O(n)
class food {
    int rating;
    String food;

    public food(int rating, String food) {
        this.rating = rating;
        this.food = food;
    }
}

class FoodRatings {

    Map<String, TreeSet<food>> cuisine_foods;
    Map<String, String> food_cuisine;
    Map<String, Integer> rating;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.cuisine_foods = new HashMap<>();
        this.food_cuisine = new HashMap<>();
        this.rating = new HashMap<>();

        for(int index = 0; index < foods.length; index++) {
            this.cuisine_foods.putIfAbsent(cuisines[index], new TreeSet<>((a, b) -> {
                if(a.rating == b.rating)
                    return a.food.compareTo(b.food);
                else
                    return Integer.compare(b.rating, a.rating);
            }));
            this.cuisine_foods.get(cuisines[index]).add(new food(ratings[index], foods[index]));
            this.food_cuisine.put(foods[index], cuisines[index]);
            this.rating.put(foods[index], ratings[index]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        int rating = this.rating.get(food);
        String cuisine = this.food_cuisine.get(food);

        this.cuisine_foods.get(cuisine).remove(new food(rating, food));
        this.cuisine_foods.get(cuisine).add(new food(newRating, food));
        this.rating.put(food, newRating);
    }
    
    public String highestRated(String cuisine) {
        return this.cuisine_foods.get(cuisine).first().food;
    }
}
