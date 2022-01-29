package util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class Utility {
    public String getPath(String filename) throws URISyntaxException {
        URL res = getClass().getClassLoader().getResource(filename);
        File file = Paths.get(res.toURI()).toFile();
        return file.getAbsolutePath();
    }
}
