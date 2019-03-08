package memy.memy.tag;

import memy.memy.picture.NoPictureException;
import memy.memy.picture.PictureIdConventer;
import memy.memy.picture.entity.Picture;
import memy.memy.tag.entity.Tag;
import memy.memy.tagspictures.TagsPicruresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagsCreator {

    @Autowired
    PictureIdConventer pictureIdConventer;

    @Autowired
    TagNameConventer tagNameConventer;

    @Autowired
    TagsPicruresService tagsPicruresService;

    void addTagToPicture(Long pictureId, String tagName) throws NoPictureException, NoTagException {
        Picture picture = pictureIdConventer.get(pictureId);
        Tag tag = tagNameConventer.get(tagName);
        tagsPicruresService.addRelation(picture, tag);
    }
}
