package br.com.jpautil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class JPAUtil {

	private static EntityManagerFactory factory = null;

	public JPAUtil() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("meuprimeiroprojetojsf");
		}
	}
	
	@Produces
	@RequestScoped
	public EntityManager getEntityManager1() {
		factory = Persistence.createEntityManagerFactory("meuprimeiroprojetojsf");
		return factory.createEntityManager();
	}
	
	public static EntityManager getEntityManager() {
		factory = Persistence.createEntityManagerFactory("meuprimeiroprojetojsf");
		return factory.createEntityManager();
	}
	
	public Object getPrimaryKey(Object entity) {
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}

}
