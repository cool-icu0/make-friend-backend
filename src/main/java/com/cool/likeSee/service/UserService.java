package com.cool.likeSee.service;

import com.cool.likeSee.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户服务
 *
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @param planetCode 星球编号
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     *  标签搜索
     * @param list
     * @return
     */
    List<User>  searchUsersByTags(List<String> list);

    /**
     *  用户信息修改
     * @param user
     * @return
     */
    int updateUser(User user,User logininUser);

    /**
     *  获取当前用户信息
     * @param request
     * @return
     */
    User getLogininUser(HttpServletRequest request);

    /**
     * 是否为管理员
     *
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 是否为管理员
     *
     * @param logininUser
     * @return
     */
    boolean isAdmin(User logininUser);
    /**
     * 获取最匹配的用户
     * @param num
     * @param user
     * @return
     **/
    List<User> matchUsers(long num, User user);
}

