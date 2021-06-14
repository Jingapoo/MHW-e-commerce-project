package com.example.mhwequipment.clients;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private EquipmentService service; // CRUD Operations for equipment
    @Autowired
    private UserRepository repo; // User Role-based

    @RequestMapping("/")
    public String HomePage(){

        return "home";

    }

    @GetMapping("/register")
    public String SignUp(Model model){

        model.addAttribute("user", new User());

        return "sign_up";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){

        /**
         * BCryptPasswordEncoder to encode the user’s password so the password itself
         * won't stored in database (for better security) – only the hash value of the password is stored.
         */

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repo.save(user);

        return "register_success";
    }

    /**
     * Login Page
     */
    @GetMapping("/login") // related to .loginPage("/login")
    public String logInPage(){

        return "log_in";
    }

    @GetMapping("/palico")
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

        if(validation.hasErrors()){
            System.out.println(weapons); // !important, print out the server side error message.
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

    @GetMapping("/403")
    public String access403(){
        return "403";
    }
}
