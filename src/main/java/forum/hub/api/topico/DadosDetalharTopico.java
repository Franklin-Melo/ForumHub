package forum.hub.api.topico;

import java.time.LocalDateTime;

public record DadosDetalharTopico(Long id, String titulo, String mensagem, LocalDateTime data, String autor, String curso) {

    public DadosDetalharTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(),topico.getAutor(),topico.getCurso());
    }
}
