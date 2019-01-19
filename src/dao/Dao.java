package dao;

import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.Dto;

public class Dao {
	
	JdbcTemplate template;
     
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Autowired
	JdbcTemplate jdbcTemplate;


	public int save(Dto a){
		String sql="insert into contact(name, mobile, email, message) values('"+a.getName()+"','"+a.getEmail()+"','"+a.getMobile()+"','"+a.getMessage()+"')";
		return template.update(sql);
	}
	
	public int subscribe(Dto a){  
		    String sql="insert into subscribe(email) values('"+a.getEmail()+"')";
	        return template.update(sql);  
	}
	
	public int forum(Dto a){
		String sql="insert into forum(name, email, phone, message, date) values('"+a.getName()+"','"+a.getEmail()+"','"+a.getPhone()+"','"+a.getMessage()+"',curdate())";
		return template.update(sql);
	}
	
	public int getId(){  
	    String sql="select MAX(forumid) from forum";  	    
	    int status = jdbcTemplate.queryForObject(sql, Integer.class);
		return status;
	}
	
	public List<Dto> getForumDecission(){  
	    return template.query("select * from forum order by forumid desc",new RowMapper<Dto>(){  
	       public Dto mapRow(ResultSet rs, int row) throws SQLException {  
	            Dto e=new Dto();  
	            e.setDate(rs.getString("date"));  
	            e.setMessage(rs.getString("message"));
	            e.setName(rs.getString("name")); 
	            e.setEmail(rs.getString("email")); 
	            e.setForumid(rs.getString("forumid")); 
	            return e;  	            
	        } 
	  });  
	} 
	
	public Dto getDiscussionById(int forumid){  
	    String sql="select * from forum where forumid=?";  
	    return template.queryForObject(sql, new Object[]{forumid},new BeanPropertyRowMapper<Dto>(Dto.class));  
	}
	
	public int getCounter(){  
	    String sql="select COUNT(forumid) from forum";  	    
	    int status = jdbcTemplate.queryForObject(sql, Integer.class);
		return status;
	}
	
	public int reply(Dto a){
		String sql="insert into reply( forumid, name, email, comment) values('"+a.getForumid()+"','"+a.getName()+"','"+a.getEmail()+"','"+a.getComment()+"')";
		return template.update(sql);
	}
	
	public List<Dto> getReply(int forumid){  
	    return template.query("select * from reply where forumid="+forumid+" order by replyid desc",new RowMapper<Dto>(){  
	       public Dto mapRow(ResultSet rs, int row) throws SQLException {  
	            Dto e=new Dto();  
	            e.setForumid(rs.getString("forumid"));
	            e.setDate(rs.getString("replyid"));  
	            e.setName(rs.getString("name")); 
	            e.setEmail(rs.getString("email")); 
	            e.setMessage(rs.getString("comment"));            
	            return e;  	            
	        } 
	  });  
	}
	
	/* Download counter table*/
	public int download(int counts){
		String sql="insert into download values("+counts+")";
		return template.update(sql);
	}
	
	public int getDownload(){  
	    String sql="select COUNT(counts) from download";  	    
	    int status = jdbcTemplate.queryForObject(sql, Integer.class);
		return status;
	}
	
	
	public List<Dto> getSelect(){  
	    String sql="select forumid from forum"; 
	    System.out.println("Forum");
	    List<Dto> status = jdbcTemplate.queryForObject(sql, List.class);
		return status;
	}
}
