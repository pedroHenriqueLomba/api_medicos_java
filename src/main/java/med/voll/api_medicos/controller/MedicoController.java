package med.voll.api_medicos.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api_medicos.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public Medico cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        return repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = "nome", direction = Sort.Direction.DESC) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @GetMapping("/{id}")
    public Medico buscaPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping
    public void atualiza(@RequestBody DadosAtualizaMedico dados){
        Medico medico = this.buscaPorId(dados.id());
        if(medico != null){
            medico.atualizarInformacoes(dados);
            repository.save(medico);
        }
    }

    @DeleteMapping("/{id}")
    public void inativa(@PathVariable Long id){
        Medico medico = this.buscaPorId(id);
        if(medico != null){
            medico.setAtivo(false);
            repository.save(medico);
        }
    }
}
