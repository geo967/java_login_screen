package com.example.app1;

import java.util.HashMap;

public class Database {

    HashMap<String,String> loginDetails= new HashMap<String,String>() {{
        put("geo", "1");
        put("gopi", "2");
    }};



    public HashMap<String, String> getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(String userName,String password) {

        loginDetails.put(userName,password);
    }
}
