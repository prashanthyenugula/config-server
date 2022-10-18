package com.api;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	@Autowired
	RouteDefinitionLocator locator;
	
	public List<GroupedOpenApi> apis(){
		List<GroupedOpenApi> groups = new ArrayList<>();
		List<RouteDefinition> definations = locator.getRouteDefinitions().collectList().block();
		assert definations != null;
		definations.stream().filter(routeDefination -> routeDefination.getId().matches(".*-service"))
		.forEach(routeDefination ->  {
			String name = routeDefination.getId().replaceAll("-service", "");
			groups.add(GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build());
		});
		return groups;
	}
}
