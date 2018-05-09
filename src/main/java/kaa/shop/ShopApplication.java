package kaa.shop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShopApplication {

	private static String SQL_SELECT_ANY = "SELECT p FROM EntityContragents p WHERE 1=1 AND (:id is null OR p.id = :id) AND (:Name is null OR p.Name LIKE :Name)";

	public static void main(String[] args) {

		EntityManager entManager = Persistence.createEntityManagerFactory("first_shop").createEntityManager();

		SpringApplication.run(ShopApplication.class, args);

		/*TypedQuery typQ = entManager.createQuery(SQL_SELECT_ANY , EntityContragents.class)
		        .setParameter("Name", "OO")
				.setParameter("id", null);*/

		Query qry = entManager.createQuery(SQL_SELECT_ANY /*,EntityContragents.class*/)
				.setParameter("Name", null)
				.setParameter("id", null);

		int offset = 2;
		int limit = 3;
		qry.setFirstResult(offset);
		qry.setMaxResults(limit);
		List arrayList = qry.getResultList();

		//arrayList.get(0).toString();
		System.out.println("-----------------------------------------!!!!!!!!!!!!" +arrayList.size());

		for( Object ttt: arrayList  ) {
			System.out.println(ttt.toString());
			System.out.println(ttt.getClass());
		}
//		DaoContragentsImpl ttt = new DaoContragentsImpl( entM);
//			System.out.println( ttt.toString());
//			System.out.println( ttt.toString());
//		ttt.findByAny(3, 2, null, null);
	}

}
