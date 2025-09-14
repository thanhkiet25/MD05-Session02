package ra.boot.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.boot.dto.MovieDto;
import ra.boot.model.Movie;

public interface MovieService {
    Page<Movie> findAll(Pageable pageable);

    boolean existByTitle(String title);

    Movie addMovie(MovieDto movieDto);

    Movie updateMovie(MovieDto movieDto, Long id);

    Movie findById(Long id);

    boolean deleteMovie(Long id);


}
