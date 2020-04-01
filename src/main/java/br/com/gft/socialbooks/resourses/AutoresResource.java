package br.com.gft.socialbooks.resourses;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.MediaType;

import br.com.gft.socialbooks.domain.Autor;
import br.com.gft.socialbooks.services.AutoresService;

@RestController
@RequestMapping("/autores")
public class AutoresResource {
	
	@Autowired
	private AutoresService autoresService;
	
	@RequestMapping(method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
    })
	public ResponseEntity<List<Autor>> listar()
	{
		List<Autor> autores = autoresService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(autores);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> salvar (@Valid @RequestBody Autor autor)
	{
		autor = autoresService.salvar(autor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(autor.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Autor> buscar(@PathVariable("id") Long id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(autoresService.buscar(id));
	}
}
