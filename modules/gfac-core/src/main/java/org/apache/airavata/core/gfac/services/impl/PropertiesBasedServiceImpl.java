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

package org.apache.airavata.core.gfac.services.impl;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.airavata.core.gfac.api.Registry;
import org.apache.airavata.core.gfac.api.impl.JCRRegistry;
import org.apache.airavata.core.gfac.context.InvocationContext;
import org.apache.airavata.core.gfac.exception.GfacException;
import org.apache.airavata.core.gfac.exception.GfacException.FaultCode;
import org.apache.airavata.core.gfac.extension.DataServiceChain;
import org.apache.airavata.core.gfac.extension.ExitableChain;
import org.apache.airavata.core.gfac.extension.PostExecuteChain;
import org.apache.airavata.core.gfac.extension.PreExecuteChain;
import org.apache.airavata.core.gfac.scheduler.Scheduler;
import org.apache.airavata.core.gfac.utils.LogUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This generic service implementation will load Registry service and Data
 * Catalog from property file. It selects provider and execute it base on
 * execution context.
 * 
 */
public class PropertiesBasedServiceImpl extends AbstractSimpleService {

    private static Log log = LogFactory.getLog(PropertiesBasedServiceImpl.class);

    /*
     * default properties file location
     */
    private static final String FILENAME = "service.properties";

    /*
     * Scheduler and chains
     */
    public static final String SCHEDULER_CLASS = "scheduler.class";
    public static final String DATA_CHAIN_CLASS = "datachain.classes";
    public static final String PRE_CHAIN_CLASS = "prechain.classes";
    public static final String POST_CHAIN_CLASS = "postchain.classes";

    /*
     * JCR properties
     */
    public static final String JCR_CLASS = "jcr.class";
    public static final String JCR_USER = "jcr.user";
    public static final String JCR_PASS = "jcr.pass";

    private Properties properties;
    private Scheduler scheduler;
    private PreExecuteChain[] preChain;
    private PostExecuteChain[] postChain;
    private DataServiceChain[] dataChain;

    private Registry registryService;

    /**
     * Default constructor
     */
    public PropertiesBasedServiceImpl() {
        log.debug("Create Default PropertiesBasedServiceImpl");
    }

    /**
     * Constructor with passing properties
     * 
     * @param prop
     */
    public PropertiesBasedServiceImpl(Properties prop) {
        this.properties = prop;
        log.debug("Create PropertiesBasedServiceImpl with Properties");
        LogUtils.displayProperties(log, prop);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.airavata.core.gfac.services.GenericService#init(org.apache
     * .airavata.core.gfac.context. InvocationContext)
     */
    public void init() throws GfacException {
        try {

            /*
             * Load properties only it is not loaded
             */
            if (this.properties == null) {
                log.info("try to load default properties: " + FILENAME);
                URL url = ClassLoader.getSystemResource(FILENAME);

                this.properties = new Properties();
                this.properties.load(url.openStream());

                log.info("Properties loaded");
                LogUtils.displayProperties(log, properties);
            }
        } catch (IOException e) {
            throw new GfacException("Error initialize the PropertiesBasedServiceImpl", e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.airavata.core.gfac.services.GenericService#dispose(org.apache
     * .airavata.core.gfac.context. InvocationContext)
     */
    public void dispose() throws GfacException {
    }

    @Override
    public void preProcess(InvocationContext context) throws GfacException {
        if (context.getExecutionContext() != null && context.getExecutionContext().getRegistryService() != null) {

            if (this.registryService == null) {
                log.info("try to create default registry service (JCR Implementation)");
                                
                // JCR
                String jcrClass = loadFromProperty(JCR_CLASS, true);
                String userName = loadFromProperty(JCR_USER, false);
                String password = loadFromProperty(JCR_PASS, false);

                /*
                 * Remove unnecessary key
                 */
                Map<String, String> map = new HashMap<String, String>((Map) this.properties);
                map.remove(JCR_CLASS);
                map.remove(SCHEDULER_CLASS);
                map.remove(DATA_CHAIN_CLASS);
                map.remove(PRE_CHAIN_CLASS);
                map.remove(POST_CHAIN_CLASS);
                map.remove(JCR_USER);
                map.remove(JCR_PASS);
                if (map.size() == 0)
                    map = null;

                this.registryService = new JCRRegistry(jcrClass, userName, password, map);
                
                log.info("Default registry service is created");
            }

            /*
             * If there is no specific registry service, use the default one. 
             */
            context.getExecutionContext().setRegistryService(this.registryService);
        }
    }

    @Override
    public void postProcess(InvocationContext context) throws GfacException {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.airavata.core.gfac.services.GenericService#getScheduler(org
     * .apache.airavata.core.gfac.context .InvocationContext)
     */
    public Scheduler getScheduler(InvocationContext context) throws GfacException {
        String className = null;
        if (this.scheduler == null) {
            log.info("try to create scheduler");
            
            /*
             * get class names
             */
            className = loadFromProperty(SCHEDULER_CLASS, true);

            /*
             * init instance of that class
             */
            try {

                Class spiClass = Class.forName(className).asSubclass(Scheduler.class);

                this.scheduler = (Scheduler) spiClass.newInstance();

                log.info("Scheduler:" + className + " is loaded");

            } catch (ClassNotFoundException ex) {
                throw new GfacException("Scheduler " + className + " not found", ex);
            } catch (Exception ex) {
                throw new GfacException("Scheduler " + className + " could not be instantiated: " + ex, ex);
            }
        }
        return this.scheduler;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.airavata.core.gfac.services.GenericService#getPreExecutionSteps
     * (org.ogce.gfac .context.InvocationContext)
     */
    public PreExecuteChain[] getPreExecutionSteps(InvocationContext context) throws GfacException {
        if (this.preChain == null) {
            log.info("try to load pre-execution chain");
            this.preChain = loadClassFromProperties(PRE_CHAIN_CLASS, PreExecuteChain.class);
        }
        return preChain;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.airavata.core.gfac.services.GenericService#getPostExecuteSteps
     * (org.ogce.gfac .context.InvocationContext)
     */
    public PostExecuteChain[] getPostExecuteSteps(InvocationContext context) throws GfacException {
        if (this.postChain == null) {
            log.info("try to load post-execution chain");
            this.postChain = loadClassFromProperties(POST_CHAIN_CLASS, PostExecuteChain.class);
        }
        return postChain;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.apache.airavata.core.gfac.services.impl.OGCEGenericService#getDataChains
     * (org.apache.airavata.core.gfac.context .InvocationContext)
     */
    public DataServiceChain[] getDataChains(InvocationContext context) throws GfacException {
        if (this.dataChain == null) {
            log.info("try to load data chain");
            this.dataChain = loadClassFromProperties(DATA_CHAIN_CLASS, DataServiceChain.class);
        }
        return dataChain;
    }

    /**
     * 
     * @param propertyName
     * @param required
     * @return
     * @throws GfacException
     */
    private String loadFromProperty(String propertyName, boolean required) throws GfacException {
        String propValue = this.properties.getProperty(propertyName);
        if (propValue == null) {
            if (required)
                throw new GfacException("Property \"" + propertyName + "\" is not found", FaultCode.InvalidConfig);
            return null;
        }
        return propValue;
    }

    /**
	 * 
	 */
    @SuppressWarnings("unchecked")
    private <T> T[] loadClassFromProperties(String propertyName, Class<? extends ExitableChain> type)
            throws GfacException {

        // property is not set
        String propValue = loadFromProperty(propertyName, false);
        if (propValue == null) {
            return null;
        }

        /*
         * get class names
         */
        String classNames[] = this.properties.getProperty(propertyName).split(",");

        /*
         * init instance of that class
         */
        T[] chain = (T[]) Array.newInstance(type, classNames.length);
        for (int i = 0; i < classNames.length; i++) {

            String className = classNames[i].trim();

            try {
                Class<? extends ExitableChain> spiClass;
                spiClass = Class.forName(className).asSubclass(ExitableChain.class);
                chain[i] = (T) spiClass.newInstance();

                log.info(type.getName() + " : " + className + " is loaded");

            } catch (ClassNotFoundException ex) {
                throw new GfacException("Cannot find the class: " + className, ex);
            } catch (IllegalAccessException ex) {
                throw new GfacException("Cannot access the class: " + className, ex);
            } catch (InstantiationException ex) {
                throw new GfacException("Cannot init the class: " + className, ex);
            }
        }
        return chain;
    }
}
