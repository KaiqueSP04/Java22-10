
public class ControleTela {

	public void select (TelaAluno tela) {
		
		String txt = tela.tfid.getText();
		long x = Long.parseLong(txt);
		
		Aluno a0 = new Aluno();
		a0.setId(x);
		
		ControleBD cbd = new ControleBD();
		//Chamando o metodo select do BD
		//..este metodo retornarah um Aluno "completo"
		a0 = cbd.select(a0);
		
		//..preenchendo o campo de id (teoricamente já preenchido)
		//OBS.: como o valor eh numehrico (long), tem-se que transformar para "texto"
		tela.tfid.setText(Long.toString(a0.getId()));
		tela.tfnome.setText(a0.getNome());
		tela.tfra.setText(a0.getRa());
		tela.tfidade.setText(Integer.toString(a0.getIdade()));
		//PREENCHER os Outros Campos da Tela com os dados do objeto aluno retornado
		
	}
	

	public void delete (TelaAluno tela) {
		
		String txt = tela.tfid.getText();
		long x = Long.parseLong(txt);
		
		Aluno a0 = new Aluno();
		a0.setId(x);
		
		ControleBD cbd = new ControleBD();
		//Chamando o metodo select do BD
		//..este metodo retornarah um Aluno "completo"
		cbd.delete(a0);
		
		//..preenchendo o campo de id (teoricamente já preenchido)
		//OBS.: como o valor eh numehrico (long), tem-se que transformar para "texto"
		tela.tfid.setText("");
		tela.tfnome.setText("");
		tela.tfra.setText("");
		tela.tfidade.setText("");
		//PREENCHER os Outros Campos da Tela com os dados do objeto aluno retornado
		
	}

	public void update (TelaAluno tela) {

		Aluno a0 = new Aluno();

		String txt = tela.tfid.getText();
		long x = Long.parseLong(txt);
		a0.setId(x);

		String txt2 = tela.tfnome.getText();
		a0.setNome(txt2);

		String txt3 = tela.tfra.getText();
		a0.setRa(txt3);

		String txt4 = tela.tfidade.getText();
		int y = Integer.parseInt(txt4);
		a0.setIdade(y);

		ControleBD cbd = new ControleBD();
		//Chamando o metodo select do BD
		//..este metodo retornarah um Aluno "completo"
		cbd.update(a0);
	}

}
