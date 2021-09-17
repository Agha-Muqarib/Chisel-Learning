// Arithmetic operations

package Lab02

import chisel3._

class Exercise01 extends Module {
    val io = IO (new Bundle {
        
        val x = Input(UInt(8.W))    
        val y = Input(UInt(8.W))
        val result = Output(UInt(8.W))
        val result2 = Output(UInt(8.W))
        val result3 = Output(UInt(8.W))
        val result4 = Output(UInt(8.W))
        val result5 = Output(UInt(8.W))
        val result6 = Output(UInt(8.W))

        })

// Addition without width expansion
val sum = io.x + io.y // OR
//  Addition with width expansion
val ModSum = io.x +% io.y
val AndSum = io.x +& io.y
// Subtraction without width expansion
val sub = io.x - io.y // OR
val ModSub = io.x -% io.y
// Subtraction with width expansion
val AndSub = io.x -& io.y

io.result := sum
io.result2 := ModSum
io.result3 := AndSum
io.result4 := sub
io.result5 := ModSub
io.result6 := AndSub

}



