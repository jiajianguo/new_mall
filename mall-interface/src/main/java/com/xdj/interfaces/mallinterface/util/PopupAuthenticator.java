package com.xdj.interfaces.mallinterface.util;

import javax.mail.Authenticator;

public class PopupAuthenticator extends Authenticator {
    private String username;
    private String password;

    public PopupAuthenticator(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

}
