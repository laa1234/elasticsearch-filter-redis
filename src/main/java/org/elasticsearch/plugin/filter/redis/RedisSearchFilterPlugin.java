package org.elasticsearch.plugin.filter.redis;
/**
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

import org.elasticsearch.common.collect.ImmutableList;
import org.elasticsearch.common.inject.Module;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.RedisFilterParser;
import org.elasticsearch.indices.query.IndicesQueriesModule;
import org.elasticsearch.plugins.AbstractPlugin;

import java.util.Collection;

/**
 */
public class RedisSearchFilterPlugin extends AbstractPlugin {

    @Override
    public String name() {
        return "redis-filter";
    }

    @Override
    public String description() {
        return "";
    }
    Settings settings;
    @Override
    public Collection<Module> modules(Settings settings) {
        this.settings=settings;
        return ImmutableList.of();
    }

    public void onModule(Module module) {
        if(module instanceof IndicesQueriesModule){
            RedisFilterParser parser=new RedisFilterParser(this.settings);
            ((IndicesQueriesModule) module).addFilter(parser);
        }
    }
}
