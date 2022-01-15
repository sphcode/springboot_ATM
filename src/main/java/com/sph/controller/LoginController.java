package com.sph.controller;

import com.sph.dao.AccountDao;
import com.sph.pojo.Account;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class LoginController
{
    @SneakyThrows
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session)
    {
        AccountDao accountDao = new AccountDao();
        ResultSet query = accountDao.query(username);
        if (query.next())
        {
            String psw = query.getString(2);
            if (!StringUtils.isEmpty(psw) && psw.equals(password))
            {
                session.setAttribute("loginUser", username);
                session.setAttribute("firstName", query.getString(3));
                session.setAttribute("lastName", query.getString(4));
                session.setAttribute("balance", query.getInt(5));
                return "redirect:/main";
            }
            else
            {
                model.addAttribute("msg", "账号密码错误");
                return "index";
            }
        }
        else
        {
            model.addAttribute("msg", "账号密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/index.html";
    }
}
