package memy.memy.picture;

import memy.memy.picture.entity.Picture;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class PictureConventer implements Converter<Picture, PictureData> {

    @Override
    public PictureData convert(Picture picture) {
        PictureData pictureData = new PictureData();
        pictureData.setId(picture.getId());
        pictureData.setPath(picture.getPath());
        return pictureData;
    }
}
