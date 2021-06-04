package com.example.mhwequipment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private EquipmentService service;

    @RequestMapping("/")
    public String HomePage(){

        return "index";

    }
    @RequestMapping("/palico")
    public String Palico(Model model){

        List<PalicoWeapons> listWeapons = service.listAll();
        model.addAttribute("listWeapons", listWeapons);

        return "palico";

    }
    @RequestMapping("/new")
    public String addWeaponForm(Model model){

        PalicoWeapons weapons = new PalicoWeapons();
        model.addAttribute("weapons", weapons);

        return "new_weapon";

    }

    @RequestMapping(value ="/save", method = RequestMethod.POST)
    public String saveWeapon(@Valid @ModelAttribute("weapons") PalicoWeapons weapons, BindingResult validation){

        /**
         * @Valid for method level validation, it triggers the Bean Validator to check if the fields populated in the object conform to the annotations
         * BindingResult is an object that holds the result of the validation and binding and contains errors
         * that may have occurred. The BindingResult must come right after the model object that is validated
         * or else Spring will fail to validate the object and throw an exception
         */
        System.out.println(weapons); // !important, print out the server side error message.

        if(validation.hasErrors()){
            return "new_weapon";
        }else{
            service.save(weapons);
            return "redirect:/palico";
        }

    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editWeapon(@PathVariable(name = "id") Long id){

       ModelAndView mav = new ModelAndView("edit_weapon");

       PalicoWeapons weapons = service.get(id);
       mav.addObject("weapons", weapons);

       return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deleteWeapon(@PathVariable(name = "id") Long id){

        service.delete(id);

        return "redirect:/palico";

    }
}
