package com.sph.controller;

import com.sph.pojo.Turnover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sph.dao.TurnoverDao;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class TurnoverController
{
    @Autowired
    TurnoverDao tDao;

    @RequestMapping("/turnover")
    public String list(Model model, HttpSession session)
    {
        Collection<Turnover> turnovers = tDao.list(session.getAttribute("loginUser").toString());
        model.addAttribute("turnovers", turnovers);
        return "turnover/list";
    }

}
