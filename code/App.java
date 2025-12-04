// Punto de entrada de la aplicación; valida argumentos y arranca la lógica.
import java.util.Optional; // Importa Optional para manejo de parámetro opcional

/** Clase App: clase con método main para ejecutar la aplicación. */
public class App { // Inicio de la clase App

    /** Método main: valida argumentos y llama a Logic. */
    public static void main(String[] args) { // Inicio de main
        if (args == null || args.length < 2) { // Si no hay al menos 2 argumentos
            System.err.println("Uso: java App <inputFile> <outputFile> [xk]"); // Mensaje de uso
            System.exit(1); // Salida con código de error
        } // fin del if
        String inFile = args[0]; // Primer argumento = archivo de entrada
        String outFile = args[1]; // Segundo argumento = archivo de salida
        Optional<Double> xk = Optional.empty(); // Inicializa Optional vacío para xk
        if (args.length >= 3) { // Si se proporcionó tercer argumento
            try { // Intenta parsear xk a double
                xk = Optional.of(Double.parseDouble(args[2])); // Asigna xk parseado
            } catch (NumberFormatException e) { // Si parseo falla
                System.err.println("Aviso: xk inválido, se ignorará. (" + e.getMessage() + ")"); // Advierte al usuario
            } // fin del catch
        } // fin del if args.length
        Logic logic = new Logic(); // Crea instancia de Logic
        logic.logic1a(inFile, outFile, xk); // Llama al método principal de la lógica
        System.out.println("Proceso finalizado. Resultados en: " + outFile); // Mensaje final
    } // fin del método main
} // fin de la clase App
