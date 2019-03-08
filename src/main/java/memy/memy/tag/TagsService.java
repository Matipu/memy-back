package memy.memy.tag;

import com.google.common.collect.Lists;
import memy.memy.tagspictures.TagsPicruresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagsService {

    @Autowired
    private TagsRepository tagsRepository;

    @Autowired
    private TagConventer tagConventer;

    @Autowired
    private TagsPicruresService tagsPicruresService;

    List<TagData> getAll() {
        return Lists.newArrayList(tagsRepository.findAll())
                .stream()
                .map(tagConventer::convert)
                .collect(Collectors.toList());
    }

    List<TagData> getById(Iterable<Long> tagId) {
        return tagsRepository.findAllById(tagId)
                .stream()
                .map(tagConventer::convert)
                .collect(Collectors.toList());
    }

    List<TagData> getByPictureId(Long pictureId) {
        List<Long> tagIds = new ArrayList<>();
        tagsPicruresService.getByPictureId(pictureId).forEach(
                tagPictures -> tagIds.add(tagPictures.getTagId())
        );

        return tagsRepository.findAllById(tagIds)
                .stream()
                .map(tagConventer::convert)
                .collect(Collectors.toList());
    }

}