package org.holy.wcoa.manager;

import org.holy.wcoa.entity.WCOAEntity;
import org.holy.wcoa.exception.WCOAException;
import org.junit.Test;

public class AccessTokenClientTest {

    @Test
    public void AccessTokenClientTest(){
        WCOAEntity w = new WCOAEntity();
        w.setAppID("xxx");
        w.setAppSecret("xxx");
        try {
            new AccessTokenClient().update(w);
        } catch (WCOAException e) {
            e.printStackTrace();
        }
    }

}
