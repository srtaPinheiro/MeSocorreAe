package factory;

public class Funcoes {
    
    public static int montaAlfabetoCrip(long cpf) {
        return Integer.parseInt(
                String.valueOf(String.valueOf(cpf).charAt(1)) + 
                String.valueOf(String.valueOf(cpf).charAt(9))
               );
    }
    
    public static String montaChaveCrip(String dataNasc, long cpf) {
        return dataNasc + "+" + String.valueOf(cpf);
    }
    
    public static String StrOnlyNumbers(String str) {
        String resultado = "";
        for (int x = 0; x < str.length(); x++) {
            if (Character.isDigit(str.charAt(x))){
                resultado += str.charAt(x);
            }
        }
        return resultado;
    }
    
}
