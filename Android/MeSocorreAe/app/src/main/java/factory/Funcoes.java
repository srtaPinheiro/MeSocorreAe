package factory;

public class Funcoes {

    public static String dateNormalToSql(String date){
        return date.substring(6,10) + "-" +
                date.substring(3,5) + "-" +
                date.substring(0,2);
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isNumeric(char charNum) {
        try {
            double d = Double.parseDouble(String.valueOf(charNum));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean validaData(String date) {
        if (date.length() != 10) {
            return false;
        }
        if (date.charAt(2) != '/' || date.charAt(5) != '/') {
            return false;
        }

        if (!isNumeric(date.charAt(0))) {
            return false;
        }
        if (Integer.parseInt(String.valueOf(date.charAt(0))) > 3) {
            return false;
        }
        if (!isNumeric(date.charAt(1))) {
            return false;
        }

        if (!isNumeric(date.charAt(3))) {
            return false;
        }
        if (Integer.parseInt(String.valueOf(date.charAt(3))) > 1) {
            return false;
        }
        if (!isNumeric(date.charAt(4))) {
            return false;
        }

        if (!isNumeric(date.charAt(6))) {
            return false;
        }
        if (Integer.parseInt(String.valueOf(date.charAt(6))) > 2 || Integer.parseInt(String.valueOf(date.charAt(6))) < 1) {
            return false;
        }
        if (!isNumeric(date.charAt(7))) {
            return false;
        }
        if (!isNumeric(date.charAt(8))) {
            return false;
        }
        if (!isNumeric(date.charAt(9))) {
            return false;
        }

        return true;
    }

    public static boolean validaHora(String hora) {
        if (hora.length() != 5) {
            return false;
        }
        if (hora.charAt(2) != ':') {
            return false;
        }

        if (!isNumeric(hora.charAt(0))) {
            return false;
        }
        if (Integer.parseInt(String.valueOf(hora.charAt(0))) > 2) {
            return false;
        }
        if (!isNumeric(hora.charAt(1))) {
            return false;
        }

        if (!isNumeric(hora.charAt(3))) {
            return false;
        }
        if (Integer.parseInt(String.valueOf(hora.charAt(3))) > 5) {
            return false;
        }
        if (!isNumeric(hora.charAt(4))) {
            return false;
        }

        return true;
    }

    public static String dateSqlToNormal(String date){
        return date.substring(8,10) + "/" +
                date.substring(5,7) + "/" +
                date.substring(0,4);
    }

    public static int montaAlfabetoCrip(long cpf) {
        return Integer.parseInt(
                String.valueOf(String.valueOf(cpf).charAt(1)) +
                        String.valueOf(String.valueOf(cpf).charAt(9))
        );
    }

    public static String montaChaveCrip(String dataNasc, long cpf) {
        return dataNasc + "+" + String.valueOf(cpf);
    }

    public static String strOnlyNumbers(String str) {
        String resultado = "";
        for (int x = 0; x < str.length(); x++) {
            if (Character.isDigit(str.charAt(x))){
                resultado += str.charAt(x);
            }
        }
        return resultado;
    }

    public static String formataCpf(long cpf) {
        String cpfFormatado = String.format("%011d", cpf);
        return cpfFormatado.substring(0,3) + "." +
                cpfFormatado.substring(3,6) + "." +
                cpfFormatado.substring(6,9) + "-" +
                cpfFormatado.substring(9,11);
    }

}