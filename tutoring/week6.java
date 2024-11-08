package tutoring;
import java.util.*;


class Movieroom {
	String name;
	Movieroom(String a){
		name = a;
	}
	

	synchronized void moviestart(Movie m) {
		if (m.movietime <= 120) {
			System.out.println(m.name +" " + m.movietime + "분간 영화 상영중");
		}
		else 
			System.out.println(m.name + " 영화 길이가 120분 초과, 상영불가!");
	}
	
}

class Movie extends Thread {
	Movieroom r;
	String name;
	int movietime;
	
	Movie(Movieroom a, String b, int c){
		r = a;
		name = b;
		movietime = c;
	}
	
	public void run() {
		r.moviestart(this);
	}
	
}
public class week6 {

	public static void main(String[] args) {
		
		Movieroom r= new Movieroom("명지 영화관");
		Movie m1 = new Movie(r, "컨저링", 112);
		Movie m2 = new Movie(r, "아바타", 192);
		Movie m3 = new Movie(r, "어바웃타임", 120);	
		Movie m4 = new Movie(r, "기생충", 138);	
		

		m1.start();
		m2.start();
		try {
			m2.join();
		} catch (Exception e) {
			System.out.println("join 실행중예외 발생");
		}
		m3.start();
		m4.start();
		System.out.println(m4.getName() + "가 상영중 입니다.");
	}

}
