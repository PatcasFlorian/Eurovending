package org.fasttrackit.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fasttrackit.spring.dao.CategoriiDAO;
import org.fasttrackit.spring.dao.SubCategoriiDAO;
import org.fasttrackit.spring.dao.UserDAO;
import org.fasttrackit.spring.model.Categorii;
import org.fasttrackit.spring.model.SubCategorii;
import org.fasttrackit.spring.model.User;
import org.fasttrackit.spring.password.PasswordUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





@Controller
public class AdminController {
	
	
	private static boolean isLoginSuperAdmin = false ;
	private static String myUserName=null;
	
	public static boolean isLoginSuperAdmin() {
		return isLoginSuperAdmin;
	}
	

	public   void setLoginSuperAdmin(boolean isLoginSuperAdmin) {
		this.isLoginSuperAdmin = isLoginSuperAdmin;
	}


	public static String getMyUserName() {
		return myUserName;
	}



	public void setMyUserName(String myUserName) {
		this.myUserName = myUserName;
	}

	
	//verificare string 
	public static boolean isNotNullNotEmptyNotWhiteSpace( String string)
	{
		boolean stringOk =false;
		if((string!=null)&&(!string.isBlank())&&(!string.trim().isEmpty()))
		{
			stringOk=true;
		}
	   return stringOk;
	}
	
	//Login for admin&user
		@RequestMapping(value="login-portal.htm")
		public ModelAndView adminPortal( HttpServletRequest request, HttpServletResponse response,final RedirectAttributes redirectAttributes) throws SQLException, IOException, ServletException {
			/*
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			request.getRequestDispatcher("logadmin.jsp").include(request, response);
			UserDAO udao = new UserDAO();
			ArrayList<User> userList = new ArrayList<User>();
			String myEmail = request.getParameter("email");
			String myPassword = request.getParameter("password");
			
			PasswordUtils uPassword = new PasswordUtils();
			String salt = null ;
			String adminPassword = "admin21782619";
			salt = uPassword.getSalt(30);
			String generatePassword = null;
			 generatePassword = uPassword.generateSecurePassword( adminPassword,salt);
			User superAdmin = new User("Patcas Florentina","+40743556569",
	             "patcasf12@gmail.com",salt,generatePassword,"ADMIN","ACTIVE");	
	UserDAO udao1 = new UserDAO();


	 try {
		udao1.createTableUser();
		//sales.createTableSales();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 int count=0;
	try {
		 
		 count = udao1.verifyTableUser();
		 
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	if(count==0) {
		   try {
			udao1.insertUser(superAdmin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	 }
			
			
			
			boolean myEmailIsOk = isNotNullNotEmptyNotWhiteSpace(myEmail) ;
			boolean myPasswordIsOk = isNotNullNotEmptyNotWhiteSpace(myPassword);
			userList = udao.getUser();
			if((myEmailIsOk==true)&&(myPasswordIsOk==true)) {
			for(User myUser:userList) {
			 boolean adminPasswordMatch=false;
			 String verifyPassword = myUser.getPassword();
			 String adminSalt = myUser.getSalt();
				adminPasswordMatch = PasswordUtils.verifyUserPassword( myPassword,myUser.getPassword(), myUser.getSalt());
	        if((adminPasswordMatch==true)&&(myUser.getEmail().equalsIgnoreCase(myEmail))) 
	        {
	        	setMyUserName(myUser.getFullName());
	        	if((myUser.getRole().equals("ADMIN"))&&(myUser.getStatute().equals("ACTIVE"))) {
	        		setLoginSuperAdmin(true);
	        	redirectAttributes.addFlashAttribute("myUser", myUser);
	            return new ModelAndView("redirect:/lista-user.htm");
	        	}
	        	if((myUser.getRole().equals("ADMIN"))&&(myUser.getStatute().equals("ACTIVE"))) {
	        		setLoginSuperAdmin(true);
	        		redirectAttributes.addFlashAttribute("myUser", myUser);
	                return new ModelAndView("redirect:/lista-user.htm");
	            	}
	        	else if((myUser.getRole().equals("USER"))&&(myUser.getStatute().equals("ACTIVE"))) {
	        		setLoginSuperAdmin(true);
	        		redirectAttributes.addFlashAttribute("myUser", myUser);
	                return new ModelAndView("WEB-INF/Home/home.jsp");
	            	}
	        	
	                    } 
			              }
			                 }
			
			if(isLoginSuperAdmin == false) {
	            out.print("<p style=text-align:center;color:red>Sorry, email or password error!</p>");
				out.close();
			                       }
			         setMyUserName(null);
					 setLoginSuperAdmin(false);
					 return new ModelAndView("welcome");
					 */
					 
					 return new ModelAndView("redirect:/lista-user.htm");
			
		}
		
		@RequestMapping(value = "/homeadmin.htm", method = RequestMethod.POST)
		public String homeAdmin(@Validated User user, Model model) {
			System.out.println("User Page Requested");
			model.addAttribute("userName", user.getFullName());
			return "user";
		}
		
		@RequestMapping("/backhomeadmin.htm")
		public ModelAndView helloWorld() {
	 
			return new ModelAndView("redirect:/lista-user.htm");
		}
		
		//listare  user
		@RequestMapping(value="lista-user.htm")
		public ModelAndView listareUseri(@ModelAttribute("myUser") User myUser ,Model model,BindingResult result) throws SQLException, ServletException, IOException {
			setLoginSuperAdmin( true);
			setMyUserName("fgs");
			if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
				ArrayList<Categorii>listCategorie = new ArrayList<Categorii>();
				ArrayList<Categorii>listaCategorii = new ArrayList<Categorii>();
				
				Categorii categorie = null;
				CategoriiDAO cdao = new CategoriiDAO();
				UserDAO udao = new UserDAO();
				ArrayList<User> userList = new ArrayList<User>();
				ArrayList<User> userList1 = new ArrayList<User>();
				userList=udao.getUser();
			String myUserFullName = getMyUserName();
			int nr = 1;
			listaCategorii = cdao.getListaCategorii();
			
			for(Categorii numeCategorie :listaCategorii) {
				
			categorie=cdao.getCategorieParinte(numeCategorie.getNumeCatParinte());
			categorie.setId(nr);
			listCategorie.add(categorie);
			nr++;
			                   }	
			for(int i=0;i<userList.size();i++) {
			User user1 = userList.get(i);
			user1.setId(i+1);
			  userList1.add(user1) ; 
			  
			  }
			model.addAttribute("nr", nr);
			model.addAttribute("userList1",userList1);
			model.addAttribute("categorie", listCategorie);
			return new ModelAndView("admin/homeadmin","model",model);
			}
			else {
				 isLoginSuperAdmin = false;
				 return new ModelAndView("redirect:/login-portal.htm");
			}
		}
		
		//add Category 
		@RequestMapping(value="add-categorie-parinte.htm")
		public ModelAndView addCatParinte( Categorii categorie,Model model,BindingResult result) throws SQLException, ServletException, IOException {
			String myUserFullName= getMyUserName();
			String numeCategorie = categorie.getNumeCatParinte();
			
			if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
			
			return new ModelAndView("admin/addcategorii");
		}
			else {
				isLoginSuperAdmin = false;
			
				 return new ModelAndView("redirect:/login-portal.htm");
			}
		}
		
		
		//collect and validate data from addcategorii.jsp
		@RequestMapping(value="insert-categorie-parinte.htm")
		public ModelAndView insertCatParinte(@ModelAttribute("categorieParinte") Categorii catParinte,
				Model model,BindingResult result) throws SQLException {
	
			if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
			Categorii categorie =new Categorii();
			ArrayList<Categorii> listCategorii = new ArrayList<Categorii>();
			String fullnameMyUser = getMyUserName();
			CategoriiDAO cdao = new CategoriiDAO();
			listCategorii = cdao.getListaCategorii();
			boolean stringOk =false;	
			stringOk=isNotNullNotEmptyNotWhiteSpace( catParinte.getNumeCatParinte());		
			
			if(stringOk==true)
			 {
				for(Categorii cat: listCategorii) {
					if(cat.getNumeCatParinte().equalsIgnoreCase(catParinte.getNumeCatParinte())) {
						return new ModelAndView("redirect:/add-categorie-parinte.htm");
					}
					else {
				categorie.setNumeCatParinte(catParinte.getNumeCatParinte());
					}
				}
			}
			else {
				return new ModelAndView("redirect:/add-categorie-parinte.htm");
			}
			stringOk=isNotNullNotEmptyNotWhiteSpace( catParinte.getStatut());
			if(stringOk==true) {
				categorie.setStatut(catParinte.getStatut());
			}
			else {
				return new ModelAndView("redirect:/add-categorie-parinte.htm");
			}
			cdao.insertCategorie(categorie);	
			model.addAttribute("myUser",getMyUserName());
			model.addAttribute("categorie", categorie);
			return new ModelAndView("redirect:/lista-user.htm");
			}
			else {
				isLoginSuperAdmin = false;
				 return new ModelAndView("redirect:/login-portal.htm");
			}
		}		
		
		
		//editare Category
				@RequestMapping(value="edit-categorie-parinte.htm")
				public ModelAndView listareCatParinte(@ModelAttribute("categorieParinte") Categorii categorie,Model model,BindingResult result) throws SQLException, ServletException, IOException {
					String myUserFullName= getMyUserName();
					String numeCategorie = categorie.getNumeCatParinte();
					
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
					CategoriiDAO adao = new CategoriiDAO();
					categorie = adao.getCategorieParinte(numeCategorie);
					//categorie.setId(1);
					model.addAttribute("myUser", getMyUserName());
					model.addAttribute("categorie", categorie);
					
					return new ModelAndView("admin/categoriiedit","model",model);
				}
					else {
						isLoginSuperAdmin = false;
					
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}

				
				//editare CatParinte
				@RequestMapping(value="update-categorie-parinte.htm")
				public ModelAndView updateCatParinte(@ModelAttribute("categorieParinte") Categorii catParinte,
						Model model,BindingResult result) throws SQLException {
			
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
					Categorii categorie =new Categorii();
					String fullnameMyUser = getMyUserName();
					CategoriiDAO cdao = new CategoriiDAO();
					categorie = cdao.getIdCategorieParinte(catParinte.getId());
					String fullName= categorie.getNumeCatParinte();
					
					boolean stringOk =false;	
					stringOk=isNotNullNotEmptyNotWhiteSpace( catParinte.getNumeCatParinte());		
					String catName=catParinte.getNumeCatParinte();
					if(stringOk==true)
					 {
						categorie.setNumeCatParinte(catParinte.getNumeCatParinte());
					}
					else {
						categorie.setNumeCatParinte(categorie.getNumeCatParinte());
					}
					stringOk=isNotNullNotEmptyNotWhiteSpace( catParinte.getStatut());
					if(stringOk==true) {
						categorie.setStatut(catParinte.getStatut());
					}
					else {
						categorie.setStatut(categorie.getStatut());
					}
					
					cdao.updateCatParinte(fullName, categorie);
					
					
					model.addAttribute("myUser",getMyUserName());
					model.addAttribute("categorie", categorie);
					 return new ModelAndView("admin/categoriiedit","model",model);
					}
					else {
						isLoginSuperAdmin = false;
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}
				
				//Delete CategorieParinte 
				@RequestMapping(value="delete-categorie.htm")
				public ModelAndView deleteUser(@ModelAttribute("numeCatParinte") Categorii user,Model model,BindingResult result) throws SQLException, ServletException, IOException {
					String myUserFullName= getMyUserName();
					String fullName = user.getNumeCatParinte();
					
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
					CategoriiDAO cdao = new CategoriiDAO();
					cdao.deleteCatParinte(user.getNumeCatParinte());
					return new ModelAndView("redirect:/lista-user.htm");
				}
					else {
						isLoginSuperAdmin = false;
					
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}
				
				//add-subCategorie 
				@RequestMapping(value="add-subcategorie.htm")
				public ModelAndView addSubCategory(@ModelAttribute("user") Categorii categorie,Model model,BindingResult result) throws SQLException, ServletException, IOException {
					String myUserFullName= getMyUserName();
					String numeCategorie = categorie.getNumeCatParinte();
					ArrayList<SubCategorii> listSubCat = new ArrayList<SubCategorii>();
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
					CategoriiDAO cdao = new CategoriiDAO();
					SubCategoriiDAO scdao = new SubCategoriiDAO();
					categorie = cdao.getCategorieParinte(numeCategorie);
					listSubCat = scdao.getListaSubCategorii(numeCategorie);
					model.addAttribute("myUser", getMyUserName());
					model.addAttribute("categorie1", categorie);
					model.addAttribute("listSubCat", listSubCat);
					return new ModelAndView("admin/addsubcategorie","model",model);
				}
					else {
						isLoginSuperAdmin = false;
					
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}
				
				
				//editare CatParinte
				@RequestMapping(value="insert-categorie-copil.htm")
				public ModelAndView insertCatCopil(@ModelAttribute("categorieParinte") SubCategorii catParinte,
						Model model,BindingResult result) throws SQLException, IOException, ServletException {
					
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
						Categorii cat = new Categorii();
						CategoriiDAO ccdao = new CategoriiDAO();
						cat = ccdao.getIdCategorieParinte(catParinte.getId());
						String numeCategorie = cat.getNumeCatParinte();
						SubCategorii categorie =new SubCategorii();
						categorie.setCategorieParinte(cat.getNumeCatParinte());
						categorie.setCategorieCopil(catParinte.getCategorieCopil());
						categorie.setStatut(catParinte.getStatut());
						ArrayList<SubCategorii> listCategorii = new ArrayList<SubCategorii>();
						String fullnameMyUser = getMyUserName();
						SubCategoriiDAO cdao = new SubCategoriiDAO();
						//cdao.insertSubCategorii(categorie);
						listCategorii = cdao.getListaSubCategorii(numeCategorie);
						boolean stringOk =false;	
						stringOk=isNotNullNotEmptyNotWhiteSpace( catParinte.getCategorieCopil());		
						if(stringOk==true)
						 {
							for(SubCategorii cat1: listCategorii) {
								if(cat1.getCategorieCopil().equalsIgnoreCase(catParinte.getCategorieCopil())) {
									return new ModelAndView("redirect:/add-categorie-parinte.htm");
								}
								else {
									String output = catParinte.getCategorieCopil().substring(0, 1).toUpperCase() + catParinte.getCategorieCopil().substring(1);
							categorie.setCategorieCopil(output);
								}
							}
						}
						else {
							return new ModelAndView("redirect:/add-categorie-parinte.htm");
						}
						stringOk=isNotNullNotEmptyNotWhiteSpace( catParinte.getStatut());
						if(stringOk==true) {
							categorie.setStatut(catParinte.getStatut());
						}
						else {
							return new ModelAndView("redirect:/add-categorie-parinte.htm");
						}
						cdao.insertSubCategorii(categorie);	
						model.addAttribute("myUser",getMyUserName());
						model.addAttribute("categorie", categorie);
						return new ModelAndView("redirect:/lista-user.htm");
						}
						else {
							isLoginSuperAdmin = false;
							 return new ModelAndView("redirect:/login-portal.htm");
						}
					}			
				
				//listare  SubCategory/Produse
				@RequestMapping(value="show-categorie-copil.htm")
				public ModelAndView listareCatCopil(@ModelAttribute("numeCatParinte") Categorii categorie,Model model,BindingResult result) throws SQLException, ServletException, IOException {
					String myUserFullName= getMyUserName();
					String numeCategorie = categorie.getNumeCatParinte();
					ArrayList<SubCategorii> listSubCat = new ArrayList<SubCategorii>();
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
					CategoriiDAO adao = new CategoriiDAO();
					SubCategoriiDAO scdao = new SubCategoriiDAO();
					categorie = adao.getCategorieParinte(numeCategorie);
					listSubCat = scdao.getListaSubCategorii(numeCategorie);
					model.addAttribute("myUser", getMyUserName());
					model.addAttribute("categorie", categorie);
					model.addAttribute("listSubCat", listSubCat);
					return new ModelAndView("admin/showsubcategory","model",model);
				}
					else {
						isLoginSuperAdmin = false;
					
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}
				
				
		//editare User 
		@RequestMapping(value="edit-user.htm")
		public ModelAndView listareUser(@ModelAttribute("user") User user,Model model,BindingResult result) throws SQLException, ServletException, IOException {
			String myUserFullName= getMyUserName();
			String fullName = user.getFullName();
			
			if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
			UserDAO adao = new UserDAO();
			user = adao.getOneUser(fullName);
			user.setId(1);
			model.addAttribute("myUser", getMyUserName());
			model.addAttribute("user", user);
			
			return new ModelAndView("admin/useredit","model",model);
		}
			else {
				isLoginSuperAdmin = false;
			
				 return new ModelAndView("redirect:/login-portal.htm");
			}
		}
		
		//Delete User 
				@RequestMapping(value="delete-user.htm")
				public ModelAndView deleteUser(@ModelAttribute("user") User user,Model model,BindingResult result) throws SQLException, ServletException, IOException {
					String myUserFullName= getMyUserName();
					String fullName = user.getFullName();
					
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
					UserDAO adao = new UserDAO();
					adao.deleteUser(user.getFullName());
					return new ModelAndView("redirect:/lista-user.htm");
				}
					else {
						isLoginSuperAdmin = false;
					
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}
		
		//editare User/role
				@RequestMapping(value="update-rolestatute.htm")
				public ModelAndView editareRoleUser(@ModelAttribute("updateUser") User updateUser,
						Model model,BindingResult result) throws SQLException {
					
					if((isLoginSuperAdmin() == true)&&(getMyUserName()!=null)) {
					User user =new User();
					User myUser=new User();
					String fullName= updateUser.getFullName();
					String fullnameMyUser = getMyUserName();
					UserDAO udao = new UserDAO();
					user = udao.getOneUser(fullName);
					myUser = udao.getOneUser(getMyUserName());
					boolean stringOk =false;
					
					stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getPhoneNumber());
					
					String phone=updateUser.getPhoneNumber();
					if(stringOk==true)
					 {
						user.setPhoneNumber(updateUser.getPhoneNumber());
					}
					else {
						user.setPhoneNumber(user.getPhoneNumber());
					}
					
					stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getEmail());
					if(stringOk==true) {
						user.setEmail(updateUser.getEmail());
					}
					else {
						user.setEmail(user.getEmail());
					}
					
					stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getStatute());
					if(stringOk==true) {
					user.setStatute(updateUser.getStatute());
					}
					else {
						user.setStatute(user.getStatute());
					}
					stringOk=isNotNullNotEmptyNotWhiteSpace( updateUser.getRole());
					if(stringOk==true) {
					user.setRole(updateUser.getRole());
					}
					else {
						user.setRole(user.getRole());
					}
					udao.updateUser(user, updateUser.getFullName());
					
					
					model.addAttribute("myUser",getMyUserName());
					model.addAttribute("user", user);
					 return new ModelAndView("admin/useredit","model",model);
					}
					else {
						isLoginSuperAdmin = false;
						 return new ModelAndView("redirect:/login-portal.htm");
					}
				}

				// redirect to adminregister.jsp
				@RequestMapping(value="register-admin.htm")
				public ModelAndView adminRegister() throws SQLException {
					
					return new ModelAndView("Register/adminregister");
					
				}
				
				//Insert New User collect and validate data from adminregister.jsp
				@RequestMapping(value="new-user.htm")
				public ModelAndView insertNewUser(@ModelAttribute("newuser") User newUser,
						Model model,BindingResult result) throws SQLException, IOException {
					UserDAO udao = new UserDAO();
					ArrayList<User> userList = new ArrayList<User>();
					PasswordUtils utilPassword = new PasswordUtils();
					 String generatePassword = null;
					 String saltWord = null;
					 userList=udao.getUser();
					 for(User u:userList) {
						 
						 if((newUser.getFullName().equalsIgnoreCase(u.getFullName()))||(newUser.getEmail().equalsIgnoreCase(u.getEmail()))) {
							String mesaj =" Nume sau email existent ,alegeti alti parametri";
							 model.addAttribute("mesaj", mesaj);
							 return new ModelAndView( "Register/adminregister","model",model);
						 }
						 
					 }
					 if(newUser.getPassword().length()<6) {
						 String mesaj =" Parola nu poate contine mai putine caractere decat 6 ";
						 model.addAttribute("mesaj", mesaj);
						 return new ModelAndView( "Register/adminregister","model",model); 
					 }
					 if((newUser.getPassword()!=null)&&(!newUser.getPassword().isBlank())&&(!newUser.getPassword().isEmpty())) {
					 if(newUser.getPassword().equals(newUser.getRetypePassword())) {
						 saltWord = utilPassword.getSalt(30);
						 generatePassword = utilPassword.generateSecurePassword(newUser.getPassword(), saltWord);
					     newUser.setSalt(saltWord);
					     newUser.setPassword(generatePassword);
					     newUser.setRole("USER");
					     newUser.setStatute("FORBIDDEN");
					
					udao.insertUser(newUser);	
					 }
					 
					 return new ModelAndView("redirect:/lista-user.htm");
					    }
					 else {
						 setLoginSuperAdmin(false);
				
							}
					 
					 return new ModelAndView( "Register/adminregister");
					          }
				
				
}
