package med.voll.api_medicos.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api_medicos.endereco.DadosEndereco;

public record DadosAtualizaMedico(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
