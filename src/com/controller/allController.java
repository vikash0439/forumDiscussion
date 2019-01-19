package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mail.MailMail;

import dao.Dao;
import dto.Dto;

@Controller @Component
public class allController {
	
	@Autowired
	Dao dao;
	
	private static final String UPLOAD_DIRECTORY ="/attachments";
	
	
	@RequestMapping("/home")
	public ModelAndView home(){		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/counter")
	public @ResponseBody String Counter(){
		String d=String.valueOf(dao.getCounter());
		return d;
	}
	
	@RequestMapping("/downloads")  
    public ModelAndView Downloads(){  		 
	        return new ModelAndView("downloads");       
    }
	
	@RequestMapping("/gallery")  
    public ModelAndView Gallery(){  		 
	        return new ModelAndView("gallery");       
    }
	
	@RequestMapping("/forum")
	public ModelAndView Forum(){
		List<Dto> list=dao.getForumDecission();
		return new ModelAndView("forum", "list", list);
	}
	
	@RequestMapping(value="/subscribe", method = RequestMethod.POST)
	public ModelAndView Subscribe(@ModelAttribute("a") Dto a, @RequestParam String email){
		dao.subscribe(a);
		try{
			System.out.println("Email check: "+email);
			MailMail.subscribe(email);
			System.out.println("Mail sent");
			}catch(Exception e){
				System.out.println("Mail not send: "+e);
			}
		return new ModelAndView("thank");
	}
	
	@RequestMapping(value="/contact", method = RequestMethod.POST)
	public ModelAndView Contact(@ModelAttribute("a") Dto a, @RequestParam String email,@RequestParam String name, @RequestParam CommonsMultipartFile file,HttpSession session) throws Exception{
		ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY); 
	    if(file.isEmpty()){
	    	System.out.println("No file found");
	    }else{
		    File f=new File(path+"/"+name);
		    f.mkdirs();
	    	String filename = file.getOriginalFilename();  	  	    
	    	byte[] bytes = file.getBytes();
		    System.out.println(path+" "+filename);
		    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(f + File.separator + filename)));  
		    stream.write(bytes);  
		    stream.flush();  
		    stream.close();  
		    System.out.println("File uploaded");
	    }
		dao.save(a);
		try{
			System.out.println("Email check: " +email);
			MailMail.sendMail(email);
			System.out.println("Mail sent");
			}catch(Exception e){
				System.out.println("Mail not send: "+e);
			}
		return new ModelAndView("thank");
	}
	
	@RequestMapping(value="/forum", method = RequestMethod.POST)
	public ModelAndView Forum(@ModelAttribute("a") Dto a, @RequestParam CommonsMultipartFile file,HttpSession session) throws Exception{
		dao.forum(a);
		int forumid=dao.getId();
		ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY); 
	    if(file.isEmpty()){
	    	System.out.println("No file found");
	    }else{
	    	File f=new File(path+"/"+forumid);
		    f.mkdirs();
	    	String filename = file.getOriginalFilename();  	  	    
	    	byte[] bytes = file.getBytes();
		    System.out.println(path+" "+filename);
		    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(f + File.separator + filename)));  
		    stream.write(bytes);  
		    stream.flush();  
		    stream.close();  
		    System.out.println("File uploaded");
	    }
		System.out.println("Forum id limit 1:"+forumid);
		try{
			System.out.println("Forum id: "+forumid);
			MailMail.forum(forumid);
			System.out.println("Mail sent");
			}catch(Exception e){
				System.out.println("Mail not send: "+e);
			}
		return new ModelAndView("redirect:/forum");
	}
	
	@RequestMapping(path="/discuss{forumid}")  
    public ModelAndView edit(@PathVariable int forumid){  
        Dto f=dao.getDiscussionById(forumid);  
        List<Dto> r=dao.getReply(forumid);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("f", f);
        model.put("r", r);
        return new ModelAndView("discuss","model",model);  
    } 
	
	@RequestMapping("/features")  
    public ModelAndView Features(){   
	        return new ModelAndView("features");       
    }
	
	@RequestMapping("/etoken")  
    public ModelAndView About(){   
	        return new ModelAndView("etoken");       
    }
	
	@RequestMapping("/contact")  
    public ModelAndView Contact(){   
	        return new ModelAndView("contact");       
    }
	
	
	@RequestMapping("reportAjax")
	public @ResponseBody void reportAjax(@ModelAttribute("a") Dto a, BindingResult result){		  	
		dao.reply(a);   
    	System.out.println("Data saved");
    }
	
	@RequestMapping("/replies")
	public ModelAndView replies(){
		List<Dto> r=dao.getReply(0);
		return new ModelAndView("forum", "r", r);
	}

	@RequestMapping("reportDownload")
	public @ResponseBody void reportDownload(@RequestParam("counts") int counts){		  	
		dao.download(counts);   
    	System.out.println("Data saved");
    }
	
	@RequestMapping("/getdownload")
	public @ResponseBody String Download(){
		String d=String.valueOf(dao.getDownload());
		return d;
	}
	
	@RequestMapping("/page-not-found")  
    public ModelAndView error(){  	
		   List<Dto> r=dao.getSelect();
	        return new ModelAndView("page-not-found");       
    }
}
