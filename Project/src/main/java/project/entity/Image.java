package project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;



    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private List< byte[]> images;
}
