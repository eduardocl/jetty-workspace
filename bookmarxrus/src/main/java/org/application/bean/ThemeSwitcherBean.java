package org.application.bean;


import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="themeSwitcherBean")
@SessionScoped
public class ThemeSwitcherBean implements Serializable{
        
    private Map<String, String> themes;
   
    private Theme theme;
   
    private String themeSelected = "aristo";
    
    @Inject
    private ThemeDAO themeDAO;
    
    public ThemeSwitcherBean() {
    	System.out.println("Theme bean instanciated.");
    }
    
    public Map<String, String> getThemes() {
        return themes;
    }

    public void setThemes(Map<String, String> themes) {
    	this.themes = themes;
    }
    

    @PostConstruct
    public void init() {
    	
    	Theme themePersisted = themeDAO.getTheme();
    	
    	if(themePersisted == null) {
    		System.out.println("------------------------");
    		System.out.println("themePersisted = null");
			Theme theme = new Theme();
			theme.setTheme("aristo");
			this.themeSelected = "aristo";
			themeDAO.persist(theme);
			this.setTheme(themeDAO.getTheme());
			System.out.println("------------------------");
		}else {
			System.out.println("------------------------");
			System.out.println("Theme selected from db");
			this.themeSelected = themePersisted.getTheme();
			this.setTheme(themePersisted);
			System.out.println("------------------------");
		}
    	
        themes = new TreeMap<String, String>();
        themes.put("Aristo", "aristo");
        themes.put("Black-Tie", "black-tie");
        themes.put("Blitzer", "blitzer");
        themes.put("Bluesky", "bluesky");
        themes.put("Casablanca", "casablanca");
        themes.put("Bootstrap", "bootstrap");
        themes.put("Cupertino", "cupertino");
        themes.put("Dark-Hive", "dark-hive");
        themes.put("Dot-Luv", "dot-luv");
        themes.put("Eggplant", "eggplant");
        themes.put("Excite-Bike", "excite-bike");
        themes.put("Flick", "flick");
        themes.put("Glass-X", "glass-x");
        themes.put("Hot-Sneaks", "hot-sneaks");
        themes.put("Humanity", "humanity");
        themes.put("Le-Frog", "le-frog");
        themes.put("Midnight", "midnight");
        themes.put("Mint-Choc", "mint-choc");
        themes.put("Overcast", "overcast");
        themes.put("Pepper-Grinder", "pepper-grinder");
        themes.put("Redmond", "redmond");
        themes.put("Rocket", "rocket");
        themes.put("Sam", "sam");
        themes.put("Smoothness", "smoothness");
        themes.put("South-Street", "south-street");
        themes.put("Start", "start");
        themes.put("Sunny", "sunny");
        themes.put("Swanky-Purse", "swanky-purse");
        themes.put("Trontastic", "trontastic");
        themes.put("UI-Darkness", "ui-darkness");
        themes.put("UI-Lightness", "ui-lightness");
        themes.put("Vader", "vader");
    }
    
    public void saveTheme() {
        //gp.setTheme(theme);
    	System.out.println(getTheme());
    	this.theme = themeDAO.getTheme();
    	if(this.theme == null) {
    		this.theme = new Theme();
    		this.theme.setTheme(this.themeSelected);
    		themeDAO.persist(theme);
    	}else {
    		System.out.println("-----------------------------------");
    		System.out.println("Theme updated to " + themeSelected);
    		themeDAO.update(theme);
    		System.out.println("-----------------------------------");
    	}
    	
    	this.theme.setTheme(this.themeSelected);
    }

	public String getThemeSelected() {
		return themeSelected;
	}

	public void setThemeSelected(String themeSelected) {
		this.themeSelected = themeSelected;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}


}