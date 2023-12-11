package med.voll.api_medicos.controller;

import jakarta.validation.Valid;
import med.voll.api_medicos.paciente.DadosCadastroPaciente;
import med.voll.api_medicos.paciente.Paciente;
import med.voll.api_medicos.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public Paciente cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        return repository.save(new Paciente(dados));
    }
}
