package kaa.shop.Repository;

import kaa.shop.Domen.EntityContragents;
import javax.persistence.*;
import java.util.ArrayList;


public class DaoContragentsImpl {

    private static String SQL_SELECT_ANY = "SELECT p FROM EntityContragents p WHERE 1=1 AND (:id is null OR p.id = :id) AND (:Name is null OR p.Name LIKE :Name)";

    public void DaoContragentsImpl(){
    }

    public ArrayList<EntityContragents> findByAny( int offset , int limit, String pId,  String pName, EntityManager entManager) {

        Long newId = null;
        String newName = null;

        if( pId != null && pId.trim().length() > 0)
               try {
                     newId = Long.valueOf(pId);
                     System.out.println(pId);
               } catch (NumberFormatException e) {
                     System.err.println("Введено не число. Неверный формат строки!");
                     return null;
               }

        if(pName != null && pName.trim().length() > 0) newName = pName;

        //EntityManager entManager = Persistence.createEntityManagerFactory("first_shop").createEntityManager();

        Query qry = entManager.createQuery(SQL_SELECT_ANY)
                .setParameter("Name", newName)
                .setParameter("id", newId)
                .setFirstResult(offset)
                .setMaxResults(limit);

        ArrayList<EntityContragents> arrayList = (ArrayList<EntityContragents>)qry.getResultList();

        /*System.out.println( "!!!!! ----------------------------------------------- !!!! : " +arrayList.size());
        for( EntityContragents ttt: arrayList  ){
            System.out.println( ttt.toString());
        }*/
        return arrayList;
    };

}
