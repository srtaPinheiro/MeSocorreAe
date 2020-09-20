package factory;

public class Criptografia {
    private final char alfabeto[] = {'A','B','C','D','E','F','G','H','I','J','K','L',
            'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c',
            'd','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
            'u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','@',
            '#','$','%','&','*','-','+','!','=','<','>','[',']','(',')','{','}'};
    private String chave = "";

    public Criptografia(int pAlfabeto, String pChave) {
        embaralharAlfabeto(pAlfabeto);
        chave = gerarChaveNova(pChave);
    }
    
    private void embaralharAlfabeto(int pNum){
        int wNum = pNum;
        String CasasPi = "1415926535897932384626433832795028841971693993751058" +
                         "209749445923078164062862089986280348253421170679";
        
        while(pNum >= CasasPi.length()){
            pNum -= CasasPi.length();
        }
        
        for (int i = 0; i < alfabeto.length; i++) {
            int j = (wNum / (i + 2)) * Integer.parseInt(String.valueOf(CasasPi.charAt(pNum))) 
                    + (Integer.parseInt(String.valueOf(CasasPi.charAt(i))) 
                    * (alfabeto.length + pNum - i));
            
            while (j >= alfabeto.length){
                j -= alfabeto.length;
            }
            while (j < 0){
                j += alfabeto.length;
            }
            
            char aux = alfabeto[j];
            alfabeto[j] = alfabeto[i];
            alfabeto[i] = aux;
        }
    }
    
    public String crypto(String pTexto){
        int wPosiT = 0, wPosiC = 0, aux = 0;
        String wResultado = "";
        
        for (int i = 0; i < pTexto.length(); i++) {
            for (int j = 0; j < alfabeto.length; j++) {
                if (pTexto.charAt(i) == alfabeto[j]){
                    wPosiT = j;
                    break;
                }
            }
            
            for (int j = 0; j < alfabeto.length; j++) {
                aux = i;
                while (aux >= chave.length()){
                    aux = aux - chave.length();
                }
                if (chave.charAt(aux) == alfabeto[j]){
                    wPosiC = j;
                    break;
                }
            }
            
            aux = wPosiT + wPosiC;
            while (aux >= alfabeto.length){
                aux = aux - alfabeto.length;
            }
            wResultado += alfabeto[aux];
        }
        
        return wResultado;
    }
    
    public String decrypto(String pTextoCifrado){
        int wPosiT = 0, wPosiC = 0, aux = 0;
        String wResultado = "";
        
        for (int i = 0; i < pTextoCifrado.length(); i++) {
            for (int j = 0; j < alfabeto.length; j++) {
                if (pTextoCifrado.charAt(i) == alfabeto[j]){
                    wPosiT = j;
                    break;
                }
            }
            
            for (int j = 0; j < alfabeto.length; j++) {
                aux = i;
                while (aux >= chave.length()){
                    aux = aux - chave.length();
                }
                if (chave.charAt(aux) == alfabeto[j]){
                    wPosiC = j;
                    break;
                }
            }
           
            aux = wPosiT - wPosiC;
            while (aux < 0){
                aux = aux + alfabeto.length;
            }
            wResultado += alfabeto[aux];
        }
        
        return wResultado;
    }
    
    private String gerarChaveNova(String pChave){
        String wResultado = "", wPosiValue = "";
        
        for (int i = 0; i < pChave.length(); i++) {
            wPosiValue = String.valueOf(pChave.charAt(i));
            
            if(Character.isDigit(wPosiValue.charAt(0)) && (i % 2 == 0)){
                switch(wPosiValue){
                    case "1":
                        wResultado += "%";
                        break;
                    case "2":
                        wResultado += "&";
                        break;
                    case "3":
                        wResultado += "}";
                        break;
                    default:
                        wResultado += wPosiValue;
                }
            } else if(Character.isDigit(wPosiValue.charAt(0))) {
                if (Integer.parseInt(wPosiValue) > 6){
                    wResultado += String.valueOf(alfabeto[i]);
                } else {
                    wResultado += wPosiValue;
                }
            } else {
                wResultado += wPosiValue;
            }
        }
        
        return wResultado;
    }
}