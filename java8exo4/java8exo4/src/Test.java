import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public void employeTest(){
        List<Employe> eList = List.of(
        new Employe ("Laure", 14500),
        new Employe ("Rihab", 12300),
        new Employe ("Aurelien", 25000),
        new Employe ("Tanguy" , 32000),
        new Employe ("Laura", 17500),
        new Employe ("Matthieu", 18700),
        new Employe ("Martin", 19000)
        );

        String chString = eList.stream()
        .filter(p -> p.getSalaire() > 15000)
        .sorted((p1, p2) -> Double.compare(p1.getSalaire(), p2.getSalaire()))
        .map(p -> (p.getSalaire() + " : " + p.getNom()))
        .collect(Collectors.joining(", "));

        System.out.println(chString);
    }
}
