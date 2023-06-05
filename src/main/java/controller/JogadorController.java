package controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.JogadorDAO;
import DAO.PessoaDAO;
import model.Jogador;
import model.Pessoa;

@WebServlet(urlPatterns = {"/JogadorController", "/main", "/jogador"})
public class JogadorController extends HttpServlet {
			private JogadorDAO jogadorDAO;
			private PessoaDAO pessoaDAO;

	    public JogadorController() {
	        this.jogadorDAO = new JogadorDAO(); 
					this.pessoaDAO = new PessoaDAO();
	    }

			public int inserirPessoa(Pessoa pessoa) {
        return pessoaDAO.inserirPessoa(pessoa);
    	}

	    public void inserirJogador(Jogador jogador, int idPessoa) {
	        jogadorDAO.inserirJogador(jogador, idPessoa);
	    }

	    public List<Jogador> listarJogadores() {
	        return jogadorDAO.listarJogadores();
	    }
	    
	    
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String action = request.getServletPath();
							if (action.equals("/main")) {
								mostrarHome(request, response);            
							} 

							if (action.equals("/register")) {
										Pessoa pessoa = new Pessoa(
												request.getParameter("nome"),
												Integer.parseInt(request.getParameter("dob")),
												Double.parseDouble(request.getParameter("peso")),
												Double.parseDouble(request.getParameter("altura"))
												);

										int idPessoa = this.inserirPessoa(pessoa); // Obtém o ID da pessoa cadastrada

										if (idPessoa != -1) { // Verifica se o ID é válido
												Jogador jogador = new Jogador(
																pessoa.getNome(),
																pessoa.getAnoNasc(),
																pessoa.getAltura(),
																pessoa.getPeso(),
																Double.parseDouble(request.getParameter("salarioBase")),
																Double.parseDouble(request.getParameter("bonus")),
																request.getParameter("nomeCamisa"),
																request.getParameter("posicaoJoga"),
																Integer.parseInt(request.getParameter("numGolCarreira"))
														);

												this.inserirJogador(jogador, idPessoa);
										} 
							}          
	    }
	    
	    protected void mostrarHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	response.sendRedirect("index.html");       
	    }
	    
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        doGet(req,res);
	    }
}
