package Lab03

// Immediate ( Assignment )


import chisel3._
import chisel3.util._

class LM_IO_Interface_ImmdValGen extends Bundle {
    
    val instr = Input(UInt(32.W))
    val pc = Input(UInt(32.W))
    val immSel = Output(UInt(2.W))
  
}

class ImmdValGen extends Module {
    
    val io = IO (new LM_IO_Interface_ImmdValGen)
    var opcode = io.instr(6,0)

    val immS = Cat(io.instr(31,25), io.instr(11,7))
    val immB = Cat (io.instr(31), io.instr(7), io.instr(30,25),io.instr(11,8), "b0".U)
    val immJ = Cat (io.instr(31), io.instr(19,12), io.instr(20), io.instr(30,21), "b0".U)

    val iType = Cat(Fill(20,io.instr(31)), io.instr(31,20))
    val sType = Cat(Fill(20,immS(11)), immS)
    val bType = (Cat(Fill(19, immB(12)), immB)) + io.pc
    val uType = (Cat(Fill(12, io.instr(31)), io.instr(31,12))) << 12
    val jType = (Cat(Fill(12, immJ(20)),immJ)) + io.pc

    io.immSel := MuxCase(0.U, Array(

        (opcode <= 19.U || opcode >= 3.U || opcode === 27.U || opcode === 115.U) -> iType,
        (opcode === "b0100011".U) -> sType,
        (opcode === "b1100011".U) -> bType,
        (opcode === "b0010111".U) -> uType,
        (opcode === "b1101111".U) -> jType
        
        ))
}
