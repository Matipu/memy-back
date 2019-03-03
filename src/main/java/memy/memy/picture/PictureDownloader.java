package memy.memy.picture;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Service
public class PictureDownloader {

    private String folderPath;

    PictureDownloader() throws IOException {
        Properties prop = new Properties();
        String propFileName = "application.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);
        this.folderPath = prop.getProperty("memy.pictures.path");
    }

    public byte[] getImageAsByteArray(String fileTag) throws IOException {
        Path path = Paths.get(folderPath + fileTag);
        return Files.readAllBytes(path);
    }
}
