
public class main {
	
	static long startTime;
	static long endTime;
	
	public static void printTime(){
		long duration = endTime - startTime;
		System.out.println(duration + " nanoseconds");
	}
	
	static LongInteger a = new LongInteger("2222");
	static LongInteger b = new LongInteger("99999999");
	static LongInteger c = new LongInteger("-246813575732");
	static LongInteger d = new LongInteger("180270361023456789");
	static LongInteger e = new LongInteger("1423550000000010056810000054593452907711568359");
	static LongInteger f = new LongInteger("-350003274594847454317890");
	static LongInteger g = new LongInteger("29302390234702973402973420937420973420937420937234872349872934872893472893749287423847");
	static LongInteger h = new LongInteger("-98534342983742987342987339234098230498203894209928374662342342342356723423423");
	static LongInteger i = new LongInteger();
	static LongInteger j = new LongInteger();
	static LongInteger k = new LongInteger();
	static LongInteger l = new LongInteger();
	static LongInteger m = new LongInteger();
	static LongInteger n = new LongInteger();
	static LongInteger o = new LongInteger();
	static LongInteger p = new LongInteger();
	static LongInteger q = new LongInteger();
	static LongInteger r = new LongInteger();
	static LongInteger s = new LongInteger();
	static LongInteger t = new LongInteger();
	static LongInteger u = new LongInteger();
	static LongInteger v = new LongInteger();
	static LongInteger w = new LongInteger();
	static LongInteger x = new LongInteger();
	static LongInteger y = new LongInteger();
	static LongInteger z = new LongInteger();
	
	public static void main (String[] args){
		printAll('A', a);
		printAll('B', b);
		printAll('C', c);
		printAll('D', d);
		printAll('E', e);
		printAll('F', f);
		printAll('G', g);
		printAll('H', h);
		
		printMath('A', a);
		printMath('B', b);
		printMath('C', c);
		printMath('D', d);
		printMath('E', e);
		printMath('F', f);
		printMath('G', g);
		printMath('H', h);
		
		printOther();
		
		printPower('A', a);
		printPower('B', b);
		printPower('C', c);
		printPower('D', d);
		printPower('E', e);
		printPower('F', f);
		printPower('G', g);
		printPower('H', h);
	}
	
	public static void printAll(char longIntChar, LongInteger longInt) {
		System.out.println(longIntChar + ":");
		startTime = System.nanoTime();
		longInt.output1();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		longInt.output2();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println("Negative? " + longInt.getSign());
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println("Digits: " + longInt.getDigitCount());
		endTime = System.nanoTime();
		printTime();
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " = A? " + longInt.equalTo(a));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " = B? " + longInt.equalTo(b));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " = C? " + longInt.equalTo(c));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " = D? " + longInt.equalTo(d));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " = E? " + longInt.equalTo(e));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " = F? " + longInt.equalTo(f));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " = G? " + longInt.equalTo(g));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " = H? " + longInt.equalTo(h));
		endTime = System.nanoTime();
		printTime();
		
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " < A? " + longInt.lessThan(a));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " < B? " + longInt.lessThan(b));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " < C? " + longInt.lessThan(c));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " < D? " + longInt.lessThan(d));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " < E? " + longInt.lessThan(e));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " < F? " + longInt.lessThan(f));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " < G? " + longInt.lessThan(g));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " < H? " + longInt.lessThan(h));
		endTime = System.nanoTime();
		printTime();
		
		System.out.println();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " > A? " + longInt.greaterThan(a));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " > B? " + longInt.greaterThan(b));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " > C? " + longInt.greaterThan(c));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " > D? " + longInt.greaterThan(d));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " > E? " + longInt.greaterThan(e));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " > F? " + longInt.greaterThan(f));
		endTime = System.nanoTime();
		printTime();

		startTime = System.nanoTime();
		System.out.println(longIntChar + " > G? " + longInt.greaterThan(g));
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.println(longIntChar + " > H? " + longInt.greaterThan(h));
		endTime = System.nanoTime();
		printTime();
		
		System.out.println();
	}
	
	public static void printMath(char longIntChar, LongInteger longInt) {
		startTime = System.nanoTime();
		if (longIntChar != 'A') {System.out.print(longIntChar + " + A: "); longInt.add(a).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'B') {System.out.print(longIntChar + " + B: "); longInt.add(b).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'C') {System.out.print(longIntChar + " + C: "); longInt.add(c).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'D') {System.out.print(longIntChar + " + D: "); longInt.add(d).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'E') {System.out.print(longIntChar + " + E: "); longInt.add(e).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'F') {System.out.print(longIntChar + " + F: "); longInt.add(f).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'G') {System.out.print(longIntChar + " + G: "); longInt.add(g).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'H') {System.out.print(longIntChar + " + H: "); longInt.add(h).solution();}
		endTime = System.nanoTime();
		printTime();
		
		System.out.println();
		startTime = System.nanoTime();
		if (longIntChar != 'A') {System.out.print(longIntChar + " - A: "); longInt.subtract(a).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'B') {System.out.print(longIntChar + " - B: "); longInt.subtract(b).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'C') {System.out.print(longIntChar + " - C: "); longInt.subtract(c).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'D') {System.out.print(longIntChar + " - D: "); longInt.subtract(d).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'E') {System.out.print(longIntChar + " - E: "); longInt.subtract(e).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'F') {System.out.print(longIntChar + " - F: "); longInt.subtract(f).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'G') {System.out.print(longIntChar + " - G: "); longInt.subtract(g).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'H') {System.out.print(longIntChar + " - H: "); longInt.subtract(h).solution();}
		endTime = System.nanoTime();
		printTime();
		
		System.out.println();
		startTime = System.nanoTime();
		if (longIntChar != 'A') {System.out.print(longIntChar + " * A: "); longInt.multiply(a).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'B') {System.out.print(longIntChar + " * B: "); longInt.multiply(b).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'C') {System.out.print(longIntChar + " * C: "); longInt.multiply(c).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'D') {System.out.print(longIntChar + " * D: "); longInt.multiply(d).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'E') {System.out.print(longIntChar + " * E: "); longInt.multiply(e).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'F') {System.out.print(longIntChar + " * F: "); longInt.multiply(f).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'G') {System.out.print(longIntChar + " * G: "); longInt.multiply(g).solution();}
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		if (longIntChar != 'H') {System.out.print(longIntChar + " * H: "); longInt.multiply(h).solution();}
		endTime = System.nanoTime();
		printTime();
		
		System.out.println();
	}
	
	public static void printOther(){
		startTime = System.nanoTime();
		i = a.add(d); System.out.print("I: "); i.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		j = b.add(c); System.out.print("J: "); j.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		k = c.add(d); System.out.print("K: "); k.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		l = i.add(i); System.out.print("L: "); l.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		m = a.add(i); System.out.print("M: "); m.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		n = b.add(k); System.out.print("N: "); n.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		o = a.subtract(d); System.out.print("O: "); o.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		p = c.subtract(d); System.out.print("P: "); p.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		q = d.subtract(c); System.out.print("Q: "); q.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		r = l.subtract(l); System.out.print("R: "); r.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		s = p.subtract(o); System.out.print("S: "); s.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		t = n.subtract(q); System.out.print("T: "); t.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		u = a.multiply(d); System.out.print("U: "); u.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		v = b.multiply(c); System.out.print("V: "); v.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		w = d.multiply(d); System.out.print("W: "); w.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		x = o.multiply(i); System.out.print("X: "); x.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		y = j.multiply(p); System.out.print("Y: "); y.solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		z = m.multiply(n); System.out.print("Z: "); z.solution();
		endTime = System.nanoTime();
		printTime();
		
		System.out.println();
	}
	
	public static void printPower(char longIntChar, LongInteger longInt) {
		startTime = System.nanoTime();
		System.out.print(longIntChar + "^2: "); longInt.power(2).solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.print(longIntChar + "^5: "); longInt.power(5).solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.print(longIntChar + "^10: "); longInt.power(10).solution();
		endTime = System.nanoTime();
		printTime();
		
		startTime = System.nanoTime();
		System.out.print(longIntChar + "^25: "); longInt.power(25).solution();
		endTime = System.nanoTime();
		printTime();
		
		System.out.println();
	}
}
