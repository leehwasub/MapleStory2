package utils;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.stream.Stream;

import maplestory.Main;

public class FileLoader {
	private static FileSystem fileSystem;

	public InputStream getFileStream(String folder, String fileName) {
		return getClass().getClassLoader().getResourceAsStream(folder + "/" + fileName);
	}

	public static ArrayList<String> getFileList(String folder) throws Exception {
		URI uri = Main.class.getResource("/" + folder).toURI();
		Path myPath;
		if (uri.getScheme().equals("jar")) {
			if (fileSystem == null) {
				fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap());
			}
			myPath = fileSystem.getPath("/" + folder, new String[0]);
		} else {
			myPath = Paths.get(uri);
		}
		Stream<Path> walk = Files.walk(myPath, 1, new FileVisitOption[0]);
		int i = 0;
		ArrayList<String> ret = new ArrayList<String>();
		for (Iterator<Path> it = walk.iterator(); it.hasNext();) {
			String filePath = ((Path) it.next()).toString();
			if (i != 0) {
				//System.out.println(filePath);
				int folderIndex = filePath.lastIndexOf("\\");
				if (uri.getScheme().equals("jar")) {
					folderIndex = filePath.lastIndexOf("/");
				}
				filePath = filePath.substring(folderIndex + 1);
				//System.out.println(filePath);
				ret.add(filePath);
			}
			i++;
		}
		return ret;
	}

	public URI getURI(String folder) throws URISyntaxException {
		return getClass().getResource("/mapText/").toURI();
	}
}
