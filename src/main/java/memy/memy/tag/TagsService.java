package memy.memy.tag;

import com.google.common.collect.Lists;
import memy.memy.tag.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagsService {

    @Autowired
    TagsRepository tagsRepository;

    List<TagData> getAll() {
        return Lists.newArrayList(tagsRepository.findAll())
                .stream()
                .map(this::tagToTagData)
                .collect(Collectors.toList());
    }

    TagData tagToTagData(Tag tag) {
        TagData tagData = new TagData();
        tagData.setName(tag.getName());

        return tagData;
    }
}
