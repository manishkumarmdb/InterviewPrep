package com.hackerrank.att;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RESTAPIBodyTemperature {
  /*
   * REST API: https://jsonmock.hackerrank.com/api/medical_records?page={page}
   * Fetch medical records and find min/max body temperature for specific doctor and diagnosis
   */

  // Fetch and filter medical records from REST API
  // Time: O(n) where n = total number of records across all pages
  // Space: O(1) excluding API response parsing
  // Returns [minTemp, maxTemp] for given doctor and diagnosis across all pages
  private static List<Integer> bodyTemperature(String doctorName, int diagnosisId) {
    int minTemp = Integer.MAX_VALUE;  // Initialize min to max value
    int maxTemp = Integer.MIN_VALUE;  // Initialize max to min value

    try {
      int page = 1;        // Start from page 1
      int total_page = 1;  // Will be updated from API response

      // Paginate through all pages of medical records
      while (page <= total_page) {
        // Build URL with page parameter
        String urlString = "https://jsonmock.hackerrank.com/api/medical_records?page=" + page;
        URL url = new URL(urlString);

        // Open HTTP connection and make GET request
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read response from API
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
          response.append(line);
        }
        br.close();

        // Parse JSON response
        JSONObject json = new JSONObject(response.toString());
        total_page = json.getInt("total_pages");  // Get total pages for pagination
        JSONArray data = json.getJSONArray("data");  // Get records array

        // Iterate through each medical record on current page
        for (int i = 0; i < data.length(); i++) {
          JSONObject record = data.getJSONObject(i);
          JSONObject doctor = record.getJSONObject("doctor");
          JSONObject diagnosis = record.getJSONObject("diagnosis");

          // Filter: match doctor name and diagnosis ID
          if (doctor.getString("name").equals(doctorName)
            && diagnosis.getInt("id") == diagnosisId) {

            // Extract body temperature from vitals
            int temp = record
              .getJSONObject("vitals")
              .getInt("bodyTemperature");

            // Update min and max temperatures
            minTemp = Math.min(minTemp, temp);
            maxTemp = Math.max(maxTemp, temp);
          }
        }

        // Move to next page
        page++;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Return both min and max temperatures as a list
    return Arrays.asList(minTemp, maxTemp);
  }

  public static void main(String[] args) {
    String doctorName = "Dr Arnold Bullock";
    int diagnosisId = 2;
    System.out.println(bodyTemperature(doctorName, diagnosisId));
  }
}
