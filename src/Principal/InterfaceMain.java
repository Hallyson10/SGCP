package Principal;


import java.util.ArrayList;

import controller.CONTROLLER_CELULA;
import controller.CONTROLLER_COLABORADOR;
import controller.CONTROLLER_PARTICIPANTE;
import controller.CONTROLLER_SUPERVISOR;
import entity.Colaborador;
import entity.DataCelula;
import entity.Participante;
import entity.Supervisor;
import entity.Telefone;

import javax.swing.JOptionPane;

public class InterfaceMain implements Func_Supervisor {
	static int cont;
	static InterfaceMain MAIN = new InterfaceMain();
	static Supervisor sup = new Supervisor();
	static Colaborador col = new Colaborador();
	static CONTROLLER_SUPERVISOR supervisorA = new CONTROLLER_SUPERVISOR();
	static CONTROLLER_COLABORADOR colaboradorA = new CONTROLLER_COLABORADOR();
	static CONTROLLER_CELULA celulaA = new CONTROLLER_CELULA();
	static CONTROLLER_PARTICIPANTE participanteA = new CONTROLLER_PARTICIPANTE();

	public static void start() {
		try {
			String resposta;

			resposta = JOptionPane.showInputDialog(
					"Bem-Vindo ao SGCP\n" + "" + "1 - Sou Supervisor\n" + "2 - Sou Colaborador\n" + "3 - Sair");
			if (resposta == null || resposta == "") {
			} else if (Integer.parseInt(resposta) == 1) {
				EfetuarLoginSupervisor();
			} else if (Integer.parseInt(resposta) == 2) {
				EfetuarLoginColaborador();
			} else if (Integer.parseInt(resposta) == 3) {
				System.exit(0);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!");
			start();
		}
	}

	public static void EfetuarLoginSupervisor() {
		try {
			String email;
			String matricula;

			boolean loop = true;
			while (loop) {
				email = JOptionPane.showInputDialog("Digite seu email");
				matricula = JOptionPane.showInputDialog("Digite sua matricula");
				int novaMatricula = Integer.parseInt(matricula);
				boolean validado = supervisorA.EfetuarLogin(email, novaMatricula);
				if (validado) {
					System.out.println(validado);
					sup = supervisorA.findSupervisorAtual(email);
					System.out.println(sup);
					MAIN.MenuSupervisor(sup);
					loop = false;
					//
				} else {

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!");
			start();
		}
	}

	public static void EfetuarLoginColaborador() {
		try {
			String email;
			String matricula;

			boolean loop = true;
			while (loop) {
				email = JOptionPane.showInputDialog("Digite seu email");
				matricula = JOptionPane.showInputDialog("Digite sua matricula");
				int novaMatricula = Integer.parseInt(matricula);
				boolean validado = colaboradorA.EfetuarLogin(email, novaMatricula);
				if (validado) {
					System.out.println(validado);
					col = colaboradorA.FindColaboradorAtual(novaMatricula);
					MenuColaborador(col);

					loop = false;
					//
				} else {
					JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!");
					start();
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!");
			start();
		}
	}

	public void MenuSupervisor(Supervisor sup) {
		try {
			String opcao;
			opcao = JOptionPane.showInputDialog(null,
					"Bem-vindo " + sup.getNome() + "\n" + "Matrícula " + sup.getMatricula() + "\n"
							+ "1 - Cadastrar Colaborador\n" + "2 - Remover Colaborador\n" + "3 - Editar Colaborador\n"
							+ "4 - Cadastrar célula\n" + "5 - Remover célula\n" + "6 - Editar célula\n"
							+ "7 - Buscar células\n" + "8 - Buscar Colaboradores\n" + "9 - Relatório Célula\n"
							+ " 11 - sair");

			int op = Integer.parseInt(opcao);
			if (op == 1) {
				MAIN.CadastrarColaborador();
				MenuSupervisor(sup);
			} else if (op == 2) {
				MAIN.RemoveColaborador();
				MenuSupervisor(sup);
			} else if (op == 3) {
				MAIN.updateColaborador();
				MenuSupervisor(sup);
			} else if (op == 4) {
				MAIN.CadastrarCelula();
				MenuSupervisor(sup);
			} else if (op == 5) {
				MAIN.FindCelula();
				MAIN.DeleteCelula();
				MenuSupervisor(sup);
			} else if (op == 7) {
				MAIN.FindCelula();
				MenuSupervisor(sup);
			} else if (op == 8) {
				MAIN.BuscaColaboradores();
				MenuSupervisor(sup);
				if (sup != null && col == null) {
					MenuSupervisor(sup);
					System.out.println("não");
				}
			} else if (op == 11) {
				JOptionPane.showMessageDialog(null, "Supervisor Deslogado!");
				start();
			} else if (opcao == null || opcao == "") {
				System.exit(0);
			} else {
				MenuSupervisor(sup);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!");
			MenuSupervisor(sup);
		}
	}

	public static void MenuColaborador(Colaborador col) {
		try {
			String opcao;
			opcao = JOptionPane.showInputDialog(null,
					"Bem-vindo " + col.getNome() + "\n" + "Matrícula " + col.getMatricula() + "\n"

							+ "1 - Cadastrar célula\n" + "2 - Remover célula\n" + "3 - Editar célula\n"
							+ "4 - Buscar células\n" + "5 - Relatório Célula\n" + "6 - Cadastrar Participante\n"
							+ " 7 - Realizar Frequência\n" + " 8 - sair");

			int op = Integer.parseInt(opcao);
			if (op == 1) {
				MAIN.CadastrarCelula();
				MenuColaborador(col);
			} else if (op == 2) {
				JOptionPane.showMessageDialog(null, "Ainda não implementado :( !");
				MenuColaborador(col);
			} else if (op == 3) {
				JOptionPane.showMessageDialog(null, "Ainda não implementado :( !");
				MenuColaborador(col);
			} else if (op == 4) {
				MAIN.FindCelula();
				MenuColaborador(col);
			} else if (op == 5) {
				MAIN.FindCelula();
				MAIN.DeleteCelula();
				MenuColaborador(col);
			} else if (op == 6) {
				MAIN.CadastrarParticipante();
				MenuColaborador(col);
			} else if (op == 8) {
				JOptionPane.showMessageDialog(null, "Colaborador Deslogado!");
				start();
			} else if (opcao == null || opcao == "") {
				System.exit(0);
			} else {
				MenuColaborador(col);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!");
			MenuColaborador(col);
		}
	}

	public void CadastrarColaborador() {
		try {
			System.out.println("entrou no cadastrar colab");
			String nome, email, curso;
			String matricula, semestre;
			boolean loop = true;
			while (loop) {
				nome = JOptionPane.showInputDialog("Digite o nome completo do colaborador");
				email = JOptionPane.showInputDialog("Digite o email do colaborador");
				matricula = JOptionPane.showInputDialog("Digite a matricula do colaborador");
				curso = JOptionPane.showInputDialog("Digite o curso do colaborador");
				semestre = JOptionPane.showInputDialog("Digite o semestre do colaborador");
				int novaMatricula = Integer.parseInt(matricula), novoSemestre = Integer.parseInt(semestre);
				int newMatricula_supervisor = sup.getMatricula();
				Colaborador colaborador = new Colaborador();
				colaborador.setNome(nome);
				colaborador.setEmail(email);
				colaborador.setMatricula(novaMatricula);
				colaborador.setMatricula_supervisor(newMatricula_supervisor);
				colaborador.setCurso(curso);
				colaborador.setSemestre(novoSemestre);
				System.out.println(colaborador);
				if (supervisorA.CadastrarColaborador(colaborador)) {
					loop = false;
					MAIN.MenuSupervisor(sup);
				} else {
					JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!");
				}

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!");
			MenuSupervisor(sup);
		}
	}

	public void RemoveColaborador() {
		String id;
		try {
			BuscaColaboradores();
			id = JOptionPane.showInputDialog("Digite a matricula do colaborador que deseja remover");
			int novoId = Integer.parseInt(id);
			col = colaboradorA.FindColaboradorAtual(novoId);
			if (supervisorA.deleteColaborador(novoId)) {
				JOptionPane.showInternalMessageDialog(null, "Você removeu " + col.getNome() + " com sucesso!");
				System.out.println("Você removeu " + col.getNome() + " com sucesso!");
				MenuSupervisor(sup);
			}
		} catch (Exception e) {
			MenuSupervisor(sup);
		}

	}

	public void updateColaborador() {

		String nome, email, matricula, curso, semestre;

		try {
			matricula = JOptionPane.showInputDialog("Digite a matricula do colaborador para atualizar");
			int newMatricula = Integer.parseInt(matricula);
			if (colaboradorA.FindColaboradorAtual(newMatricula) != null) {
				String newMatriculaA = JOptionPane.showInputDialog("Nova matrícula do colaborador");
				nome = JOptionPane.showInputDialog("Digite um novo nome");
				email = JOptionPane.showInputDialog("Digite um novo email");
				curso = JOptionPane.showInputDialog("Digite o novo curso");
				String matricula_supervisor = JOptionPane.showInputDialog("Nova matrícula do supervisor");
				semestre = JOptionPane.showInputDialog("Digite o novo semestre");
				int newSemestre = Integer.parseInt(semestre);
				int newMatricula_supervisor = Integer.parseInt(matricula_supervisor);
				int newMatriculaB = Integer.parseInt(newMatriculaA);
				System.out.println("chamando a função edite");
				supervisorA.EditeColaborador(nome, email, newMatriculaB, newMatricula_supervisor, curso, newSemestre,
						newMatricula);
				System.out.println(newMatriculaB);
				MenuSupervisor(sup);
			} else {

				JOptionPane.showMessageDialog(null, "Não existe um colaborador com esse ID,tente novamente");
				updateColaborador();

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!");
			MenuSupervisor(sup);
		}

	}

	@Override
	public void CadastrarCelula() {
		try {
			if (sup.getMatricula() != 0) {
				BuscaColaboradores();
				cont++;
				String matricula_colaborador = JOptionPane.showInputDialog("matricula do colaborador");
				int matriculaColaborador = Integer.parseInt(matricula_colaborador);
				if (colaboradorA.FindColaboradorAtual(matriculaColaborador) != null) {
					String nome = JOptionPane.showInputDialog("Nome da celula");
					String descricao = JOptionPane.showInputDialog("Descreva sua celula");
					String bloco = JOptionPane.showInputDialog("Bloco onde ocorrerá a célula");
					String sala = JOptionPane.showInputDialog("Sala onde ocorrerá a célula");
					String qtdHoras = JOptionPane.showInputDialog("Quantas horas tem cada encontro?");
					int qtdHora = Integer.parseInt(qtdHoras);
					if (nome == null || descricao == null || bloco == null || sala == null) {
						CadastrarCelula();
						return;
					}
					celulaA.CadastrarCelula(cont, matriculaColaborador, nome, descricao, bloco, sala, qtdHora);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário inexistente, tente novamente");
					CadastrarCelula();
				}
			} else {
				BuscaColaboradores();

				int matriculaColaborador = col.getMatricula();
				if (colaboradorA.FindColaboradorAtual(matriculaColaborador) != null) {
					String nome = JOptionPane.showInputDialog("Nome da celula");
					String descricao = JOptionPane.showInputDialog("Descreva sua celula");
					String bloco = JOptionPane.showInputDialog("Bloco onde ocorrerá a célula");
					String sala = JOptionPane.showInputDialog("Sala onde ocorrerá a célula");
					String qtdHoras = JOptionPane.showInputDialog("Quantas horas tem cada encontro?");
					int qtdHora = Integer.parseInt(qtdHoras);
					if (nome == null || descricao == null || bloco == null || sala == null) {
						CadastrarCelula();
						return;
					}
					celulaA.CadastrarCelula(cont, matriculaColaborador, nome, descricao, bloco, sala, qtdHora);
				} else {
					JOptionPane.showMessageDialog(null, "Usuário inexistente, tente novamente");
					CadastrarCelula();
				}

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuário inexistente, tente novamente");
			if (sup.getMatricula() == 0 && col.getMatricula() != 0) {
				MenuColaborador(col);
			} else if (sup.getMatricula() == 0 && col.getMatricula() != 0) {
				MenuSupervisor(sup);
			}

		}

	}

	@Override
	public void FindCelula() {
		try {
			ArrayList<entity.Celula> data;
			data = celulaA.findCelula();
			System.out.println("Todas as células PACCE 2019.2\n");
			for (int i = 0; i < data.size(); i++) {
				System.out.println(data.get(i).getNome() + " Descrição " + data.get(i).getDescricao() + " ID "
						+ data.get(i).getId_celula());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houvestes um erro");
		}
	}

	@Override
	public void FindMysCelula() {
		// Buscar nome, horário,dias, descrição e nome do colaborador que tem supervisor
		// na celula
		supervisorA.FindMysCelula();

	}

	public void BuscaColaboradores() {
		try {
			ArrayList<Colaborador> col = colaboradorA.BuscaColaboradores();
			for (int i = 0; i < col.size(); i++) {
				System.out.println(col.get(i).getNome() + " Matrícula: " + col.get(i).getMatricula() + " Curso: "
						+ col.get(i).getCurso() + " Semestre: " + col.get(i).getSemestre());
			}
			// MenuSupervisor(sup);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro!");
			MenuSupervisor(sup);
		}
	}

	public void CadastrarParticipante() {
		try {
			String nome;
			String id_celula;
			String email;
			String matricula;
			String curso;
			String semestre;
			String ddd;
			String num;

			FindCelula();
			id_celula = JOptionPane.showInputDialog("Insira o id da celula");
			int newIdCelula = Integer.parseInt(id_celula);
			if (celulaA.VerificaCelula(newIdCelula)) {
				nome = JOptionPane.showInputDialog("Insira o nome do participante");
				email = JOptionPane.showInputDialog("Insira o email do participante");
				matricula = JOptionPane.showInputDialog("Insira a matricula do participante");
				curso = JOptionPane.showInputDialog("Insira o curso do participante");
				semestre = JOptionPane.showInputDialog("Insira o semestre do participante");
				ddd = JOptionPane.showInputDialog("Insira o DDD do numero de telefone");
				num = JOptionPane.showInputDialog("Insira o numero de telefone sem o DDD");
				int newMatricula = Integer.parseInt(matricula), newSemestre = Integer.parseInt(semestre),
						newDdd = Integer.parseInt(ddd);
				int newNum = Integer.parseInt(num);
				System.out.println("entrando no cria participas");
				Participante participante = new Participante();
				participante.setNome(nome);
				participante.setEmail_participante(email);
				participante.setMatricula_participante(newMatricula);
				participante.setCurso(curso);
				participante.setSemestre(newSemestre);
				Telefone tel = new Telefone(newDdd, newNum);
				participante.setTelefone(tel);
				System.out.println("passou por participante");
				if (participanteA.CadastrarParticipante(participante, newIdCelula)) {
					JOptionPane.showMessageDialog(null, "cadastrado com sucesso na célula " + newIdCelula);

				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!");
			MenuColaborador(col);
		}
	}

	public DataCelula CadastraDataCelula(DataCelula dt) {
		return dt;
	}

	public void DeleteCelula() {
		try {
			String id = JOptionPane.showInputDialog("Digite o ID da célula que deseja remover!");
			int id_celula = Integer.parseInt(id);
			if (celulaA.VerificaCelula(id_celula)) {
				celulaA.RemoveCelula(id_celula);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!");
			if (sup.getMatricula() == 0 && col.getMatricula() != 0) {
				MenuColaborador(col);
			} else if (sup.getMatricula() != 0 && col.getMatricula() == 0) {
				MenuSupervisor(sup);
			}
		}

	}

	@Override
	public void UpdateCelula() {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteCelula(int id_celula) {
		// TODO Auto-generated method stub

	}
}
