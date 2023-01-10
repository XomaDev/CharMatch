import xyz.kumaraswamy.charmatch.CharMatch;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Main {

   private static final File ROOT = new File(System.getProperty("user.dir"));

   public static void main(String[] args) throws IOException {

      // length = 5
      // index = 0; at A
      // 0:
      String text = Files.readString(new File(ROOT, "texts.txt").toPath());

      long start = System.currentTimeMillis();
      List<Integer> ints = CharMatch.create(text, 14);

      System.out.printf("Took %d ms, found %d unique sequences",
              System.currentTimeMillis() - start,
              ints.size());
   }

}