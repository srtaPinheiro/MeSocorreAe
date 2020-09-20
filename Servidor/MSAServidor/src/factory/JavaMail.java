package factory;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class JavaMail {
    private SimpleEmail email = null;
    private String emailRemetente = "mesocorreae.contato@gmail.com";
    private String senha = "8^-@%G60";

    public JavaMail() {
        try {
            this.email = new SimpleEmail();
            this.email.setFrom(emailRemetente);
            this.email.setHostName("smtp.googlemail.com");
            this.email.setSmtpPort(465);
            this.email.setTLS(true);
            this.email.setSSL(true);
            this.email.setAuthenticator(new DefaultAuthenticator(emailRemetente, senha));
        } catch (EmailException ex) {
            System.out.println("Erro ao configurar o envio de email: " + ex.getMessage());
        }
    }
    
    public void setMensagem(String msg) {
        try {
            this.email.setMsg(msg);
        } catch (EmailException ex) {
            System.out.println("Erro ao definir a mensagem do email: " + ex.getMessage());
        }
    }
    
    public void setAssunto(String assunto) {
        this.email.setSubject(assunto);
    }
    
    public void setDestinatario(String destinatario) {
        try {
            this.email.addTo(destinatario);
        } catch (EmailException ex) {
            System.out.println("Erro ao definir o destinatário do email: " + ex.getMessage());
        }
    }
    
    public boolean enviar() {
        try {
            this.email.send();
            return true;
        } catch (EmailException ex) {
            System.out.println("Erro ao enviar o email: " + ex.getMessage());
            return false;
        }
    }
    
}
