package com.capgemini.capskills;

import java.util.Arrays;
import java.util.List;

import com.capgemini.capskills.dao.SkillTypeDAO;
//import com.capgemini.capskills.dao.ProjectDAO;
import com.capgemini.capskills.dao.UserDAO;
import com.capgemini.capskills.entities.SkillType;
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
    	SkillTypeDAO daoS = new SkillTypeDAO();
//    	ProjectDAO daoP = new ProjectDAO();
    	User user;
    	SkillType skilltype;
//    	Project project;
    	
    	
    	
    	
    	
    	for (String name : Arrays.asList("jules", "quickos", "thibaut", "cécile")) {
    		skilltype = new SkillType();
    		skilltype.setName(name);
    		daoS.insert(skilltype);
//    		project = new Project();
//    		daoP.insert(project);
    		System.out.println(skilltype);
//    		System.out.println(project);
		}
   
    	

    	System.out.println("---------------------------------");

    	List<User> users = daoU.select();
    	for (User user2 : users) {
			System.out.println(user2);
			
			
		}
    }
}
