import java.util.ArrayList;

public class EquipoVentas {
    private ArrayList<Vendedor> vendedores;

    public EquipoVentas() {
        this.vendedores = new ArrayList<>();
    }

    public boolean agregarVendedor(Vendedor vendedor) {
        if (vendedor == null || vendedor.getIdentificacion() == null) {
            return false;
        }
        for (Vendedor v : vendedores) {
            if (v.getIdentificacion().equalsIgnoreCase(vendedor.getIdentificacion())) {
                return false;
            }
        }
        vendedores.add(vendedor);
        return true;
    }

    public boolean eliminarPorIdentificacion(String identificacion) {
        if (identificacion == null) {
            return false;
        }
        for (int i = 0; i < vendedores.size(); i++) {
            Vendedor v = vendedores.get(i);
            if (v != null && v.getIdentificacion() != null
                    && v.getIdentificacion().equalsIgnoreCase(identificacion)) {
                vendedores.remove(i);
                return true;
            }
        }
        return false;
    }

    public String buscarPorIdentificacion(String identificacion) {
        if (identificacion == null) {
            return "Identificación inválida.";
        }
        for (Vendedor v : vendedores) {
            if (v != null && v.getIdentificacion() != null
                    && v.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return v.describir();
            }
        }
        return "No se encontró ningún vendedor con identificación: " + identificacion;
    }

    public double calcularVentasTotales() {
        double total = 0.0;
        for (Vendedor v : vendedores) {
            if (v != null) {
                total += v.getVentas();
            }
        }
        return total;
    }

    public Vendedor obtenerMayorVendedor() {
        if (vendedores.isEmpty()) {
            return null;
        }
        Vendedor mayor = null;
        for (Vendedor v : vendedores) {
            if (v != null) {
                if (mayor == null || v.getVentas() > mayor.getVentas()) {
                    mayor = v;
                }
            }
        }
        return mayor;
    }

    public String listarVendedores() {
        if (vendedores.isEmpty()) {
            return "El equipo no tiene vendedores registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vendedores.size(); i++) {
            sb.append(i + 1).append(". ").append(vendedores.get(i).describir());
            if (i < vendedores.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}