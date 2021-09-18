package Lab03

import chisel3._
import chisel3.util._

class SwitchALU extends Module {

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
 
    io.output := 0.S
        switch (io.sel) {

            is ("b0000".U){
                io.output := adder
            }

            is ("b0001".U){
                io.output := subtractor
            }
            
            is ("b0010".U){
                io.output := andGate
            }

            is ("b0011".U){
                io.output := orGate
            }
            
            is ("b0100".U){
                io.output := xorGate
            }
            
            is ("b0101".U){
                io.output := leftShift.asSInt
            }
            
            is ("b0110".U){
                io.output := logicalRightShift.asSInt
            }
            
            is ("b0111".U){
                io.output := AirthematicRightShift.asSInt
            }
            
            is ("b1000".U){
                io.output := Mux(equality, 1.S, 0.S)
            }

            is ("b1001".U){
                io.output := Mux(lessThan, 1.S, 0.S)
            }
            
            is ("b1010".U){
                io.output := Mux(greaterThan, 1.S, 0.S)
            }


        }

    //     ("b0000".U) -> adder,
    //     ("b0001".U) -> subtractor,
    //     ("b0010".U) -> andGate,
    //     ("b0011".U) -> orGate,
    //     ("b0100".U) -> xorGate,      
    //     ("b0101".U) -> leftShift.asSInt,
    //     ("b0110".U) -> logicalRightShift.asSInt,
    //     ("b0111".U) -> AirthematicRightShift.asSInt,
    //     ("b1000".U) -> Mux(equality, 1.S, 0.S),
    //     ("b1001".U) -> Mux(lessThan, 1.S, 0.S),
    //     ("b1010".U) -> Mux(greaterThan, 1.S, 0.S)

    // ))

}