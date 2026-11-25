public class Main {
    public static void main(String[] args) {
        Vendedor v1 = new Vendedor("V-101", "Camila Torres", 4200.50);
        Vendedor v2 = new Vendedor("V-102", "Mateo Paredes", 6850.00);
        Vendedor v3 = new Vendedor("V-103", "Sofía Andrade", 5100.75);
        Vendedor v4 = new Vendedor("V-104", "Diego Salazar", 7920.00);
        Vendedor v5 = new Vendedor("V-105", "Valeria Muñoz", 3640.25);

        EquipoVentas equipo = new EquipoVentas();

        System.out.println("=== 1. PRUEBA AGREGAR 5 VENDEDORES ===");
        System.out.println("Agregado V-101: " + equipo.agregarVendedor(v1));
        System.out.println("Agregado V-102: " + equipo.agregarVendedor(v2));
        System.out.println("Agregado V-103: " + equipo.agregarVendedor(v3));
        System.out.println("Agregado V-104: " + equipo.agregarVendedor(v4));
        System.out.println("Agregado V-105: " + equipo.agregarVendedor(v5));

        System.out.println("\n=== EQUIPO ACTUAL ===");
        System.out.println(equipo.listarVendedores());

        System.out.println("\n=== 2. PRUEBA BUSCAR ===");
        System.out.println("Existente (V-103): " + equipo.buscarPorIdentificacion("V-103"));
        System.out.println("Inexistente (V-999): " + equipo.buscarPorIdentificacion("V-999"));

        System.out.println("\n=== 3. PRUEBA VENTAS TOTALES ===");
        System.out.printf("Ventas totales del equipo: $%.2f%n", equipo.calcularVentasTotales());

        System.out.println("\n=== 4. PRUEBA MAYOR VENDEDOR ===");
        Vendedor top = equipo.obtenerMayorVendedor();
        if (top != null) {
            System.out.println("Mayor vendedor: " + top.describir());
        } else {
            System.out.println("No hay vendedores en el equipo.");
        }

        System.out.println("\n=== 5. PRUEBA ELIMINAR POR IDENTIFICACIÓN ===");
        System.out.println("Eliminar V-104 (existente): " + equipo.eliminarPorIdentificacion("V-104"));
        System.out.println("Eliminar V-999 (inexistente): " + equipo.eliminarPorIdentificacion("V-999"));
        System.out.println("Vendedor V-104 sigue existiendo fuera del equipo: " + v4.describir());

        System.out.println("\n=== ESTADO TRAS ELIMINACIÓN ===");
        System.out.println(equipo.listarVendedores());
        System.out.printf("Nuevas ventas totales: $%.2f%n", equipo.calcularVentasTotales());
        Vendedor nuevoTop = equipo.obtenerMayorVendedor();
        if (nuevoTop != null) {
            System.out.println("Nuevo mayor vendedor: " + nuevoTop.describir());
        }
    }
}