/*
 * Copyright 2014 by the Metanome project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.metanome.algorithm_integration.configuration;

import de.metanome.algorithm_integration.AlgorithmConfigurationException;
import de.metanome.algorithm_integration.AlgorithmExecutionException;
import de.metanome.test_helper.GwtSerializationTester;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Tests for {@link ConfigurationRequirementDatabaseConnection}
 */
public class ConfigurationRequirementDatabaseConnectionTest {

  /**
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {

  }

  /**
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {

  }

  /**
   * Test method for {@link ConfigurationRequirementDatabaseConnection#ConfigurationRequirementDatabaseConnection(String)}
   * <p/> The identifier should be set in the constructor and be retrievable through getIdentifier.
   * The numberOfValues should be set to 1.
   */
  @Test
  public void testConstructorGetOne() {
    // Setup
    // Expected values
    String expectedIdentifier = "parameter1";
    int expectedNumberOfValues = 1;
    ConfigurationRequirementDatabaseConnection
        configSpec =
        new ConfigurationRequirementDatabaseConnection(expectedIdentifier);

    // Execute functionality
    String actualIdentifier = configSpec.getIdentifier();
    int actualNumberOfValues = configSpec.getNumberOfSettings();

    // Check result
    assertEquals(expectedIdentifier, actualIdentifier);
    assertEquals(expectedNumberOfValues, actualNumberOfValues);
  }

  /**
   * Test method for {@link ConfigurationRequirementDatabaseConnection#ConfigurationRequirementDatabaseConnection(String)}
   * <p/> The identifier should be set in the constructor and be retrievable through getIdentifier.
   * The numberOfValues should be set to 2.
   */
  @Test
  public void testConstructorGetTwo() {
    // Setup
    // Expected values
    String expectedIdentifier = "parameter1";
    int expectedNumberOfValues = 2;
    ConfigurationRequirementDatabaseConnection
        configSpec =
        new ConfigurationRequirementDatabaseConnection(expectedIdentifier, expectedNumberOfValues);

    // Execute functionality
    String actualIdentifier = configSpec.getIdentifier();
    int actualNumberOfValues = configSpec.getNumberOfSettings();

    // Check result
    assertEquals(expectedIdentifier, actualIdentifier);
    assertEquals(expectedNumberOfValues, actualNumberOfValues);
  }

  /**
   * Test method for {@link ConfigurationRequirementDatabaseConnection#checkAndSetSettings(de.metanome.algorithm_integration.configuration.ConfigurationSettingDatabaseConnection...)}
   *
   * Setting a wrong number of settings should throw an Exception.
   */
  @Test(expected=AlgorithmExecutionException.class)
  public void testSetSettingsWithWrongNumber() throws AlgorithmConfigurationException {
    // Setup
    ConfigurationRequirementDatabaseConnection
        configSpec =
        new ConfigurationRequirementDatabaseConnection("parameter1", 2);
    // Expected values
    ConfigurationSettingDatabaseConnection expectedValue = mock(ConfigurationSettingDatabaseConnection.class);

    // Execute functionality
    configSpec.checkAndSetSettings(expectedValue);
  }

  /**
   * Tests that the instances of {@link ConfigurationRequirementDatabaseConnection}
   * are serializable in GWT.
   */
  @Test
  public void testGwtSerialization() {
    GwtSerializationTester
        .checkGwtSerializability(new ConfigurationRequirementDatabaseConnection("some identifier", 3));
  }
}
