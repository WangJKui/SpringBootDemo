package com.wjk.boot.springboot.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroRealm extends AuthorizingRealm{

	private Logger logger =  LoggerFactory.getLogger(this.getClass());

	/**
	 * 授权查询, 进行鉴权但缓存中无用户的授权信息时调用
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		List<String> r_l=userService.findAllRole();
//		List<String> p_l=userService.findAllPrivilege();
//		
		String currentUsername = (String)super.getAvailablePrincipal(principals);  

		SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo(); 

//		List<String> roles= new ArrayList<>();
//		roles.add("admin");
//		roles.add("wjk");
//
//		List<String> privilege= new ArrayList<>();
//		privilege.add("add");
//		privilege.add("del");

//		simpleAuthorInfo.addRoles(r_l);
//		simpleAuthorInfo.addStringPermissions(p_l);

		

		logger.info("授权查询, 进行鉴权但缓存中无用户的授权信息时调用。用户名："+currentUsername);

		return simpleAuthorInfo;
	}

	/**
	 * 认证,登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();  				//得到用户
		String password = new String((char[])token.getCredentials()); 	//得到密码

		UsernamePasswordToken token11 = (UsernamePasswordToken)token;  

		logger.info("认证,登录时调用。用户名："+token11.getUsername());
		logger.info("认证,登录时调用。密码："+token11.getPassword().toString());
		logger.info("认证,登录时调用。用户名："+username+",密码："+password);

		if(null != username && null != password){
			return new SimpleAuthenticationInfo(username, password, getName());
		}else{
			return null;
		}
	}

}
