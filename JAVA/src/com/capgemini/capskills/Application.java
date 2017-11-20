package com.capgemini.capskills;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.capgemini.capskills.dao.ProjectDao;
import com.capgemini.capskills.entities.Project;
import com.capgemini.capskills.entities.base.BaseEntity;
//import com.capgemini.capskills.dao.ProjectDAO;
import com.capgemini.capskills.exception.DatabaseNotReadyException;

//import com.capgemini.capskills.entities.Project;


import com.capgemini.capskills.manager.DatabaseManager;

public class Application {
	private static final boolean PRODUCTION = false;
	private static final boolean DEVELOPMENT = true;

	/**
	 * Program run.
	 * @param args
	 * @throws DatabaseNotReadyException
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws DatabaseNotReadyException, ParseException {
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		DatabaseManager database = DatabaseManager.getInstance();

		database.prepareDb(PRODUCTION);
		database.getConnection();

		ProjectDao dao = new ProjectDao();

		//        // Arrays.asList => creates list from given values.
		//        dao.insert(Arrays.asList(
		//                new SkillType("coucou"),
		//                new SkillType("bonne"),
		//                new SkillType("inutile"),
		//                new SkillType("marrante")));
		//
		//        dao.findAll().forEach(type -> System.out.println(type));

		DatabaseManager.getInstance().prepareDb(PRODUCTION);
		ProjectDao daoPj = new ProjectDao();
		Project pj = new Project("PoeCap",df.parse("2017-10-05"), df.parse("2017-12-22"), "POE 2017", (double)0 );
		daoPj.insert(pj);
		
		Project pj2 = new Project("PoeCap2",df.parse("2017-10-05"), df.parse("2017-12-22"), "POE 2018", (double)0 );
		daoPj.insert(pj2);
		
		
		List<BaseEntity> projects = daoPj.select();
		//projects.addAll(projects1);
		System.out.println();
		System.out.println("---Recupération des données dans la base et affichage---");
		int i=0;
    	for (BaseEntity project : projects) {
    		i++;
			System.out.println(i +":" +((Project)project).toString());

    }
		/* 
    	  ProjectDAO daoP = new ProjectDAO();
    	User user;
   	Project project;
      for (int i = 0; i < 5; i++) {
    		user = new User();
    		user.setEmail("coucou");
    		daoU.insert(user);
    		project = new Project();
    		daoP.insert(project);
    		System.out.println(user);
    		System.out.println(project);

		}
		 */

		System.out.println("-----------");

		/*List<User> users = daoU.select();
    	for (User user2 : users) {
			System.out.println(user2);

    }*/
	}
}
