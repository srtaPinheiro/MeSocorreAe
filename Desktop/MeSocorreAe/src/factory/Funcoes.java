package factory;

public class Funcoes {
    
    public static String dateNormalToSql(String date){
        return date.substring(6,10) + "-" +
               date.substring(3,5) + "-" +
               date.substring(0,2);
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
