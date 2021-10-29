package net.office_planner.Organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrganizationController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("/add_org")
    public String showOrganizationAddForm(Model model) {
        model.addAttribute("organization", new Organization());
        return "Organization/add_org";
    }

    @PostMapping("/create_organization")
    public String OrgCreate(Organization organization) {

        organizationRepository.save(organization);
        return "User/users_page";
    }

    @GetMapping("/list_organization")
    public String viewOrgList(Model model) {
        List<Organization> listOrg = organizationRepository.findAll();
        model.addAttribute("listOrg", listOrg);
        return "Organization/list_organization";
    }

    @RequestMapping("/delete_org/{organization_id}")
    public String deleteOrg(@PathVariable(name = "organization_id") Integer organization_id) {
        organizationRepository.deleteById(organization_id);
        return "User/users_page";
    }

    @RequestMapping("/edit_org/{organization_id}")
    public ModelAndView ShowEditOrg(@PathVariable(name = "organization_id") Integer organization_id) {
        ModelAndView umv = new ModelAndView("Organization/edit_org");
        Organization organization = organizationRepository.findByOrganization_id(organization_id);
        umv.addObject("edit_org", organization);
        return umv;

    }
}