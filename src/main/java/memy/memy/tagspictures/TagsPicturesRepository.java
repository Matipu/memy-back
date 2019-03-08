package memy.memy.tagspictures;

import memy.memy.tagspictures.entity.TagPictures;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface TagsPicturesRepository extends JpaRepository<TagPictures, Long> {

    List<TagPictures> findByTagId(Long tagId);
    List<TagPictures> findByPictureId(Long pictureId);
    Optional<TagPictures> findByTagIdAndPictureId(Long tagId, Long pictureId);
}

