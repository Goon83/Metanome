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

package de.metanome.frontend.client.parameter;

import de.metanome.algorithm_integration.AlgorithmConfigurationException;
import de.metanome.algorithm_integration.configuration.ConfigurationRequirementListBox;
import de.metanome.algorithm_integration.configuration.ConfigurationSettingListBox;
import de.metanome.algorithm_integration.configuration.ConfigurationRequirement;
import de.metanome.frontend.client.TabWrapper;
import de.metanome.frontend.client.input_fields.InputField;
import de.metanome.frontend.client.input_fields.ListBoxInput;

import java.util.List;

public class InputParameterListBoxWidget extends InputParameterWidget {

  protected ConfigurationRequirementListBox specification;
  protected List<ListBoxInput> inputWidgets;
  protected TabWrapper messageReceiver;

  public InputParameterListBoxWidget(ConfigurationRequirementListBox config, TabWrapper wrapper) {
    super(config, wrapper);
  }

  @Override
  protected void addInputField(boolean optional) {
    ListBoxInput field = new ListBoxInput(optional);
    field.setValues(this.specification.getValues());
    this.inputWidgets.add(field);
    int index = (this.getWidgetCount() < 1 ? 0 : this.getWidgetCount() - 1);
    this.insert(field, index);
  }

  @Override
  public ConfigurationRequirementListBox getUpdatedSpecification()
      throws AlgorithmConfigurationException {
    this.specification.checkAndSetSettings(this.getConfigurationSettings());
    return this.specification;
  }

  protected ConfigurationSettingListBox[] getConfigurationSettings() {
    ConfigurationSettingListBox[]
        values =
        new ConfigurationSettingListBox[this.inputWidgets.size()];
    int i = 0;
    for (ListBoxInput lbi : this.inputWidgets) {
      values[i] = new ConfigurationSettingListBox(lbi.getSelectedValue());
      i++;
    }
    return values;
  }


  @Override
  public List<? extends InputField> getInputWidgets() {
    return this.inputWidgets;
  }

  @Override
  public void setInputWidgets(List<? extends InputField> inputWidgetsList) {
    this.inputWidgets = (List<ListBoxInput>) inputWidgetsList;
  }


  @Override
  public ConfigurationRequirement getSpecification() {
    return this.specification;
  }

  @Override
  public void setSpecification(ConfigurationRequirement config) {
    this.specification = (ConfigurationRequirementListBox) config;
  }

  protected void setSelection(String value) {
    for (ListBoxInput input : this.inputWidgets) {
      input.setSelectedValue(value);
    }
  }

  @Override
  public void setMessageReceiver(TabWrapper messageReceiver) {
    this.messageReceiver = messageReceiver;
  }
}
