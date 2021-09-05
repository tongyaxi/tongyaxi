package com.knowledge.tongyaxi.Stream.Lambda;

import java.util.*;
import java.util.stream.*;

public class Lambda12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<String> stream = Stream.of("APPL:Apple", "MSFT:Microsoft");
        Map<String, String> map = stream
                .collect(Collectors.toMap(
                        // ��Ԫ��sӳ��Ϊkey:
                        s -> s.substring(0, s.indexOf(':')),
                        // ��Ԫ��sӳ��Ϊvalue:
                        s -> s.substring(s.indexOf(':') + 1)));
        System.out.println(map);
	}

}
