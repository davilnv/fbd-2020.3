package br.com.business;

import java.util.ArrayList;

import br.com.dao.DaoPrato;
import br.com.exception.BusinessException;
import br.com.model.Prato;

public class BusinessPrato implements IBusinessPrato{
	private DaoPrato daoPrato;
	
	public BusinessPrato() {
		daoPrato = new DaoPrato();
	}

	@Override
	public Prato cadastrar(Prato prato) throws BusinessException {
		if (prato.getPreco() <= 0 || prato.getNome().trim().equals("") || prato.getDescricao().trim().equals("") || prato.getPeso() <= 0) {
			throw new BusinessException("Todos os campos devem ser preenchidos");
		}
		return daoPrato.cadastrar(prato);
	}

	@Override
	public Prato procurarPorId(int id){
		return daoPrato.procurarPorId(id);
	}

	@Override
	public ArrayList<Prato> procurarPorNome(String nome) throws BusinessException {
		if (nome.trim().equals("")) {
			throw new BusinessException("Barra de pesquisa em branco, digite o que deseja pesquisar.");
		}
		return daoPrato.procurarPorNome(nome);
	}

	@Override
	public ArrayList<Prato> listarTodos() {
		return daoPrato.listarTodos();
	}

	@Override
	public Prato alterarPrato(Prato prato) throws BusinessException {
		if (prato.getPreco() <= 0 || prato.getNome().trim().equals("") || prato.getDescricao().trim().equals("") || prato.getPeso() <= 0) {
			throw new BusinessException("Todos os campos devem ser preenchidos");
		}
		return daoPrato.alterarPrato(prato);
	}

	@Override
	public int retornarRegistrosSalvos() {
		return daoPrato.retornarRegistrosSalvos();
	}

}
