/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.vonbargen.dennis.weightnut.api.ejb;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import se.vonbargen.dennis.weightnut.api.ejb.local.DBInterfaceLocal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.vonbargen.dennis.weightnut.api.model.Food;
import se.vonbargen.dennis.weightnut.api.model.Meal;
import se.vonbargen.dennis.weightnut.api.model.SystemParameter;

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
    public SystemParameter getParameter(String parameter) {
        logger.log(Level.FINER, "getParameter({0})", parameter);
        
        return em.createNamedQuery("SystemParameter.findByParam", SystemParameter.class)
                .setParameter("param", parameter)
                .getSingleResult();
    }

    @Override
    public List<Long> getFoodId(List<String> foods) {
        logger.log(Level.FINER, "getFoodId(List.size({0}))", foods.size());
        
        return em.createQuery("SELECT f.idfood "
                + "FROM Food f "
                + "WHERE f.name IN :foods", Long.class)
                .setParameter("foods", foods)
                .getResultList();
    }

    @Override
    public List<Food> getAllFoodId() {
        logger.log(Level.FINER, "getAllFoodId()");
        
        return em.createQuery("SELECT f.idfood "
                + "FROM Food f ", Food.class)
                .getResultList();
    }

    @Override
    public List<Food> getFoods(List<Long> foods, int offset, int maxResults) {
        logger.log(Level.FINER, "getFoods(List.size({0}), {1}, {2})", 
                new Object[]{foods.size(), offset, maxResults});
        
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
        logger.log(Level.FINER, "getMealId(List.size({0}))", meals.size());
        
        return em.createQuery("SELECT m.idmeal "
                + "FROM Meal m "
                + "WHERE m.mealName IN :meals", Long.class)
                .setParameter("foods", meals)
                .getResultList();
    }

    @Override
    public List<Meal> getAllMealId() {
        logger.log(Level.FINER, "getAllMealId()");
        
        return em.createQuery("SELECT m.idmeal "
                + "FROM Meal m ", Meal.class)
                .getResultList();
    }

    @Override
    public List<Meal> getMeals(List<Long> meals, int offset, int maxResults) {
        logger.log(Level.FINER, "getMeals(List.size({0}), {1}, {2})",
                new Object[]{meals.size(), offset, maxResults});
        
        return em.createQuery("SELECT m "
                + "FROM Meal m "
                + "WHERE m.idmeal IN :meals", Meal.class)
                .setParameter("meals", meals)
                .setFirstResult(offset)
                .setMaxResults(maxResults)
                .getResultList();
    }
}
