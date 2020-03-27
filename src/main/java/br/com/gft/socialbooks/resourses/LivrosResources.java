package br.com.gft.socialbooks.resourses;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gft.socialbooks.domain.Livro;
import br.com.gft.socialbooks.repository.LivrosRepository;

@RestController
public class LivrosResources {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@RequestMapping (value = "/livros", method = RequestMethod.GET)
	public List<Livro> listar()
	{
		return livrosRepository.findAll();
		
		
		//livrosRepository.findAll();
		//return Arrays.asList(livros);
	}

}
