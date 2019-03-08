package memy.memy.picture;

import memy.memy.picture.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

interface PicturesRepository extends JpaRepository<Picture, Long> {

}

