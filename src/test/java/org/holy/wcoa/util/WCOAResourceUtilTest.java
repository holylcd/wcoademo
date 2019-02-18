package org.holy.wcoa.util;

import org.junit.Test;

public class WCOAResourceUtilTest {

    @Test
    public void contextLoads() {

        String s = WCOAResourceUtil.getInstance().getConfigByName("wx.getaccessToken");
        System.out.println(s);
    }



}
