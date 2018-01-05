package org.springstudy.springBoot.mapper;

import java.util.Map;

import org.springframework.util.StringUtils;
import org.springstudy.springBoot.beans.UserInfo;
import org.springstudy.springBoot.utils.TextUtils;


public class UserSQLProvider {

	
	public String updateUserInfo(Map<String, Object> param) {
		System.out.println("UserSQLProvider-----updateUserInfo: " + param);
		UserInfo user = (UserInfo) param.get("user");
		StringBuilder sb = new StringBuilder("update t_user set ");
		if(StringUtils.hasLength(user.getUserName())) {
			sb.append("user_name = '"+user.getUserName()+"',");
		}
		if(StringUtils.hasLength(user.getLoginName())) {
			sb.append("login_name = '"+user.getLoginName()+"',");
		}
		if(!TextUtils.isEmpty(user.getGender())) {
			sb.append("gender = '"+user.getGender()+"',");
		}
		if(StringUtils.hasLength(user.getPassword())) {
			sb.append("password = '"+user.getPassword()+"',");
		}
		int lastIndex = sb.lastIndexOf(",");
		sb.replace(lastIndex, sb.length(), " ");
		sb.append("where id = '"+user.getId()+"'");
		return sb.toString();
	}
	
	
}
