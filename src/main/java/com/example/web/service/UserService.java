package com.example.web.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.web.model.Membre;
import com.example.web.model.Responsable;
import com.example.web.model.User;
import com.example.web.repository.RoleRepository;
import com.example.web.repository.UserRepository;

import net.bytebuddy.utility.RandomString;


@Service
public class UserService {

	@Autowired
     UserRepository userRepository;

	@Autowired
     RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	 @Autowired
	    private JavaMailSender mailSender;
	

	public User addUser (User userNew) {
		String randomCode = RandomString.make(64);
		Responsable respo= new Responsable();
		respo.setEmail(userNew.getEmail());
		respo.setUserName(userNew.getUserName());
		respo.setPassword(passwordEncoder.encode(userNew.getPassword()));
		respo.setEnabled(false);
		respo.setGrade(2);
		respo.setCodeVerification(randomCode);

	    //user.setRole(new Role(Integer.valueOf(1), user));	
		try {
			sendVerificationEmail(respo, "http://localhost:8099");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRepository.save(respo);

		
	}
	public void sendVerificationEmail(User user, String siteURL) throws MessagingException, UnsupportedEncodingException  {
		 
		 String toAddress = user.getEmail();
		    String fromAddress = "testContactapp02@gmail.com";
		    String senderName = "Admin";
		    String subject = "Please verify your registration";
		    String content = "Bonjour [[name]],<br>"
		            + "Please click the link below to verify your registration:<br>"
		            + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
		            + "Thank you,<br>"
		            + "Admin.";
		     
		    MimeMessage message = mailSender.createMimeMessage();
		    MimeMessageHelper helper = new MimeMessageHelper(message);
		     
		    helper.setFrom(fromAddress, senderName);
		    helper.setTo(toAddress);
		    helper.setSubject(subject);
		     
		    content = content.replace("[[name]]", user.getUserName());
		    String verifyURL = siteURL + "/verify/" + user.getCodeVerification();
		     
		    content = content.replace("[[URL]]", verifyURL);
		     
		    helper.setText(content, true);
		     
		    mailSender.send(message);
	     
	    }
	
	public User emailVerification(String token) {
			User user= userRepository.getUserByCode(token);
			if (user!=null) {
				user.setCodeVerification("");
				user.setEnabled(true);
				return userRepository.save(user);
			}
			return null;
	}
	 
	public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        //return userRepository.findAll();
    	return userRepository.findAllRespoAdmin();
    }

    public void deleteUser (final Long id) {
        userRepository.deleteById(id);
    }
	
	public User auth (User user) {
		
		//Responsable respo= new Responsable();
		//respo.setEmail(user.getEmail());
     	//respo.setPassword(passwordEncoder.encode(user.getPassword()));
		User userAuth= userRepository.getUser(user.getEmail());
		//System.out.println(userAuth);
     	if(passwordEncoder.matches(user.getPassword(), userAuth.getPassword())) {
		    return userAuth;
		}
		return null;
	}
}
