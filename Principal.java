public class Principal {
    public static void main(String[] args) {
        DatosIglesia datosIglesia = new DatosIglesia();
        datosIglesia.setFeligreses();
        datosIglesia.setIglesia();
        datosIglesia.setDiezmos();

        datosIglesia.mostrarInforme();
    }
}
