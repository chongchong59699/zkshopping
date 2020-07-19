package com.qf.test;/*
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


import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * AlipayClient工厂，提供执行openapi的接口. 需要从application.properties中读取配置参数
 *
 * @author alipay.demo
 */
@Component
public class AlipayClientFactory implements FactoryBean<AlipayClient>, InitializingBean {
    private AlipayClient alipayClient = null;

    @Autowired
    private Environment env;

    @Override
    public AlipayClient getObject() throws Exception {
        return alipayClient;
    }

    @Override
    public Class<?> getObjectType() {
        return AlipayClient.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() {
        alipayClient = createAlipayClient();
    }

    private AlipayClient createAlipayClient() {
        String gatewayUrl = env.getProperty(Constants.PROP_OPEN_GATEWAY_URL);
        String appId = env.getProperty(Constants.PROP_OPEN_APP_ID);
        String format = env.getProperty(Constants.PROP_OPEN_FORMAT);
        String charset = env.getProperty(Constants.PROP_OPEN_CHARSET);
        String appPrivateKey = env.getProperty(Constants.PROP_OPEN_APP_PRIVATE_KEY);
        String alipayPublicKey = env.getProperty(Constants.PROP_OPEN_ALIPAY_PUBLIC_KEY);
        String signType = env.getProperty(Constants.PROP_OPEN_SIGN_TYPE);
        return new DefaultAlipayClient(gatewayUrl, appId, appPrivateKey, format, charset, alipayPublicKey, signType);
    }
}