package memy.memy.picture.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="path")
    private String path;
}
