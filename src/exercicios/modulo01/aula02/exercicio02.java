void main () {
   IO.println ("===TABUADA===");
   int numero = Integer.parseInt(IO.readln("Digite um número: "));

   for (int i = 1; i <= 10; i++) {
        IO.println(numero + "x" + i + "=" + (numero * i));
    }
}
