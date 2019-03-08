package memy.memy.tag;

import memy.memy.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface TagsRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);
}

