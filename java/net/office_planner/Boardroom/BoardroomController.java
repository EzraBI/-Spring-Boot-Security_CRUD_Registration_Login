package net.office_planner.Boardroom;

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
public class BoardroomController {

    @Autowired
    private BoardroomRepository boardroomRepository;

    @GetMapping("/add_room")
    public String showRoomAddForm(Model model) {
        model.addAttribute("boardroom", new Boardroom());
        return "Boardroom/add_room";
    }

    @PostMapping("/create_room")
    public String RoomCreate(Boardroom boardroom) {

        boardroomRepository.save(boardroom);
        return "User/users_page";
    }

    @GetMapping("/list_room")
    public String viewOrgList(Model model) {
        List<Boardroom> listRoom = boardroomRepository.findAll();
        model.addAttribute("listRoom", listRoom);
        return "Boardroom/list_room";
    }

    @RequestMapping("/delete_room/{boardroom_id}")
    public String deleteRoom(@PathVariable(name = "boardroom_id") Integer boardroom_id) {
        boardroomRepository.deleteById(boardroom_id);
        return "User/users_page";
    }


    @RequestMapping("/edit_room/{boardroom_id}")
    public ModelAndView ShowEditRoom(@PathVariable(name = "boardroom_id") Integer boardroom_id) {
        ModelAndView umv1 = new ModelAndView("Boardroom/edit_room");
        Boardroom boardroom= boardroomRepository.findByBoardroom_id(boardroom_id);
        umv1.addObject("edit_room", boardroom);
        return umv1;

    }

}