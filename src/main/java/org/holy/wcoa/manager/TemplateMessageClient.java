package org.holy.wcoa.manager;

import com.alibaba.fastjson.JSONObject;
import org.holy.wcoa.entity.WCOAEntity;
import org.holy.wcoa.util.WCOAResourceUtil;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * 模板消息相关 Client
 *
 * @author holy
 *
 */
public class TemplateMessageClient {

    public TemplateMessageClient() {}

    /**
     * 发送模板消息
     *
     */
    public boolean sendTemplateMessage(WCOAEntity wcoaEntity, JSONObject paramJSON) {
        Boolean flag = false;

        String url = WCOAResourceUtil.getInstance()
                .getConfigByName("wx.sendTemplateMessage");

        String url1 = String.format(url, wcoaEntity.getAccessToken());

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("name1","value1");
        formData.add("name2","value2");
        Mono<String> resp = WebClient.create().post()
                .uri("http://www.w3school.com.cn/test/demo_form.asp")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(paramJSON), JSONObject.class)
                .retrieve().bodyToMono(String.class);

        JSONObject result = (JSONObject) JSONObject.parse(resp.block());

        if(result.getInteger("errcode").equals(0)){
            flag = true;
        }else{

        }

        return flag;
    }
}
