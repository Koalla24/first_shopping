package kaa.shop;

import kaa.shop.Domen.EntityContragents;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("first_shop");
		EntityManager entM = entityManagerFactory.createEntityManager();

		SpringApplication.run(ShopApplication.class, args);
		System.out.println( "----------------------- entityManagerFactory: " +entityManagerFactory.toString());

//		DaoContragentsImpl ttt = new DaoContragentsImpl( entM);
		TypedQuery typQ = entM.createQuery("SELECT p FROM EntityContragents p" , EntityContragents.class);
//WHERE 1=1 AND (:id is null OR p.id = :id) AND (:Name IS NULL OR p.Name LIKE %:Name%)
		//.setParameter("custName", name)
		System.out.println( "sdsjbdfljksdnfljksndfljksdnfsjk --------------------------------------- 2");
		int offset = 2;;
		int limit = 3;;
		typQ.setFirstResult(offset);
		typQ.setMaxResults(limit);
		List arrayList = typQ.getResultList();
		arrayList.get(0).toString();
		System.out.println(arrayList);
		for( Object ttt: arrayList  ){
			System.out.println( ttt.toString());
			System.out.println( ttt.getClass());
//			System.out.println( ttt.toString());
//			System.out.println( ttt.toString());
		}
//		ttt.findByAny(3, 2, null, null);

	}
}
