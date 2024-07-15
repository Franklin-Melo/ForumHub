package forum.hub.api.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id, String titulo, String mensagem, LocalDateTime data, Status status, String autor, String curso) {

    public DadosListagemTopico(Topico topico){

        this(topico.getId(),topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
