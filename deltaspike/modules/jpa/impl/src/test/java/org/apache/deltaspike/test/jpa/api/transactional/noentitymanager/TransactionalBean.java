/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.deltaspike.test.jpa.api.transactional.noentitymanager;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.apache.deltaspike.test.jpa.api.shared.Second;

@ApplicationScoped
public class TransactionalBean
{

    /**
     * This methods requests a transaction for the EntityManager qualified with {@link Second} although there is no
     * producer for such an {@link EntityManager}.
     */
    @Transactional(qualifier = Second.class)
    public void executeInTransaction()
    {
        // no need to do anything
    }

}
