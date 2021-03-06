/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
///*
// *
// * Licensed to the Apache Software Foundation (ASF) under one
// * or more contributor license agreements.  See the NOTICE file
// * distributed with this work for additional information
// * regarding copyright ownership.  The ASF licenses this file
// * to you under the Apache License, Version 2.0 (the
// * "License"); you may not use this file except in compliance
// * with the License.  You may obtain a copy of the License at
// *
// *   http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing,
// * software distributed under the License is distributed on an
// * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// * KIND, either express or implied.  See the License for the
// * specific language governing permissions and limitations
// * under the License.
// *
// */
//
//package org.apache.airavata.workflow.model.ode;
//
//import java.util.ArrayList;
//
//import org.xmlpull.infoset.XmlAttribute;
//import org.xmlpull.infoset.XmlElement;
//
//import xsul5.wsdl.WsdlBinding;
//import xsul5.wsdl.WsdlDefinitions;
//import xsul5.wsdl.WsdlPort;
//import xsul5.wsdl.WsdlService;
//
///**
// * ODE does not work well with the wsdls with SOAP 1.2 binding and HTTP bindings that are generated by wsdls generated
// * by Axis2. This class is intended to remove the extra bindings and the extra ports.
// * 
// */
//public class WSDLCleaner {
//
//    public static void cleanWSDL(WsdlDefinitions definition) {
//        WsdlDefinitions wsdl = definition;
//        Iterable<WsdlBinding> bindings = wsdl.bindings();
//        ArrayList<WsdlBinding> removedBindings = new ArrayList<WsdlBinding>();
//        for (WsdlBinding wsdlBinding : bindings) {
//            XmlElement innerBinding = wsdlBinding.xml().element("binding");
//            if (null != innerBinding
//                    && !"http://schemas.xmlsoap.org/wsdl/soap/".equals(innerBinding.getNamespace().getName())) {
//
//                removedBindings.add(wsdlBinding);
//            }
//        }
//        // to mitigate the Concurrent modifications this is done separately
//        for (WsdlBinding wsdlBinding : removedBindings) {
//            wsdl.xml().removeElement(wsdlBinding.xml());
//        }
//
//        ArrayList<WsdlPort> removePorts = new ArrayList<WsdlPort>();
//        Iterable<WsdlService> services = wsdl.services();
//        for (WsdlService wsdlService : services) {
//            Iterable<WsdlPort> ports = wsdlService.ports();
//            for (WsdlPort wsdlPort : ports) {
//                for (WsdlBinding removedBinding : removedBindings) {
//                    if (removedBinding.getName().equals(wsdlPort.getBinding().getLocalPart())) {
//                        removePorts.add(wsdlPort);
//                        break;
//                    }
//                }
//            }
//            for (WsdlPort wsdlPort : removePorts) {
//                wsdlService.xml().removeElement(wsdlPort.xml());
//            }
//            removePorts.clear();
//        }
//
//        // remove attributeFormDefault and elementFormDefault
//        Iterable<XmlElement> schemas = wsdl.getTypes().elements(null, "schema");
//        for (XmlElement schema : schemas) {
//            XmlAttribute attributeFormDefault = schema.attribute("attributeFormDefault");
//            schema.removeAttribute(attributeFormDefault);
//
//            XmlAttribute elementFormDefault = schema.attribute("elementFormDefault");
//            schema.removeAttribute(elementFormDefault);
//        }
//    }
//
//    //
//    // public void addUniqueMessageNameIfNecessary(WsdlDefinitions definition){
//    //
//    //
//    // Iterable<WsdlMessage> messages = definition.messages();
//    // for (WsdlMessage wsdlMessage : messages) {
//    // String msgName = wsdlMessage.getName();
//    // WSDLUtil.replaceAttributeValue(element, name, oldValue, newValue)
//    // }
//    // }
//
//}