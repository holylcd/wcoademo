package org.holy.wcoa.manager;

import com.alibaba.fastjson.JSONObject;
import org.holy.wcoa.entity.WCOAEntity;
import org.holy.wcoa.exception.WCOAException;
import org.holy.wcoa.util.WCOAResourceUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;

public class AccessTokenClient {

    public WCOAEntity update(WCOAEntity wcoa) throws WCOAException {
        String url = WCOAResourceUtil.getInstance()
                .getConfigByName("wx.getaccessToken");

        String u = String.format(url, wcoa.getAppID(), wcoa.getAppSecret());
        WebClient client = WebClient.builder()
                .baseUrl(u)
                .defaultHeader(HttpHeaders.CONTENT_TYPE
                        , MediaType.APPLICATION_JSON_VALUE)
                .build();

        WebClient.RequestHeadersUriSpec<?> request = client.get();

        String response = request
                .retrieve().bodyToMono(String.class).block();

        JSONObject result = (JSONObject) JSONObject.parse(response);

        Integer errcode = (Integer) result.get("errcode");

        if(null == errcode){
            String newToken = result.getString("access_token");
            wcoa.setAccessToken(newToken);
            wcoa.setAccessTokenLastUpdateTime(new Date());

            return wcoa;
        }else{
            throw new WCOAException(WCOAException.ACCESS_TOKEN_UPDATE_ERROR);
        }
    }



}
