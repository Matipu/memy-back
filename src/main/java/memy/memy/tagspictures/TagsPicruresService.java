package memy.memy.tagspictures;

import memy.memy.picture.entity.Picture;
import memy.memy.tag.entity.Tag;
import memy.memy.tagspictures.entity.TagPictures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TagsPicruresService {

    @Autowired
    private TagsPicturesRepository tagsRepository;

    public Iterable<TagPictures> getByPictureId(Long pictureId) {
        return tagsRepository.findByPictureId(pictureId);
    }

    @Transactional
    public void addRelation(Picture picture, Tag tag) {
        Optional<TagPictures> optionalTagPictures = tagsRepository.findByTagIdAndPictureId(tag.getId(), picture.getId());
        TagPictures tagPictures;
        if(optionalTagPictures.isPresent()) {
            tagPictures = optionalTagPictures.get();
            tagPictures.setTagsCount(tagPictures.getTagsCount() + 1);
        } else {
            tagPictures = new TagPictures();
            tagPictures.setTagId(null);
            tagPictures.setPictureId(picture.getId());
            tagPictures.setTagId(tag.getId());
            tagPictures.setTagsCount(1L);
        }

        tagsRepository.saveAndFlush(tagPictures);
    }
}
