package med.voll.api.domain.consulta;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "consulta_id")
        Long idConsulta,
        @NotNull
        String motivoCancelamento) {
}
