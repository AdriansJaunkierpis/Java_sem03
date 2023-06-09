package service;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.PostType;
import model.users.BusinessUser;
import model.users.GuestUser;
import model.users.PrivateUser;
import model.users.User;

public class MainService {

	public static ArrayList<User> allRegisterdUsers = new ArrayList<>();
	
	
	public static void main(String[] args) {
		// TODO 
		//1. create 2 Guest User objects
		GuestUser u1 = new GuestUser();
		GuestUser u2 = new GuestUser();
		
		System.out.println(u1);
		System.out.println(u2);
		
		//TODO create register function for users 
		//TODO create UserTYpe as enum - privateUser, businessUser
		//public boolean register(String name, String surname, String username, String password, UserType userType)
		
		//2. create 2 Private user objects
		PrivateUser u3 = new PrivateUser("Karina", "Skirmante", "karina.skirmante", "123");
		PrivateUser u4 = new PrivateUser("Janis", "Berzins", "janis.berzins", "321");
		allRegisterdUsers.add(u3);
		allRegisterdUsers.add(u4);
		
		//3. create 2 Business User objects
		
		BusinessUser u5 = new BusinessUser("SIA", "Ziedi", "sia.ziedi", "987");
		BusinessUser u6 = new BusinessUser("SIA", "Dators", "sia.dators", "789");
		allRegisterdUsers.add(u5);
		allRegisterdUsers.add(u6);
		
		//4. create 1 private and 1 public posts for each Private User
		u3.createPost(new Post("Man patīk programmēt!"), PostType.publicPost);
		u3.createPost(new Post("Man šodien viss ir apnicis!"), PostType.privatePost);
		u4.createPost(new Post("Man šodien jāiet pie ārsta!"), PostType.privatePost);
		
		
		for(Post temp: u3.getAllPrivatePosts()) {
			System.out.println(temp);
		}
		
		for(Post temp: u4.getAllPrivatePosts()) {
			System.out.println(temp);
		}
		
		//5. create page for private user --> it is not allowed in our system
		//u4.addPage();
		//6. create at least one page for each Business User
		Page p1  = new Page("Ziedi Ventspilī", "Informācija par Ventspils Ziedu veikalu!"); 
		u5.addPage(p1);
		Page p2  = new Page("Ziedi Liepājā", "Informācija par Liepājas Ziedu veikalu!"); 
		u5.addPage(p2);
		
		
		
		//7. create at least one post in each page
		u5.createPostInPage(p1, u5.createPost(new Post("Ventspils svētkos 20% atlaide rozēm"), PostType.publicPost));
		u5.createPostInPage(p2, u5.createPost(new Post("Liepājas svētkos 25% atlaide tulpēm"), PostType.publicPost));
		u5.createPostInPage(p1, u5.createPost(new Post("31.03.2023 narcises par brīvu!"), PostType.publicPost));
		
		System.out.println("--------------------------");
		for(Post temp: u5.getAllPages().get(0).getPostsInPage()) {
			System.out.println(temp);
		}
		
		//8. verify login func.
		BusinessUser u7 = new BusinessUser("SIA", "VeA", "sia.vea", "987");
		System.out.println(u4.login());
		System.out.println(u7.login());
	
		//9. verify followPage func. for Page object
		try {
			u3.followPage(p2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p2);
		try {
			u4.followPage(p2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p2);
		//10. verify addFollowers func. for PrivateUser object
		
		//11. verify removeFollower func. for PrivateUser
		//12. verify increaseLikes func. for Post
		for (int i = 0; i < 6; i++) {
			u3.getAllPrivatePosts().get(0).increaseLikes();
		}
		for(Post temp: u3.getAllPrivatePosts()) {
			System.out.println(temp);
		}
		for(Post temp: u4.getAllPrivatePosts()) {
			System.out.println(temp);
		}
		System.out.println("--------------------------");
		for(Post temp: u5.getAllPages().get(0).getPostsInPage()) {
			System.out.println(temp);
		}
		System.out.println("---------finding-----------------");
		System.out.println(u1.findUsersByUsernameOrSurname("sia"));
		System.out.println("---------finding-----------------");
		System.out.println(u1.findPagesByTitleOrDescription("zied"));
		
		System.out.println("---------finding-----------------");
		System.out.println(u1.findPublicPostsInPrivateUserOrInPage("atlaid"));
	}
}