package com.sph.controller;

import com.sph.dao.TurnoverDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
public class DepositController
{
    @RequestMapping("/deposit")
    String deposit()
    {
        return "deposit";
    }

    @PostMapping("/todeposit")
    String de(@RequestParam("amount") Integer amount, HttpSession session)
    {
        TurnoverDao turnoverDao = new TurnoverDao();
        session.setAttribute("balance",
                (Integer)session.getAttribute("balance") + amount);
        try
        {
            turnoverDao.deposit((String)session.getAttribute("loginUser"), amount, (Integer)session.getAttribute("balance"));
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return "redirect:/main";
    }
}
