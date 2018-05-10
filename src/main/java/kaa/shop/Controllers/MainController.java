package kaa.shop.Controllers;


import kaa.shop.Domen.EntityContragents;
import kaa.shop.Repository.DaoContragentsImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Controller
public class MainController {

    @PersistenceContext
    EntityManager entManager;

    @RequestMapping("/")
    public String indexHTML() {
        return "index";
    }

    @RequestMapping(value = "/contragents")
    @ResponseBody
    public ArrayList<EntityContragents> contragentsHTML() {

        DaoContragentsImpl ttt = new DaoContragentsImpl();
        return ttt.findByAny(0, 2, "3", null, entManager);
    }
}