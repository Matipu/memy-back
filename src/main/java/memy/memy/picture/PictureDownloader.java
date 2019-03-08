package memy.memy.picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
class PictureDownloader {

    private final Path rootLocation;

    @Autowired
    private PicturesRepository picturesRepository;

    @Autowired
    private PictureConventer pictureConventer;

    PictureDownloader() throws IOException {
        Properties prop = new Properties();
        String propFileName = "application.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);
        this.rootLocation = Paths.get(prop.getProperty("memy.pictures.path"));
    }

    public List<PictureData> getAllPicturesData() {
        List<PictureData> pictures = new ArrayList<>();
        picturesRepository.findAll().forEach(
                picture -> pictures.add(pictureConventer.convert(picture))
        );

        return pictures;
    }

    Resource loadFile(String filename) {
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
