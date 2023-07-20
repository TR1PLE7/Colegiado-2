import javax.swing.JOptionPane;

public class DatosIglesia {
    private int Feligreses = 0;
    private String Info = "";
    private String[][] Datos;
    private int[][] Dinero;

    public void setFeligreses() {
        Feligreses = Integer.parseInt(JOptionPane.showInputDialog(null, "CANTIDAD DE FELIGRESES", null, 0));
    }

    public int getFeligreses() {
        return this.Feligreses;
    }

    public void setIglesia() {
        Datos = new String[3][Feligreses];
        for (int i = 0; i < Feligreses; i++) {
            for (int j = 0; j < 3; j++) {
                Info = JOptionPane.showInputDialog(null, "INGRESE NOMBRE DE IGLESIA \n NOMBRE DEL PASTOR \n NOMBRE FELIGRES", "DATOS", JOptionPane.INFORMATION_MESSAGE);
                Datos[j][i] = Info;
            }
        }
    }

    public String getInfo() {
        return this.Info;
    }

    public void setDiezmos() {
        Dinero = new int[3][Feligreses];
        for (int i = 0; i < Feligreses; i++) {
            for (int j = 0; j < 3; j++) {
                int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "DIGITE LA CEDULA Y DIEZMO", "ENTEROS", JOptionPane.INFORMATION_MESSAGE));
                Dinero[j][i] = valor;
            }
        }
    }

    public int[][] getDiezmos() {
        return this.Dinero;
    }

    public int getMontoTotalGanancias() {
        int totalGanancias = 0;
        for (int i = 0; i < Feligreses; i++) {
            for (int j = 0; j < 3; j++) {
                totalGanancias += Dinero[j][i];
            }
        }
        return totalGanancias;
    }

    
    public int getMontoMunicipalidadInfraestructura() {
        int totalGanancias = getMontoTotalGanancias();
        return totalGanancias / 10;
    }
    public int getMontoComedorMunicipal() {
        int totalGanancias = getMontoTotalGanancias();
        return totalGanancias / 20;
    }

    
    public int getMontoGananciaPastor() {
        int totalGanancias = getMontoTotalGanancias();
        return totalGanancias * 3 / 10;
    }

    
    public String getListaDiezmoCero() {
        StringBuilder listaDiezmoCero = new StringBuilder();
        for (int i = 0; i < Feligreses; i++) {
            for (int j = 0; j < 3; j++) {
                if (Dinero[j][i] == 0) {
                    listaDiezmoCero.append(Datos[j][i]).append("\n");
                }
            }
        }
        return listaDiezmoCero.toString();
    }

    
    public String getListaDiezmoMayor100000() {
        StringBuilder listaDiezmoMayor100000 = new StringBuilder();
        for (int i = 0; i < Feligreses; i++) {
            for (int j = 0; j < 3; j++) {
                if (Dinero[j][i] > 100000) {
                    listaDiezmoMayor100000.append(Datos[j][i]).append("\n");
                }
            }
        }
        return listaDiezmoMayor100000.toString();
    }

    
    public void mostrarInforme() {
        int montoTotalGanancias = getMontoTotalGanancias();
        int montoMunicipalidadInfraestructura = getMontoMunicipalidadInfraestructura();
        int montoComedorMunicipal = getMontoComedorMunicipal();
        int montoGananciaPastor = getMontoGananciaPastor();
        String listaDiezmoCero = getListaDiezmoCero();
        String listaDiezmoMayor100000 = getListaDiezmoMayor100000();

        StringBuilder informe = new StringBuilder();
        informe.append("Monto total de ganancias de la iglesia: ").append(montoTotalGanancias).append("\n");
        informe.append("Monto para la municipalidad infraestructura: ").append(montoMunicipalidadInfraestructura).append("\n");
        informe.append("Monto para el comedor municipal: ").append(montoComedorMunicipal).append("\n");
        informe.append("Monto de ganancia para el pastor: ").append(montoGananciaPastor).append("\n");
        informe.append("\n");
        informe.append("Lista de nombres y cédulas de las personas con diezmo igual a 0:\n").append(listaDiezmoCero).append("\n");
        informe.append("Lista de nombres y cédulas de las personas con diezmo mayor a 100000:\n").append(listaDiezmoMayor100000).append("\n");

        JOptionPane.showMessageDialog(null, informe.toString(), "Informe", JOptionPane.INFORMATION_MESSAGE);
    }


}
