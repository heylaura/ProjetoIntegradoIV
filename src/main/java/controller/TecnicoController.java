package controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.TecnicoDAO;
import DAO.PessoaDAO;
import model.Tecnico;
import model.Pessoa;

@WebServlet(urlPatterns = {"/TecnicoController", "/main", "/tecnico"})
public class TecnicoController extends HttpServlet  {
    private TecnicoDAO tecnicoDAO;
    private PessoaDAO pessoaDAO;

    public TecnicoController() {
        this.tecnicoDAO = new TecnicoDAO();
        this.pessoaDAO = new PessoaDAO();
    }

    public int inserirPessoa(Pessoa pessoa) {
        return pessoaDAO.inserirPessoa(pessoa);
    }

    public void inserirTecnico(Tecnico tecnico, int idPessoa) {
        tecnicoDAO.inserirTecnico(tecnico, idPessoa);
    }

    public List<Tecnico> listarTecnicos() {
        return tecnicoDAO.listarTecnicos();
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
                Tecnico tecnico = new Tecnico(
                        pessoa.getNome(),
                        pessoa.getAnoNasc(),
                        pessoa.getAltura(),
                        pessoa.getPeso(),
                        request.getParameter("apelido"),
                        Integer.parseInt(request.getParameter("anosExperiencia")),
                        Integer.parseInt(request.getParameter("tempoContrato")),
                        Integer.parseInt(request.getParameter("horaExtra")),
                        Double.parseDouble(request.getParameter("salarioBase"))
                    );

                this.inserirTecnico(tecnico, idPessoa);
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
