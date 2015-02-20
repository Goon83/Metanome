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

import com.google.common.annotations.GwtIncompatible;

import com.fasterxml.jackson.annotation.JsonTypeName;

import de.metanome.algorithm_integration.AlgorithmConfigurationException;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;

/**
 * Concrete {@link ConfigurationRequirement} for database connections.
 *
 * @author Jakob Zwiener
 * @see ConfigurationRequirement
 */
@JsonTypeName("ConfigurationRequirementDatabaseConnection")
public class ConfigurationRequirementDatabaseConnection extends ConfigurationRequirement {

  private ConfigurationSettingDatabaseConnection[] settings;
  private List<String> acceptedDBSystems = new ArrayList<>();

  /**
   * Exists for serialization.
   */
  public ConfigurationRequirementDatabaseConnection() {
  }

  /**
   * Construct a {@link ConfigurationRequirementDatabaseConnection}, requesting 1 value.
   *
   * @param identifier the specification's identifier
   */
  public ConfigurationRequirementDatabaseConnection(String identifier) {
    super(identifier);
  }

  /**
   * Construcats a {@link ConfigurationRequirementDatabaseConnection}, potentially requesting
   * several values.
   *
   * @param identifier       the specification's identifier
   * @param numberOfSettings the number of settings expected
   */
  public ConfigurationRequirementDatabaseConnection(String identifier,
                                                    int numberOfSettings) {

    super(identifier, numberOfSettings);
  }

  /**
   * Constructs a {@link ConfigurationRequirementDatabaseConnection}, requesting several values.
   *
   * @param identifier         the specification's identifier
   * @param minNumberOfSetting the min number of settings expected
   * @param maxNumberOfSetting the max number of settings expected
   */
  public ConfigurationRequirementDatabaseConnection(String identifier,
                                         int minNumberOfSetting,
                                         int maxNumberOfSetting) {
    super(identifier, minNumberOfSetting, maxNumberOfSetting);
  }

  @Override
  public ConfigurationSettingDatabaseConnection[] getSettings() {
    return settings;
  }
  /**
   * Exists only for serialization!
   * @param settings the settings
   */
  public void setSettings(ConfigurationSettingDatabaseConnection... settings) {
    this.settings = settings;
  }

  public void setAcceptedDBSystems(ArrayList<String> dbSystems) {
    this.acceptedDBSystems = dbSystems;
  }

  public List<String> getAcceptedDBSystems() {
    return this.acceptedDBSystems;
  }

  /**
   * Sets the actual settings on the requirement if the number of settings is correct.
   *
   * @param settings the settings
   * @throws de.metanome.algorithm_integration.AlgorithmConfigurationException if the number of
   * settings does not match the expected number of settings
   */
  @XmlTransient
  public void checkAndSetSettings(ConfigurationSettingDatabaseConnection... settings)
      throws AlgorithmConfigurationException {
    checkNumberOfSettings(settings.length);
    this.settings = settings;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @XmlTransient
  @GwtIncompatible("ConfigurationValues cannot be build on client side.")
  public ConfigurationValue build(ConfigurationFactory factory)
      throws AlgorithmConfigurationException {
    return factory.build(this);
  }

}
