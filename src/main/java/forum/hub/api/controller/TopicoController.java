package forum.hub.api.controller;

import forum.hub.api.dto.DadosRegistarTopico;
import forum.hub.api.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repositorio;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DadosRegistarTopico dados, UriComponentsBuilder uriBuilder){

        if (repositorio.findByTituloAndMensagem(dados.titulo(), dados.mensagem()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Tópico duplicado: já existe um tópico com o mesmo título e mensagem.");
        }
        var topico = new Topico(dados);
        repositorio.save(topico);
        var uri = uriBuilder.path(("/topicos/{id}")).buildAndExpand(topico.getId()).toUri();
//        return ResponseEntity.status(HttpStatus.CREATED).body("Tópico criado com sucesso.");
        return  ResponseEntity.created((uri)).body(new DadosDetalharTopico(topico));

    }

    @GetMapping
    public ResponseEntity<List<DadosListagemTopico>> listar(){

        List<DadosListagemTopico> topicos = repositorio.findAll().stream()
                .map(DadosListagemTopico::new)
                .toList();

        return ResponseEntity.ok(topicos);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody DadosAtualizacaoTopico dados){


            var topicoOptional = repositorio.findById(id);

            if (topicoOptional.isPresent()) {
                var topico = topicoOptional.get();
                topico.atualizarInformacoes(dados);

                repositorio.save(topico); // Salva as alterações

                return ResponseEntity.ok(new DadosDetalharTopico(topico)); // Retorna os dados atualizados
            } else {
                return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
            }


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
//       repositorio.deleteById(id);

        if (repositorio.existsById(id)) {
            repositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }


    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {


        var topico = repositorio.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalharTopico(topico));
    }
}
