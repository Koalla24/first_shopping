package kaa.shop.Repository;

import kaa.shop.Domen.EntityContragents;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DaoContragentsImpl {

    @Autowired
    DaoContragents daoContragents;

    public List<EntityContragents> findByAny( String pId,  String pName) {
        Long newId = null;
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
        return dc;
    };
}
