package ouhk.comps380f.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import ouhk.comps380f.model.Attachment;
import ouhk.comps380f.model.Ticket;
import ouhk.comps380f.view.DownloadingView;
import ouhk.comps380f.dao.FoodEntryRepository;
import ouhk.comps380f.model.FoodEntry;

@Controller
public class IndexController {

    @Resource
    private FoodEntryRepository foodEntryRepo;

    @GetMapping
    public String index(ModelMap model) {
        model.addAttribute("entries", foodEntryRepo.listEntries());
        return "list";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
