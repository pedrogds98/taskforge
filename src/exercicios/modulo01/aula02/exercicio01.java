void main () {
    IO.println("===VERIFICADOR DE IDADE===");
    int idade = Integer.parseInt(IO.readln("Digite sua idade: "));

    if (idade >= 18) {
        IO.println("Sua idade é:" + idade + "anos");
        IO.println("VOCÊ É MAIOR DE 18 ANOS");
    }
    else{
        IO.println("Sua idade é:" + idade + "anos");
        IO.println("VOCÊ É MENOR DE 18 ANOS");
    }
}


