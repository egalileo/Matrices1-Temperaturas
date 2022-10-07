package sandbox2;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Sandbox2 {

    public static void main(String[] args) {
        JTextArea hoja = new JTextArea();
        double matriz[][] = new double[24][7];
        String dia[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        String salida = "";
        boolean salir = false;
        int opcion, fila, columna, hora = 0, cualHora;
        double promedio = 0;

        for (fila = 0; fila < 24; fila++) {
            for (columna = 0; columna < 7; columna++) {
                matriz[fila][columna] = (Math.random() * 65) - 15;
            }
        }

        while (!salir) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desee\n1. Mostrar todo el registro"
                    + "\n2. Promedio por dia\n3. Promedio por Horas\nCualquier otro para salir"));
            hora = 0;
            promedio = 0;
            salida = "";
            if (opcion == 1) { //Mostrar toda la matriz y el vector
                salida += "\t";
                for (columna = 0; columna < 7; columna++) {
                    salida += dia[columna] + "\t";
                }
                salida += "\n";
                for (fila = 0; fila < 24; fila++) {
                    salida += hora + ":00\t";
                    hora++;
                    for (columna = 0; columna < 7; columna++) {

                        salida += String.format("%.2f", matriz[fila][columna]) + "\t";
                    }
                    salida += "\n";
                }
                hoja.setText(salida);
                JOptionPane.showMessageDialog(null, hoja);
            } else if (opcion == 2) { //Promedio por dia (Columnas)
                for (columna = 0; columna < 7; columna++) {
                    for (fila = 0; fila < 24; fila++) {
                        promedio += matriz[fila][columna];
                    }
                    promedio /= 24;
                    salida += dia[columna] + " =" + String.format("%.2f", promedio) + "°C\n";
                }
                JOptionPane.showMessageDialog(null, salida);
            } else if (opcion == 3) { // promedio por horas (filas)
                cualHora = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora que desea promediar (Formato de 24h)"));
                if (cualHora >= 0 && cualHora <= 23) { // correcto

                    for (columna = 0; columna < 7; columna++) {
                        promedio += matriz[cualHora][columna];
                    }

                    promedio /= 7;
                    salida += "EL promedio de la hora " + cualHora + ":00 \nes: " + String.format("%.2f", promedio) + "°C";
                    JOptionPane.showMessageDialog(null, salida);

                } else { //error
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
            } else if (opcion == 4) {//Calcular promedio de temperatura solamente de un dia ingresado por el usuario

            }else if(opcion == 5){ //Calcular el dia con la temperatura mas baja y su hora
                
            } else if(opcion == 6){ //Calcular el dia con la temperatura mas alta y su hora
                
            }else if(opcion==7){ //Calcular el promedio de temperatura en fin de semana
                
            }else if(opcion==8){ //Calcular promedio de temperatura semanal de 6AM a 6PM
                
            }
            else {
                break;
            }

        }

    }

}
