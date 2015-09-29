/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.vonbargen.dennis.weightnut.api.ejb.local;

import java.util.List;
import javax.ejb.Local;
import se.vonbargen.dennis.weightnut.api.model.Food;
import se.vonbargen.dennis.weightnut.api.model.Meal;

/**
 *
 * @author dennis
 */
@Local
public interface DBInterfaceLocal {
    
    public void persist(Object object);
    
    public List<Long> getFoodId(List<String> foods);
    public List<Food> getAllFoodId();
    public List<Food> getFoods(List<Long> foods, int offset, int maxResults);
    
    public List<Long> getMealId(List<String> meals);
    public List<Meal> getAllMealId();
    public List<Meal> getMeals(List<Long> meals, int offset, int maxResults);
}
