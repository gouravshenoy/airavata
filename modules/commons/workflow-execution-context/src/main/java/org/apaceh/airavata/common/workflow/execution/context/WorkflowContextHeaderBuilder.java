/*
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
 *
*/
package org.apaceh.airavata.common.workflow.execution.context;

import org.apache.airavata.common.utils.XMLUtil;
import org.apache.airavata.schemas.wec.*;
import org.xmlpull.v1.builder.XmlElement;

public class WorkflowContextHeaderBuilder {

    private WorkflowMonitoringContextDocument.WorkflowMonitoringContext workflowMonitoringContext = null;

    private SecurityContextDocument.SecurityContext securityContext = null;

    private SoaServiceEprsDocument.SoaServiceEprs soaServiceEprs = null;

    private String userIdentifier = null;

    private WorkflowOutputDataHandlingDocument.WorkflowOutputDataHandling workflowOutputDataHandling = null;

    private ContextHeaderDocument.ContextHeader contextHeader = null;

    private WorkflowSchedulingContextDocument.WorkflowSchedulingContext workflowSchedulingContext = null;


    public WorkflowContextHeaderBuilder(String brokerUrl, String gfacUrl, String registryUrl, String experimentId, String workflowId) {
        this.contextHeader = ContextHeaderDocument.ContextHeader.Factory.newInstance();

        this.soaServiceEprs = SoaServiceEprsDocument.SoaServiceEprs.Factory.newInstance();
        this.soaServiceEprs.setGfacUrl(gfacUrl);
        this.soaServiceEprs.setRegistryUrl(registryUrl);

        this.workflowMonitoringContext = WorkflowMonitoringContextDocument.WorkflowMonitoringContext.Factory.newInstance();
        this.workflowMonitoringContext.setEventPublishEpr(brokerUrl);
        this.workflowMonitoringContext.setWorkflowInstanceId(workflowId);
        this.workflowMonitoringContext.setExperimentId(experimentId);

        this.contextHeader.setWorkflowMonitoringContext(this.workflowMonitoringContext);
        this.contextHeader.setSoaServiceEprs(this.soaServiceEprs);

        this.contextHeader.setSecurityContext(SecurityContextDocument.SecurityContext.Factory.newInstance());
        this.contextHeader.setWorkflowSchedulingContext(WorkflowSchedulingContextDocument.WorkflowSchedulingContext.Factory.newInstance());
    }

    public WorkflowContextHeaderBuilder setWorkflowMonitoringContext(WorkflowMonitoringContextDocument.WorkflowMonitoringContext workflowMonitoringContext) {
        this.workflowMonitoringContext = workflowMonitoringContext;
        return this;
    }


    public WorkflowContextHeaderBuilder setSecurityContext(SecurityContextDocument.SecurityContext securityContext) {
        this.securityContext = securityContext;
        return this;
    }


    public WorkflowContextHeaderBuilder setWorkflowOutputDataHandling(WorkflowOutputDataHandlingDocument.WorkflowOutputDataHandling workflowOutputDataHandling) {
        this.workflowOutputDataHandling = workflowOutputDataHandling;
        return this;
    }

    public WorkflowContextHeaderBuilder setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
        return this;
    }

    public WorkflowContextHeaderBuilder setContextHeader(ContextHeaderDocument.ContextHeader contextHeader) {
        this.contextHeader = contextHeader;
        return this;
    }

    public WorkflowContextHeaderBuilder setWorkflowSchedulingContext(WorkflowSchedulingContextDocument.WorkflowSchedulingContext workflowSchedulingContext) {
        this.workflowSchedulingContext = workflowSchedulingContext;
        return this;
    }

    public ContextHeaderDocument.ContextHeader getContextHeader() {
        return contextHeader;
    }

    public WorkflowSchedulingContextDocument.WorkflowSchedulingContext getWorkflowSchedulingContext() {
        return workflowSchedulingContext;
    }

    public SecurityContextDocument.SecurityContext getSecurityContext() {
        return securityContext;
    }

    public WorkflowOutputDataHandlingDocument.WorkflowOutputDataHandling getWorkflowOutputDataHandling() {
        return workflowOutputDataHandling;
    }

    public SoaServiceEprsDocument.SoaServiceEprs getSoaServiceEprs() {
        return soaServiceEprs;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }


    public WorkflowMonitoringContextDocument.WorkflowMonitoringContext getWorkflowMonitoringContext() {
        return workflowMonitoringContext;
    }

    public XmlElement getXml() {
        this.contextHeader.setWorkflowMonitoringContext(this.workflowMonitoringContext);
        this.contextHeader.setSoaServiceEprs(this.soaServiceEprs);
        this.contextHeader.setSecurityContext(this.securityContext);
        this.contextHeader.setWorkflowSchedulingContext(this.workflowSchedulingContext);
        this.contextHeader.setUserIdentifier(this.userIdentifier);
        this.contextHeader.setWorkflowOutputDataHandling(this.workflowOutputDataHandling);
        return XMLUtil.stringToXmlElement3(this.contextHeader.toString());
    }

    public WorkflowContextHeaderBuilder setResourceSchedularUrl(String resourceSchedular) {
        this.soaServiceEprs.setResourceSchedulerUrl(resourceSchedular);
        return this;
    }

    public WorkflowContextHeaderBuilder setWorkflowTemplateId(String template) {
        this.workflowMonitoringContext.setWorkflowTemplateId(template);
        return this;
    }

    public WorkflowContextHeaderBuilder setWorkflowNodeId(String node) {
        this.workflowMonitoringContext.setWorkflowNodeId(node);
        return this;
    }

    public WorkflowContextHeaderBuilder setWorkflowTimeStep(int timestep) {
        this.workflowMonitoringContext.setWorkflowTimeStep(timestep);
        return this;
    }

    public WorkflowContextHeaderBuilder setServiceInstanceId(String node) {
        this.workflowMonitoringContext.setServiceInstanceId(node);
        return this;
    }

    public WorkflowContextHeaderBuilder setServiceReplicaId(String node) {
        this.workflowMonitoringContext.setServiceReplicaId(node);
        return this;
    }

    public WorkflowContextHeaderBuilder setEventPublishEpr(String node) {
        this.workflowMonitoringContext.setEventPublishEpr(node);
        return this;
    }

    public WorkflowContextHeaderBuilder setErrorPublishEpr(String node) {
        this.workflowMonitoringContext.setErrorPublishEpr(node);
        return this;
    }

    public WorkflowContextHeaderBuilder setNotificationTopic(String node) {
        this.workflowMonitoringContext.setNotificationTopic(node);
        return this;
    }

    public WorkflowContextHeaderBuilder setGridProxy(byte[] gridProxy) {
        if (this.securityContext == null) {
            this.securityContext = SecurityContextDocument.SecurityContext.Factory.newInstance();
        }
        this.securityContext.setGridProxy(gridProxy);
        return this;
    }

    public WorkflowContextHeaderBuilder setGridMyProxyRepository(String myProxyServer, String userName, String password, int lifeTimeInHours) {
        if (this.securityContext == null) {
            this.securityContext = SecurityContextDocument.SecurityContext.Factory.newInstance();
        }
        SecurityContextDocument.SecurityContext.GridMyproxyRepository gridMyproxyRepository = this.securityContext.addNewGridMyproxyRepository();
        gridMyproxyRepository.setMyproxyServer(myProxyServer);
        gridMyproxyRepository.setUsername(userName);
        gridMyproxyRepository.setPassword(password);
        gridMyproxyRepository.setLifeTimeInhours(lifeTimeInHours);
        return this;
    }

    public WorkflowContextHeaderBuilder setSSHAuthentication(String accessKeyId, String secretKeyId) {
        if (this.securityContext == null) {
            this.securityContext = SecurityContextDocument.SecurityContext.Factory.newInstance();
        }
        SecurityContextDocument.SecurityContext.SshAuthentication sshAuthentication = this.securityContext.addNewSshAuthentication();
        sshAuthentication.setAccessKeyId(accessKeyId);
        sshAuthentication.setSecretAccessKey(secretKeyId);
        return this;
    }

    public WorkflowContextHeaderBuilder setCredentialManagementService(String scmUrl, String securitySessionId) {
        if (this.securityContext == null) {
            this.securityContext = SecurityContextDocument.SecurityContext.Factory.newInstance();
        }
        SecurityContextDocument.SecurityContext.CredentialManagementService credentialManagementService = this.securityContext.addNewCredentialManagementService();
        credentialManagementService.setScmsUrl(scmUrl);
        credentialManagementService.setExecutionSessionId(securitySessionId);
        return this;
    }

    public WorkflowContextHeaderBuilder setAmazonWebServices(String accessKeyId, String secretAccesKey) {
        if (this.securityContext == null) {
            this.securityContext = SecurityContextDocument.SecurityContext.Factory.newInstance();
        }
        SecurityContextDocument.SecurityContext.AmazonWebservices amazonWebservices = this.securityContext.addNewAmazonWebservices();
        amazonWebservices.setSecretAccessKey(accessKeyId);
        amazonWebservices.setSecretAccessKey(secretAccesKey);
        return this;
    }

    public WorkflowContextHeaderBuilder addApplicationOutputDataHandling(String outputDir, String outputDataRegistry, boolean dataPersistence) {
        if (this.workflowOutputDataHandling == null) {
            this.workflowOutputDataHandling = WorkflowOutputDataHandlingDocument.WorkflowOutputDataHandling.Factory.newInstance();
        }
        ApplicationOutputDataHandlingDocument.ApplicationOutputDataHandling applicationOutputDataHandling = this.workflowOutputDataHandling.addNewApplicationOutputDataHandling();
        applicationOutputDataHandling.setOutputDataDirectory(outputDir);
        applicationOutputDataHandling.setDataRegistryUrl(outputDataRegistry);
        applicationOutputDataHandling.setDataPersistance(dataPersistence);
        return this;
    }

    public WorkflowContextHeaderBuilder addApplicationSchedulingContext
            (String workflowNodeId, String serviceId, String hostName, boolean wsGramPreffered, String gateKeepersEpr, String jobManager, int cpuCount, int nodeCount, String qName, int maxWalTime) {
        if (this.workflowSchedulingContext == null) {
            this.workflowSchedulingContext = WorkflowSchedulingContextDocument.WorkflowSchedulingContext.Factory.newInstance();
        }
        ApplicationSchedulingContextDocument.ApplicationSchedulingContext applicationSchedulingContext = this.workflowSchedulingContext.addNewApplicationSchedulingContext();
        applicationSchedulingContext.setWorkflowNodeId(workflowNodeId);
        applicationSchedulingContext.setCpuCount(cpuCount);
        applicationSchedulingContext.setGatekeeperEpr(gateKeepersEpr);
        applicationSchedulingContext.setHostName(hostName);
        applicationSchedulingContext.setJobManager(jobManager);
        applicationSchedulingContext.setMaxWallTime(maxWalTime);
        applicationSchedulingContext.setServiceId(serviceId);
        applicationSchedulingContext.setNodeCount(nodeCount);
        applicationSchedulingContext.setQueueName(qName);
        applicationSchedulingContext.setWsgramPreferred(wsGramPreffered);
        return this;
    }
}
