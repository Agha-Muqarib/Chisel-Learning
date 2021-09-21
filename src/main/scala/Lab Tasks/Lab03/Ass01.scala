// Branch control ( Assignment )

package Lab03

import chisel3._
import chisel3.util._

class LM_IO_Interface_BranchControl extends Bundle {
    
    val funct3= Input(UInt(3.W))
    val inputA = Input(SInt(32.W))
    val inputB = Input(SInt(32.W))
    val branchTaken = Output(Bool())
}

class BranchControl extends Module {
    
    val io = IO(new LM_IO_Interface_BranchControl)

    // Signed Operations

    val SGreaterEqual = (io.inputA >= io.inputB)
    val SlessThan = (io.inputA < io.inputB)

    // Unigned Operations 

    val USgreaterThan = (io.inputA.asUInt > io.inputB.asUInt)
    val USequality = (io.inputA.asUInt === io.inputB.asUInt)
    val USlessThan = (io.inputA.asUInt < io.inputB.asUInt)
    val USNotEqualsTo = (io.inputA.asUInt =/= io.inputB.asUInt)

    when (io.funct3 === "b000".U) {
        io.branchTaken := USequality
    }

    .elsewhen (io.funct3 === "b001".U) {
            io.branchTaken := USNotEqualsTo
    }

    .elsewhen (io.funct3 === "b100".U) {
            io.branchTaken := USlessThan
    }

    .elsewhen (io.funct3 > "b101".U){
        io.branchTaken := USgreaterThan
    }

    .elsewhen (io.funct3 === "b110".U){
        io.branchTaken := SlessThan
    }

    .elsewhen (io.funct3 === "b111".U){
        io.branchTaken := SGreaterEqual
    }

    .otherwise{
        io.branchTaken := true.B

    }

}