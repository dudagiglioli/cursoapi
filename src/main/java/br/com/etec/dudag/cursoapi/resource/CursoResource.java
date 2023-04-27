package br.com.etec.dudag.cursoapi.resource;

import br.com.etec.dudag.cursoapi.model.Curso;
import br.com.etec.dudag.cursoapi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoResource {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/todos")
    public List<Curso> listarTodosOsCursos(){
        return cursoRepository.findAll();
    }
}
