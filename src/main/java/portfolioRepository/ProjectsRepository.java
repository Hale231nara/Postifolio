package portfolioRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.Project;
@Repository
public interface ProjectsRepository extends JpaRepository<Project, Long> {
}
