package we.cod.bnz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import we.cod.bnz.account.Account;
//import we.cod.bnz.account.AccountRepository;
//import we.cod.bnz.account.AccountRole;

@SpringBootApplication
public class BnzApplication implements CommandLineRunner {

//  @Autowired
//  private AccountRepository repoA;

  public static void main(String[] args) {
    SpringApplication.run(BnzApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("we.cod.bnz.account : BnzApplication : run");
//    Account admin = repoA.findByAccountRole(AccountRole.ADMIN).orElse(null);
//    if (admin == null) {
//      Account a = new Account();
//      a.setUsername("admin");
//      a.setEmail("admin@gmail.com");
//      a.setNickname("admin");
//      a.setAccountRole(AccountRole.ADMIN);
//      a.setPassword(new BCryptPasswordEncoder().encode("admin"));
//      a.setPhone("01011112222");
//      a.setProfile("Default" + "Green" + "Normal" + "Smile" + ".jpg");
//      System.out.println(a.toString());
//      repoA.save(a);
//    } else {
//      System.out.println(admin.toString());
//    }
  }
}
