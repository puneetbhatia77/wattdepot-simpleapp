package org.wattdepot.simpleapp;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Tests the SimpleApplication application.
 * @author Philip Johnson
 */
public class TestSimpleApplication {
  
  /** The URL to use for testing. */
  private String testUrl = "http://server.wattdepot.org:8190/wattdepot/";
  /** The sample source to use for testing. */
  private String testSource = "Ilima-A";
  /** The sample date for testing. */
  private String testDate = "2011-11-01";

  /**
   * Tests the getCurrentPower method.  If it returns a positive value, assume OK.
   * @throws Exception If the testUrl is bad, or the sensor data exceeds the acceptable latency.
   */
  @Test
  public void testGetCurrentPower() throws Exception {
    SimpleApplication application = new SimpleApplication(testUrl);
    assertTrue("Testing current power", application.getCurrentPower(testSource) > 0);
  }
  
  
  /**
   * Tests the getDailyEnergy method.  If it returns a positive value, assume OK.
   * @throws Exception If the testUrl is bad, or the date does not have positive energy.
   */
  @Test
  public void testGetDailyEnergy() throws Exception {
    SimpleApplication application = new SimpleApplication(testUrl);
    assertTrue("Testing daily energy", application.getDailyEnergy(testSource, testDate) > 0);
  }
  
  
  /**
   * Tests the getEnergySince method.  If it returns a positive value, assume OK.
   * @throws Exception If the testUrl is bad, or the date does not have positive energy.
   */
  @Test
  public void testGetEnergySince() throws Exception {
    SimpleApplication application = new SimpleApplication(testUrl);
    assertTrue("Testing energy since", application.getDailyEnergy(testSource, testDate) > 0);
  }

}
