//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
Livro livro1 = new Livro ("Harry Potter", "JK Rowling", 54);

String titulo = livro1.getTitulo();
String autor = livro1.getAutor();
int paginas = livro1.getPaginas();

IO.println("O titulo do livro é: " + titulo);
IO.println("O autor do livro é: " + autor);
IO.println("O livro tem" + paginas + "páginas");

}
