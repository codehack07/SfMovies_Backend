package main.java.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import main.java.dao.MoviesDao;
import main.java.model.MoviesData;
import main.java.model.Response;

 public class MoviesService{

	MoviesDao dao = new MoviesDao();

	public Response getmovielocations(String movie) {

		Response<MoviesData> response = new Response<MoviesData>();
		List<MoviesData> data =null;
		try{
			 data = dao.getmovielocationsDao(movie);
		}catch(Exception e){
			System.out.println(e.getMessage());
			response.setMessage(e.getMessage());
			response.setData(null);
			response.setErrorCode("");
			return response;
			//log
		}
   
		/*Iterator<MoviesData> iterator = data.iterator();
		while (iterator.hasNext()) {
			MoviesData md = (MoviesData) iterator.next();
			iterator.remove();
			data.add(md);
		}*/						
		response.setMessage("success");
		response.setData(data);
		response.setErrorCode("");

		return response;
		
		}
	
	
	public Response getrecommendmovies(String title) {

		Response<String> response = new Response<String>();
		List<MoviesData> data =null;
		List<String> movieslist=null;

	    Set<String> hashset = new HashSet<String>();
	    
		try{
			 data = dao.getrecommendmoviesDao(title);
		}catch(Exception e){
			System.out.println(e.getMessage());
			response.setMessage(e.getMessage());
			response.setData(null);
			response.setErrorCode("");
			return response;
			//log
		}
   
		Iterator<MoviesData> iterator = data.iterator();
		while (iterator.hasNext()) {
			MoviesData md = (MoviesData)iterator.next();
			
			hashset.add(md.getTitle());
			
			
		}		
	    movieslist = new ArrayList<String>(hashset);
		response.setMessage("success");
		response.setData(movieslist);
		response.setErrorCode("");

		return response;
		
		}
	
	

}
