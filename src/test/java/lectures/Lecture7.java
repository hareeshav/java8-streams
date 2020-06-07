package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    List<Car> cars = MockData.getCars();
    long yellowCarCount = cars.stream()
        .filter(c -> c.getColor().equalsIgnoreCase("yellow"))
        .count();
    System.out.println(yellowCarCount);
  }

  @Test
  public void min() throws Exception {

    List<Car> cars = MockData.getCars();
    OptionalDouble yellow = cars.stream()
        .filter(c -> c.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(c -> c.getPrice())
        .min();

    System.out.println(yellow.getAsDouble());

  }

  @Test
  public void max() throws Exception {
    List<Car> cars = MockData.getCars();
    OptionalDouble yellow = cars.stream()
        .filter(c -> c.getColor().equalsIgnoreCase("yellow"))
        .mapToDouble(c -> c.getPrice())
        .max();

    System.out.println(yellow.getAsDouble());


  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    cars.stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);

  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
  }

}