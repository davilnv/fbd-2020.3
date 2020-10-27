package br.com.dao;

import java.util.ArrayList;

import br.com.model.Prato;
import br.com.model.Produto;

public interface IDaoPrato {
	public Prato cadastrar(Prato prato);
	public Prato procurarPorId(int id);
	public ArrayList<Prato> procurarPorNome(String nome);
	public ArrayList<Prato> listarTodos();
	public Prato alterarPrato(Prato prato);
	public int retornarRegistrosSalvos();
}
