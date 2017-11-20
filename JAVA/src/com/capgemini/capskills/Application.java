package com.capgemini.capskills;

import java.util.List;

//import com.capgemini.capskills.dao.ProjectDAO;
import com.capgemini.capskills.dao.UserDAO;
//import com.capgemini.capskills.entities.Project;
import com.capgemini.capskills.entities.User;
import com.capgemini.capskills.exceptions.DatabaseNotReadyException;
import com.capgemini.capskills.manager.DatabaseManager;

public class Application {
    private static final boolean PRODUCTION = false;
//    private static final boolean DEVELOPMENT = true;

    /**
     * Program run.
     * @param args
     * @throws DatabaseNotReadyException
     */
    public static void main(String[] args) throws DatabaseNotReadyException {
//        DatabaseManager database = DatabaseManager.getInstance();
//
//        database.prepareDb(PRODUCTION);
//        database.getConnection();
//
//        SkillTypeDao dao = new SkillTypeDao();
//
//        // Arrays.asList => creates list from given values.
//        dao.insert(Arrays.asList(
//                new SkillType("coucou"),
//                new SkillType("bonne"),
//                new SkillType("inutile"),
//                new SkillType("marrante")));
//
//        dao.findAll().forEach(type -> System.out.println(type));
    	DatabaseManager.getInstance().prepareDb(PRODUCTION);
    	UserDAO daoU = new UserDAO();
//    	ProjectDAO daoP = new ProjectDAO();
    	User user;
//    	Project project;
    	
    	
    	
    	for (int i = 0; i < 5; i++) {
    		user = new User();
    		user.setEmail("coucou");
    		daoU.insert(user);
//    		project = new Project();
//    		daoP.insert(project);
    		System.out.println(user);
//    		System.out.println(project);
		}
   
    		User user1;
    		user1 = new User();
    		user1.setFirstname("toto");
    		daoU.insert(user1);
    		
    		daoU.delete(user1);
    	

    	System.out.println("---------------------------------");

    	List<User> users = daoU.select();
    	for (User user2 : users) {
			System.out.println(user2);
		}
    }
}
