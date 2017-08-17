package com.experience.totvs.easyfashion_v1.domain.user;

import org.json.JSONObject;

public class UserFactory {

    public User makeFromJsonObject(String jsonObjectString) {
        User user = new User();

        try {
            JSONObject jsonParsed = new JSONObject(jsonObjectString);
            user
                .setId(jsonParsed.getInt("__id"))
                .setName(jsonParsed.getString("name"))
                .setAge(jsonParsed.getInt("age"))
                .setGender(jsonParsed.getString("gender"))
                .setStyle(jsonParsed.getString("style"));
        } catch(Exception e) {
            e.printStackTrace();
        }

        return user;
    }

}
