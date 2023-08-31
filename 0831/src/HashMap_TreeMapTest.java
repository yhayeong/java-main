
import java.util.HashMap;
import java.util.Map;

public class HashMap_TreeMapTest {
	public static void main(String[] args) {
		/*
		Map에는 TreeMap, HashMap, HashTable, Properties가 있음
		두가지를 중점적으로 학습 - TreeMap, HashMap(HashTable의 동기화를 뺀 경량화버전)
		Tree(정렬)Map은 Key를 가지고 정렬시킴
		
		메소드 Set entrySet() : 엔트리(키와 벨류)들을 Set에 저장해 반환
		메소드 Collection values() : 벨류들만 목록으로 반환
		*/
		
		
		//1. 데이터(키,벨류) 넣기
		Map<String, Integer> hmap = new HashMap<>();
		hmap.put("1001", 35);
		hmap.put("1002", 30);
		hmap.put("1003", 25);
		hmap.put("1004", 10);
		
		//1-2. 중복키의 유무 확인
		//데이터를 넣을때는 동일한 키가 있는지를 확인하고 넣어야 안전함 안그러면 덮어쓰기 때문
		if(hmap.containsKey("1004")==false) hmap.put("1004", 90);
//		hmap.put("1004", 90);
		
		
		//2. 출력
		System.out.println(hmap); //{1004=10, 1003=25, 1002=30, 1001=35}
		
		//2-2. 벨류 전체 출력
		for (Integer v : hmap.values()) {
			System.out.print(v + ","); //10,25,30,35,
		}
		
		//3. 키를 통해 벨류 리턴
		System.out.println("\n----------");
		Integer value = hmap.get("1001");
		System.out.println(value); //35
		
		//4. 키 목록 리턴
		System.out.println("\n-----------------------");
		for (String k : hmap.keySet()) {
			System.out.print(k+","); //1004,1003,1002,1001,
		}
		
		//3-2. 벨류를 조회할때 목록 가져와서 벨류목록 가져오기 - get(가져온키) -하는 경우도 많음
		System.out.println("\n-------------------------------------------");
		for (String key : hmap.keySet()) {
			System.out.println(hmap.get(key));
//			System.out.println(String.format("key: %s, value: %d", key, hmap.get(key))); //엔트리 리턴
		}
		
		//5. 키와 벨류의 조합인 엔트리 리턴
		System.out.println("\n==================");
		for (Map.Entry<String, Integer> e : hmap.entrySet()) {
			System.out.println(String.format("key: %s, value: %d", e.getKey(), e.getValue()));
		}
		/*
		key: 1004, value: 10
		key: 1003, value: 25
		key: 1002, value: 30
		key: 1001, value: 35
		*/
		
		//6. 삭제
		System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		hmap.remove("1003");
		System.out.println(hmap); //{1004=10, 1002=30, 1001=35}
		
		
		
		//cf. 출력결과를 보면 입력순서로 저장되지 않았음을 확인할 수 있음(해싱되어 저장되므로 즉, 해시코드를 통해서 해시코드에 따라 위치를 정해 저장되므로)
		
		
		//***계좌의 키로 계좌번호(id)를 쓸때, '벨류에 id를 포함되도록 둔 채로' '따로' 키로 id를 사용하는 경우가 일반적이다.
		//Map<String, Account> accs = new HashMap<>();
		//넣을때도 찾을때도 키를 통해 해싱하여 (처음부터 검색하지않고) 쉽게 찾아간다
		
	}//main
	
}






/*
 < TreeMap >
 
Tree->정렬되며 저장됨 (검색에 유리)
주로 HashMap을 사용하고 정렬조회가 필요한 경우가 빈번한 경우에 TreeMap을 쓴다

생성자 : TreeMap(), TreeMap(비교기)

메소드 SortedMap headMap(Object toKey) :  특정요소미포함까지 범위의 SortedMap을 리턴
메소드 SortedMap subMapObject(fromKey, Object toKey), SortedMap tailMap(Object fromKey)
cf. Set의 subSet메소드

*/
