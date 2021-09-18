package Example

import chisel3._
import chisel3.util._

class ALU extends Module {

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
 
    io.output := MuxLookup(io.sel, 0.S , Array(

        ("b0000".U) -> adder,
        ("b0001".U) -> subtractor,
        ("b0010".U) -> andGate,
        ("b0011".U) -> orGate,
        ("b0100".U) -> xorGate,      
        ("b0101".U) -> leftShift.asSInt,
        ("b0110".U) -> logicalRightShift.asSInt,
        ("b0111".U) -> AirthematicRightShift.asSInt,
        ("b1000".U) -> Mux(equality, 1.S, 0.S),
        ("b1001".U) -> Mux(lessThan, 1.S, 0.S),
        ("b1010".U) -> Mux(greaterThan, 1.S, 0.S)

    ))

}