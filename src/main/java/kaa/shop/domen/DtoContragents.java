package kaa.shop.domen;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class DtoContragents implements CrudRepository<EntityContragents, long> {

    private final CrudRepository rep;

    @Autowired
    DtoContragents(CrudRepository rep) {
        this.rep = rep;
    }

    @Transactional
    @Override
    public void delete(EntityContragents contr){
        rep.delete( contr);
    }

    /*public void deleteAll(){}

    public Optional<EntityContragents> findById(long ID) { return null;}

    public List<EntityContragents> findAllByID(Iterable<ID> ids){ return null;}*/
}
