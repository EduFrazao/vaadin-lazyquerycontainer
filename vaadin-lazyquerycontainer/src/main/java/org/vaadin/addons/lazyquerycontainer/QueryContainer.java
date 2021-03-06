/**
 * Copyright 2010 Tommi S.E. Laukkanen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.addons.lazyquerycontainer;

/**
 * QueryContainer enables loading items in non lazy manner with same query backend as LCQ.
 *
 * @param <T> Entity class.
 * @author Tommi Laukkanen
 */
public final class QueryContainer<T> extends LazyQueryContainer {
    /**
     * Java serialization version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor which configures query definition for accessing JPA entities.
     *
     * @param queryFactory                   The query factory.
     * @param idPropertyId                   The ID of the ID property or null if item index is used as ID.
     * @param maximumQueryResultSize         The maximum size of the query result.
     * @param compositeItems                 True f items are wrapped to CompositeItems.
     */
    public QueryContainer(final QueryFactory queryFactory,
                          final Object idPropertyId,
                          final int maximumQueryResultSize,
                          final boolean compositeItems) {
        super(new LazyQueryDefinition(compositeItems, maximumQueryResultSize, idPropertyId), queryFactory);
        getQueryView().getQueryDefinition().setMaxQuerySize(maximumQueryResultSize);
    }

}
