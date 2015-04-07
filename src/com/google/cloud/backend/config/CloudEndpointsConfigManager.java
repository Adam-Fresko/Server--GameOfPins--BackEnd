/*
 * Copyright (c) 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.backend.config;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.cloud.backend.spi.EndpointV1;

import java.util.List;

/**
 * Class that manages the Cloud Endpoints configuration stored in App Engine
 * Datastore. By using the special kind GoogleCloudEndpointConfiguration, it can
 * control Endpoints config parameters incl. audiences and clientIds without
 * redeploying the app. Developer can control these parameters from the Admin
 * UI.
 */
public class CloudEndpointsConfigManager {
  private final DatastoreService datastoreService;
  private final MemcacheService memcacheService;

  /**
   * Kind name for storing endpoint configuration.
   */
  public static final String ENDPOINT_CONFIGURATION_KIND = "GoogleCloudEndpointConfiguration";

  private static final String AUDIENCES = "audiences";
  private static final String CLIENT_IDS = "clientIds";

  public CloudEndpointsConfigManager() {
    this(DatastoreServiceFactory.getDatastoreService(),
        MemcacheServiceFactory.getMemcacheService());
  }

  public CloudEndpointsConfigManager(DatastoreService datastoreService, 
      MemcacheService memcacheService) {
    this.datastoreService = datastoreService;
    this.memcacheService = memcacheService;
  }

  /**
   * Configures the Cloud Endpoints exposed from this backend. Specifically, it
   * configures {@link EndpointV1} endpoints. This call overwrites any
   * previously specified settings.
   * 
   * @param clientIds
   *          list of clientIds that will be allowed to make authenticated calls
   *          to this backend.
   * @param audiences
   *          list of audiences that will be allowed to make authenticated calls
   *          to this backend.
   */
  public void setAuthenticationInfo(Class<?> endpointClass,
      List<String> clientIds,
      List<String> audiences) {
    Entity config = getEndpointEntity(endpointClass);
    
    
    //DZIAŁA! wersja pokazowa 243586188654-rtnld0c2b6gbbun3qjoh1ftmfvddbd33.apps.googleusercontent.com
     
     
    clientIds.clear();
     
     
   clientIds.add("243586188654-rtnld0c2b6gbbun3qjoh1ftmfvddbd33.apps.googleusercontent.com");//  // com.deadswine.game.of.pins.game //TODO DZIAŁA - ECLIPSE PC - WERSJA POKAZOWA
      
 clientIds.add("243586188654-bmtjoilqf8758rf22kdn05g16aaungs6.apps.googleusercontent.com"); // com.deadswine.game.of.pins.admin   //TODO   DZIAŁA!! AS _ MAC _ ANDY!

 clientIds.add("243586188654-t3a8pff62bcuncbddekfbqj2qqvi2ol0.apps.googleusercontent.com"); // CHROMNE????
      
     
//"crx_key": "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjzQPSfGVkqzNxQvjyd28ZNYIFfw66rJUiqyEqb3kLQJ04S7Iqo21M+7+u+mxXHNCkXh5mhdFuY4gSbe3fgNC89NqkW5inmQLbCtoIMtcFvVHcu0N7BNU+spKK514Ad/EiG395KvTpXXLdFN6scNZQz/TjOB8cNk0UauQMZvJm7KCyszllYsfhtbW//IHAJjs3UMDso5mOB4bvursXzso3XT7lWB77ck+XafDEVki3o/P2uUQkLnA1zjG6d3+GTDx+HJKj5+uvadTJqvWfQ/aL5cvlmxBNjmaWJWzKnyw9k2F531O95hTSkyGtMo499TvhdQ0TcDQB+q1fwUbcKyRdwIDAQAB"
     
     
     
    
     
    
    config.setProperty(CLIENT_IDS, clientIds);
    config.setProperty(AUDIENCES, audiences);
    datastoreService.put(config);

    // Google Cloud Endpoints infrastructure caches the configuration in Memcache.
    // In order for the changes to be applied without restart/redeployment
    // they need to be updated not only in Datastore, but also in Memcache.
    memcacheService.put(ENDPOINT_CONFIGURATION_KIND + "." + endpointClass.getName(), config);
  }

  private Entity getEndpointEntity(Class<?> endpointClass) {
    Key key = KeyFactory.createKey(ENDPOINT_CONFIGURATION_KIND,
        endpointClass.getSimpleName());
    try {
      return datastoreService.get(key);
    } catch (EntityNotFoundException e) {
      return new Entity(key);
    }
  }
}