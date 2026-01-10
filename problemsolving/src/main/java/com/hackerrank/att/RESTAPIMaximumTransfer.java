package com.hackerrank.att;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

public class RESTAPIMaximumTransfer {
  private static final String BASE_URL = "https://jsonmock.hackerrank.com/api/transactions";

  private static List<String> maximumTransfer(String name, String city) {
    List<String> result = new ArrayList<>();
    URI uri = URI.create(BASE_URL);
    try {
      HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
      connection.setRequestMethod("GET");
      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder response = new StringBuilder();
      String line;
      while ((line = br.readLine()) != null) {
        response.append(line);
      }
      br.close();
      // System.out.println(response.toString());
      Gson gson = new Gson();
      JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
      System.out.println("jsonObject:\n" + jsonObject);
      JsonArray jsonArray = jsonObject.getAsJsonArray("data");
      boolean hasData = Optional.ofNullable(jsonArray)
          .map(array -> !array.isEmpty())
          .orElse(false);
      // System.out.println("hasData: " + hasData);
      if (!hasData) {
        return List.of();
      }
      JsonArray filteredJsonArray = StreamSupport.stream(jsonArray.spliterator(), false)
          .map(JsonElement::getAsJsonObject)
          .filter(obj -> {
            String jsonName = obj.get("userName").getAsString().trim();
            String jsonCity = obj.getAsJsonObject("location")
                .get("city")
                .getAsString()
                .trim();

            return jsonName.equalsIgnoreCase(name)
                && jsonCity.equalsIgnoreCase(city);
          })
          .collect(JsonArray::new, JsonArray::add, JsonArray::addAll);
      System.out.println("\nfilteredJsonArray:\n" + filteredJsonArray);
      // Max credit
      Optional<Double> maxCredit = StreamSupport.stream(filteredJsonArray.spliterator(), false)
          .map(JsonElement::getAsJsonObject)
          .filter(obj -> "credit".equalsIgnoreCase(obj.get("txnType").getAsString()))
          .map(obj -> parseAmount(obj.get("amount").getAsString()))
          .max(Double::compare);

      // Max debit
      Optional<Double> maxDebit = StreamSupport.stream(filteredJsonArray.spliterator(), false)
          .map(JsonElement::getAsJsonObject)
          .filter(obj -> "debit".equalsIgnoreCase(obj.get("txnType").getAsString()))
          .map(obj -> parseAmount(obj.get("amount").getAsString()))
          .max(Double::compare);

      result.add(formatCurrency(maxCredit.orElse(0.0)));
      result.add(formatCurrency(maxDebit.orElse(0.0)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    return result;
  }

  // Utility to parse "$1,670.57" → 1670.57
  private static double parseAmount(String amount) {
    return Double.parseDouble(amount.replace("$", "").replace(",", "").trim());
  }

  private static String formatCurrency(double value) {
    return String.format("$%,.2f", value);
  }

  public static void main(String[] args) {
    List<String> result = maximumTransfer("John Oliver", "Ripley");
    result.stream().forEach(System.out::println);
  }
}
