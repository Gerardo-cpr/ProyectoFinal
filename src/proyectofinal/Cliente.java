package proyectofinal;

/**
 *
 * @author gerardo, adriel, julio
 */
public class Cliente {
    private String nombre;
    private int id;
    private int mesesPagados;
    private int tiempoDePrestamo;
    private int encargadoID;
    private int deudaTotal;
    private int montoRestante;

    public Cliente(int id, String nombre, int mesesPagados, int tiempoDePrestamo, int encargadoID, int deudaTotal, int montoRestante) {
        this.id = id;
        this.nombre = nombre;
        this.mesesPagados = mesesPagados;
        this.tiempoDePrestamo = tiempoDePrestamo;
        this.encargadoID = encargadoID;
        this.deudaTotal = deudaTotal;
        this.montoRestante = montoRestante;
    }

    public int getEncargadoID() {
        return encargadoID;
    }

    public void setEncargadoID(int encargadoID) {
        this.encargadoID = encargadoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesesPagados() {
        return mesesPagados;
    }

    public void setMesesPagados(int mesesPagados) {
        this.mesesPagados = mesesPagados;
    }

    public int getTiempoDePrestamo() {
        return tiempoDePrestamo;
    }

    public void setTiempoDePrestamo(int tiempoDePrestamo) {
        this.tiempoDePrestamo = tiempoDePrestamo;
    }

    public int getdeudaTotal() {
        return deudaTotal;
    }

    public void setdeudaTotal(int deudaTotal) {
        this.deudaTotal = deudaTotal;
    }

    public float getMontoRestante() {
        return montoRestante;
    }

    public void setMontoRestante(int montoRestante) {
        this.montoRestante = montoRestante;
    }
}
