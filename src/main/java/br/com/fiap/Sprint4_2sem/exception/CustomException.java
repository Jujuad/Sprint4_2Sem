package br.com.fiap.Sprint4_2sem.exception;

public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String mensagem;

    public CustomException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
