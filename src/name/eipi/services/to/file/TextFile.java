package name.eipi.services.to.file;

import java.io.*;

/**
 * Created by dbdon_000
 * Date: 10/08/13
 */
public class TextFile extends File {

  private boolean isNew = false;

  public boolean isNew() {
    return isNew;
  }

  public void setNew(boolean aNew) {
    isNew = aNew;
  }

  public TextFile(String pathname) {
    super(pathname);
  }

  public void write(String message)throws Exception{
    FileWriter writer = new FileWriter(this, true);
    writer.append(message);
    writer.close();
  }

  public void clear() throws Exception  {
    FileWriter writer  = new FileWriter(this);
    writer.write("");

  }

  public String read() throws Exception {
    StringBuffer buffer = new StringBuffer();
    FileReader reader  = new FileReader(this);
    BufferedReader bufferedReader = new BufferedReader(reader);
    while (bufferedReader.ready()){
      buffer.append(bufferedReader.readLine());
    }
    bufferedReader.close();
    reader.close();
    return buffer.toString();
  }



}
