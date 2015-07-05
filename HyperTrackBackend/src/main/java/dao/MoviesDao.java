package main.java.dao;

import java.util.List;

import main.java.model.MoviesData;
import main.java.utils.HibernateUtil;
import main.java.utils.HyperTrackException;
import main.java.utils.Initializer;

import org.hibernate.Query;
import org.hibernate.Session;

public class MoviesDao {

	public List<MoviesData> getmovielocationsDao(String Title) throws Exception{

		if(Title == null){
			throw new NullPointerException();
		}

		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	
			Query q = session.createQuery("from movies_data where Title = :Title");
			q.setParameter("Title", Title);
	
			MoviesData dbObject = null;
			@SuppressWarnings("unchecked")
			List<MoviesData> dbObjects = (List<MoviesData>)q.list();
			if(dbObjects.size() >= 1){
				
				
			}else if(dbObjects.size() == 0){
				throw new HyperTrackException(Initializer.properties.getProperty("E101"));
			}else{
				throw new HyperTrackException(Initializer.properties.getProperty("E4"));
			}
	
			session.getTransaction().commit();  
			session.close();
			
			return dbObjects;
		}catch(Exception e){
			//log
			throw e;
		}
	}
	
	public List<MoviesData> getrecommendmoviesDao(String Title) throws Exception{

		if(Title == null){
			throw new NullPointerException();
		}

		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	
			Query q = session.createQuery("from movies_data where Title LIKE :Title");
			q.setParameter("Title",Title + "%");
	
			MoviesData dbObject = null;
			@SuppressWarnings("unchecked")
			List<MoviesData> dbObjects = (List<MoviesData>)q.list();
			if(dbObjects.size() >= 1){
				
				
			}else if(dbObjects.size() == 0){
				throw new HyperTrackException(Initializer.properties.getProperty("E101"));
			}else{
				throw new HyperTrackException(Initializer.properties.getProperty("E4"));
			}
	
			session.getTransaction().commit();  
			session.close();
			
			return dbObjects;
		}catch(Exception e){
			//log
			throw e;
		}
	}
	
}
