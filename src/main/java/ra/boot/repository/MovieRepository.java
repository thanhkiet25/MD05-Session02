package ra.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ra.boot.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Long> {
@Query("select count(m) from Movie m where m.title = :title")
    long countByTitle(@Param("title") String title);
}
