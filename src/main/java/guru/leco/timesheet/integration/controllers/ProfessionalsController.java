package guru.leco.timesheet.integration.controllers;

import guru.leco.timesheet.commons.StringToUUID;
import guru.leco.timesheet.domain.Professionals;
import guru.leco.timesheet.services.contracts.ProfessionalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotBlank;

@Controller
@RequestMapping("/user")
public class ProfessionalsController {

    private ProfessionalsService professionalsService;

    @Autowired
    public ProfessionalsController(ProfessionalsService professionalsService) {
        this.professionalsService = professionalsService;
    }

    @GetMapping("/{id}/pointing")
    public String pointing(@NotBlank @PathVariable String id, Model model){
        Professionals user = this.professionalsService.findById(StringToUUID.convert(id));
        model.addAttribute("pointing", user.getPointing());
        return "/pointing/index";
    }
}
