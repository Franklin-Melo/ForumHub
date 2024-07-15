package forum.hub.api.topico;

import forum.hub.api.dto.DadosRegistarTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private  String mensagem;
    private  String autor;
    private String curso;

    @Enumerated(EnumType.STRING)
    private  Status status;

    @ElementCollection
    private List<String> respostas;
    private LocalDateTime data;



    public Topico(DadosRegistarTopico dados) {

        this.titulo= dados.titulo();
        this.mensagem= dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.data = LocalDateTime.now();
        this.status = Status.NAO_RESPONDIDO;
    }

    public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
        if (dados.titulo()!=null){
            this.titulo= dados.titulo();
        }
        if (dados.mensagem()!= null){
            this.mensagem = dados.mensagem();
        }
        if (dados.curso()!=null){
            this.curso = dados.curso();
        }
        if (dados.autor()!= null){
            this.autor = dados.autor();
        }

    }





}
