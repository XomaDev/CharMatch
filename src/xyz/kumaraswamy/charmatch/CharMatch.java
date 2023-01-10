package xyz.kumaraswamy.charmatch;

import java.util.ArrayList;
import java.util.List;

public class CharMatch {

   public static List<Integer> create(String text) {
      return new CharMatch(text).run();
   }

   public static List<Integer> create(String text, int nMatchLength) {
      return new CharMatch(text, nMatchLength).run();
   }

   private int MATCH_LENGTH = 3;
   private final char[] chars;

   public CharMatch(String text, int nMatchLength) {
      this(text);
      MATCH_LENGTH = nMatchLength;
   }

   public CharMatch(String text) {
      chars = text.toCharArray();
   }

   public List<Integer> run() {
      List<Integer> indexes = new ArrayList<>();

      char[] alloc = new char[MATCH_LENGTH];

      int len = chars.length;

      outer:
      for (int i = 0; i < len; i++) {
         if (i + MATCH_LENGTH > len)
            break;

         int allocIndex = 0;

         // current index + n match length
         for (int j = i; j < i + MATCH_LENGTH; j++) {
            char ch = chars[j];

            // to check for existing same
            // characters in the allocation
            for (int k = 0; k < allocIndex; k++) {
               if (alloc[k] == ch) {
                  continue outer;
               }
            }
            alloc[allocIndex++] = chars[j];
         }
         indexes.add(i);
      }
      return indexes;
   }
}
