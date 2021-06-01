package com.example.mhwequipment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("Weapons", weapons);

        return "new_weapons";

    }
}
