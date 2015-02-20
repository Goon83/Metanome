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
import de.metanome.test_helper.GwtSerializationTester;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

/**
 * Tests for {@link ConfigurationRequirementRelationalInput}
 *
 * @author Jakob Zwiener
 */
public class ConfigurationRequirementRelationalInputTest {

  /**
   * Test method for {@link ConfigurationRequirementRelationalInput#getSettings()} and {@link
   * ConfigurationRequirementRelationalInput#checkAndSetSettings(ConfigurationSettingRelationalInput...)
   */
  @Test
  public void testGetSetValues() throws AlgorithmConfigurationException {
    // Setup
    ConfigurationRequirementRelationalInput
        configSpec =
        new ConfigurationRequirementRelationalInput("parameter1", 2);
    // Expected values
    ConfigurationSettingRelationalInput
        expectedSetting0 =
        mock(ConfigurationSettingRelationalInput.class);
    ConfigurationSettingRelationalInput
        expectedSetting1 =
        mock(ConfigurationSettingRelationalInput.class);

    // Execute functionality
    configSpec.checkAndSetSettings(expectedSetting0, expectedSetting1);
    List<ConfigurationSettingRelationalInput>
        actualSettings =
        Arrays.asList(configSpec.getSettings());

    // Check result
    assertThat(actualSettings, IsIterableContainingInAnyOrder
        .containsInAnyOrder(expectedSetting0, expectedSetting1));
  }

  /**
   * Test method for {@link ConfigurationRequirementRelationalInput#getSettings()} and {@link
   * ConfigurationRequirementRelationalInput#checkAndSetSettings(ConfigurationSettingRelationalInput...)
   */
  @Test
  public void testGetSetValuesRange() throws AlgorithmConfigurationException {
    // Setup
    ConfigurationRequirementRelationalInput
        configSpec =
        new ConfigurationRequirementRelationalInput("parameter1", 2, 4);
    // Expected values
    ConfigurationSettingRelationalInput
        expectedSetting0 =
        mock(ConfigurationSettingRelationalInput.class);
    ConfigurationSettingRelationalInput
        expectedSetting1 =
        mock(ConfigurationSettingRelationalInput.class);
    ConfigurationSettingRelationalInput
        expectedSetting2 =
        mock(ConfigurationSettingRelationalInput.class);

    // Execute functionality
    configSpec.checkAndSetSettings(expectedSetting0, expectedSetting1, expectedSetting2);
    List<ConfigurationSettingRelationalInput>
        actualSettings =
        Arrays.asList(configSpec.getSettings());

    // Check result
    assertThat(actualSettings, IsIterableContainingInAnyOrder
        .containsInAnyOrder(expectedSetting0, expectedSetting1, expectedSetting2));
  }

  /**
   * Test method for {@link ConfigurationRequirementRelationalInput#checkAndSetSettings(ConfigurationSettingRelationalInput...)}
   *
   * When setting the wrong number of settings, false is returned.
   */
  @Test
  public void testSetValuesWrongNumberOfValues() {
    // Setup
    ConfigurationRequirementRelationalInput
        configSpec =
        new ConfigurationRequirementRelationalInput("parameter1", 2);
    // Expected values
    ConfigurationSettingRelationalInput
        expectedSetting0 =
        mock(ConfigurationSettingRelationalInput.class);
    ConfigurationSettingRelationalInput
        expectedSetting1 =
        mock(ConfigurationSettingRelationalInput.class);
    ConfigurationSettingRelationalInput
        expectedSetting2 =
        mock(ConfigurationSettingRelationalInput.class);

    // Execute functionality
    // Check result
    try {
      configSpec.checkAndSetSettings(expectedSetting0);
    } catch (AlgorithmConfigurationException e) {
      // should trow an exception
    }

    try {
      configSpec.checkAndSetSettings(expectedSetting0, expectedSetting1);
    } catch (AlgorithmConfigurationException e) {
      fail(); // number of settings is correct
    }

    try {
      configSpec.checkAndSetSettings(expectedSetting0, expectedSetting1, expectedSetting2);
    } catch (AlgorithmConfigurationException e) {
      // should throw an exception
    }
  }



  /**
   * Test method for {@link ConfigurationRequirementRelationalInput#checkAndSetSettings(ConfigurationSettingRelationalInput...)}
   *
   * When setting the wrong number of settings, false is returned.
   */
  @Test
  public void testSetValuesWrongNumberRangeOfValues() {
    // Setup
    ConfigurationRequirementRelationalInput
        configSpec =
        new ConfigurationRequirementRelationalInput("parameter1", 2, 4);
    // Expected values
    ConfigurationSettingRelationalInput
        expectedSetting0 =
        mock(ConfigurationSettingRelationalInput.class);
    ConfigurationSettingRelationalInput
        expectedSetting1 =
        mock(ConfigurationSettingRelationalInput.class);
    ConfigurationSettingRelationalInput
        expectedSetting2 =
        mock(ConfigurationSettingRelationalInput.class);
    ConfigurationSettingRelationalInput
        expectedSetting3 =
        mock(ConfigurationSettingRelationalInput.class);

    // Execute functionality
    // Check result
    try {
      configSpec.checkAndSetSettings(expectedSetting0);
    } catch (AlgorithmConfigurationException e) {
      // should trow an exception
    }

    try {
      configSpec.checkAndSetSettings(expectedSetting0, expectedSetting1);
    } catch (AlgorithmConfigurationException e) {
      fail(); // number of settings is correct
    }

    try {
      configSpec.checkAndSetSettings(expectedSetting0, expectedSetting1, expectedSetting2);
    } catch (AlgorithmConfigurationException e) {
      fail(); // number of settings is correct
    }

    try {
      configSpec.checkAndSetSettings(expectedSetting0, expectedSetting1, expectedSetting2, expectedSetting3);
    } catch (AlgorithmConfigurationException e) {
      // should throw an exception
    }
  }


  /**
   * Tests that the instances of {@link ConfigurationRequirementRelationalInput}
   * are serializable in GWT.
   */
  @Test
  public void testGwtSerialization() {
    GwtSerializationTester
        .checkGwtSerializability(
            new ConfigurationRequirementRelationalInput("some identifier", 3));
  }
}
