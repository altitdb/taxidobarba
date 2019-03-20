package br.com.taxidobarba.mock;

import br.com.taxidobarba.domain.User;

public class UserMock {

    public static User mockUser() {
        User user = new User();
        user.setUsername("taxidobarba");
        user.setPassword("52007496FBC1E6093E711F0EBFD749A7957BDEFE44EE82DA80E2322848514FE3");
        return user;
    }

}
