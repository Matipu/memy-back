package memy.memy.tagspictures.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tags_pictures")
public class TagPictures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="tag_id")
    private Long tagId;

    @Column(name="picture_id")
    private Long pictureId;

    @Column(name="tags_count")
    private Long tagsCount;

}
