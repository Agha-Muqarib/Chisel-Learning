package Lab02

import chisel3._
import chisel3.util._

class Exercise02 extends Module {
    val io = IO (new Bundle {
        val x = Input(UInt(8.W))
        val y = Input(UInt(8.W))
        val high_Byte = Input(UInt(5.W))
        val low_Byte = Input(UInt(2.W))


        val X_Msb = Output(UInt(32.W))
        val Y_Low_Byte = Output(UInt(32.W))
        val con_cat = Output(UInt(7.W))
        val dup = Output(UInt(8.W))
        // val Data = Output(UInt(8.W))
        val All_Ones = Output(UInt(1.W))
        val Any_One = Output(UInt(1.W))
        val Parity_Check = Output(Bool())

        
    })

// Bitfield manipulations

val xMSB = io.x(31.U)
// when x is 32 - bit
val yLowByte = io.y(7.U) // y is atleat 8 - bit
// // concatenates bitfields with first operand on left
val concat = Cat(io.high_Byte, io.low_Byte)
// // replicate a string multiple times
val duplicate = Fill(2, "b1010".U) // " b10101010 ". U
// // Bitfield reductions
val data = "b1001".U
val allOnes = data.andR
val anyOne = data.orR
val parityCheck = data.xorR
// // performs AND reduction
// // performs OR reduction
// // performs XOR reduction

io.X_Msb := xMSB
io.Y_Low_Byte := yLowByte
io.con_cat := concat
io.dup := duplicate
// io.Data := data
io.All_Ones := allOnes
io.Any_One := anyOne
io.Parity_Check := parityCheck

}
