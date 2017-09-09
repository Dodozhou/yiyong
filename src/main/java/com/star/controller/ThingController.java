package com.star.controller;

import com.star.entity.MyThing;
import com.star.repository.ThingRepository;
import com.star.util.ImgPathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by hp on 2017/9/8.
 */
@Controller
public class ThingController {

    @Autowired
    ImgPathUtil imgPathUtil;

    @Autowired
    ThingRepository repository;

    @RequestMapping({"/index","/"})
    public String index( Model model){
        model.addAttribute("recs",repository.findAll(new PageRequest(0,8)).getContent());
        model.addAttribute("wen",repository.findByCategory("文具"));
        model.addAttribute("bei",repository.findByCategory("杯具"));
        model.addAttribute("chong",repository.findByCategory("宠物"));
        model.addAttribute("dian",repository.findByCategory("电器"));
        model.addAttribute("xi",repository.findByCategory("洗护"));
        model.addAttribute("yin",repository.findByCategory("饮食"));
        model.addAttribute("pei",repository.findByCategory("配件"));
        model.addAttribute("shou",repository.findByCategory("收纳"));
        return "index";
    }
    @RequestMapping("/redir/{type}")
    public String redir(@PathVariable("type") String type){
        return "redirect:/index#"+type;
    }

    @RequestMapping("/rec")
    public String recommend(Model model){
        model.addAttribute("rec",new MyThing());
        return "upload";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(MyThing thing, @RequestPart("pic") MultipartFile pic,
                         RedirectAttributes model, HttpServletRequest request) throws IOException{
        System.out.println(pic.isEmpty());
        if (pic.isEmpty()){
            model.addFlashAttribute("error","请选择文件O(∩_∩)O！");
            return "redirect:/rec";
        }
        String picUrl=imgPathUtil.saveImgs(request,pic,"pic");
        thing.setPicPath(picUrl);
        //Repository
        repository.saveAndFlush(thing);
        return "redirect:/index";
    }



}
