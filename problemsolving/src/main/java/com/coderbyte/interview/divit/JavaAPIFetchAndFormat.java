package com.coderbyte.interview.divit;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class JavaAPIFetchAndFormat {

  // Class to represent a Post object from JSON
  static class Post {
    int userId;
    int id;
  }

  // Function 1: fetchPosts()
  private static List<Post> fetchPosts() throws Exception {
    String urlString = "https://coderbyte.com/api/challenges/json/all-posts";
    URL url = new URL(urlString);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");

    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String inputLine;
    StringBuilder responseContent = new StringBuilder();

    while ((inputLine = in.readLine()) != null) {
      responseContent.append(inputLine);
    }
    in.close();

    // Parse JSON string to Post objects list using Gson
    Gson gson = new Gson();
    Post[] postsArray = gson.fromJson(responseContent.toString(), Post[].class);

    return Arrays.asList(postsArray);
  }

  // Function 2: formatPosts()
  private static List<Map<String, Integer>> formatPosts(List<Post> posts) {

    return posts.stream()
        .collect(Collectors.groupingBy(
            p -> p.userId,
            Collectors.counting()
        ))
        .entrySet()
        .stream()
        .sorted((a, b) -> {
          int cmp = Long.compare(b.getValue(), a.getValue());
          return (cmp != 0) ? cmp : Integer.compare(b.getKey(), a.getKey());
        })
        .map(e -> {
          Map<String, Integer> map = new LinkedHashMap<>();
          map.put("userId", e.getKey());
          map.put("numberOfPosts", e.getValue().intValue());
          return map;
        })
        .toList();
  }

  // Main function to test
  public static void main(String[] args) {
    try {
      List<Post> posts = fetchPosts();
      List<Map<String, Integer>> result = formatPosts(posts);
      System.out.println(result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
