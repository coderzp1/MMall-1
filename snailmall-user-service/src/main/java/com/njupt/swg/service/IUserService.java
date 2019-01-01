package com.njupt.swg.service;

import com.njupt.swg.common.resp.ServerResponse;
import com.njupt.swg.entity.User;
import com.njupt.swg.vo.UserResVO;

/**
 * @Author swg.
 * @Date 2018/12/31 21:07
 * @CONTACT 317758022@qq.com
 * @DESC
 */
public interface IUserService {
    /** 用户登陆 **/
    ServerResponse<UserResVO> login(String username,String password);

    /** 用户注册 **/
    ServerResponse register(User user);

    /** 判断用户名和邮箱是否重复 **/
    ServerResponse checkValid(String str, String type);
}
