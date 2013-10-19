package name.eipi.services.appservice.file;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static java.lang.System.out;

/**
 * Created by dbdon_000
 * Date: 21/08/13
 */
public class Scanner {

  private final static FileSystem  FILE_SYSTEM;

  static{
    FILE_SYSTEM =  FileSystems.getDefault();
  }

  public  void  executeFullScan() {
    Iterable<Path> roots = FILE_SYSTEM.getRootDirectories();
    out.println("Drives found: " + roots);
    Path root = roots.iterator().next();
    out.println("Using " + root);

  }

  public void getFilesInFolder(final Path path) {

  }

  public void getSubolders(final Path path){

  }

  public void getAllChildern(final Path path) {

  }

  public void getAllToDepth(final Path path, final int depth) throws IllegalArgumentException {

  }

}

