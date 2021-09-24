package Lab05

import chisel3._
import chisel3.util._

class ALU_case extends Module {

    val io = IO(new Bundle {

        val inputA = Input(SInt(32.W))
        val inputB = Input(SInt(32.W))

        val sel = Input(UInt(4.W))

        val output = Output(SInt(32.W)) 

    })

    val adder = io.inputA + io.inputB
    val subtractor = io.inputA - io.inputB
    val andGate = io.inputA & io.inputB
    val orGate = io.inputA | io.inputB
    val xorGate = io.inputA ^ io.inputB

    val splitA = io.inputA(4,0)
    val splitB = io.inputB(4,0)

    val leftShift = splitB.asUInt << splitA.asUInt
    val logicalRightShift = splitA.asUInt >> splitB.asUInt
    val AirthematicRightShift = splitA.asUInt >> splitB.asUInt
    val equality = io.inputA === io.inputB
    val lessThan = io.inputA < io.inputB
    val greaterThan = io.inputA > io.inputB
 
    when (io.sel === "b0000".U) {io.output := adder}

    .elsewhen (io.sel === "b0001".U) {io.output := subtractor}  
    .elsewhen (io.sel === "b0010".U) {io.output := andGate}
    .elsewhen (io.sel === "b0011".U) {io.output := orGate}
    .elsewhen (io.sel === "b0100".U) {io.output := xorGate}      
    .elsewhen (io.sel === "b0101".U) {io.output := leftShift.asSInt}
    .elsewhen (io.sel === "b0110".U) {io.output := logicalRightShift.asSInt}
    .elsewhen (io.sel === "b0111".U) {io.output := AirthematicRightShift.asSInt}
    .elsewhen (io.sel === "b1000".U) {io.output := Mux(equality, 1.S, 0.S)}
    .elsewhen (io.sel === "b1001".U) {io.output := Mux(lessThan, 1.S, 0.S)}
    .elsewhen (io.sel === "b1010".U) {io.output := Mux(greaterThan, 1.S, 0.S)}
    .otherwise {io.output := 0.S}

}
