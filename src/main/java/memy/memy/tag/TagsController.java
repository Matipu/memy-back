package memy.memy.tag;

import memy.memy.picture.NoPictureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TagsController {

    @Autowired
    private TagsService tagsService;

    @Autowired
    private TagsCreator tagsCreator;

    @GetMapping(value = "/tag")
    public @ResponseBody
    List<TagData> getTags() {
        return tagsService.getAll();
    }

    @GetMapping(value = "picture/{pictureId}/tag")
    public @ResponseBody
    List<TagData> getTags(@PathVariable Long pictureId) {
        return tagsService.getByPictureId(pictureId);
    }

    @GetMapping(value = "addTagToPicture")
    public @ResponseBody
    void addTagToPicture(@RequestParam("pictureId") Long pictureId, @RequestParam("tag") String tag) throws NoPictureException, NoTagException {
        tagsCreator.addTagToPicture(pictureId, tag);
    }
}
