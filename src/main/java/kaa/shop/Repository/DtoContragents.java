package kaa.shop.Repository;

import kaa.shop.Domen.EntityContragents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//@Repository
@Transactional
public class DtoContragents implements CrudRepository<EntityContragents, Long> {

    @Autowired
    private final CrudRepository rep;

    private final JpaEntityInformation<EntityContragents, Long> entityInformation;

    //@Autowired
    public DtoContragents( JpaEntityInformation<EntityContragents, Long> pEntityInformation, CrudRepository rep) {
        this.rep = rep;
        this.entityInformation = pEntityInformation;
    }

    @Override
    public void delete(EntityContragents contr){
        rep.delete( contr);

        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public List<EntityContragents> findAllById( Iterable<Long> ids){

        if (!ids.iterator().hasNext()) {
            return Collections.emptyList();
        }


    }

    public void deleteAll(Iterable<? extends EntityContragents> entities) {

        for (EntityContragents entity : entities) {
            delete(entity);
        }
    }

    /*@Override
    public void deleteAll(){
        rep.deleteAll();
        getQueryString(DELETE_ALL_QUERY_STRING, entityInformation.getEntityName());
    }*/

    @Override
    public void deleteById( Long pId){
        rep.deleteById(pId);
    }

    @Override
    public boolean existsById( Long pId){
        return rep.existsById(pId);
    }

    @Override
    public long count(){
        return em.createQuery(getCountQueryString(), Long.class).getSingleResult();
       // return rep.count();
    }

    public <S extends EntityContragents> List<S> saveAll(Iterable<S> entities) {

        List<S> result = new ArrayList<S>();

        for (S entity : entities) {
            result.add( save(entity));
        }
        return result;
    }

}
