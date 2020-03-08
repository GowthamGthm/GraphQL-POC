package com.godigit.graphql.model;

import lombok.Data;

/**
 * Class represents call from http://jsonplaceholder.typicode.com/todos/1
 */
@Data
public class BookInfo {
	
	private int userId;
	private int id;
	private String title;
	private Boolean completed;
}
