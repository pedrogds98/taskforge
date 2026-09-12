import java.util.ArrayList;
import java.util.List;


void main() {
    List<Forma> formas = new ArrayList<>();

    formas.add(new Circulo("Circulo1,", 5.0));
    formas.add(new Quadrado("Quadrado", 4));

    for (Forma item : formas) {
        item.mostrar();
    }

}
abstract public class Forma {
    String nome;

    public Forma(String nome) {
        this.nome = nome;
    }

    public abstract double area();

    public void mostrar() {
        IO.println(nome + ": " + area());
    }
}
     public class Circulo extends Forma  {
         double raio;
         public Circulo(String nome, double raio) {
             super(nome);
             this.raio = raio;
         }

         @Override
         public double area() {
             return 3.14 * raio * raio;
         }
     }

     public class Quadrado extends Forma {
         double lado;
         public Quadrado(String nome, double lado) {
             super(nome);
             this.lado = lado;
         }

         @Override
         public double area() {
             return lado * lado;
         }
     }



