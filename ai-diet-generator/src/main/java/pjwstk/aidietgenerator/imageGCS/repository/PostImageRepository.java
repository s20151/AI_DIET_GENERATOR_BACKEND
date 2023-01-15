package pjwstk.aidietgenerator.imageGCS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pjwstk.aidietgenerator.imageGCS.entity.PostImage;

@Repository
public interface PostImageRepository extends JpaRepository<PostImage, Long> {
}