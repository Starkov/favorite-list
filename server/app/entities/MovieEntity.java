package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movie")
public class MovieEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private Integer movieId;

    @Column(name="foreign_sys_id")
    private Integer foreignSysId;

    private Boolean adult;

    @Column(name = "backdrop_path")
    private String backdropPath;

    private String overview;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "poster_path")
    private String posterPath;

    private Float popularity;

    private String title;

    private Boolean video;

    @Column(name = "vote_average")
    private Float voteAverage;

    @Column(name = "vote_count")
    private Float voteCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_list_id", nullable = false)
    private MovieListEntity movieList;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getForeignSysId() {
        return foreignSysId;
    }

    public void setForeignSysId(Integer foreignSysId) {
        this.foreignSysId = foreignSysId;
    }

    public MovieListEntity getMovieList() {
        return movieList;
    }

    public void setMovieList(MovieListEntity movieList) {
        this.movieList = movieList;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Float getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Float voteCount) {
        this.voteCount = voteCount;
    }
}
