package solucao.forma;

public class Main {

	public static void main(String[] args) {
		Forma forma1 = new Quadrado(2);
		Forma forma2 = new Circulo(2);
		Forma forma3 = new Retangulo(3, 2);
		Forma forma4 = new Triangulo(2, 2);
		
		System.out.println(forma1.area());
		System.out.println(forma2.area());
		System.out.println(forma3.area());
		System.out.println(forma4.area());
	}

}
