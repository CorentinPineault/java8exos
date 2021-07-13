import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.*;
import java.util.Collection;
import java.util.Comparator;
public class App {
    public static void main(String[] args) throws Exception {
        /*
        List<Personne> listPersonnes = new ArrayList<>();
        listPersonnes.add(new Personne("Billy", "bob", "H", 1994));
        listPersonnes.add(new Personne("Jilly", "Cob", "F", 1984));
        listPersonnes.add(new Personne("Silly", "Cob", "H", 1976));
        listPersonnes.add(new Personne("Lilly", "Lob", "F", 1995));
        listPersonnes.add(new Personne("Zilly", "Zob", "H", 1992));
        listPersonnes.add(new Personne("AA", "AA", "H", 1946));

        
        System.out.println("Hello, World!");*/

        Stream<String> txtFile = Files.lines(Paths.get("/Users/java/Documents/Java/java8exos/java8exos/java8exo3/java8exo3/src/personnes.txt"));

        List<Personne> txtStream = txtFile
        .skip(1)
        .map(v -> v.split(","))
        .map(new Function<String[],Personne>(){

            @Override
            public Personne apply(String[] line) {
                // TODO Auto-generated method stub
                return new Personne(line[1], line[0], line[4].strip(), line[5].strip(), Integer.parseInt(line[2].strip()), Double.parseDouble(line[3]));
            }
            
        })
        .collect(Collectors.toList());

        System.out.println("1- Afficher les personnes nées après 1991");
        
        txtStream.stream().filter(p -> p.getAnnee_naissance() > 1991).forEach(System.out::println);
        System.out.println("");

        System.out.println("2- Afficher le nom des personnes nées en 1995");
        txtStream.stream().filter(p -> p.getAnnee_naissance() == 1995).map(Personne::getNom).forEach(System.out::println);
        System.out.println("");

        System.out.println("3- Afficher le nom des personnes nées avant 1990, triés par ordre alphabétique sur leur nom, et afficher leur nombre");
        txtStream.stream().filter(p -> p.getAnnee_naissance() < 1990).map(Personne::getNom).sorted().forEach(System.out::println);
        System.out.println(txtStream.stream().filter(p -> p.getAnnee_naissance() < 1990).count());
        System.out.println("");

        System.out.println("4- Afficher tous les noms et prénoms, triés par ordre alphabétique sur leur nom et leur prénom");
        txtStream.stream()
        .sorted((p1, p2) -> p1.getNom().toLowerCase().compareTo(p2.getNom().toLowerCase()))
        .sorted((p1, p2) -> p1.getPrenom().toLowerCase().compareTo(p2.getPrenom().toLowerCase()))
        .forEach(p -> System.out.println(p.getPrenom() + " " + p.getNom()));
        System.out.println("");
        
        System.out.println("5- Afficher les personnes ayant un genre 'F' et le nom qui commence par la lettre ‘j’");
        txtStream.stream().filter(p -> p.getGenre().equalsIgnoreCase("F")).filter(p -> p.getNom().startsWith("J")).forEach(System.out::println);
        System.out.println("");

        System.out.println("6- Transformer le genre des personnes en lettre minuscule et afficher ceux ayant un genre 'h'");
        txtStream.stream().forEach(p -> p.setGenre(p.getGenre().toLowerCase()));
        txtStream.stream().filter(p -> p.getGenre().equals("h")).forEach(System.out::println);
        System.out.println("");

        int max = txtStream.stream().map(Personne::getAnnee_naissance).max(Comparator.naturalOrder()).orElse(0);
        System.out.println(max);
        System.out.println("");

        Double avg = txtStream.stream().filter(p -> p.getVille().equals("Lyon")).mapToDouble(i -> i.getSalaire()).average().orElse(0);
        System.out.println(avg);
        System.out.println("");

        
    }
}
