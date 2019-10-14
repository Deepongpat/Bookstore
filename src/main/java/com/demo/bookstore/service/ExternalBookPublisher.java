package com.demo.bookstore.service;

import java.io.IOException;

import okhttp3.*;

public class ExternalBookPublisher {
	
	  private final OkHttpClient httpClient = new OkHttpClient();

	   public String getBook() throws Exception {

	        Request request = new Request.Builder()
	                .url("https://scb-test-book-publisher.herokuapp.com/books")
	                .build();

	        try (Response response = httpClient.newCall(request).execute()) {

	            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

	            // Get response body
	            String body =response.body().string();
	            System.out.println(body);
	            return body;
	        }

	    }
	   
	   public String getBookRecommendation() throws Exception {

	        Request request = new Request.Builder()
	                .url("https://scb-test-book-publisher.herokuapp.com/books/recommendation")
	                .build();

	        try (Response response = httpClient.newCall(request).execute()) {

	            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

	            // Get response body
	            String body =response.body().string();
	            System.out.println(body);
	            return body;
	        }

	    }
	   
	   
	
}
