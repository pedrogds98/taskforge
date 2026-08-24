package src.exercicios.modulo02.aula01.exercicio05;


public class Retangulo {
    int base;
    int altura;

    public Retangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;

    }

    void perimetro() {
        int perimetro = (base * 2) + (altura * 2);
        IO.println("Perimêtro: " + perimetro);

    }

    void area() {
        int area = (base * altura);
        IO.println("Área: " + area);
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;

    }

}
