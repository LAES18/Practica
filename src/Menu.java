import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Alumno> alumnos;
    private List<Catedratico> catedraticos;
    private List<Curso> cursos;

    public Menu() {
        alumnos = new ArrayList<>();
        catedraticos = new ArrayList<>();
        cursos = new ArrayList<>();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Registrar Catedrático");
            System.out.println("3. Inscribir Alumno en Curso");
            System.out.println("4. Asignar Curso a Catedrático");
            System.out.println("5. Parquear Vehículo de Alumno");
            System.out.println("6. Parquear Vehículo de Catedrático");
            System.out.println("7. Mostrar Alumnos");
            System.out.println("8. Mostrar Catedráticos");
            System.out.println("9. Mostrar Vehículos");
            System.out.println("10. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarAlumno(scanner);
                    break;
                case 2:
                    registrarCatedratico(scanner);
                    break;
                case 3:
                    inscribirAlumnoEnCurso(scanner);
                    break;
                case 4:
                    asignarCursoACatedratico(scanner);
                    break;
                case 5:
                    parquearVehiculoAlumno(scanner);
                    break;
                case 6:
                    parquearVehiculoCatedratico(scanner);
                    break;
                case 7:
                    mostrarAlumnos();
                    break;
                case 8:
                    mostrarCatedraticos();
                    break;
                case 9:
                    mostrarVehiculos();
                    break;
                case 10:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    private void registrarAlumno(Scanner scanner) {
        System.out.print("Nombre del Alumno: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del Alumno: ");
        String id = scanner.nextLine();
        System.out.print("Carrera del Alumno: ");
        String carrera = scanner.nextLine();

        Alumno alumno = new Alumno(nombre, id, carrera);
        alumnos.add(alumno);
        System.out.println("Alumno registrado exitosamente.\n");
    }

    private void registrarCatedratico(Scanner scanner) {
        System.out.print("Nombre del Catedrático: ");
        String nombre = scanner.nextLine();
        System.out.print("ID del Catedrático: ");
        String id = scanner.nextLine();
        System.out.print("Profesion del Catedrático: ");
        String profesion = scanner.nextLine();

        Catedratico catedratico = new Catedratico(nombre, id, profesion);
        catedraticos.add(catedratico);
        System.out.println("Catedrático registrado exitosamente.\n");
    }

    private void inscribirAlumnoEnCurso(Scanner scanner) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
            return;
        }
        System.out.println("Lista de Alumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getNombre());
        }
        System.out.print("Elige el número del Alumno: ");
        int numAlumno = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Nombre del Curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Código del Curso: ");
        String codigoCurso = scanner.nextLine();

        Curso curso = new Curso(nombreCurso, codigoCurso);
        alumnos.get(numAlumno).inscribirCurso(curso);
        cursos.add(curso);
    }

    private void asignarCursoACatedratico(Scanner scanner) {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
            return;
        }
        System.out.println("Lista de Catedráticos:");
        for (int i = 0; i < catedraticos.size(); i++) {
            System.out.println(i + 1 + ". " + catedraticos.get(i).getNombre());
        }
        System.out.print("Elige el número del Catedrático: ");
        int numCatedratico = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Nombre del Curso: ");
        String nombreCurso = scanner.nextLine();
        System.out.print("Código del Curso: ");
        String codigoCurso = scanner.nextLine();

        Curso curso = new Curso(nombreCurso, codigoCurso);
        catedraticos.get(numCatedratico).asignarCurso(curso);
        cursos.add(curso);
    }

    private void parquearVehiculoAlumno(Scanner scanner) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
            return;
        }
        System.out.println("Lista de Alumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + 1 + ". " + alumnos.get(i).getNombre());
        }
        System.out.print("Elige el número del Alumno: ");
        int numAlumno = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Tipo de Vehículo (Carro/Motocicleta): ");
        String tipoVehiculo = scanner.nextLine();
        System.out.print("Placa del Vehículo: ");
        String placaVehiculo = scanner.nextLine();

        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, placaVehiculo);
        alumnos.get(numAlumno).setVehiculo(vehiculo);
        System.out.println("Vehículo registrado exitosamente.\n");
    }

    private void parquearVehiculoCatedratico(Scanner scanner) {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
            return;
        }
        System.out.println("Lista de Catedráticos:");
        for (int i = 0; i < catedraticos.size(); i++) {
            System.out.println(i + 1 + ". " + catedraticos.get(i).getNombre());
        }
        System.out.print("Elige el número del Catedrático: ");
        int numCatedratico = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Tipo de Vehículo (Carro/Motocicleta): ");
        String tipoVehiculo = scanner.nextLine();
        System.out.print("Placa del Vehículo: ");
        String placaVehiculo = scanner.nextLine();

        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, placaVehiculo);
        catedraticos.get(numCatedratico).setVehiculo(vehiculo);
        System.out.println("Vehículo registrado exitosamente.\n");
    }

    private void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.\n");
        } else {
            System.out.println("----- Lista de Alumnos -----");
            for (Alumno alumno : alumnos) {
                alumno.mostrarDetalles();
            }
            System.out.println();
        }
    }

    private void mostrarCatedraticos() {
        if (catedraticos.isEmpty()) {
            System.out.println("No hay catedráticos registrados.\n");
        } else {
            System.out.println("----- Lista de Catedráticos -----");
            for (Catedratico catedratico : catedraticos) {
                catedratico.mostrarDetalles();
            }
            System.out.println();
        }
    }

    private void mostrarVehiculos() {
        System.out.println("----- Vehículos de Alumnos -----");
        for (Alumno alumno : alumnos) {
            Vehiculo vehiculo = alumno.getVehiculo();
            if (vehiculo != null) {
                System.out.println("Alumno: " + alumno.getNombre() + " - " + vehiculo);
            }
        }
        System.out.println("----- Vehículos de Catedráticos -----");
        for (Catedratico catedratico : catedraticos) {
            Vehiculo vehiculo = catedratico.getVehiculo();
            if (vehiculo != null) {
                System.out.println("Catedrático: " + catedratico.getNombre() + " - " + vehiculo);
            }
        }
    }
}
