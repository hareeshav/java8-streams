package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    final Predicate<Car> carPredicate = car -> { return car.getPrice() < 1000; };
    cars.stream()
        .filter(carPredicate)
        .collect(Collectors.toList())
        .forEach(System.out::println);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    final Function<Person, PersonDTO> personPersonDTOFunction = person -> {
      return new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
    };
    List<PersonDTO> personDTOList = people.stream()
        .map(personPersonDTOFunction)
       /* .map(PersonDTO :: map)*/
        .collect(Collectors.toList());
    assertThat(personDTOList.size()).isEqualTo(1000);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    /*OptionalDouble average = cars.stream()
        .mapToDouble(c -> c.getPrice())
        .average();*/
    Double average = cars.stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);
    System.out.println(average);
   /* cars.stream()
        .mapToDouble(c->c.getPrice().doubleValue())
        .collect(Collectors.toList())
        .*/

  }

  @Test
  public void test() throws Exception {

  }
}



