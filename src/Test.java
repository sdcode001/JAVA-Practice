import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
	   List<Post> list1 = new ArrayList();
       list1.add(new Post(LocalDateTime.now()));
       list1.add(new Post(LocalDateTime.now().plusHours(1)));
       list1.add(new Post(LocalDateTime.now().plusHours(4)));
       
       List<Post> list2 = new ArrayList();
       list2.add(new Post(LocalDateTime.now().plusHours(2)));
       list2.add(new Post(LocalDateTime.now().plusHours(6)));
       list2.add(new Post(LocalDateTime.now().plusHours(5)));
       
       List<Post> res = new ArrayList();
       res.addAll(list1);
       res.addAll(list2);
       
       res.sort(Comparator.comparing(Post::getTT).reversed());
       
       List<Post> r = res.subList(0, 3);
       
       for (Post post : r) {
           System.out.println(post.getTT());
       }
       
       List<Integer> l = new ArrayList();
       l.add(5);
       l.add(2);
       l.add(9);
       l.sort(null);
       for(var v: l) {
    	   System.out.println(v);
       }
       
	}

}
