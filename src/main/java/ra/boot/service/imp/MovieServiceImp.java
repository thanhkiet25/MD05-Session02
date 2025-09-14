package ra.boot.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.boot.dto.MovieDto;
import ra.boot.model.Movie;
import ra.boot.repository.MovieRepository;
import ra.boot.service.MovieService;
@Service
public class MovieServiceImp implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public boolean existByTitle(String title) {
        long count = movieRepository.countByTitle(title);
        return count>0;
    }

    @Override
    public Movie addMovie(MovieDto movieDto) {
        Movie movie = convertDtoToMovie(movieDto);
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(MovieDto movieDto, Long id) {
        Movie movie = convertDtoToMovie(movieDto);
        movie.setId(id);
        return movieRepository.save(movie);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteMovie(Long id) {
        Movie movie1 = findById(id);
        if (movie1 != null) {
            movieRepository.delete(movie1);
            return true;
        }else{
            return false;
        }
    }



    private Movie convertDtoToMovie(MovieDto movieDto) {
        return Movie
                .builder()
                .title(movieDto.getTitle())
                .director(movieDto.getDirector())
                .releaseDate(movieDto.getReleaseDate())
                .rating(movieDto.getRating())
                .build();
    }
}
