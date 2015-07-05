package io.hypertrack.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.java.model.MoviesData;
import main.java.model.Response;
import main.java.services.MoviesService;

import com.google.gson.Gson;



@Path("/")
public class MoviesContoller {
	
	@GET
	@Path("movies/{movie}")
	@Produces("application/json")
	public String getmovielocations(@PathParam("movie") String movie, String body) throws IOException{
		System.out.println(movie);
		MoviesService service = new MoviesService();
		Response<MoviesData> userProfile = service.getmovielocations(movie);
		//System.out.println(userProfile.getErrorCode()+ "  "+userProfile.getMessage()+ " "+userProfile.getData());
		Gson gson = new Gson();
		return gson.toJson(userProfile);
	}
	
	@GET
	@Path("recommend/{title}")
	@Produces("application/json")
	public String getmovies(@PathParam("title") String title, String body) throws IOException{
		System.out.println(title);
		MoviesService service = new MoviesService();
		Response<String> userProfile = service.getrecommendmovies(title);
		//System.out.println(userProfile.getErrorCode()+ "  "+userProfile.getMessage()+ " "+userProfile.getData());
		Gson gson = new Gson();
		return gson.toJson(userProfile);
	}
	

}
