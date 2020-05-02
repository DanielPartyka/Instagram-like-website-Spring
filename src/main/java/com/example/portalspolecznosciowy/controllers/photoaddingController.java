package com.example.portalspolecznosciowy.controllers;

import com.example.portalspolecznosciowy.models.Photos;
import com.example.portalspolecznosciowy.models.Sections;
import com.example.portalspolecznosciowy.repositories.PhotosRepository;
import com.example.portalspolecznosciowy.services.SectionsServices;
import com.example.portalspolecznosciowy.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class photoaddingController {

    @Autowired
    private SectionsServices sectionsServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    private PhotosRepository photosRepository;

    public static String user;

    @GetMapping("/add_photo")
    public ModelAndView add_photorender() {
        ModelAndView modelAndView = new ModelAndView("add_photo");
        modelAndView.addObject("sections",sectionsServices.allSections());
        return modelAndView;
    }
    @PostMapping("/add_photo")
    public ModelAndView add_photorender(@ModelAttribute("photos") Photos photos, @ModelAttribute("sections") Sections sections, @RequestParam("files") MultipartFile file, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            System.out.println("Jest problem z " + result);
        }
        ModelAndView modelAndView = new ModelAndView("/user");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        user = authentication.getName();
        photos.setUser(userServices.findUserId(user));
        photos.setSections(sectionsServices.findSectionByName(sections.getName()));
        String tags = photos.getTags();
        String[] splited_tags = tags.split(",");
        String final_tags = "";
        for (String s : splited_tags) {
            s = "#" + s;
        }
        for (String s : splited_tags) {
            final_tags += s;
        }
        photos.setTags(final_tags);
        photos.setDescription(photos.getDescription());
        photos.setName_photo(photos.getName_photo());
        Date today = new Date();
        photos.setDate(today);
        //Upload Image to folder

        String path = System.getProperty("user.dir") + "\\uploads\\";
        path+=user;
        System.out.println(path);
        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }
        byte[] bytes = file.getBytes();
        Path pathsave = Paths.get(path,file.getOriginalFilename());
        Files.write(pathsave,bytes);
        //
        photos.setSource(user+"/"+file.getOriginalFilename());
        photosRepository.save(photos);
        return modelAndView;
    }
}
