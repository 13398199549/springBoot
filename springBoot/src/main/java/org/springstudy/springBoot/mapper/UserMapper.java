package org.springstudy.springBoot.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springstudy.springBoot.beans.UserInfo;

public interface UserMapper {

	@Insert("insert into t_user (user_name,password,login_name,gender) values (#{user.userName},#{user.password},#{user.loginName},#{user.gender})")
	public int saveUserInfo(@Param("user")UserInfo user);
	
	@UpdateProvider(type=UserSQLProvider.class,method="updateUserInfo")
	public int updateUserInfo(@Param("user")UserInfo user);
	
	@Delete("delete from t_user where id = #{id}")
	public int deleteUserInfoById(Long id);
	
	@ResultType(UserInfo.class)
	@Select("select id as id ,user_name as userName,password as password,login_name as loginName,gender as gender from t_user where id = #{id}")
	public UserInfo getUserInfobyId(Long id);
}
