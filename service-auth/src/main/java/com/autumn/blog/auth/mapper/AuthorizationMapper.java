package com.autumn.blog.auth.mapper;

import com.autumn.blog.model.po.auth.Authorization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author autumn
 * @date 2024年12月21日
 * @version: 1.0
 */
@Mapper
public interface AuthorizationMapper extends BaseMapper<Authorization> {

    @Select("select a from authorization a where a.state = #{token}" +
            " or a.authorizationCodeValue = #{token}" +
            " or a.accessTokenValue = #{token}" +
            " or a.refreshTokenValue = #{token}" +
            " or a.oidcIdTokenValue = #{token}" +
            " or a.userCodeValue = #{token}" +
            " or a.deviceCodeValue = #{token}"
    )
    Authorization findByStateOrAuthorizationCodeValueOrAccessTokenValueOrRefreshTokenValueOrOidcIdTokenValueOrUserCodeValueOrDeviceCodeValue(@Param("token") String token);
}
