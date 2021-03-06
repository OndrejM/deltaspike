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
package org.apache.deltaspike.data.impl.meta.extractor;

import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.impl.meta.RepositoryEntity;
import org.apache.deltaspike.data.impl.util.EntityUtils;

public class AnnotationMetadataExtractor implements MetadataExtractor
{

    @Override
    public RepositoryEntity extract(Class<?> repoClass)
    {
        Repository repo = repoClass.getAnnotation(Repository.class);
        Class<?> repoEntity = repo.forEntity();
        boolean isEntityClass = !Object.class.equals(repoEntity) && EntityUtils.isEntityClass(repoEntity);
        if (isEntityClass)
        {
            return new RepositoryEntity(repoEntity, EntityUtils.primaryKeyClass(repoEntity));
        }
        return null;
    }

}
