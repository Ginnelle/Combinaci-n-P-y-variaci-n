import java.util.InputMismatchException;
import java.util.Scanner;

public class Proyecto3 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
        System.out.print("¿El orden de los elementos importa? (S/N): ");
        char ordenImporta = scanner.next().charAt(0);

        int n;

        if (ordenImporta == 'S') {
            System.out.print("¿Se usan todos los elementos? (S/N): ");
            char seUsanTodos = scanner.next().charAt(0);

            System.out.print("¿Se pueden repetir los elementos? (S/N): ");
            char sePuedenRepetir = scanner.next().charAt(0);

            switch (seUsanTodos) {
                case 'S':
                    switch (sePuedenRepetir) {
                        case 'S':
                            pnr();
                            break;
                        case 'N':
                            System.out.print("Ingrese el valor de n: ");
                            n = scanner.nextInt();
                            long permutacionSinRepeticion = permutacionSinRepeticion(n);
                            System.out.println("La permutación sin repetición es: " + permutacionSinRepeticion);
                            break;
                    }
                    break;
                case 'N':
                    switch (sePuedenRepetir) {
                         case 'S':
                        	 System.out.print("Ingrese el valor de n: ");
                             n = scanner.nextInt();
                             System.out.print("Ingrese el valor de r: ");
                             int r = scanner.nextInt();
                        	 long variaciónr= variacionConRepeticion(n,r);
                        	 System.out.println("La variación con repetición es: " + variaciónr);
                        	 break;
                         case 'N' :
                        	 System.out.print("Ingrese el valor de n: ");
                             n = scanner.nextInt();
                             System.out.print("Ingrese el valor de r: ");
                             r = scanner.nextInt();
                             long variacións= variacionSinRepeticion(n,r);
                             System.out.println("La variación sin repetición es: " + variacións);
                    }
            }
        } else {
            System.out.print("¿Se pueden repetir los elementos? (S/N): ");
            char sePuedenRepetir = scanner.next().charAt(0);

            switch (sePuedenRepetir) {
                case 'S':
                    System.out.print("Ingrese el valor de n: ");
                    n = scanner.nextInt();
                    System.out.print("Ingrese el valor de r: ");
                    int r = scanner.nextInt();
                    long combinacionConRepeticion = combinacionConRepeticion(n,r);
                    System.out.println("La combinación con repetición es: " + combinacionConRepeticion);
                    break;
                case 'N':
                    System.out.print("Ingrese el valor de n: ");
                    n = scanner.nextInt();
                    System.out.print("Ingrese el valor de r: ");
                    r = scanner.nextInt();
                    long combinacionSinRepeticion = combinacionSinRepeticion(n,r);
                    System.out.println("La combinación sin repetición es: " + combinacionSinRepeticion);
                    break;
            }
        }}catch (InputMismatchException e) {
            System.out.println("Error: El valor ingresado no es válido. Por favor, ingrese un valor numérico.");}
    }

    public static long permutacionSinRepeticion(int n) {
        return factorial(n);
    }

    public static long combinacionSinRepeticion(int n, int k) {
    	return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static long combinacionConRepeticion(int n, int r) {
        return factorial(n + r - 1) / (factorial(r) * factorial(n - 1));
    }

    public static long factorial(long elemento) {
        long resultado = 1;
        for (int i = 2; i <= elemento; i++) {
            resultado *= i;
        }
        return resultado;
    }
public static void pnr() {
	Scanner scanner = new Scanner(System.in);

    System.out.print("Ingrese el valor de n: ");
    int n = scanner.nextInt();

    System.out.print("Ingrese el número de elementos que se repiten: ");
    int numElementos = scanner.nextInt();

    long[] elementos = new long[numElementos];

    for (int i = 0; i < numElementos; i++) {
        System.out.print("Ingrese el valor de elemento " + (i + 1) + ": ");
        elementos[i] = scanner.nextLong();
    }

    long resultado = permutacionConRepeticion(n, elementos);

    System.out.println("La permutación con repetición es: " + resultado);
}
public static long permutacionConRepeticion(int n, long[] elementos) {
    long factorialN = factorial(n);
    long denominador = 1;

    for (long elemento : elementos) {
        denominador *= factorial(elemento);
    }

    return factorialN / denominador;
}
public static long variacionConRepeticion(int n, int r) {
    return (long) Math.pow(n, r);
}
public static long variacionSinRepeticion(int n, int r) {
	long resultado = 1;
    for (int i = n; i > n - r; i--) {
        resultado *= i;
    }
    return resultado;
}
}
