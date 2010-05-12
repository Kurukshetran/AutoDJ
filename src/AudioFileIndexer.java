import java.nio.ByteBuffer;
import java.io.File;

/**
 * abstract class AudioFileIndexer
 * 
 * provides an interface to read the metadata of an audio file
 * subclasses have to implement the actual parsing according to the file format
 * 
 * @author Florian Staudacher <florian_staudacher@yahoo.de>
 *
 */
abstract class AudioFileIndexer {

	protected File audioFile;	// contains the file handle to the audio file
	protected ByteBuffer buff;  // contains the actual metadata
	
	// here comes the metadata
	protected String title, artist, album, comment, genre, year;
	protected long 	lastModified,	// milliseconds since 1970-01-01 00:00 
					length;			// filesize in bytes
	
	/**
	 * reads the metadata in the audio file and saves it to local member variables
	 * 
	 * TODO: implement in the subclasses
	 */
	abstract void populateMetadata();
	
	/**
	 * opens the file and puts the metadata in ByteBuffer buff
	 * and places the file handle in audioFile
	 * 
	 * TODO: implement in the subclass
	 * 
	 * @param path
	 * @throws Exception 
	 */
	abstract void readFile(String path) throws Exception;
	
	/**
	 * gets infos about the file, that are not music-related
	 */
	public void getFileInfo() {
		lastModified = audioFile.lastModified();
		length = audioFile.length();
	}
}
