
public class ControlSignal {
	
	
	static int ALUop, RegDst, ALUSrc, RegWrite, MemRead, MemWrite,Branch, MemtoReg;
	int instruction,rs,rd,rt,opcode,shamt,Imm,address,Execoutput,ReadMemData;
	int instrutionNumber;
	
	
	
	
	public static ControlSignal Control(int opcode, ControlSignal signal) {
		//opcode = Memory.getOpcode();
		
		switch(opcode) 
		{
			case 0 ://ADD
				//instruction = 0;
				signal.ALUop=0;
				signal.RegDst = 1;
				signal.ALUSrc = 0; 
				signal.RegWrite = 1;
				signal.MemRead = 0;
				signal.MemWrite = 0;
				signal.Branch = 0;
				signal.MemtoReg = 0;
				break;
				
			case 1 ://SUB
				signal.ALUop = 1;
				signal.RegDst = 1;
				signal.ALUSrc = 0; 
				signal.RegWrite = 1;
				signal.MemRead = 0;
				signal.MemWrite = 0;
				signal.Branch = 0;
				signal.MemtoReg = 0;
				break;
				
			case 2 ://MUL
				signal.ALUop = 2;
				signal.RegDst = 1;
				signal.ALUSrc = 0; 
				signal.RegWrite = 1;
				signal.MemRead = 0;
				signal.MemWrite = 0;
				signal.Branch = 0;
				signal.MemtoReg = 0;
				break;
				
			case 3 : //MOVI
				signal.ALUop = 0; // ALUop = 0 represents addition
				signal.RegDst = 0;
				signal.ALUSrc = 1; 
				signal.RegWrite = 1;
				signal.MemRead = 0;
				signal.MemWrite = 0;
				signal.Branch = 0;
				signal.MemtoReg = 0;
				break;
				
			case 4: // JEQ
				signal.ALUop = 4;
				signal.RegDst = 1;
				signal.ALUSrc = 1; 
				signal.RegWrite = 0;
				signal.MemRead = 0;
				signal.MemWrite = 0;
				signal.Branch = 1;
				signal.MemtoReg = 0;
				break;
			
			case 5 : //AND
				signal.ALUop = 5; //fix the ALU operations w keda
				signal.RegDst = 1;
				signal.ALUSrc = 0; 
				signal.RegWrite = 1;
				signal.MemRead = 0;
				signal.MemWrite = 0;
				signal.Branch = 0;
				signal.MemtoReg = 0;
				break;
			
			case 6 : //XORI
				signal.ALUop = 6;
				signal.RegDst = 0;
				signal.ALUSrc = 1; 
				signal.RegWrite = 1;
				signal.MemRead = 0;
				signal.MemWrite = 0;
				signal.Branch = 0;
				signal.MemtoReg = 0;
				break;
				
			case 7 : //JMP
				signal.ALUop = 7;
				signal.RegDst = 0;
				signal.ALUSrc = 1; //how will the ALUSrc work with the jump.
				signal.RegWrite = 0;
				signal.MemRead = 0;
				signal.MemWrite = 0;
				signal.Branch = 1;
				signal.MemtoReg = 0;
				break;
				
			case 8 : //LSL
				signal.ALUop = 8;
				signal.RegDst = 1;
				signal.ALUSrc = 1; // shamt dah hayeb2a 7aga zy el Imm keda msh hayeb2a register
				signal.RegWrite = 1;
				signal.MemRead = 0;
				signal.MemWrite = 0;
				signal.Branch = 0;
				signal.MemtoReg = 0; 
				break;
				
			case 9 : //LSR
				signal.ALUop = 9;
				signal.RegDst = 1;
				signal.ALUSrc = 1; 
				signal.RegWrite = 1;
				signal.MemRead = 0;
				signal.MemWrite = 0;
				signal.Branch = 0;
				signal.MemtoReg = 0;
				break;
				
			case 10 : //MOVR
				signal.ALUop = 10;
				signal.RegDst = 0;
				signal.ALUSrc = 1; 
				signal.RegWrite = 1; 
				signal.MemRead = 1;
				signal.MemWrite = 0;
				signal.Branch = 0;
				signal.MemtoReg = 1;
				break;
				
			case 11 : //MOVM
				signal.ALUop = 11;
				signal.RegDst = 0;
				signal.ALUSrc = 1; 
				signal.RegWrite = 0; 
				signal.MemRead = 0;
				signal.MemWrite = 1;
				signal.Branch = 0;
				signal.MemtoReg = 0;
				break;
			
		}
		
		return signal;
	}
	
	
	
	public static int getALUop() {
		return ALUop;
	}
	
	public static int getBranch() {
		return Branch;
	}
	
	public static int getALUSrc() {
	return ALUSrc;
	}
	
	public static int getMemRead() {
		return MemRead;
	}
	
	public static int getMemtoReg() {
		return MemtoReg;
	}
	
	public static int getMemWrite() {
		return MemWrite;
	}
	
	public static int getRegDst() {
		return RegDst;
	}
	
	public static int getRegWrite() {
		return RegWrite;
	}
	
	
	
	
	



	public int getInstruction() {
		return instruction;
	}



	public void setInstruction(int instruction) {
		this.instruction = instruction;
	}



	public int getRs() {
		return rs;
	}



	public void setRs(int rs) {
		this.rs = rs;
	}



	public int getRd() {
		return rd;
	}



	public void setRd(int rd) {
		this.rd = rd;
	}



	public int getRt() {
		return rt;
	}



	public void setRt(int rt) {
		this.rt = rt;
	}



	public int getOpcode() {
		return opcode;
	}



	public void setOpcode(int opcode) {
		this.opcode = opcode;
	}



	public int getShamt() {
		return shamt;
	}



	public void setShamt(int shamt) {
		this.shamt = shamt;
	}



	public int getImm() {
		return Imm;
	}



	public void setImm(int imm) {
		Imm = imm;
	}



	public int getAddress() {
		return address;
	}



	public void setAddress(int address) {
		this.address = address;
	}
	
	public void setExecoutput(int execoutput) {
		Execoutput = execoutput;
	}
	
	public int getExecoutput() {
		return Execoutput;
	}
	
	public int getReadMemData() {
		return ReadMemData;
	}
	
	public void setReadMemData(int readMemData) {
		ReadMemData = readMemData;
	}
	



	public int getInstrutionNumber() {
		return instrutionNumber;
	}



	public void setInstrutionNumber(int instrutionNumber) {
		this.instrutionNumber = instrutionNumber;
	}



	public static void main(String [] args) {
		System.out.println(getRegWrite());
	}

}
