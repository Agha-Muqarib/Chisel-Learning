package Lab07

import chisel3._
import chisel3.util._


// priority arbiter


class Exercise01 extends Module {    
    
    val io = IO ( new Bundle {

        val input1 = Flipped(Decoupled(UInt(8.W))) 
        val input2 = Flipped(Decoupled(UInt(8.W)))
        val consumer = Decoupled(UInt(8.W))
        
    })


    val producerQ1 = Queue(io.input1)
    val producerQ2 = Queue(io.input2)
    val arbiter = Module(new Arbiter(UInt(), 2))

    arbiter.io.in(0) <> producerQ1
    arbiter.io.in(1) <> producerQ2

    io.consumer <> arbiter.io.out

}