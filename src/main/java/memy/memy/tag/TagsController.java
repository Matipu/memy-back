package memy.memy.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TagsController {

    @Autowired
    TagsService tagsService;

    @GetMapping(value = "/tag")
    public @ResponseBody
    List<TagData> getTags() {
        return tagsService.getAll();
    }
}
