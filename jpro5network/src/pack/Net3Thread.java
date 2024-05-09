package pack;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

// 멀티 스레드로 멀티 태스킹 : 복수 개의 문서 읽기
public class Net3Thread implements Runnable {
	private String url;
	private String title;
	
	public Net3Thread(String url, String title) {
		this.url = url;
		this.title = title;
	}

	@Override
	public void run() {
		try {
			Document doc = Jsoup.connect(url).get(); // 네트워크를 통해 다른 컴에 접속 후 자료 읽기
			String text = doc.text();
			
			System.out.println("--------");
			System.out.println("문서 제목 : " + title);
			
			printKoreanText(text);
		} catch (Exception e) {
			System.out.println("read error : " + e);
		}
	}

	public static void main(String[] args) throws Exception {
		String[] title = { "백설공주", "인어공주" };
		String[] url = { "https://ko.wikipedia.org/wiki/" + URLEncoder.encode(title[0], "UTF-8"),
				"https://ko.wikipedia.org/wiki/" + URLEncoder.encode(title[1], "UTF-8") };

		for (int i = 0; i < url.length; i++) {
			Thread thread = new Thread(new Net3Thread(url[i], title[i]));
			thread.start();
		}

		
	}
	
	private static void printKoreanText(String text) {
		// 정규 표현식 사용
		// 한글과 공백만 얻기
		Pattern pattern = Pattern.compile("[가-힣\\s]+");
		Matcher matcher = pattern.matcher(text);
		
		while(matcher.find()) {
			String line = matcher.group().trim();
			if(!line.isEmpty() && line.length() > 1) {	// 빈 줄, 1글자는 제외
				System.out.println(line);
			}
		}
		
	}
	
}
