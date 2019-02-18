package org.holy.wcoa.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公众号
 * @author holy
 */
@Data
public class WCOAEntity implements Serializable {

    private Integer id;

    private String name;

    private String code;

    private String appID;

    private String appSecret;

    private String accessToken;

    private Date accessTokenLastUpdateTime;

}
