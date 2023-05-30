package com.petzey.clinic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@SpringBootApplication
public class Application {

	@Value(value = "${swagger.url}")   
	public String url;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    
	@Bean 
	public OpenAPI customOpenAPI() 
	{
		Server productionserver = new Server(); 
	//Server localserver = new Server(); 
	List<Server> servers = new ArrayList<>();
	productionserver.setUrl(url);   
	//localserver.setUrl(localURL);
	servers.add(productionserver);
	// servers.add(localserver); 
	OpenAPI openAPI = new OpenAPI(); 
	openAPI.setServers(servers);   
	return openAPI; 
	}
}  
