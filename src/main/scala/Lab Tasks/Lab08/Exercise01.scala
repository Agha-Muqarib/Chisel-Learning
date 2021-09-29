package Lab08

import chisel3._
import chisel3.util._

class NoOverload extends Module {
    
    val width: Int = 8
    val io = IO ( new Bundle {

        val enable = Input(Bool())
        val write = Input(Bool())
        val addr = Input(UInt(10.W))
        val memMask = Input(Vec(4, Bool()))
        val dataIn = Input(Vec(4, UInt(width.W)))
        val dataOut = Output(Vec(4, UInt(width.W)))
        
    })


val mem = SyncReadMem(1024,Vec(4 , UInt(width.W )))

// mem.write( io.addr , io.dataIn , io.mask )

val reg =  Reg(Vec(4,UInt()))

reg(0) := io.dataIn(0) & io.memMask(0)
reg(1) := io.dataIn(1) & io.memMask(1)
reg(2) := io.dataIn(2) & io.memMask(2)
reg(3) := io.dataIn(3) & io.memMask(3)

when(io.write){
    mem.write(io.addr, reg)
}

io.dataOut := mem.read(io.addr,io.enable)

}