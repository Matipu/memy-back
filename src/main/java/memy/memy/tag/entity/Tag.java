package memy.memy.tag.entity;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;
}
