/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.vonbargen.dennis.weightnut.api.ejb;

import java.util.List;
import java.util.logging.Logger;
import se.vonbargen.dennis.weightnut.api.ejb.local.DBInterfaceLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.vonbargen.dennis.weightnut.api.model.Food;
import se.vonbargen.dennis.weightnut.api.model.Meal;

/**
 *
 * @author dennis
 */
@Stateless
public class DBInterface implements DBInterfaceLocal {

    @PersistenceContext(unitName = "WeightNut-API-ejbPU")
    private EntityManager em;

    private static final Logger logger = Logger.getLogger(DBInterface.class.getName());

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<Long> getFoodId(List<String> foods) {
        return em.createQuery("SELECT f.idfood "
                + "FROM Food f "
                + "WHERE f.name IN :foods", Long.class)
                .setParameter("foods", foods)
                .getResultList();
    }

    @Override
    public List<Food> getAllFoodId() {
        return em.createQuery("SELECT f.idfood "
                + "FROM Food f ", Food.class)
                .getResultList();
    }

    @Override
    public List<Food> getFoods(List<Long> foods, int offset, int maxResults) {
        return em.createQuery("SELECT f "
                + "FROM Food f "
                + "WHERE f.idfood IN :foods", Food.class)
                .setParameter("foods", foods)
                .setFirstResult(offset)
                .setMaxResults(maxResults)
                .getResultList();
    }

    @Override
    public List<Long> getMealId(List<String> meals) {
        return em.createQuery("SELECT m.idmeal "
                + "FROM Meal m "
                + "WHERE m.mealName IN :meals", Long.class)
                .setParameter("foods", meals)
                .getResultList();
    }

    @Override
    public List<Meal> getAllMealId() {
        return em.createQuery("SELECT m.idmeal "
                + "FROM Meal m ", Meal.class)
                .getResultList();
    }

    @Override
    public List<Meal> getMeals(List<Long> meals, int offset, int maxResults) {
        return em.createQuery("SELECT m "
                + "FROM Meal m "
                + "WHERE m.idmeal IN :meals", Meal.class)
                .setParameter("meals", meals)
                .setFirstResult(offset)
                .setMaxResults(maxResults)
                .getResultList();
    }
}
