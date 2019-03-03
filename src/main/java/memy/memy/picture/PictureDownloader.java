package memy.memy.picture;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class PictureDownloader {

    private String folderPath;
    private final Path rootLocation;

    PictureDownloader() throws IOException {
        Properties prop = new Properties();
        String propFileName = "application.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);
        this.folderPath = prop.getProperty("memy.pictures.path");
        this.rootLocation = Paths.get(folderPath);
    }

    public List<PictureData> getAllPicturesData() {
        List<PictureData> pictures = new ArrayList<>();
        addToTist(pictures, "1.jpg");
        addToTist(pictures, "pach.png");
        addToTist(pictures, "hejters.gif");
        addToTist(pictures, "tabletki.jpg");
        addToTist(pictures, "partner.jpg");
        addToTist(pictures, "hmmm.jpg");
        addToTist(pictures, "hmm.png");

        return pictures;
    }

    void addToTist(List<PictureData> pictures, String tag) {
        PictureData pictureData2 = new PictureData();
        pictureData2.setPath(tag);
        pictures.add(pictureData2);
    }

    public Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }
}
