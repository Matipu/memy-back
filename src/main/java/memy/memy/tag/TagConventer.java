package memy.memy.tag;

import org.springframework.core.convert.converter.Converter;
import memy.memy.tag.entity.Tag;
import org.springframework.stereotype.Service;

@Service
public class TagConventer implements Converter<Tag, TagData> {

    @Override
    public TagData convert(Tag tag) {
        TagData tagData = new TagData();
        tagData.setName(tag.getName());

        return tagData;
    }
}
