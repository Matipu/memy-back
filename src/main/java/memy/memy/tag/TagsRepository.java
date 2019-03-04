package memy.memy.tag;

import memy.memy.tag.entity.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagsRepository extends CrudRepository<Tag, Long> {

}

