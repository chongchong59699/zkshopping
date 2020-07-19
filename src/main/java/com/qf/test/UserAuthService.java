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


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 认证授权获取用户信息
 *
 * @author alipay.demo
 */
@Service
public class UserAuthService {
    @Autowired
    private AlipayClient alipayClient;

    public UserInfo authUser(String authCode) throws Exception {
        if (isBlank(authCode)) {
            throw new Exception("授权编码不能为空");
        }

        // 通过授权码换取access token
        AlipaySystemOauthTokenResponse authTokenResp = getAccessToken(authCode);
        if (!authTokenResp.isSuccess()) {
            String msg = "换取 AuthToken 失败！错误编码：" + authTokenResp.getCode() + ", 错误信息：" + authTokenResp.getMsg();
            throw new Exception(msg);
        }

        // 通过accessToken获取用户信息
        AlipayUserInfoShareResponse userInfoResp = getUserInfoFromAlipay(authTokenResp.getAccessToken());
        if (!userInfoResp.isSuccess()) {
            String msg = "获取用户信息失败！错误编码：" + authTokenResp.getCode() + ", 错误信息：" + authTokenResp.getMsg();
            throw new Exception(msg);
        }

        return convertUserInfo(userInfoResp, authTokenResp);
    }

    private AlipaySystemOauthTokenResponse getAccessToken(String authCode) throws AlipayApiException {
        AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
        request.setGrantType("authorization_code");
        request.setCode(authCode);
        return alipayClient.execute(request);
    }

    private AlipayUserInfoShareResponse getUserInfoFromAlipay(String accessToken) throws AlipayApiException {
        AlipayUserInfoShareRequest request = new AlipayUserInfoShareRequest();
        return alipayClient.execute(request, accessToken);
    }

    private UserInfo convertUserInfo(AlipayUserInfoShareResponse userInfoResp, AlipaySystemOauthTokenResponse authTokenResp) {
        String nickName = userInfoResp.getNickName();
        String avatar = userInfoResp.getAvatar();

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userInfoResp.getUserId());
        userInfo.setNickName(isBlank(nickName) ? "" : nickName);
        userInfo.setAvatar(isBlank(avatar) ? "" : avatar);
        userInfo.setAccessToken(authTokenResp.getAccessToken());
        userInfo.setRefreshToken(authTokenResp.getRefreshToken());
        return userInfo;
    }

    private static boolean isBlank(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}