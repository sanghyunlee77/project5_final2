package com.pet;
import com.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class PetController {
    @Autowired
    PetService petService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/pet/list",method = RequestMethod.GET)
    public String petlist(Model model){
        model.addAttribute("list",petService.getPetList());
        return "list";
    }
    @RequestMapping(value = "/pet/add",method = RequestMethod.GET)
    public String addPost(){
        return "addpostform";
    }
    @RequestMapping(value = "/pet/addok",method = RequestMethod.POST )
    public String addPostOK(PetVO vo){
        int i =petService.insertPet(vo);
        if(i==0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공!!");
        return "redirect:../pet/list";
    }
    @RequestMapping(value = "/pet/editform/{seq}",method = RequestMethod.GET)
    public String editpost(@PathVariable("seq")int seq, Model model){
        PetVO petVO = petService.getPet(seq);
        model.addAttribute("u",petVO);
        return "editpost";
    }
    @RequestMapping(value = "/pet/editok",method = RequestMethod.POST)
    public String editPostOk(PetVO vo){
        if(petService.updatePet(vo)==0)
            System.out.println("데이터 수정 실패");
        else
            System.out.println("데이터 수정 성공!!");
        return "redirect:list";
    }
    @RequestMapping(value = "/pet/deleteok/{seq}",method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("seq") int seq) {
        System.out.println(seq);
        int result = petService.deletePet(seq);
        if (result > 0) {
            System.out.println("데이터 삭제 성공!!");
            return "redirect:/pet/list";
        } else {
            System.out.println("데이터 삭제 실패");
            return "redirect:../list";
        }
    }

    @RequestMapping(value = "/pet/view/{seq}",method = RequestMethod.GET)
    public String viewpost(@PathVariable("seq")int seq, Model model){
        PetVO petVO = petService.getPet(seq);
        model.addAttribute("u",petVO);
        return "view";
    }

}