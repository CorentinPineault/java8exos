

public class Main {
    public static void main(String[] args){
        int[] tab = { -9, 3, -8, 7, -6, 2, -1 };
        
        System.out.println("Les nombres positifs : ");
        affichagePositif(tab, ee -> ee > 0);
    }

    private static void affichagePositif(int[] tab, MyFilter object) {
    }
}