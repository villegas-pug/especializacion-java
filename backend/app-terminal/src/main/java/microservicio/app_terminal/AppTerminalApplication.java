package microservicio.app_terminal;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;
import microservicio.app_terminal.Models.Departamento;
import microservicio.app_terminal.repositories.DepartamentoRepository;

@SpringBootApplication
@Log4j2
public class AppTerminalApplication implements CommandLineRunner {

	@Autowired
	DepartamentoRepository departamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppTerminalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("░ MENÚ:");
			System.out.println("1. Agregar departamento");
			System.out.println("2. Buscar departamento por código");
			System.out.println("3. Listar todos los departamentos");
			System.out.print("Seleccione una opción: ");

			int opcion = scanner.nextInt();

			scanner.nextLine();

			switch (opcion) {
				case 1:
					System.out.println("Nuevo departamento:");
					String nombre = scanner.nextLine();

					Departamento departamento = Departamento
							.builder()
							.nombre(nombre)
							.activo(true)
							.build();

					departamentoRepository.saveDepartamento(departamento);

					// departamentoRepository.listarEmpleados().forEach(System.out::println);
					break;
				case 2:
					/*
					 * System.out.print("\nIngrese el nombre del nuevo empleado: ");
					 * String nombre = scanner.nextLine();
					 * departamentoRepository.agregarEmpleado(nombre);
					 * System.out.println("✅ Empleado agregado con éxito.");
					 */
					break;
				case 3:
					System.out.println("👋 Saliendo...");
					scanner.close();
					return;
				default:
					System.out.println("❌ Opción inválida. Intente de nuevo.");
			}
		}

	}

}
