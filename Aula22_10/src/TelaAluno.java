import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaAluno extends JFrame implements ActionListener {
	// painel principal
	GridLayout painel_principal = new GridLayout(2, 1);

	// tela_1
	JPanel tela_1 = new JPanel();
	GridLayout oeste = new GridLayout(4, 1);
	GridLayout central = new GridLayout(4, 1, 8, 8);
	GridLayout sul = new GridLayout(1, 4, 8, 8);

	// leste
	JPanel oeste_tela_1 = new JPanel();
	JLabel id = new JLabel("ID");
	JLabel nome = new JLabel("Nome");
	JLabel ra = new JLabel("RA");
	JLabel idade = new JLabel("Idade");

	// central
	JPanel central_tela_1 = new JPanel();
	JTextField tfid = new JTextField();
	JTextField tfnome = new JTextField();
	JTextField tfra = new JTextField();
	JTextField tfidade = new JTextField();

	// sul
	JPanel sul_tela_1 = new JPanel();
	JButton sel = new JButton("Select");
	JButton ins = new JButton("Insert");
	JButton upd = new JButton("Update");
	JButton del = new JButton("Delete");

	// tela_2
	JPanel tela_2 = new JPanel();

	// norte
	JPanel norte_tela_2 = new JPanel();
	JLabel log_eventos = new JLabel("Log De Eventos");

	// center
	JPanel centro_tela_2 = new JPanel();
	TextArea log = new TextArea();

	// sul
	JPanel sul_tela_2 = new JPanel();
	GridLayout cancel = new GridLayout(1, 2);
	JPanel vazio = new JPanel();
	GridLayout cancel_end = new GridLayout(1, 2);
	JButton cancelar = new JButton("Cancel");

	public TelaAluno() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(painel_principal);
		this.setBounds(100, 100, 400, 400);
		this.add(tela_1);
		this.add(tela_2);

		tela_1.setLayout(new BorderLayout());

		tela_1.add(oeste_tela_1, BorderLayout.WEST);

		oeste_tela_1.setLayout(oeste);
		oeste_tela_1.add(id);
		oeste_tela_1.add(nome);
		oeste_tela_1.add(ra);
		oeste_tela_1.add(idade);

		tela_1.add(central_tela_1);

		central_tela_1.setLayout(central);

		central_tela_1.add(tfid);
		central_tela_1.add(tfnome);
		central_tela_1.add(tfra);
		central_tela_1.add(tfidade);

		tela_1.add(sul_tela_1, BorderLayout.SOUTH);

		sul_tela_1.setLayout(sul);

		sul_tela_1.add(sel);
		sul_tela_1.add(ins);
		sul_tela_1.add(upd);
		sul_tela_1.add(del);

		tela_2.setLayout(new BorderLayout());

		tela_2.add(norte_tela_2, BorderLayout.NORTH);
		norte_tela_2.setLayout(new GridLayout(1, 1));
		norte_tela_2.add(log_eventos);

		tela_2.add(centro_tela_2);
		centro_tela_2.setLayout(new GridLayout(1, 1));

		centro_tela_2.add(log);

		tela_2.add(sul_tela_2, BorderLayout.SOUTH);
		sul_tela_2.setLayout(cancel);
		sul_tela_2.add(new JLabel());

		sul_tela_2.add(cancelar);
		sul_tela_2.add(vazio);
		vazio.setLayout(cancel_end);
		vazio.add(new JLabel());
		vazio.add(cancelar);

		//ACIONANDO OS BOTOES
		cancelar.addActionListener(this);
		sel.addActionListener(this);
		del.addActionListener(this);
		upd.addActionListener(this);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TelaAluno();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ControleTela ct = new ControleTela();
		
		Object obj = e.getSource();
		if (obj.equals(cancelar)) {
			System.exit(0);
		} else if (obj.equals(sel)) {
			//rodar metodo select da Classe ControleTela
			ct.select(this);
		} else if (obj.equals(del)) {
			//rodar metodo select da Classe ControleTela
			ct.delete(this);
		}
		else if (obj.equals(upd)) {
			//rodar metodo select da Classe ControleTela
			ct.update(this);
		}

	}

}