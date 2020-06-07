package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    StringBuffer resultName = new StringBuffer();
    names.forEach(e->resultName.append(e).append(", "));
    System.out.println(resultName.toString().substring(0, resultName.length()-2));

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String resultString = names.stream()
        .collect(Collectors.joining(","));
    System.out.println(resultString);

  }
}
