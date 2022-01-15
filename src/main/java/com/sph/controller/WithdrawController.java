package com.sph.controller;

import com.sph.dao.AccountDao;
import com.sph.dao.TurnoverDao;
import com.sph.pojo.Account;
import com.sph.pojo.Turnover;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class WithdrawController
{
    @RequestMapping("/withdraw")
    String withdraw()
    {
        return "withdraw";
    }

    @PostMapping("/towithdraw")
    String wi(@RequestParam("amount") Integer amount, HttpSession session, Model model) throws SQLException
    {
        TurnoverDao turnoverDao = new TurnoverDao();
        Integer sum = turnoverDao.todayWithdraw(session.getAttribute("loginUser").toString());
        if (sum + amount > 10000)
        {
            model.addAttribute("msg", "超过每日取款额");
            return "withdraw";
        }
        if ((Integer)session.getAttribute("balance") - amount >= 0)
        {
            session.setAttribute("balance",
                    (Integer)session.getAttribute("balance") - amount);
            turnoverDao.withdraw((String)session.getAttribute("loginUser"), amount, (Integer)session.getAttribute("balance"));
            return "redirect:/main";
        }
        else
        {
            model.addAttribute("msg", "余额不足");
            return "withdraw";
        }
    }
}
