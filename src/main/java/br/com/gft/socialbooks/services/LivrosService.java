package br.com.gft.socialbooks.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.gft.socialbooks.domain.Comentario;
import br.com.gft.socialbooks.domain.Livro;
import br.com.gft.socialbooks.repository.ComentariosRepository;
import br.com.gft.socialbooks.repository.LivrosRepository;
import br.com.gft.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {

	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	public List<Livro> listar()
	{
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id)
	{
		Livro livro = livrosRepository.findById(id).orElse(null);
		if(livro == null)
		{
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado");
		}
		return livro;
	}
	
	public Livro salvar (Livro livro)
	{
		livro.setId(null);
		livro = livrosRepository.save(livro);
		return livro;
		
	}
	
	public void deletar(Long id)
	{
		try 
		{
			livrosRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) 
		{
			throw new LivroNaoEncontradoException("O livro não pôde ser encontrado");
		}
	}
	
	public void atualizar(Livro livro)
	{
		verificarExistencia(livro); //para facilitar manutenção e entendimento do codigo
		livrosRepository.save(livro);
	}
	
	private void verificarExistencia(Livro livro)
	{
		buscar(livro.getId());
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario)
	{
		Livro livro = buscar(livroId);
		comentario.setLivro(livro);
		comentario.setData(new Date());
		
		return comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentarios(Long livroId)
	{
		Livro livro = buscar(livroId);
		return livro.getComentarios();
	}
}



