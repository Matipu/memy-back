package memy.memy.tag;

import memy.memy.tag.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagNameConventer {

    @Autowired
    private TagsRepository tagsRepository;

    public Tag get(String tagName) throws NoTagException {
        Optional<Tag> tag = tagsRepository.findByName(tagName);
        return tag.orElseThrow(NoTagException::new);
    }
}
