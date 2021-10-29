package com.wwj.mycloud.command;

import com.alibaba.cola.dto.Response;
import com.wwj.mycloud.convertor.UserProfileConvertor;
import com.wwj.mycloud.domain.user.UserProfile;
import com.wwj.mycloud.dto.UserProfileUpdateCmd;
import com.wwj.mycloud.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileUpdateCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}