package pjwstk.aidietgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pjwstk.aidietgenerator.entity.Survey;
import pjwstk.aidietgenerator.entity.User;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Survey findByuser(User user);
}
