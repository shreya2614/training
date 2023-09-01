import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class AlbumDaoImpl implements AlbumDao {

	List<Album> albums ;

	public AlbumDaoImpl() {
		albums = new ArrayList<Album>();

		try (Stream<String> lines = Files.lines(Paths.get("src/albums.txt"))){
			albums =lines.map(line ->{
				String[] record =line.split(",");
				return new Album(record[0], record[1], record[2]);
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}


	@Override
	public void persist(Album a) {
		albums.add(a);
	}

	@Override
	public Album findByTitle(String title) {
		return albums.stream().filter(l -> l.getTitle().equals(title)).findFirst().get();
	}

	@Override
	public List<Album> list() {
		return albums;
	}

	@Override
	public List<Album> findByArtist(String artist) {
		return albums.stream().filter(l -> l.getArtist().equals(artist)).collect(Collectors.toList());
	}

	@Override
	public List<Album> findByGenre(String genre) {
		return albums.stream().filter(l -> l.getGenre().equals(genre)).collect(Collectors.toList());
	}

	@Override
	public boolean update(Album updatedAlbum) {
		for (Album album : albums) {
	        if (album.getTitle().equals(updatedAlbum.getTitle())) {
	            album.setArtist(updatedAlbum.getArtist());
	            album.setGenre(updatedAlbum.getGenre());
	            return true; 
	        }
	    }
	    return false; 
	}

	@Override
	public boolean delete(String title) {
		return albums.removeIf(p -> p.getTitle().equals(title));
	}

}