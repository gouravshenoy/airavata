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
package org.apache.airavata.sharing.registry.db.repositories;

import org.apache.airavata.sharing.registry.db.entities.EntityEntity;
import org.apache.airavata.sharing.registry.db.entities.EntityPK;
import org.apache.airavata.sharing.registry.db.entities.SharingEntity;
import org.apache.airavata.sharing.registry.db.utils.DBConstants;
import org.apache.airavata.sharing.registry.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRepository extends AbstractRepository<Entity, EntityEntity, EntityPK> {
    private final static Logger logger = LoggerFactory.getLogger(EntityRepository.class);

    public EntityRepository() {
        super(Entity.class, EntityEntity.class);
    }

    public List<Entity> getChildEntities(String parentId) throws SharingRegistryException {
        HashMap<String, String> filters = new HashMap<>();
        filters.put(DBConstants.EntityTable.PARENT_ENTITY_ID, parentId);
        return select(filters, 0, -1);
    }

    public List<Entity> searchEntities(String domainId, List<String> groupIds, String entityTypeId, List<SearchCriteria> filters,
                                       int offset, int limit) throws SharingRegistryException {
        String groupIdString = "'";
        for(String groupId : groupIds)
            groupIdString += groupId + "','";
        groupIdString = groupIdString.substring(0, groupIdString.length()-2);

        String query = "SELECT DISTINCT E FROM " + EntityEntity.class.getSimpleName() + " E, " + SharingEntity.class.getSimpleName() + " S WHERE " +
                "E." + DBConstants.EntityTable.ENTITY_ID + " = S." + DBConstants.SharingTable.ENTITY_ID + " AND " +
                "E." + DBConstants.EntityTable.DOMAIN_ID + " = S." + DBConstants.SharingTable.DOMAIN_ID + " AND " +
                "E." + DBConstants.EntityTable.DOMAIN_ID + " = '" + domainId + "' AND " +
                "S." + DBConstants.SharingTable.GROUP_ID + " IN(" + groupIdString + ") AND E." + DBConstants.EntityTable.ENTITY_TYPE_ID + "='" +
                entityTypeId + "' AND ";

        for(SearchCriteria searchCriteria : filters){
            if(searchCriteria.getSearchField().equals(EntitySearchField.NAME)){
                query += "E." + DBConstants.EntityTable.NAME + " LIKE '%" + searchCriteria.getValue() + "%' AND ";
            }else if(searchCriteria.getSearchField().equals(EntitySearchField.DESCRIPTION)){
                query += "E." + DBConstants.EntityTable.DESCRIPTION + " LIKE '%" + searchCriteria.getValue() + "%' AND ";
            }else if(searchCriteria.getSearchField().equals(EntitySearchField.PERMISSION_TYPE_ID)){
                query += "S." + DBConstants.SharingTable.PERMISSION_TYPE_ID + " = '" + searchCriteria.getValue() + "' AND ";
            }else if(searchCriteria.getSearchField().equals(EntitySearchField.FULL_TEXT)){
                //FULL TEXT Search with Query Expansion
                String queryTerms = "";
                for(String word : searchCriteria.getValue().trim().replaceAll(" +", " ").split(" ")){
                    queryTerms += queryTerms + " +" + word;
                }
                queryTerms = queryTerms.trim();
                query += "MATCH(E." + DBConstants.EntityTable.FULL_TEXT + ") AGAINST ('" + queryTerms
                        + "' IN BOOLEAN MODE WITH QUERY EXPANSION) AND ";
            }else if(searchCriteria.getSearchField().equals(EntitySearchField.PARRENT_ENTITY_ID)){
                query += "E." + DBConstants.EntityTable.PARENT_ENTITY_ID + " = '" + searchCriteria.getValue() + "' AND ";
            }else if(searchCriteria.getSearchField().equals(EntitySearchField.CREATED_TIME)){
                if(searchCriteria.getSearchCondition().equals(SearchCondition.GTE)){
                    query += "E." + DBConstants.EntityTable.CREATED_TIME + " >= " + Integer.parseInt(searchCriteria.getValue().trim()) + " AND ";
                }else{
                    query += "E." + DBConstants.EntityTable.CREATED_TIME + " <= " + Integer.parseInt(searchCriteria.getValue().trim()) + " AND ";
                }
            }else if(searchCriteria.getSearchField().equals(EntitySearchField.UPDATED_TIME)){
                if(searchCriteria.getSearchCondition().equals(SearchCondition.GTE)){
                    query += "E." + DBConstants.EntityTable.UPDATED_TIME + " >= " + Integer.parseInt(searchCriteria.getValue().trim()) + " AND ";
                }else{
                    query += "E." + DBConstants.EntityTable.UPDATED_TIME + " <= " + Integer.parseInt(searchCriteria.getValue().trim()) + " AND ";
                }
            }
        }

        query = query.substring(0, query.length() - 5);
        return select(query, offset, limit);
    }

    public String getSelectQuery(Map<String, String> filters){
        String query = "SELECT p from " + EntityEntity.class.getSimpleName() + " as p";
        if(filters != null && filters.size() != 0){
            query += " WHERE ";
            for(String k : filters.keySet()){
                query += "p." + k + " = '" + filters.get(k) + "' AND ";
            }
            query = query.substring(0, query.length()-5);
        }

        query += " ORDER BY p."+DBConstants.EntityTable.ORIGINAL_ENTITY_CREATION_TIME+" DESC";

        return query;
    }
}