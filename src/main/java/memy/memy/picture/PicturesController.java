package memy.memy.picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Controller
public class PicturesController {

    private final PictureDownloader pictureDownloader;

    @Autowired
    public PicturesController(PictureDownloader pictureDownloader) {
        this.pictureDownloader = pictureDownloader;
    }

    @GetMapping(value = "/pictures")
    public @ResponseBody
    List<PictureData> getPictures() { //mocked already
        PictureData pictureData = new PictureData();
        pictureData.setPath("1.jpg");

        return Collections.singletonList(pictureData);
    }

    @GetMapping(value = "/picture")
    public @ResponseBody
    byte[] getImageAsByteArray(@RequestParam("fileTag") String fileTag) throws IOException {
        return pictureDownloader.getImageAsByteArray(fileTag);
    }
}
