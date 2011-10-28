package org.wattdepot.simpleapp;

import java.util.List;
import org.wattdepot.client.WattDepotClient;
import org.wattdepot.resource.source.jaxb.Source;

/**
 * A simple application that shows basic interaction with a running WattDepot server.
 * @author Philip Johnson
 */
public class SimpleApplication {

  /**
   * Illustrate simple interaction with WattDepot.
   * @param args The first arg should be the URL to a running WattDepot server.
   */
  public static void main(String[] args) throws Exception {
    String url = args[0];
    // Create a client.
    WattDepotClient client = new WattDepotClient(url);
    // Check to make sure a connection can be made. 
    // If no connection, then exit right now.
    if (client.isHealthy()) {
      System.out.format("Connected successfully to: %s%n", url);
    }
    else {
      System.out.format("Could not connect to: %s%n", url);
      return;
    }
    // Get the list of sources and print them out.
    System.out.println("WattDepot sources defined for this URL:");
    List<Source> sources = client.getSources();
    for (Source source : sources) {
      System.out.format("Name: %20s %s%n", source.getName(), source.getDescription());
    }
    
    // Find the last sensor data from the first source in our list.
    Source sampleSource = sources.get(0);
    client.getLatestSensorData(source)
  }
}
