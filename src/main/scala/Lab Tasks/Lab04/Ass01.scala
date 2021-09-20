// Branch control ( Assignment )

package Lab04

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

    // Unigned Operations

    val SgreaterThan = (io.inputA.asUInt > io.inputB.asUInt)
    val Sequality = (io.inputA.asUInt === io.inputB.asUInt)
    val SlessThan = (io.inputA.asUInt < io.inputB.asUInt)
    val SNotEqualsTo = (io.inputA.asUInt =/= io.inputB.asUInt)

    // Signed Operations 

    val USgreaterThan = (io.inputA > io.inputB)
    val USequality = (io.inputA === io.inputB)
    val USlessThan = (io.inputA < io.inputB)
    val USNotEqualsTo = (io.inputA =/= io.inputB)


//     io.branchTaken := MuxLookup(io.funct3, false.B , Array (

//         ("b000".U) ->  USgreaterThan
//         ("b001".U) ->  USequality.asBool()
//         ("b010".U) ->  USlessThan.asBool()
//         ("b011".U) ->  USNotEqualsTo.asBool()
//         ("b100".U) ->  SgreaterThan.asBool()
//         ("b101".U) ->  Sequality.asBool()
//         ("b110".U) ->  SlessThan.asBool()
    
//     ))

// }


    when (io.funct3 === "b000".U) {
        io.branchTaken := USgreaterThan
    }

    .elsewhen (io.funct3 === "b001".U) {
            io.branchTaken := USequality
    }

    .elsewhen (io.funct3 === "b010".U) {
            io.branchTaken := USlessThan
    }

    .elsewhen (io.funct3 === "b011".U){
        io.branchTaken := USNotEqualsTo
    }

    .elsewhen (io.funct3 === "b100".U){
        io.branchTaken := SgreaterThan
    }

    .elsewhen (io.funct3 === "b101".U){
        io.branchTaken := Sequality
    }

    .elsewhen (io.funct3 === "b110".U){
        io.branchTaken := SlessThan
    }

    .elsewhen (io.funct3 === "b111".U){
        io.branchTaken := SNotEqualsTo
    }

    .otherwise{
        io.branchTaken := true.B

    }

}