package com.capgemini.capskills;

import java.util.List;

//import com.capgemini.capskills.dao.ProjectDAO;
import com.capgemini.capskills.dao.UserDAO;
//import com.capgemini.capskills.entities.Project;
import com.capgemini.capskills.entities.User;
import com.capgemini.capskills.exceptions.DatabaseNotReadyException;
import com.capgemini.capskills.manager.DatabaseManager;
import com.capgemini.capskills.manager.InputManager;

public class Application {
    private static final boolean PRODUCTION = false;
//    private static final boolean DEVELOPMENT = true;

    /**
     * Program run.
     * @param args
     * @throws DatabaseNotReadyException
     */
    public static void main(String[] args) throws DatabaseNotReadyException {

    
    	DatabaseManager.getInstance().prepareDb(PRODUCTION);
    	UserDAO daoU = new UserDAO();

    	User user;    	
    	
    	for (int i = 0; i < 5; i++) {
    		user = new User();
    		user.setEmail("coucou");
    		daoU.insert(user);
    		System.out.println(user);
		}
   
    	User user1 = new User();
    	user1.setFirstname("toto");
    	user1.setEmail("coucou");
    	daoU.insert(user1);
    	
    	System.out.println(user1);
    	
//    	daoU.delete(user1);
    	
    	user1.setFirstname("titi");
    	
    	daoU.update(user1);
    	
    	InputManager.createUser();

    	System.out.println("---------------------------------");

    	List<User> users = daoU.select();
    	for (User user2 : users) {
			System.out.println(user2);
		}
    }
}