package com.star.controller;

import com.star.entity.MyThing;
import com.star.repository.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by hp on 2017/9/8.
 */
@Controller
public class SearchController {
    @Autowired
    ThingRepository repository;

    @RequestMapping("/search")//这里只能用@RequestParam而不能用@Param，不知道为啥
    public String searchData(@RequestParam("keys") String key, Model model){
        String key2="";
        key=key.trim();
        key=key.replaceAll("\\s+",",");
        String[] keys=key.split(",");
        for (String key1 : keys) {
            key2 = key2 + "%" + key1;
        }
        key2=key2.concat("%");
        List<MyThing> datas= repository.searchMyThing(key2);
        model.addAttribute("things",datas);
        return "search";
    }
}
