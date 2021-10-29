package com.wwj.mycloud.domain;

import com.wwj.mycloud.domain.user.UserProfile;

public class DomainFactory {

    public static UserProfile getUserProfile(){
        return new UserProfile();
    }

}
