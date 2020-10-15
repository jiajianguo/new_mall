package com.xdj.interfaces.mallinterface.config;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

    @Configuration
    public class PaypalConfig {

        /*@Value("${paypal.client.app}")
        private String clientId;
        @Value("${paypal.client.secret}")
        private String clientSecret;
        @Value("${paypal.mode}")
        private String mode;*/


        private String clientId="AdzB8eyuCmutAI9vFz5oJGEYKJyWmwFJ8rvrhpEtwf2P2uFO4TqqjoA2ryty_fFJguaFXa4vN6z65u-9";
        private String clientSecret="EN0FUAJ-OfVV4Nn-STSTPzOJBgLBueTV-vcx-hCziW09Yb3BGZYxylPltaEK3upNTsuvt1coCeGL_i4x";
        private String mode="sandbox";

        @Bean
        public Map<String, String> paypalSdkConfig(){
            Map<String, String> sdkConfig = new HashMap<>();
            sdkConfig.put("mode", mode);
            return sdkConfig;
        }

        @Bean
        public OAuthTokenCredential authTokenCredential(){
            return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
        }

        @Bean
        public APIContext apiContext() throws PayPalRESTException {
            APIContext apiContext = new APIContext(authTokenCredential().getAccessToken());
            apiContext.setConfigurationMap(paypalSdkConfig());
            return apiContext;
        }
    }


