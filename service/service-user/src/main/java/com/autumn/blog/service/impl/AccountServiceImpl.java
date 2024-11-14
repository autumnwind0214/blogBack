package com.autumn.blog.service.impl;

import com.autumn.blog.common.exception.AutumnException;
import com.autumn.blog.common.result.ResultCodeEnum;
import com.autumn.blog.common.util.MD5Utils;
import com.autumn.blog.common.util.UuidUtils;
import com.autumn.blog.mapper.AccountMapper;
import com.autumn.blog.model.entity.Account;
import com.autumn.blog.model.form.LoginForm;
import com.autumn.blog.model.form.RegisterForm;
import com.autumn.blog.model.vo.UserVo;
import com.autumn.blog.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author autumn
 * @description
 * @date 2024年11月11日
 * @version: 1.0
 */
@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public UserVo login(LoginForm loginForm) {
        // 根据用户名查找账号信息
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getUsername, loginForm.getUsername());
        Account account = accountMapper.selectOne(queryWrapper);
        if (account == null) {
            throw new AutumnException(ResultCodeEnum.ACCOUNT_NOT_EXIST);
        }
        String hashPassword = MD5Utils.hashPassword(loginForm.getPassword(), account.getSalt());
        if (!hashPassword.equals(account.getPassword())) {
            throw new AutumnException(ResultCodeEnum.ACCOUNT_ERROR);
        }
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(account, vo);
        return vo;
    }

    @Override
    public Boolean register(RegisterForm registerForm) {
        // 校验该用户是否存在
        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Account::getUsername, registerForm.getUsername());
        Account account = accountMapper.selectOne(queryWrapper);
        if (account != null) {
            throw new AutumnException(ResultCodeEnum.ACCOUNT_EXIST);
        }
        account = new Account();
        account.setUsername(registerForm.getUsername());
        String salt = UuidUtils.getUUID();
        account.setSalt(salt);
        // 密码加密
        account.setPassword(MD5Utils.hashPassword(registerForm.getPassword(), salt));

        return accountMapper.insert(account) > 1;
    }
}
