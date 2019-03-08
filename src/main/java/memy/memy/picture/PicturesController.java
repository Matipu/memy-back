package memy.memy.picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    List<PictureData> getPictures(Pageable pageable) { //mocked already

        return pictureDownloader.getAllPicturesData();
    }
    
    @GetMapping("/picture")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@RequestParam("fileTag") String fileTag) {
        Resource file = pictureDownloader.loadFile(fileTag);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
