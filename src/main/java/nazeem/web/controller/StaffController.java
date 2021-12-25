package nazeem.web.controller;

import javax.validation.Valid;

import nazeem.web.model.ProductType;
import nazeem.web.model.Staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private nazeem.web.service.StaffService staffService;

    private String add_edit_template="/admin/staff/add-edit-staff";
    private String list_template="/admin/staff/list-staff";
    private String list_redirect="redirect:/staff/list";
//    private String list_redirect="/staff/list";

    @GetMapping("/add")
    public String addStaff(Staff staff, Model model){
        model.addAttribute("staff", staff);
        return add_edit_template;
    }

//    @GetMapping("/edit/{id}")
    @RequestMapping("/edit/{id}")
    public String editStaff(@PathVariable("id") int id, Model model){
        Staff staff = staffService.get(id);

        model.addAttribute("staff", staff);

        return add_edit_template;
    }

//    @PostMapping("/save")
//    public String saveStaff(@Valid @ModelAttribute("staff") Staff staff, BindingResult result, Model model){
//        model.addAttribute("staff", staff);
//
//        if(result.hasErrors()){
//            return add_edit_template;
//        }
//        staffService.save(staff);
//
//        return list_redirect+"?success";
//
//    }
//    @PostMapping("/save")
   	  @RequestMapping("/save")
    public String saveStaff(@Valid @ModelAttribute("staff") Staff staff, BindingResult result, Model model){
        model.addAttribute("staff", staff);

        if(result.hasErrors()){
            return add_edit_template;
        }
        staffService.save(staff);

        return list_redirect+"?success";

    }
    public String saveStaff(Staff staff,  Model model){
        model.addAttribute("staff", staff);

       
        staffService.save(staff);

        return list_redirect+"?success";

    }

    @GetMapping("/delete/{id}")
    public String deleteStaff(@PathVariable("id") int id, Model model) {
    	staffService.delete(id);

        return list_redirect+"?deleted";
    }

    @GetMapping("/list")
    public String listStaff(Model model) {
        List<Staff> listStaffs = staffService.listAll();
        model.addAttribute("listStaffs", listStaffs);

        return list_template;
    }
}