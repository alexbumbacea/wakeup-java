package ro.bumbacea.alex.wakeup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ro.bumbacea.alex.wakeup.services.Discovery;
import ro.bumbacea.alex.wakeup.services.Manager;

import java.util.Map;

@Controller
public class HomeController {

    private Manager manager;
    private Discovery discoveryService;

    @Autowired
    public void setDiscovery(Discovery discovery) {
        this.discoveryService = discovery;
    }

    @Autowired
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("msg", "1000");
        model.put("computers", this.manager.getList());
        return "index";
    }

    @RequestMapping(value = "/autodiscovery", method = RequestMethod.GET)
    public RedirectView autodiscovery() {
        discoveryService.autodiscover();

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/");
        return redirectView;
    }

    //Spring Security see this :
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }
}
