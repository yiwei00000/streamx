/*
 * Copyright (c) 2019 The StreamX Project
 * <p>
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.streamxhub.streamx.flink.repl.shims;


import org.apache.commons.cli.CommandLine;
import org.apache.flink.client.cli.CliFrontend;

import java.util.Properties;

/**
 * This is abstract class for anything that is api incompatible between different flink versions. It will
 * load the correct version of FlinkShims based on the version of flink.
 *
 * @author benjobs
 */
public class FlinkShims {

    protected Properties properties;

    public FlinkShims(Properties properties) {
        this.properties = properties;
    }

    public Object getCustomCli(Object cliFrontend, Object commandLine) {
        return ((CliFrontend) cliFrontend).validateAndGetActiveCommandLine((CommandLine) commandLine);
    }

}
