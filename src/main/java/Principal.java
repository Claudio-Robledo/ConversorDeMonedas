import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        List<String> historial = new ArrayList<>();  // Historial de conversiones
        String baseCode;
        String target_code;
        double monto;

        String menu = """
                **************************************************************
                Sea bienvenido/a el Conversor de Moneda =]
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Dólar =>> Euro
                8) Euro =>> Dólar
                9) Dólar =>> Yen japonés
                10) Yen japonés =>> Dólar
                11) Ver historial de conversiones
                12) Salir
                Elija una opción válida:
                
                **************************************************************
                """;
        int opcion = 1;

        while (opcion != 12) {
            System.out.println(menu);
            opcion = teclado.nextInt();

            if (opcion == 11) {
                // Mostrar historial de conversiones
                if (historial.isEmpty()) {
                    System.out.println("No se han realizado conversiones todavía.");
                } else {
                    System.out.println("Historial de conversiones:");
                    for (String registro : historial) {
                        System.out.println(registro);
                    }
                }
                continue;
            }

            if (opcion == 12) break;

            System.out.println("Ingrese el valor que desea convertir:");
            monto = teclado.nextDouble();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
           // LocalDateTime fechaHora = LocalDateTime.parse(LocalDateTime.now().format(formatter));

            switch (opcion) {
                case 1 -> {
                    baseCode = "USD";
                    target_code = "ARS";
                }
                case 2 -> {
                    baseCode = "ARS";
                    target_code = "USD";
                }
                case 3 -> {
                    baseCode = "USD";
                    target_code = "BRL";
                }
                case 4 -> {
                    baseCode = "BRL";
                    target_code = "USD";
                }
                case 5 -> {
                    baseCode = "USD";
                    target_code = "COP";
                }
                case 6 -> {
                    baseCode = "COP";
                    target_code = "USD";
                }
                case 7 -> {
                    baseCode = "USD";
                    target_code = "EUR";
                }
                case 8 -> {
                    baseCode = "EUR";
                    target_code = "USD";
                }
                case 9 -> {
                    baseCode = "USD";
                    target_code = "JPY";
                }
                case 10 -> {
                    baseCode = "JPY";
                    target_code = "USD";
                }
                default -> {
                    System.out.println("Opción no válida");
                    continue;
                }
            }

            Moneda moneda = consulta.convertirMoneda(baseCode, target_code, monto);
            String resultado = " El valor " + monto + moneda.toString() + " Fecha y hora: " + LocalDateTime.now().format(formatter);
            System.out.println(resultado);

            // Guardar en el historial
            historial.add(resultado);
        }
        System.out.println("Saliendo del conversor de monedas");
        teclado.close();
    }
}
