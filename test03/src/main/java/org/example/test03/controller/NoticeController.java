package org.example.test03.controller;

import lombok.RequiredArgsConstructor;
import org.example.test03.model.dto.NoticeDTO;
import org.example.test03.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    NoticeService noticeService;

    @GetMapping
    public ModelAndView mainPage(ModelAndView modelAndView){

        modelAndView.setViewName("/notice/main");
        return modelAndView;
    }

    // 공지 등록
    @PostMapping("/register")
    public ModelAndView registerNotice(ModelAndView modelAndView, @RequestBody NoticeDTO noticeDTO){

        String message = noticeService.registerNotice(noticeDTO);

        modelAndView.addObject("message", message);
        modelAndView.setViewName("/notice/main");
        return modelAndView;
    }

    // 공지 수정
    @PostMapping("/update")
    public ModelAndView updateNotice(ModelAndView modelAndView, @RequestBody NoticeDTO noticeDTO){

        String message = noticeService.updateNotice(noticeDTO);

        modelAndView.addObject("message", message);
        modelAndView.setViewName("/notice/updateNotice");
        return modelAndView;
    }

    // 공지 삭제
    @PostMapping("/delete")
    public ModelAndView deleteNotice(ModelAndView modelAndView, @RequestBody NoticeDTO noticeDTO){

        String message = noticeService.deleteNotice(noticeDTO);

        modelAndView.addObject("message", message);
        modelAndView.setViewName("/notice/updateNotice");
        return modelAndView;
    }

    // 상세 조회
    @PostMapping("/detailNotice/{noticeNo}")
    public ModelAndView detailNotice(ModelAndView modelAndView, @PathVariable("noticeNo") Integer noticeNo){

        NoticeDTO noticeDTO = noticeService.getNoticeById(noticeNo);


        modelAndView.addObject("notice", noticeDTO);
        modelAndView.setViewName("/notice/detailNotice");
        return modelAndView;
    }


    // 페이지 이동
    @GetMapping("/newNotice")
    public ModelAndView newNotice(ModelAndView modelAndView){
        modelAndView.setViewName("/notice/newNotice");

        return modelAndView;
    }

    @GetMapping("/updateNotice")
    public ModelAndView updateNotice(ModelAndView modelAndView){
        modelAndView.setViewName("/notice/updateNotice");

        return modelAndView;
    }










    @ModelAttribute("noticeList")
    public List<NoticeDTO> getAllNoticeList(){
        List<NoticeDTO> noticeList = noticeService.getAllNoticeList();
        return noticeList;
    }


}
