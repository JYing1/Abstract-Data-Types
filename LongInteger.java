public class LongInteger extends UtilityOperations {
    
    //private ProjectList list = new DLLProjectList();
	private ProjectList list = new ArrayProjectList();
	//private ProjectList list = new SLLProjectList();
    
	private boolean sign;
    
    public void setSign(boolean sign) {
    	this.sign = sign;										//false is positive, true is negative
    }
	    
    public LongInteger(String s) {
    	String t = s;

    	if (s.charAt(0) == '-') {
    		t = t.substring(1);
    		setSign(true);
    	}
    	else {
    		setSign(false);
    	}
    	    	
        while(t.length() >= 8) {
        	list.insertFirst(Integer.parseInt(t.substring(t.length()-8)));
        	t = t.substring(0, t.length()-8);
        }
        if(t.length() > 0) {
        	list.insertFirst(Integer.parseInt(t));
        }
    }
    
    public LongInteger(){
    	list = new DLLProjectList();
    	setSign(false);
    }
    
    public void output1() {
    	
    	Position p = list.first();
    	System.out.print("String: ");							//prints out the LongInteger as a string
    	if (sign) {
    		System.out.print("-");
    	}
    	else {
    		System.out.print("+");
    	}
    	System.out.printf("%d", p.getValue());
    	
    	while (!list.isLast(p)) {
    		p = list.after(p);
    		System.out.printf("%08d", p.getValue());
    	}
    	System.out.println();
    }
    
    public void output2() {
    	Position p = list.first();
    	System.out.print("Nodes: ");							//Prints out the LongInteger by nodes
    	if (sign){
    		System.out.print("- ");
    	}
    	else{
    		System.out.print("+ ");
    	}
    	System.out.printf("%d", p.getValue());
    	
    	while (!list.isLast(p)) {
    		p = list.after(p);
    		System.out.printf(" %08d", p.getValue());
    	}
    	System.out.println();
    }
	
    public void solution() {
    	
    	Position p = list.first();
    	if (sign) {
    		System.out.print("-");
    	}
    	else {
    		System.out.print("+");
    	}
    	while (p.getValue() == 0) {
    		if (list.isLast(p)){
    			System.out.print("");
    			break;
    		}
    		else{
        		p = list.after(p);
    		}
    	}
    	System.out.printf("%d", p.getValue());
    	
    	while (!list.isLast(p)) {
    		p = list.after(p);
    		System.out.printf("%08d", p.getValue());
    	}
    	System.out.println();
    }

	public boolean getSign() {
		return sign;
	}
	
	public int getDigitCount() {
		Position p = list.first();
		int d = list.size() - 1;
		if(d < 0) {
			d = 0;
		}
		d = d*8;
		if(list.size() != 0) {
			d = d + UtilityOperations.digits(p.getValue());
		}
		return d;
	}
    
    public boolean equalTo(LongInteger i) {
    	Position p = list.last();
    	Position q = i.list.last();
    	
    	if (this.list.size() == i.list.size()) {												//equal size
    		if (this.getSign() == i.getSign()) {												//same sign
    			if(p.getValue() != q.getValue()) {
    				return false;
    			}
    			
    			while (!this.list.isFirst(p)) {
    				p = this.list.before(p);
    				q = i.list.before(q);
    				
    				if (p.getValue() == q.getValue()) {											//2 nodes are the same
    					continue;
    				}
    				else{
    					return false;
    				}
    			}
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    	else{
    		return false;
    	}
    }
    
    public boolean lessThan(LongInteger i) {
        Position p = list.last();
        Position q = i.list.last();
        
        if (this.getSign() != i.getSign()) {													//both signs are different
        	if(this.getSign() && !i.getSign()) {												//this is negative, i is positive, this < i
        		return true;
        	}
        	if(!this.getSign() && i.getSign()) {												//this is positive, i is negative, this > i
        		return false;
        	}
        }
        
	    if (this.list.size() < i.list.size()) {
	    	if(!this.getSign()) { 																//10000000 < 100000000
	    		return true;
	    	}
	    	else{																				//10000000 < 100000000 (- sign)
	    		return false;
	        }
	    }
	    else if (this.list.size() > i.list.size()) {
	    	if(!this.getSign()) { 																//10000000 < 100000000
	    		return false;
	    	}
	    	else{																				//10000000 < 100000000 (- sign)
	    		return true;
	        }
	    }
	    else{
	    	if (this.list.isFirst(p)){
 	    		if (this.getSign() == false) {
	 				if (p.getValue() < q.getValue()) {											//100 < 101
	 					return true;
	 				}
	 				else if (p.getValue() > q.getValue()) {										//101 > 100
	 					return false;
	 				}
	         	}
	         	else {
	         		if (p.getValue() < q.getValue()) {											//100 < 101 (- sign)
	 					return true;
	 				}
	 				else if (p.getValue() > q.getValue()) {										//100 > 101 (- sign)
	 					return false;
	 				}
	         	}
 	    	}
	    	else{
		        while (!this.list.isFirst(p)) {
		        	if(this.getSign() == false)
		        	{
						if (p.getValue() < q.getValue()) {										//100 < 101
							return true;
						}
						else if (p.getValue() > q.getValue()) {									//101 > 100
							return false;
						}
		        	}
		        	else {
		        		if (p.getValue() < q.getValue()) {										//100 < 101 (- sign)
							return false;
						}
						else if (p.getValue() > q.getValue()) {									//100 > 101 (- sign)
							return true;
						}
		        	}
					p = list.before(p);
					q = i.list.before(q);
		        }
	    	}
	    }
	    return false;
    }
    
    public boolean greaterThan(LongInteger i) {
    	 Position p = list.last();
         Position q = i.list.last();
         
         if (this.getSign() != i.getSign()) {													//both signs are different
         	if(this.getSign() && !i.getSign()) {												//this is negative, i is positive, this < i
         		return false;
         	}
         	if(!this.getSign() && i.getSign()) {												//this is positive, i is negative, this > i
         		return true;
         	}
         }
         
         if (this.list.size() < i.list.size()) {
 	    	if(!this.getSign()) { 																//10000000 < 100000000
 	    		return false;
 	    	}
 	    	else{																				//10000000 < 100000000 (- sign)
 	    		return true;
 	        }
 	    }
 	    else if (this.list.size() > i.list.size()) {
 	    	if(!this.getSign()) { 																//10000000 < 100000000
 	    		return true;
 	    	}
 	    	else{																				//10000000 < 100000000 (- sign)
 	    		return false;
 	        }
 	    }
 	    else{
 	    	if (this.list.isFirst(p)){
 	    		if (this.getSign() == false) {
	 				if (p.getValue() < q.getValue()) {											//100 < 101
	 					return false;
	 				}
	 				else if (p.getValue() > q.getValue()) {										//101 > 100
	 					return true;
	 				}
	         	}
	         	else {
	         		if (p.getValue() < q.getValue()) {											//100 < 101 (- sign)
	 					return true;
	 				}
	 				else if (p.getValue() > q.getValue()) {										//100 > 101 (- sign)
	 					return false;
	 				}
	         	}
 	    	}
 	    	else{
		        while (!this.list.isFirst(p)) {
		        	if (this.getSign() == false) {
		 				if (p.getValue() < q.getValue()) {										//100 < 101
		 					return false;
		 				}
		 				else if (p.getValue() > q.getValue()) {									//101 > 100
		 					return true;
		 				}
		         	}
		         	else {
		         		if (p.getValue() < q.getValue()) {										//100 < 101 (- sign)
		 					return true;
		 				}
		 				else if (p.getValue() > q.getValue()) {									//100 > 101 (- sign)
		 					return false;
		 				}
		         	}
		 			p = list.before(p);
		 			q = i.list.before(q);
		 		}
 	    	}
 	    }
        return false;
    }
    
	public LongInteger add(LongInteger i) {
    	LongInteger answer = new LongInteger();							//create answer, the new LongInteger
        int min = 0;													//which LongInteger has the most nodes
        
        if (this.list.size() < i.list.size()) {
        	min = this.list.size();
        }
        else {
        	min = i.list.size();
        }

        if (this.getSign() == i.getSign()) {							//both have the same sign
        	if (this.list.size() == min){
        		answer = i.addAbsolute(this);
        		answer.setSign (this.getSign());						//positive + positive will always be positive and vice-versa
        	}
        	else {
        		answer = this.addAbsolute(i);
        		answer.setSign (this.getSign());						//positive + positive will always be positive and vice-versa
        	}
        }
        else {															//different signs
    		if (this.getSign() == false) {								//if this is positive
    			if (this.list.size() == i.list.size()){					//equal size
    				if (this.list.first().getValue() > i.list.first().getValue()){		//if this is larger than i
            			answer = this.subAbsolute(i);				//subtract the lower value (i) from this
            			answer.setSign(false);							//the answer will be positive
            		}
            		else{												//if i is larger than this
            			answer = i.subAbsolute(this);				//subtract the lower value (this) from i
            			answer.setSign(true);							//the answer will be negative
            		}
    			}
    			else if (this.list.size() == min) {						//if i is larger than this
    				answer = i.subAbsolute(this);					//subtract the lower value (this) from i
        			answer.setSign(true);								//the answer will be negative
    			}
    			else {													//if this is larger than i
    				answer = this.subAbsolute(i);					//subtract the lower value (i) from this
        			answer.setSign(false);								//the answer will be positive
    			}
        		
        	}
    		else {														//if this is negative
    			if (this.list.size() == i.list.size()){					//equal size
    				if (this.list.first().getValue() > i.list.first().getValue()){		//if this is larger than i
            			answer = this.subAbsolute(i);				//subtract the lower value (i) from this
            			answer.setSign(true);							//the answer will be negative
            		}
            		else{												//if i is larger than this
            			answer = i.subAbsolute(this);				//subtract the lower value (this) from i
            			answer.setSign(false);							//the answer will be positive
            		}
    			}
    			else if (this.list.size() == min) {						//if i is larger than this
    				answer = i.subAbsolute(this);					//subtract the lower value (this) from i
    				answer.setSign(false);								//the answer will be positive
    			}
    			else {													//if this is larger than i
    				answer = this.subAbsolute(i);					//subtract the lower value (i) from this
    				answer.setSign(true);								//the answer will be negative
    			}
    		}
        }
        return answer;
    }
	
	public LongInteger addAbsolute(LongInteger i){												//this is where the real addition happens
		LongInteger answer = new LongInteger();
		Position p = this.list.last();
        Position q = i.list.last();
        int temp;
        int min = i.list.size();
        boolean overflow = false;
        
        temp = p.getValue() + q.getValue();														//initial addition
        
        if (digits(temp) == 9) {																//check for overflow
        	overflow = true;
        	temp = temp - 100000000;
        }
        answer.list.insertFirst(temp);
        
        for (int l = 0; l < min - 1; l++) {														//only add the nodes up to the largest node of the minimum
        	p = this.list.before(p);
        	q = i.list.before(q);
        	temp = p.getValue() + q.getValue();
        	if (overflow) {																		//if there was an overflow, add 1 to the temp value
        		temp = temp + 1;
        	}
        	if (digits(temp) == 9) {															//check for overflow again
            	overflow = true;
            	temp = temp - 100000000;
            }
        	else {
        		overflow = false;
        	}
        	answer.list.insertFirst(temp);
        }
        
        for (int m = 0; m < (this.list.size() - min); m++) {									//add the excess nodes to answer
        	p = this.list.before(p);
        	temp = p.getValue();
        	if (overflow) {																		//if there was an overflow, add 1 to the temp value
        		temp = temp + 1;
        	}
        	if (digits(temp) == 9) {															//check for overflow again
            	overflow = true;
            	temp = temp - 100000000;
            }
        	else {
        		overflow = false;
        	}
        	answer.list.insertFirst(temp);
        }
        if(overflow) {																			//1 final overflow
        	answer.list.insertFirst(1);
        }
        
		return answer;
	}
    
    public LongInteger subtract(LongInteger i) {
    	LongInteger answer = new LongInteger();
    	
    	if (this == i){
    		answer.list.insertFirst(0);
    		answer.setSign(false);
    		return answer;
    	}
        int min = 0;																			//which LongInteger has the least amount of nodes
        
        if (this.list.size() < i.list.size()) {
        	min = this.list.size();
        }
        else {
        	min = i.list.size();
        }

    	if (this.getSign() != i.getSign()) {													//both have the same sign
    		if (this.list.size() == min){
        		answer = i.addAbsolute(this);
        		answer.setSign (this.getSign());												//positive + positive will always be positive and vice-versa
        	}
        	else {
        		answer = this.addAbsolute(i);
        		answer.setSign (this.getSign());												//positive + positive will always be positive and vice-versa
        	}
    	}
    	else {																					//different signs
    		if (this.getSign() == false) {														//if this is positive
    			if (this.list.size() == i.list.size()) {										//equal size
    				if (this.list.first().getValue() == i.list.first().getValue()) {
    					Position p = this.list.first();
    					Position q = i.list.first();
    					while (p.getValue() == q.getValue()) {
    						p = this.list.after(p);
    						q = i.list.after(q);
    					}
    					if (p.getValue() > q.getValue()) {										//if this is larger than i
                			answer = this.subAbsolute(i);									//subtract the lower value (i) from this
                			answer.setSign(false);												//the answer will be positive
                		}
                		else {																	//if i is larger than this
                			answer = i.subAbsolute(this);									//subtract the lower value (this) from i
                			answer.setSign(true);												//the answer will be negative
                		}
    				}
    				else if (this.list.first().getValue() > i.list.first().getValue()) {		//if this is larger than i
            			answer = this.subAbsolute(i);										//subtract the lower value (i) from this
            			answer.setSign(false);													//the answer will be positive
            		}
            		else {																		//if i is larger than this
            			answer = i.subAbsolute(this);										//subtract the lower value (this) from i
            			answer.setSign(true);													//the answer will be negative
            		}
    			}
    			else if (this.list.size() == min) {												//if i is larger than this
    				answer = i.subAbsolute(this);											//subtract the lower value (this) from i
        			answer.setSign(true);														//the answer will be negative
    			}
    			else {																			//if this is larger than i
    				answer = this.subAbsolute(i);											//subtract the lower value (i) from this
        			answer.setSign(false);														//the answer will be positive
    			}
        		
        	}
    		else {																				//if this is negative
    			if (this.list.size() == i.list.size()) {										//equal size
    				if (this.list.first().getValue() == i.list.first().getValue()) {
    					Position p = this.list.first();
    					Position q = i.list.first();
    					while (p.getValue() == q.getValue()) {
    						p = this.list.after(p);
    						q = i.list.after(q);
    					}
    					if (p.getValue() > q.getValue()) {										//if this is larger than i
                			answer = this.subAbsolute(i);									//subtract the lower value (i) from this
                			answer.setSign(true);												//the answer will be negative
                		}
    					else {																	//if i is larger than this
                			answer = i.subAbsolute(this);									//subtract the lower value (this) from i
                			answer.setSign(false);												//the answer will be positive
                		}
    				}
    				else if (this.list.first().getValue() > i.list.first().getValue()) {		//if this is larger than i
            			answer = this.subAbsolute(i);										//subtract the lower value (i) from this
            			answer.setSign(true);													//the answer will be negative
            		}
            		else{																		//if i is larger than this
            			answer = i.subAbsolute(this);										//subtract the lower value (this) from i
            			answer.setSign(false);													//the answer will be positive
            		}
    			}
    			else if (this.list.size() == min) {												//if i is larger than this
    				answer = i.subAbsolute(this);											//subtract the lower value (this) from i
    				answer.setSign(false);														//the answer will be positive
    			}
    			else {																			//if this is larger than i
    				answer = this.subAbsolute(i);											//subtract the lower value (i) from this
    				answer.setSign(true);														//the answer will be negative
    			}
    		}
        }
    	return answer;
    }
    
    public LongInteger subAbsolute(LongInteger i) {												//this is where the subtraction actually happens
    	LongInteger answer = new LongInteger();
        Position p = this.list.last();
        Position q = i.list.last();
        int temp;
        boolean borrow = true;																	//if this needed to borrow from the node before; initialized to true
        int min = i.list.size();
        
        temp = (p.getValue() + 100000000) - q.getValue();										//this will always get +100000000, no matter what
        if (digits(temp) == 9) {																//if the +100000000 doesn't get used, set borrow to false
        	borrow = false;
        	temp = temp - 100000000;
        }
        
        answer.list.insertFirst(temp);
        
        for (int l = 0; l < min - 1; l++) {
        	p = this.list.before(p);
        	q = i.list.before(q);
        	temp = (p.getValue() + 100000000) - q.getValue();									//this will always get +100000000, no matter what
        	if (borrow) {																		//if there was an overflow, add 1 to the temp value
        		temp = temp - 1;
        	}
        	if (digits(temp) == 9) {															//check for overflow again
            	borrow = false;
            	temp = temp - 100000000;
            }
        	else {
        		borrow = true;
        	}
        	answer.list.insertFirst(temp);
        }
        
        for (int m = 0; m < this.list.size() - min; m++) {
        	p = this.list.before(p);
        	temp = p.getValue();
        	if (borrow) {
        		temp = temp - 1;
        		borrow = false;
        	}
        	answer.list.insertFirst(temp);
        }
    	return answer;
    }
    
    public LongInteger multiply(LongInteger i) {
    	
    	LongInteger answer = new LongInteger();
    	
    	int min = 0;
    	if (this.list.size() < i.list.size()) {
        	answer = this.multAbsolute(i);
        }
        else {
        	answer = i.multAbsolute(this);
        }
    	
    	if (this.getSign() == i.getSign()){
    		answer.setSign(false);
    	}
    	else {
    		answer.setSign(true);
    	}
    	
        return answer;
    }
    
    public LongInteger multAbsolute(LongInteger i) {											//this is where the multiplication actually happens
    	
    	LongInteger answer = new LongInteger();
    	
    	int maxuh, maxlh;																		//upper half and lower half of this
    	int minuh, minlh;																		//upper half and lower half of i
    	int ans1, ans2;
    	int z1, z2, z3;
    	int zeroes = 0;																			//number of padding required for the 0's
    	int digits = 10000;
    	
    	Position p = this.list.last();
    	Position q = i.list.last();
    	
    	int max = this.list.size();
    	int min = i.list.size();
    	
    	for (int j = 0; j < (max+min); j++){
    		answer.list.insertFirst(0);
    	}
    	
    	while (max > 0) {																		//larger DLLNode
    		LongInteger temp = new LongInteger();
    		
    		for (int j = 0; j < zeroes; j++){
    			temp.list.insertFirst(0);
    		}
    		
    		boolean insert = false;
    		int carry = 0;
    		while (min > 0) {														//smaller DLLNode
    			maxuh = upperHalf(p.getValue());
    			maxlh = lowerHalf(p.getValue());
    			minuh = upperHalf(q.getValue());
    			minlh = lowerHalf(q.getValue());
    			
    			z1 = maxuh * minuh;
    			z3 = maxlh * minlh;
    			z2 = ((maxuh + maxlh) * (minuh + minlh)) - z3 - z1;
    			ans1 = z1 + upperHalf(z2);
    			ans2 = z3 + (lowerHalf(z2) * digits) + carry;
    			
    			if (!insert){
    				temp.list.insertFirst(ans2);
    			}
    			else {
    				int value = temp.list.first().getValue() + ans2;
    				carry = overflow(value);
    				value = underflow(value);
    				temp.list.first().setValue(value);
    			}
    			
    			if (ans1 > 0) {
    				insert = true;
    				if (carry != 0){
    					ans1 = ans1 + carry;
    				}
    				carry = overflow(ans1);
    				temp.list.insertFirst(ans1);
    			}
    			else {
    				insert = false;
    			}
    			
    			if (!i.list.isFirst(q)){
    				q = i.list.before(q);
    			}
    			min--;
    		}
    		answer = answer.add(temp);
    		
    		if (!this.list.isFirst(p)){
    			p = this.list.before(p);
    		}
    		max--;
    		zeroes++;
    		q = i.list.last();
    		min = i.list.size();
    	}
        return answer;
    }
    public LongInteger power(int p) {
        if (p == 0) {
			return new LongInteger("1");
		}
        else if (p == 1) {
			return this;
		}
        else if ((p % 2) == 0) {
			LongInteger sqrdLongInt = multiply(this);
			return sqrdLongInt.power(p / 2);
		}
        else {
			LongInteger sqrdLongInt = multiply(this);
			return multiply(sqrdLongInt.power((p - 1) / 2));
		}
    }
}
