package org.holy.wcoa.exception;

public class WCOAException extends Exception {

    private static final long serialVersionUID = 6660648838533929994L;

    public final static int OK = 0;
    public final static int ACCESS_TOKEN_UPDATE_ERROR = -40001;

    private int code;

    public WCOAException(int code) {
        super(getMessage(code));
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    private static String getMessage(int code) {
        switch (code) {
            case ACCESS_TOKEN_UPDATE_ERROR:
                return "access token 更新失败";
            default:
                return null;
        }
    }

}
