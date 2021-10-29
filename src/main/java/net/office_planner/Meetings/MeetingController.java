package net.office_planner.Meetings;

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
public class MeetingController {

    @Autowired
    private MeetingRepository meetingRepository;

    @GetMapping("/add_meeting")
    public String showMeetingAddForm(Model model) {
        model.addAttribute("meetings", new Meetings());
        return "Meetings/add_meeting";
    }

    @PostMapping("/create_meeting")
    public String MeetingCreate(Meetings meetings) {

        meetingRepository.save(meetings);
        return "User/users_page";
    }

    @GetMapping("/ListMeetings")
    public String viewMeetingList(Model model) {
        List<Meetings> listMeetings = meetingRepository.findAll();
        model.addAttribute("ListMeetings", listMeetings);
        return "Meetings/list_meeting";
    }

    @RequestMapping("/delete_meeting/{meeting_id}")
    public String deleteMeeting(@PathVariable(name = "meeting_id") Integer meeting_id) {
        meetingRepository.deleteById(meeting_id);
        return "User/users_page";
    }

    @RequestMapping("/edit_meeting/{meeting_id}")
    public ModelAndView ShowEditOrg(@PathVariable(name = "meeting_id") Integer meeting_id) {
        ModelAndView umv = new ModelAndView("Meetings/edit_meeting");
        Meetings meetings = meetingRepository.findByMeeting_id(meeting_id);
        umv.addObject("edit_meeting", meetings);
        return umv;

    }
}