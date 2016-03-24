package com.controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metier.Facture;
import com.metier.Habitation;
import com.metier.Usager;
import com.persistance.AccesData;

/**
 * Servlet implementation class ServVue
 */
@WebServlet("/ServVue")
public class ServVue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServVue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// on g�n�re la sortie html qui met en page les donn�es
				response.setContentType("text/html");
				response.setCharacterEncoding( "UTF-8" );
				// instanciation d'un objet Printer
				PrintWriter out = response.getWriter();
				// entete page html
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset=\"utf-8\" />");
				out.println("<title>Formulaire authentification</title>");
				out.println("</head>");
				// lien vers le fichier javascript de controles � la saisie
				out.println("<script type='text/javascript' src='js/controle.js'></script>");
				out.println("<body>");
				out.println("<H1> <img src='img/Trisel.jpg' width='150' height='150'> Acc�s au portail de la Communaut� des Communes</H1>");
				// on r�cup�re le message �ventuel si il ne s'agit pas de l'appel initial au formulaire
				String message = request.getParameter("message");
				// on affiche le message
				if (message!=null) {
				out.println("<font color=Red>" + message + "</br></font>");
				}
				out.println("<p>Veuillez vous authentifier avec le code usager et le mot de passe que vous avez re�u par courrier</p>");
				out.println("<form name = 'authentification' method='post' onSubmit='return verifForm(this)' action='./ServVue'>");
				out.println("<table >");
				out.println("<tr>");
				out.println("<td>code usager</td>");
				out.println("<td><input type=text name=user></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>mot de passe</td>");
				out.println("<td><input type=text name=mdp></td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<input type=submit name=valider value = valider>");
				out.println("<input type=reset name=annuler value = annuler>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// on r�cup�re les donn�es du formulaire
		String user = request.getParameter("user");
		String mdp = request.getParameter("mdp");
		// on fait appel au mod�le pour r�cup�rer l'�ventuel usager
		Usager usag = AccesData.getUsager(user, mdp);
		if (usag==null) {
			// on d�finit le message d'erreur
			String message = "Authentification incorrecte";	
			// on rappelle la serveur en m�thode get en lui passant en param�tre le message
			response.sendRedirect("./ServMenu?message="+ message);
		}
		else {
			request.setAttribute("usager", usag);
			// on r�cup�re les habitations de l'usager 
			// soit en faisant appel � la collection des habitations de l'usager(c'est le cas ici)
			// soit en faisant appel au service hql mis en place qi il n'y a pas de navigabilit� dans ce sens
			List<Habitation> listeHabitation = usag.getLesHabitations();
			// on proc�de � l'affichage
			response.setContentType("text/html");
			response.setCharacterEncoding( "UTF-8" );
			// instanciation d'un objet Printer
			PrintWriter out = response.getWriter();
			// entete page html
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"utf-8\" />");
			out.println("<title>Affichage factures</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p><a href='./ServMenu'> D�connexion</a>");
			// affichage nom et prenom de l'usager
			out.println("<h1>");
			out.println( usag.getNom() + " " + usag.getPrenom());
			out.println("</h1>");
			// parcours des habitations
			if (listeHabitation.size() == 0 ) {
				out.println("Aucune habitation connue ");
			}
			else {
				for (Habitation  h: listeHabitation)
				{
					out.println("<p> pour le logement situ� � </p>");
					out.println(h.getAdresseRue()+"<br/>");
					out.println(h.getAdresseVille()+ "<br/>");
					// on r�cup�re les factures, navigabilit� mise en place
					List<Facture> listeFacture = h.getLesFactures();
					if ( listeFacture.size()!=0) {
						for(Facture f : listeFacture) {
							out.println("<table border='1'>");
							out.println("<tr>");
							out.println("<th>liste des factures</th>");
							out.println("</tr>");
							out.println("<tr>"); 
							String lienFacture ="pdf/" + f.getNomF();
							String nomFacture = f.getNomF();
							out.println("<td><a href="+ lienFacture +" target='_blank'><img src='img/logoadobe.png'>" + nomFacture +"</a></td>");
							out.println("</tr>");
						} 
						out.println("</table>");
					}
					else
					{
						out.println("pas de facture");
					}
					out.println("</body>");
					out.println("</html>");
				}
			}
			request.getRequestDispatcher("vue/pageFacture.jsp").forward(request, response);
		}
	}
}
