package kaa.shop.Repository;

import javafx.application.Application;
import kaa.shop.Domen.EntityContragents;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


//import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class DaoContragentsImpl {

    private EntityManager entM;

    public void DaoContragentsImpl( EntityManager pEntM){
        this.entM = pEntM;
    }

    public ArrayList<EntityContragents> findByAny( int limit , int offset, String pId,  String pName) {

        EntityManager entManager = Persistence.createEntityManagerFactory("first_shop").createEntityManager();

        //Query typQ = entM.createQuery("SELECT p FROM EntityContragents p" ); /*, EntityContragents.class*/
        TypedQuery typQ = entM.createQuery("SELECT p FROM EntityContragents p" , EntityContragents.class);
//WHERE 1=1 AND (:id is null OR p.id = :id) AND (:Name IS NULL OR p.Name LIKE %:Name%)
        //.setParameter("custName", name)
        System.out.println( "sdsjbdfljksdnfljksndfljksdnfsjk --------------------------------------- 2");

        typQ.setFirstResult(offset);
        typQ.setMaxResults(limit);
        ArrayList<EntityContragents> arrEntContr = (ArrayList<EntityContragents>) typQ.getResultList();

        for( EntityContragents ttt: arrEntContr  ){
            System.out.println( ttt);
        }

        return arrEntContr;

        /*Long newId = null;%
        String newName = pName;

        if(pId.trim().length() == 0) newId = null;
        else {
               try {
                     newId = Long.valueOf(pId);
                     System.out.println(pId);
               } catch (NumberFormatException e) {
                     System.err.println("Неверный формат строки!");
                     return null;
               }
        };

        if(pName.trim().length() == 0) newName = null;

        List<EntityContragents> dc = daoContragents.findByAny( newId, newName);
        return dc;*/
    };


}
