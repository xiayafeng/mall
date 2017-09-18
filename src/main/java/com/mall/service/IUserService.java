package com.mall.service;

import com.mall.common.ServerResponse;
import com.mall.pojo.User;


/**
 * Created by peter on 17/8/6.
 */
public interface IUserService {

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> registerUser(User user);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse<String> getForgetQuestion(String username);

    ServerResponse<String> checkAnswer(String username, String question, String answer);

    ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken);

    ServerResponse<String> restPassword(User user, String passwordOld, String passwordNew);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);

    ServerResponse checkAdminRole(User user);

}

