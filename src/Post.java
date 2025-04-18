import java.time.LocalDateTime;


public class Post {
   private LocalDateTime tt;
   
   public Post(LocalDateTime tt) {
	   this.tt = tt;
   }
   
   public LocalDateTime getTT() {
	   return this.tt;
   }
   
}
