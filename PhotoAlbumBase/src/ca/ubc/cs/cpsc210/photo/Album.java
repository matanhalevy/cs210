package ca.ubc.cs.cpsc210.photo;

import ca.ubc.cs.cpsc210.utility.ThumbnailDoesNotExistException;
import ca.ubc.cs.cpsc210.utility.Viewer;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * An album contains a set of photos.
 */
public class Album extends Observable implements Iterable<Photo>{

	// The photos that the album contains
	private Set<Photo> photos = new HashSet<Photo>();

	// The name of the album
	private String name;

	/**
	 * @pre name != null
	 * @param name
	 *            The name for the album
	 */
	public Album(String name) {
		this.name = name;
        ConsoleWriter cw = new ConsoleWriter();
        addObserver(cw);
	}

	/**
	 * @return The album name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Change the album name.
	 * 
	 * @pre name != null
	 * @post @post.getName().equals( name )
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Add a photo to this album.
	 * 
	 * @pre photos.contains(photo) == false AND photo.getAlbum() == null
	 * @post @post.photos.contains(photo) == true
	 /* @throws PhotoAlreadyInAlbumException
	 *             if the precondition is violated
	 */
	public void addPhoto(Photo photo) {
		if (!photos.contains(photo)) {
			photos.add(photo);
			photo.setAlbum(this);
            notifyObservers(photo.getName());
		}

	}

	/**
	 * Remove a photo from this album.
	 * 
	 * @pre getPhotos.contains(photo) == true
	 * @post @post.getPhotos.contains(photo) == false
	 /* @throws PhotoDoesNotExistException
	 *             if the precondition is violated
	 */
	public void removePhoto(Photo photo) {
		if (photos.contains(photo)) {
			photos.remove(photo);
			// Set the photo's link to its album to null just in case we haven't
			// severed all links to this photo. The photo is logically removed
			// from the system. Java will garbage collect the space taken
			// by this photo when there exists no more references to the object.
			photo.setAlbum(null);
            notifyObservers(photo.getName());
		}
	}

	/**
	 * Return access to all photos
	 * 
	 * @return An unmodifiable version of the photos set
	 */
	public Set<Photo> getPhotos() {
		return Collections.unmodifiableSet(photos);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		// Two albums are equal if their names are the same
		Album otherAlbum = (Album) o;
		return this.name.equals(otherAlbum.getName());
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public String toString() {
		return "Album(" + name + ")";
	}

	/**
	 * Display thumbnails of all photos in the album in the given viewer
	 * 
	 * @pre viewer != null
	 * @post viewer is displaying thumbnails of all photos in the album
	 * @param viewer
	 *            The viewer to use
	 * @throws ThumbnailDoesNotExistException
	 *             if the thumbnail file has been deleted
	 */
	public void display(Viewer viewer) {
		for (Photo photo : photos) {
			viewer.addImage(photo.getThumbnailImage());
		}
		viewer.display();
	}

    @Override
    public Iterator<Photo> iterator() {
        return photos.iterator();
    }
}
