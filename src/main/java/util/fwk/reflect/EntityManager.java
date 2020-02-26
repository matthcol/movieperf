package util.fwk.reflect;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import util.fwk.reflect.annotation.Entity;
import util.fwk.reflect.exception.PersistenceException;

public class EntityManager<T>{
	
	public void persist(T t) {
		
	}
	
	/**
	 * 
	 * @param objectClass
	 * @return
	 * @throws PersistenceException
	 */
	public List<T> findAll(Class<T> objectClass) throws PersistenceException{
		
		Optional<Entity> optClassEntity = Annotations.getAnnotation(objectClass, Entity.class);
		Entity classEntity = optClassEntity.orElseThrow(
				()->exceptionFromNonPersistenceClass(objectClass));
		String tableName = classEntity.name();
		if(tableName.isEmpty()) {
			tableName=objectClass.getSimpleName();
		}
		
		String sql = "select * from "+tableName;
		System.out.println(sql);
		return null;
		
	}

	private static PersistenceException exceptionFromNonPersistenceClass(Class<?> objectClass) {
		return new PersistenceException("class "+objectClass.getName()
		+" is not persistent");
		
	}
}
