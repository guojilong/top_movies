package com.gjl.topmovies.api.security;

import com.gjl.topmovies.dto.LoginUser;
import com.gjl.topmovies.model.MyHttpResponse;
import com.gjl.topmovies.model.Response;
import com.gjl.topmovies.service.impl.LoginServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guojilong on 2017/11/13.
 */
@Controller
@RequestMapping(value = "/security")
public class Securities {

    @Autowired
    LoginServiceImpl loginService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public MyHttpResponse login(HttpServletRequest request) {

        String userName = request.getParameter("username");
        String pwd = request.getParameter("password");

        if (userName==null||userName.length()==0) {

            return MyHttpResponse.notOk("用户名不能为空");
        }

        if (pwd==null||pwd.length()==0) {
            return MyHttpResponse.notOk("密码不能为空");

        }

        Response<LoginUser> loginUserResponse = loginService.login(userName, pwd);
        if (Response.OK == loginUserResponse.getStatus()) {


            Map resultMap = new HashMap();
            resultMap.put("username", loginUserResponse.getData().getUsername());
            resultMap.put("token", loginUserResponse.getData().getToken());

            return MyHttpResponse.ok(new Gson().toJson(loginUserResponse.getData()));
        } else {
            return MyHttpResponse.notOk(loginUserResponse.getErr());

        }


    }
}
