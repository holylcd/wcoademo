package org.holy.wcoa.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 微信接口资源工具类
 * <br>
 * @author holy
 */
public class WCOAResourceUtil {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static ResourceBundle BUNDLE = ResourceBundle
            .getBundle("wechat-official-accounts", Locale.CHINA);

    private WCOAResourceUtil() {}

    /**
     * 实例化（单例）
     * <p>
     * @return ResourceFactory
     */
    public static WCOAResourceUtil getInstance() {
        return ResourceUtilHolder.resourceFactory;
    }

    private static class ResourceUtilHolder {
        private static final WCOAResourceUtil resourceFactory = new WCOAResourceUtil();
    }

    /**
     * 获取参数
     * <p>
     * @param key			参数名称
     * @return 				参数名称对应值
     */
    public String getConfigByName(String key) {
        String value = null;
        if(null == key){
            return value;
        }
        try {
            value = new String(BUNDLE.getString(key)
                    .getBytes("iso8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return value;
    }
}
