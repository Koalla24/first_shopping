package kaa.shop.Repository;

import kaa.shop.Domen.EntityContragents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

//@Repository
@Transactional
public interface DaoContragents extends CrudRepository<EntityContragents, Long> {

    @Query("SELECT p FROM EntityContragents p")
    public List<EntityContragents> findAll();

    @Query("SELECT p FROM EntityContragents p WHERE p.id = :id")
    public List<EntityContragents> findById( @Param("id") long pId);

    @Query("SELECT p FROM EntityContragents p WHERE 1=1 AND (:id is null OR p.id = :id) AND (:Name IS NULL OR p.Name LIKE %:Name%)")
    public List<EntityContragents> findByAny(@Param("id") Long pId, @Param("Name") String pName);
}
