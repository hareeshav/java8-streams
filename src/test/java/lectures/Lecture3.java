package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
   /* Optional<Integer> minNumber = numbers.stream()
        .min((num1, num2) -> num1 > num2 ? 1 : -1);*/
    Optional<Integer> minNumber = numbers.stream().
        min(Comparator.naturalOrder());

    assertThat(minNumber.get()).isEqualTo(1);

  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Optional<Integer> maxNumber = numbers.stream().
        max(Comparator.naturalOrder());

    assertThat(maxNumber.get()).isEqualTo(100);
  }
}
