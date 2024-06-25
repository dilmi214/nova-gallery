package io.github.dilmi214.artgallery.nova_gallery.exhibition;

import io.github.dilmi214.artgallery.nova_gallery.model.Exhibition;
import io.github.dilmi214.artgallery.nova_gallery.service.ExhibitionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/exhibitions")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    public ExhibitionController(ExhibitionService exhibitionService) {
        this.exhibitionService = exhibitionService;
    }

    @GetMapping("/")
    public String getAllExhibitions(Model model) {
        List<Exhibition> exhibitions = exhibitionService.getAllExhibitions();
        model.addAttribute("exhibitions", exhibitions);
        return "/Exhibition/exhibitions";
    }

    @GetMapping("/{id}")
    public String getExhibition(Model model, @PathVariable Integer id) {
        Exhibition exhibition = exhibitionService.getExhibition(id);
        model.addAttribute("exhibition", exhibition);
        return "/Exhibition/exhibition";
    }

    @GetMapping("/add")
    public String addExhibition() {
        return "/Exhibition/addExhibition";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Exhibition> getAllExhibitionsJson() {
        return exhibitionService.getAllExhibitions();
    }

    @GetMapping("/exhibition/{id}")
    @ResponseBody
    public Exhibition getExhibitionJson(@PathVariable Integer id) {
        return exhibitionService.getExhibition(id);
    }

    @PostMapping("/create")
    @ResponseBody
    public Exhibition createExhibition(@RequestBody Exhibition exhibition) {
        return exhibitionService.createExhibition(exhibition);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Exhibition updateExhibition(@PathVariable Integer id, @RequestBody Exhibition exhibition) {
        return exhibitionService.updateExhibition(id, exhibition);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteExhibition(@PathVariable Integer id) {
        exhibitionService.deleteExhibition(id);
    }


}
