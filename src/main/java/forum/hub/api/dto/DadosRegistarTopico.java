package forum.hub.api.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosRegistarTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String autor,
        @NotBlank
        String curso,

        LocalDateTime data) {
}
