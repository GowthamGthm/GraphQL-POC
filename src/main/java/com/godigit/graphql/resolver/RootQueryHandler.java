package com.godigit.graphql.resolver;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.godigit.graphql.model.BookInfo;

import lombok.AllArgsConstructor;

/**
 * Handler takes care of RootQueries in root.grapqls
 */
@AllArgsConstructor
public class RootQueryHandler implements GraphQLQueryResolver {
	
	private static final String EXTERNAL_URI = "http://jsonplaceholder.typicode.com/todos";

	private RestTemplate restTemplate;

	public BookInfo bookByTitle(String title) {
		List<BookInfo> books = bookInfos();
		BookInfo result = books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).findAny().get();
		return result;
	}
	
	public List<BookInfo> bookInfos() {
		ResponseEntity<BookInfo[]> response = restTemplate.getForEntity(EXTERNAL_URI, BookInfo[].class);
		BookInfo[] responseArr = response.getBody();
		List<BookInfo> bookInfos = Arrays.asList(responseArr);
		return bookInfos;
	}
	
	

}
