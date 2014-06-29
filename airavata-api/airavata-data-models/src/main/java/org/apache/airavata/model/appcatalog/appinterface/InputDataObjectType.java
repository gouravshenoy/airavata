    /*
     * Licensed to the Apache Software Foundation (ASF) under one or more
     * contributor license agreements.  See the NOTICE file distributed with
     * this work for additional information regarding copyright ownership.
     * The ASF licenses this file to You under the Apache License, Version 2.0
     * (the "License"); you may not use this file except in compliance with
     * the License.  You may obtain a copy of the License at
     *
     *     http://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */
/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.model.appcatalog.appinterface;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Inputs. The paramters describe how inputs are passed to the application.
 * 
 * name:
 *   Name of the parameter.
 * 
 * value:
 *   Value of the parameter. A default value could be set during registration.
 * 
 * type:
 *   Data type of the parameter
 * 
 * applicationArguement:
 *   The argument flag sent to the application. Such as -p pressure.
 * 
 * standardInput:
 *   When this value is set, the parameter is sent as standard input rather than a parameter.
 *   Typically this is passed using redirection operator ">".
 * 
 * userFriendlyDescription:
 *   Description to be displayed at the user interface.
 * 
 * metaData:
 *   Any metadat. This is typically ignore by Airavata and is used by gateways for application configuration.
 * 
 */
@SuppressWarnings("all") public class InputDataObjectType implements org.apache.thrift.TBase<InputDataObjectType, InputDataObjectType._Fields>, java.io.Serializable, Cloneable, Comparable<InputDataObjectType> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("InputDataObjectType");

  private static final org.apache.thrift.protocol.TField IS_EMPTY_FIELD_DESC = new org.apache.thrift.protocol.TField("isEmpty", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField VALUE_FIELD_DESC = new org.apache.thrift.protocol.TField("value", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField APPLICATION_ARGUEMENT_FIELD_DESC = new org.apache.thrift.protocol.TField("applicationArguement", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField STANDARD_INPUT_FIELD_DESC = new org.apache.thrift.protocol.TField("standardInput", org.apache.thrift.protocol.TType.BOOL, (short)6);
  private static final org.apache.thrift.protocol.TField USER_FRIENDLY_DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("userFriendlyDescription", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField META_DATA_FIELD_DESC = new org.apache.thrift.protocol.TField("metaData", org.apache.thrift.protocol.TType.STRING, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new InputDataObjectTypeStandardSchemeFactory());
    schemes.put(TupleScheme.class, new InputDataObjectTypeTupleSchemeFactory());
  }

  private boolean isEmpty; // required
  private String name; // required
  private String value; // optional
  private DataType type; // optional
  private String applicationArguement; // optional
  private boolean standardInput; // optional
  private String userFriendlyDescription; // optional
  private String metaData; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  @SuppressWarnings("all") public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    IS_EMPTY((short)1, "isEmpty"),
    NAME((short)2, "name"),
    VALUE((short)3, "value"),
    /**
     * 
     * @see DataType
     */
    TYPE((short)4, "type"),
    APPLICATION_ARGUEMENT((short)5, "applicationArguement"),
    STANDARD_INPUT((short)6, "standardInput"),
    USER_FRIENDLY_DESCRIPTION((short)7, "userFriendlyDescription"),
    META_DATA((short)8, "metaData");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // IS_EMPTY
          return IS_EMPTY;
        case 2: // NAME
          return NAME;
        case 3: // VALUE
          return VALUE;
        case 4: // TYPE
          return TYPE;
        case 5: // APPLICATION_ARGUEMENT
          return APPLICATION_ARGUEMENT;
        case 6: // STANDARD_INPUT
          return STANDARD_INPUT;
        case 7: // USER_FRIENDLY_DESCRIPTION
          return USER_FRIENDLY_DESCRIPTION;
        case 8: // META_DATA
          return META_DATA;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ISEMPTY_ISSET_ID = 0;
  private static final int __STANDARDINPUT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.VALUE,_Fields.TYPE,_Fields.APPLICATION_ARGUEMENT,_Fields.STANDARD_INPUT,_Fields.USER_FRIENDLY_DESCRIPTION,_Fields.META_DATA};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.IS_EMPTY, new org.apache.thrift.meta_data.FieldMetaData("isEmpty", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.VALUE, new org.apache.thrift.meta_data.FieldMetaData("value", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, DataType.class)));
    tmpMap.put(_Fields.APPLICATION_ARGUEMENT, new org.apache.thrift.meta_data.FieldMetaData("applicationArguement", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.STANDARD_INPUT, new org.apache.thrift.meta_data.FieldMetaData("standardInput", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.USER_FRIENDLY_DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("userFriendlyDescription", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.META_DATA, new org.apache.thrift.meta_data.FieldMetaData("metaData", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(InputDataObjectType.class, metaDataMap);
  }

  public InputDataObjectType() {
    this.isEmpty = false;

    this.standardInput = false;

  }

  public InputDataObjectType(
    boolean isEmpty,
    String name)
  {
    this();
    this.isEmpty = isEmpty;
    setIsEmptyIsSet(true);
    this.name = name;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public InputDataObjectType(InputDataObjectType other) {
    __isset_bitfield = other.__isset_bitfield;
    this.isEmpty = other.isEmpty;
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetValue()) {
      this.value = other.value;
    }
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetApplicationArguement()) {
      this.applicationArguement = other.applicationArguement;
    }
    this.standardInput = other.standardInput;
    if (other.isSetUserFriendlyDescription()) {
      this.userFriendlyDescription = other.userFriendlyDescription;
    }
    if (other.isSetMetaData()) {
      this.metaData = other.metaData;
    }
  }

  public InputDataObjectType deepCopy() {
    return new InputDataObjectType(this);
  }

  @Override
  public void clear() {
    this.isEmpty = false;

    this.name = null;
    this.value = null;
    this.type = null;
    this.applicationArguement = null;
    this.standardInput = false;

    this.userFriendlyDescription = null;
    this.metaData = null;
  }

  public boolean isIsEmpty() {
    return this.isEmpty;
  }

  public void setIsEmpty(boolean isEmpty) {
    this.isEmpty = isEmpty;
    setIsEmptyIsSet(true);
  }

  public void unsetIsEmpty() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ISEMPTY_ISSET_ID);
  }

  /** Returns true if field isEmpty is set (has been assigned a value) and false otherwise */
  public boolean isSetIsEmpty() {
    return EncodingUtils.testBit(__isset_bitfield, __ISEMPTY_ISSET_ID);
  }

  public void setIsEmptyIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ISEMPTY_ISSET_ID, value);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void unsetValue() {
    this.value = null;
  }

  /** Returns true if field value is set (has been assigned a value) and false otherwise */
  public boolean isSetValue() {
    return this.value != null;
  }

  public void setValueIsSet(boolean value) {
    if (!value) {
      this.value = null;
    }
  }

  /**
   * 
   * @see DataType
   */
  public DataType getType() {
    return this.type;
  }

  /**
   * 
   * @see DataType
   */
  public void setType(DataType type) {
    this.type = type;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public String getApplicationArguement() {
    return this.applicationArguement;
  }

  public void setApplicationArguement(String applicationArguement) {
    this.applicationArguement = applicationArguement;
  }

  public void unsetApplicationArguement() {
    this.applicationArguement = null;
  }

  /** Returns true if field applicationArguement is set (has been assigned a value) and false otherwise */
  public boolean isSetApplicationArguement() {
    return this.applicationArguement != null;
  }

  public void setApplicationArguementIsSet(boolean value) {
    if (!value) {
      this.applicationArguement = null;
    }
  }

  public boolean isStandardInput() {
    return this.standardInput;
  }

  public void setStandardInput(boolean standardInput) {
    this.standardInput = standardInput;
    setStandardInputIsSet(true);
  }

  public void unsetStandardInput() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __STANDARDINPUT_ISSET_ID);
  }

  /** Returns true if field standardInput is set (has been assigned a value) and false otherwise */
  public boolean isSetStandardInput() {
    return EncodingUtils.testBit(__isset_bitfield, __STANDARDINPUT_ISSET_ID);
  }

  public void setStandardInputIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __STANDARDINPUT_ISSET_ID, value);
  }

  public String getUserFriendlyDescription() {
    return this.userFriendlyDescription;
  }

  public void setUserFriendlyDescription(String userFriendlyDescription) {
    this.userFriendlyDescription = userFriendlyDescription;
  }

  public void unsetUserFriendlyDescription() {
    this.userFriendlyDescription = null;
  }

  /** Returns true if field userFriendlyDescription is set (has been assigned a value) and false otherwise */
  public boolean isSetUserFriendlyDescription() {
    return this.userFriendlyDescription != null;
  }

  public void setUserFriendlyDescriptionIsSet(boolean value) {
    if (!value) {
      this.userFriendlyDescription = null;
    }
  }

  public String getMetaData() {
    return this.metaData;
  }

  public void setMetaData(String metaData) {
    this.metaData = metaData;
  }

  public void unsetMetaData() {
    this.metaData = null;
  }

  /** Returns true if field metaData is set (has been assigned a value) and false otherwise */
  public boolean isSetMetaData() {
    return this.metaData != null;
  }

  public void setMetaDataIsSet(boolean value) {
    if (!value) {
      this.metaData = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case IS_EMPTY:
      if (value == null) {
        unsetIsEmpty();
      } else {
        setIsEmpty((Boolean)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((String)value);
      }
      break;

    case VALUE:
      if (value == null) {
        unsetValue();
      } else {
        setValue((String)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((DataType)value);
      }
      break;

    case APPLICATION_ARGUEMENT:
      if (value == null) {
        unsetApplicationArguement();
      } else {
        setApplicationArguement((String)value);
      }
      break;

    case STANDARD_INPUT:
      if (value == null) {
        unsetStandardInput();
      } else {
        setStandardInput((Boolean)value);
      }
      break;

    case USER_FRIENDLY_DESCRIPTION:
      if (value == null) {
        unsetUserFriendlyDescription();
      } else {
        setUserFriendlyDescription((String)value);
      }
      break;

    case META_DATA:
      if (value == null) {
        unsetMetaData();
      } else {
        setMetaData((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case IS_EMPTY:
      return Boolean.valueOf(isIsEmpty());

    case NAME:
      return getName();

    case VALUE:
      return getValue();

    case TYPE:
      return getType();

    case APPLICATION_ARGUEMENT:
      return getApplicationArguement();

    case STANDARD_INPUT:
      return Boolean.valueOf(isStandardInput());

    case USER_FRIENDLY_DESCRIPTION:
      return getUserFriendlyDescription();

    case META_DATA:
      return getMetaData();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case IS_EMPTY:
      return isSetIsEmpty();
    case NAME:
      return isSetName();
    case VALUE:
      return isSetValue();
    case TYPE:
      return isSetType();
    case APPLICATION_ARGUEMENT:
      return isSetApplicationArguement();
    case STANDARD_INPUT:
      return isSetStandardInput();
    case USER_FRIENDLY_DESCRIPTION:
      return isSetUserFriendlyDescription();
    case META_DATA:
      return isSetMetaData();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof InputDataObjectType)
      return this.equals((InputDataObjectType)that);
    return false;
  }

  public boolean equals(InputDataObjectType that) {
    if (that == null)
      return false;

    boolean this_present_isEmpty = true;
    boolean that_present_isEmpty = true;
    if (this_present_isEmpty || that_present_isEmpty) {
      if (!(this_present_isEmpty && that_present_isEmpty))
        return false;
      if (this.isEmpty != that.isEmpty)
        return false;
    }

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_value = true && this.isSetValue();
    boolean that_present_value = true && that.isSetValue();
    if (this_present_value || that_present_value) {
      if (!(this_present_value && that_present_value))
        return false;
      if (!this.value.equals(that.value))
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_applicationArguement = true && this.isSetApplicationArguement();
    boolean that_present_applicationArguement = true && that.isSetApplicationArguement();
    if (this_present_applicationArguement || that_present_applicationArguement) {
      if (!(this_present_applicationArguement && that_present_applicationArguement))
        return false;
      if (!this.applicationArguement.equals(that.applicationArguement))
        return false;
    }

    boolean this_present_standardInput = true && this.isSetStandardInput();
    boolean that_present_standardInput = true && that.isSetStandardInput();
    if (this_present_standardInput || that_present_standardInput) {
      if (!(this_present_standardInput && that_present_standardInput))
        return false;
      if (this.standardInput != that.standardInput)
        return false;
    }

    boolean this_present_userFriendlyDescription = true && this.isSetUserFriendlyDescription();
    boolean that_present_userFriendlyDescription = true && that.isSetUserFriendlyDescription();
    if (this_present_userFriendlyDescription || that_present_userFriendlyDescription) {
      if (!(this_present_userFriendlyDescription && that_present_userFriendlyDescription))
        return false;
      if (!this.userFriendlyDescription.equals(that.userFriendlyDescription))
        return false;
    }

    boolean this_present_metaData = true && this.isSetMetaData();
    boolean that_present_metaData = true && that.isSetMetaData();
    if (this_present_metaData || that_present_metaData) {
      if (!(this_present_metaData && that_present_metaData))
        return false;
      if (!this.metaData.equals(that.metaData))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(InputDataObjectType other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetIsEmpty()).compareTo(other.isSetIsEmpty());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsEmpty()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isEmpty, other.isEmpty);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValue()).compareTo(other.isSetValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValue()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.value, other.value);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetApplicationArguement()).compareTo(other.isSetApplicationArguement());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetApplicationArguement()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.applicationArguement, other.applicationArguement);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetStandardInput()).compareTo(other.isSetStandardInput());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStandardInput()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.standardInput, other.standardInput);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserFriendlyDescription()).compareTo(other.isSetUserFriendlyDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserFriendlyDescription()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userFriendlyDescription, other.userFriendlyDescription);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMetaData()).compareTo(other.isSetMetaData());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMetaData()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.metaData, other.metaData);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("InputDataObjectType(");
    boolean first = true;

    sb.append("isEmpty:");
    sb.append(this.isEmpty);
    first = false;
    if (!first) sb.append(", ");
    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (isSetValue()) {
      if (!first) sb.append(", ");
      sb.append("value:");
      if (this.value == null) {
        sb.append("null");
      } else {
        sb.append(this.value);
      }
      first = false;
    }
    if (isSetType()) {
      if (!first) sb.append(", ");
      sb.append("type:");
      if (this.type == null) {
        sb.append("null");
      } else {
        sb.append(this.type);
      }
      first = false;
    }
    if (isSetApplicationArguement()) {
      if (!first) sb.append(", ");
      sb.append("applicationArguement:");
      if (this.applicationArguement == null) {
        sb.append("null");
      } else {
        sb.append(this.applicationArguement);
      }
      first = false;
    }
    if (isSetStandardInput()) {
      if (!first) sb.append(", ");
      sb.append("standardInput:");
      sb.append(this.standardInput);
      first = false;
    }
    if (isSetUserFriendlyDescription()) {
      if (!first) sb.append(", ");
      sb.append("userFriendlyDescription:");
      if (this.userFriendlyDescription == null) {
        sb.append("null");
      } else {
        sb.append(this.userFriendlyDescription);
      }
      first = false;
    }
    if (isSetMetaData()) {
      if (!first) sb.append(", ");
      sb.append("metaData:");
      if (this.metaData == null) {
        sb.append("null");
      } else {
        sb.append(this.metaData);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetIsEmpty()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'isEmpty' is unset! Struct:" + toString());
    }

    if (!isSetName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'name' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class InputDataObjectTypeStandardSchemeFactory implements SchemeFactory {
    public InputDataObjectTypeStandardScheme getScheme() {
      return new InputDataObjectTypeStandardScheme();
    }
  }

  private static class InputDataObjectTypeStandardScheme extends StandardScheme<InputDataObjectType> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, InputDataObjectType struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // IS_EMPTY
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isEmpty = iprot.readBool();
              struct.setIsEmptyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // VALUE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.value = iprot.readString();
              struct.setValueIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.type = DataType.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // APPLICATION_ARGUEMENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.applicationArguement = iprot.readString();
              struct.setApplicationArguementIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // STANDARD_INPUT
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.standardInput = iprot.readBool();
              struct.setStandardInputIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // USER_FRIENDLY_DESCRIPTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.userFriendlyDescription = iprot.readString();
              struct.setUserFriendlyDescriptionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // META_DATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.metaData = iprot.readString();
              struct.setMetaDataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, InputDataObjectType struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(IS_EMPTY_FIELD_DESC);
      oprot.writeBool(struct.isEmpty);
      oprot.writeFieldEnd();
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.value != null) {
        if (struct.isSetValue()) {
          oprot.writeFieldBegin(VALUE_FIELD_DESC);
          oprot.writeString(struct.value);
          oprot.writeFieldEnd();
        }
      }
      if (struct.type != null) {
        if (struct.isSetType()) {
          oprot.writeFieldBegin(TYPE_FIELD_DESC);
          oprot.writeI32(struct.type.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.applicationArguement != null) {
        if (struct.isSetApplicationArguement()) {
          oprot.writeFieldBegin(APPLICATION_ARGUEMENT_FIELD_DESC);
          oprot.writeString(struct.applicationArguement);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetStandardInput()) {
        oprot.writeFieldBegin(STANDARD_INPUT_FIELD_DESC);
        oprot.writeBool(struct.standardInput);
        oprot.writeFieldEnd();
      }
      if (struct.userFriendlyDescription != null) {
        if (struct.isSetUserFriendlyDescription()) {
          oprot.writeFieldBegin(USER_FRIENDLY_DESCRIPTION_FIELD_DESC);
          oprot.writeString(struct.userFriendlyDescription);
          oprot.writeFieldEnd();
        }
      }
      if (struct.metaData != null) {
        if (struct.isSetMetaData()) {
          oprot.writeFieldBegin(META_DATA_FIELD_DESC);
          oprot.writeString(struct.metaData);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class InputDataObjectTypeTupleSchemeFactory implements SchemeFactory {
    public InputDataObjectTypeTupleScheme getScheme() {
      return new InputDataObjectTypeTupleScheme();
    }
  }

  private static class InputDataObjectTypeTupleScheme extends TupleScheme<InputDataObjectType> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, InputDataObjectType struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeBool(struct.isEmpty);
      oprot.writeString(struct.name);
      BitSet optionals = new BitSet();
      if (struct.isSetValue()) {
        optionals.set(0);
      }
      if (struct.isSetType()) {
        optionals.set(1);
      }
      if (struct.isSetApplicationArguement()) {
        optionals.set(2);
      }
      if (struct.isSetStandardInput()) {
        optionals.set(3);
      }
      if (struct.isSetUserFriendlyDescription()) {
        optionals.set(4);
      }
      if (struct.isSetMetaData()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetValue()) {
        oprot.writeString(struct.value);
      }
      if (struct.isSetType()) {
        oprot.writeI32(struct.type.getValue());
      }
      if (struct.isSetApplicationArguement()) {
        oprot.writeString(struct.applicationArguement);
      }
      if (struct.isSetStandardInput()) {
        oprot.writeBool(struct.standardInput);
      }
      if (struct.isSetUserFriendlyDescription()) {
        oprot.writeString(struct.userFriendlyDescription);
      }
      if (struct.isSetMetaData()) {
        oprot.writeString(struct.metaData);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, InputDataObjectType struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.isEmpty = iprot.readBool();
      struct.setIsEmptyIsSet(true);
      struct.name = iprot.readString();
      struct.setNameIsSet(true);
      BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.value = iprot.readString();
        struct.setValueIsSet(true);
      }
      if (incoming.get(1)) {
        struct.type = DataType.findByValue(iprot.readI32());
        struct.setTypeIsSet(true);
      }
      if (incoming.get(2)) {
        struct.applicationArguement = iprot.readString();
        struct.setApplicationArguementIsSet(true);
      }
      if (incoming.get(3)) {
        struct.standardInput = iprot.readBool();
        struct.setStandardInputIsSet(true);
      }
      if (incoming.get(4)) {
        struct.userFriendlyDescription = iprot.readString();
        struct.setUserFriendlyDescriptionIsSet(true);
      }
      if (incoming.get(5)) {
        struct.metaData = iprot.readString();
        struct.setMetaDataIsSet(true);
      }
    }
  }

}

